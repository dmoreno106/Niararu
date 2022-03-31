
package controlador;

import static controlador.ConexionControl.conexion;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Autor;

/**
 *
 * @author Eva
 */
public class ControlAutores {
    ResultSet rs;
    PreparedStatement pst;
    Statement st;
    
    public ArrayList<Autor> listaAutores(){
       ArrayList<Autor> listaAutores = new ArrayList<>();
       try{
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM AUTOR ORDER BY ID");
            while(rs.next()){
                int id = rs.getInt("Id");
                String fechaNac = rs.getString("FechaNac");
                String nombre = rs.getString("Nombre");
                String sinopsis = rs.getString("Sinopsis");
                Autor autor = new Autor(id, fechaNac,nombre, sinopsis);
                listaAutores.add(autor);
            }
            
       }catch(SQLException e){
           System.out.println("Error: "+e);
       }
       return listaAutores;
     
    }
    
    public boolean saveAutor(Autor autor){
         boolean insertado = false;
        try {
            pst = conexion.prepareStatement("INSERT INTO AUTOR (FechaNac, Nombre,Sinopsis) VALUES (?,?,?)");
            pst.setString(1, autor.getFechaNac());
            pst.setString(2, autor.getNombre());
            pst.setString(3, autor.getSinopsis());
            pst.execute();
            pst.close();
            insertado = true;

        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        return insertado;
    }
    
    public boolean deleteAutor(int id){
       try {
            st = conexion.createStatement();
            st.executeUpdate("DELETE FROM AUTOR WHERE ID = " + id);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    
      public boolean updateAutor(Autor a){
        try {
            pst=conexion.prepareStatement("UPDATE AUTOR SET FechaNac = ?, Nombre = ?, Sinopsis = ? WHERE Id = ?");
            pst.setString(1, a.getFechaNac());
            pst.setString(2, a.getNombre());
            pst.setString(3, a.getSinopsis());
            pst.setInt(4, a.getId());
          
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : "+ex.getMessage());
            return false;
        }
    }
}

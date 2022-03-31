
package controlador;

import static controlador.ConexionControl.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Exposicion;
/**
 *
 * @author Eva
 */
public class ControlExposicion {
    ResultSet rs;
    PreparedStatement pst;
    Statement st;
    
    
     public ArrayList<Exposicion> listaExposiciones(){
       ArrayList<Exposicion> listaExposicones = new ArrayList<>();
       try{
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM EXPOSICION ORDER BY IDEXP");
            while(rs.next()){
                String id = rs.getString("IdExp");
                String titulo = rs.getString("Descripcion");
                String fechaPubli = rs.getString("Fecha");
                String lenguaje = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String cp = rs.getString("codigoPostal");
                String municipio = rs.getString("municipio");
                Exposicion exp = new Exposicion(id, titulo, fechaPubli, lenguaje, direccion, cp, municipio);
                listaExposicones.add(exp);
            }
            
       }catch(SQLException e){
           System.out.println("Error: "+e);
       }
       return listaExposicones;
     
    }
     
     
    public boolean saveExposicion(Exposicion exp){
         boolean insertado = false;
        try {
            pst = conexion.prepareStatement("INSERT INTO EXPOSICION VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, exp.getId());
            pst.setString(2, exp.getDesc());
            pst.setString(3, exp.getFecha());
            pst.setString(4, exp.getNombre());
            pst.setString(5, exp.getDireccion());
            pst.setInt(6, Integer.parseInt(exp.getCp()));
            pst.setString(7, exp.getMunicipio());
            pst.execute();
            pst.close();
            insertado = true;

        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        return insertado;
    }
   
    public boolean deleteExposicion(String id){
       try {
            st = conexion.createStatement();
            st.executeUpdate("DELETE FROM EXPOSICION WHERE IDEXP = '" + id+"'");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
      public boolean updateExposicion(Exposicion e){
        try {
            pst=conexion.prepareStatement("UPDATE EXPOSICION SET DESCRIPCION = ?, FECHA = ?, NOMBRE = ?, DIRECCION = ?, CODIGOPOSTAL = ?, MUNICIPIO = ? WHERE IDEXP = ?");
            pst.setString(1, e.getDesc());
            pst.setString(2, e.getFecha());
            pst.setString(3, e.getNombre());
            pst.setString(4, e.getDireccion());
            pst.setString(5, e.getCp());
            pst.setString(6, e.getMunicipio());
            pst.setString(7, e.getId());
          
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : "+ex.getMessage());
            return false;
        }
    }
   
}

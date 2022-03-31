/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ConexionControl.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Autor;
import models.Libro;

/**
 *
 * @author Eva
 */
public class ControlLibros {
    ResultSet rs;
    PreparedStatement pst;
    Statement st;
    
    public ArrayList<Libro> listaLibros(){
       ArrayList<Libro> listaLibros = new ArrayList<>();
       try{
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM LIBRO ORDER BY IDLIBRO");
            while(rs.next()){
                String id = rs.getString("IdLibro");
                String titulo = rs.getString("Titulo");
                String fechaPubli = rs.getString("FechaPublicacion");
                String lenguaje = rs.getString("Lenguaje");
                Libro libro = new Libro(id, titulo,fechaPubli, lenguaje);
                listaLibros.add(libro);
            }
            
       }catch(SQLException e){
           System.out.println("Error: "+e);
       }
       return listaLibros;
     
    }
    
    public boolean saveLibro(Libro libro){
         boolean insertado = false;
        try {
            pst = conexion.prepareStatement("INSERT INTO LIBRO VALUES (?,?,?,?)");
            pst.setString(1, libro.getId());
            pst.setString(2, libro.getTitulo());
            pst.setString(3, libro.getFechaPublicacion());
            pst.setString(4, libro.getLenguaje());
            pst.execute();
            pst.close();
            insertado = true;

        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        return insertado;
    }
    
    public boolean deleteLibro(String id){
       try {
            st = conexion.createStatement();
            st.executeUpdate("DELETE FROM LIBRO WHERE IDLIBRO = '" + id+"'");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    
      public boolean updateLibro(Libro li){
        try {
            pst=conexion.prepareStatement("UPDATE LIBRO SET TITULO = ?, FECHAPUBLICACION = ?, LENGUAJE = ? WHERE IDLIBRO = ?");
            pst.setString(1, li.getTitulo());
            pst.setString(2, li.getFechaPublicacion());
            pst.setString(3, li.getLenguaje());
            pst.setString(4,li.getId());
          
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR : "+ex.getMessage());
            return false;
        }
    }
}

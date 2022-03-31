
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionControl {
    public static Connection conexion;
    
    public boolean probarConexion(){
        boolean conectado = false;
        try{
            conexion = DriverManager.getConnection("jdbc:sqlite:C:/Users/Eva/Documents/GitHub/Niararu/basededatos.db");
            conectado = true;
        }catch(SQLException e){
            System.out.println("Error: "+e);
            
        }
        return conectado;
    }
   
            
}

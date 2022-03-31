package controlador;

import static controlador.ConexionControl.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Autor;
import models.Exposicion;
import models.Libro;

/**
 *
 * @author Eva
 */
public class ControlOrganizacion {

    ResultSet rs;
    PreparedStatement pst;
    Statement st;

    public ArrayList<Autor> listaAutores() {
        ArrayList<Autor> listaAutores = new ArrayList<>();
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM AUTOR ORDER BY ID");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String nombre = rs.getString("Nombre");
                Autor autor = new Autor(id, nombre);
                listaAutores.add(autor);

            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return listaAutores;

    }

    public ArrayList<Libro> listaLibros() {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT *FROM LIBRO ORDER BY IDLIBRO");
            while (rs.next()) {
                String id = rs.getString("IdLibro");
                String titulo = rs.getString("Titulo");
                String fechaPublicacion = rs.getString("FechaPublicacion");
                String lenguaje = rs.getString("Lenguaje");

                Libro libro = new Libro(id, titulo, fechaPublicacion, lenguaje);
                listaLibros.add(libro);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return listaLibros;

    }

    public ArrayList<Exposicion> listaExposicion() {
        ArrayList<Exposicion> listaExposicion = new ArrayList<>();
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT *FROM Exposicion ORDER BY IDEXP");
            while (rs.next()) {
                String id = rs.getString("IdExp");
                String nombre = rs.getString("nombre");

                Exposicion exp = new Exposicion(id, nombre);
                listaExposicion.add(exp);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return listaExposicion;

    }

    public int comprobarExistenciaAutor_Exp(int idAutor, String idExp) {
        int contador = 0;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM AUTOR_EXPOSICION WHERE IDAUTOR = " + idAutor + " AND IDEXP = '" + idExp + "'");

            while (rs.next()) {
                contador += 1;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return contador;
    }

    public boolean insertRelacionAutor_Exp(int idAutor, String idExp) {

        try {
            pst = conexion.prepareStatement("INSERT INTO AUTOR_EXPOSICION VALUES (?,?)");
            pst.setInt(1, idAutor);
            pst.setString(2, idExp);
            pst.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }

        return false;
    }

    public int comprobarExistenciaLibro_Exp(String idLibro, String idExp) {
        int contador = 0;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM LIBRO_EXPOSICION WHERE IDLIBRO != '" + idLibro + "' AND IDEXP != '" + idExp + "'");

            while (rs.next()) {
                contador += 1;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }

        return contador;
    }

    public boolean insertRelacionLibro_Exp(String idLibro, String idExp) {

        try {
            pst = conexion.prepareStatement("INSERT INTO LIBRO_EXPOSICION VALUES (?,?)");
            pst.setString(1, idLibro);
            pst.setString(2, idExp);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            return false;
        }

    }

    public int comprobarIdLibro(String idLibro) {
        int contador = 0;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM LIBRO WHERE IDLIBRO = '" + idLibro + "'");

            while (rs.next()) {
                contador += 1;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return contador;
    }

    public boolean borrarAutor_Exp(int idAutor, String idExp) {
        try {
            st = conexion.createStatement();
            st.executeUpdate("DELETE FROM AUTOR_EXPOSICION WHERE IDAUTOR = " + idAutor + "AND IDEXP = '"+ idExp+"'");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean borrarLibro_Exp(String idlibro, String idExp) {
        try {
            st = conexion.createStatement();
            st.executeUpdate("DELETE FROM LIBRO_EXPOSICION WHERE IDLIBRO = " + idlibro + "AND IDEXP = '"+ idExp+"'");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}

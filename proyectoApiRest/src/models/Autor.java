
package models;

/**
 *
 * @author Eva
 */
public class Autor {
    int Id;
    String FechaNac;
    String nombre;
    String sinopsis;
    
      public Autor( String FechaNac, String nombre, String sinopsis) {
       
        this.FechaNac = FechaNac;
        this.nombre = nombre;
        this.sinopsis = sinopsis;
    }

    public Autor(int Id, String FechaNac, String nombre, String sinopsis) {
        this.Id = Id;
        this.FechaNac = FechaNac;
        this.nombre = nombre;
        this.sinopsis = sinopsis;
    }

    public Autor(int id, String nombre) {
        this.Id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    
    public String toString(){
        return this.getId() + "-"+ this.getNombre();
    }

   
}
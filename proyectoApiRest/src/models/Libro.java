
package models;

/**
 *
 * @author Eva
 */
public class Libro {
    String Id;
    String titulo;
    String fechaPublicacion;
    String lenguaje;

    public Libro(String Id, String titulo, String fechaPublicacion, String lenguaje) {
        this.Id = Id;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.lenguaje = lenguaje;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    public String toString(){
        return this.getId() + "-"+ this.getTitulo();
    }
    
    
}

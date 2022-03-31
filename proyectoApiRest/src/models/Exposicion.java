
package models;

/**
 *
 * @author Eva
 */
public class Exposicion {
    String Id;
    String Desc;
    String Fecha;
    String nombre;
    String direccion;
    String cp;
    String municipio;

    public Exposicion(String Id, String Desc, String Fecha, String nombre, String direccion, String cp, String municipio) {
        this.Id = Id;
        this.Desc = Desc;
        this.Fecha = Fecha;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cp = cp;
        this.municipio = municipio;
    }

    public Exposicion(String id, String nombre) {
        this.Id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    public String toString(){
        return this.getId() + "-"+ this.getNombre();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Eva
 */
public class Autor_Exposicion {
    int id_Autor;
    String idExp;

    public Autor_Exposicion(int id_Autor, String idExp) {
        this.id_Autor = id_Autor;
        this.idExp = idExp;
    }

    public int getId_Autor() {
        return id_Autor;
    }

    public void setId_Autor(int id_Autor) {
        this.id_Autor = id_Autor;
    }

    public String getIdExp() {
        return idExp;
    }

    public void setIdExp(String idExp) {
        this.idExp = idExp;
    }
    
}

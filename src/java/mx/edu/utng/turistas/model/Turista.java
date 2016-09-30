/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.turistas.model;

/**
 *
 * @author Omar Uriel Rodriguez Castañeda
 */
public class Turista {
   private int idTurista;
   private String nombre;
   private String telefono;
   private String pais;
   private String email;

    public Turista(int idTurista, String nombre, String telefono, String pais, String email) {
        this.idTurista = idTurista;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pais = pais;
        this.email = email;
    }

    public Turista() {
        this(0,"","","","");
    }

    public int getIdTurista() {
        return idTurista;
    }

    public void setIdTurista(int idTurista) {
        this.idTurista = idTurista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    
}

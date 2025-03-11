package com.mycompany.portaldelsaber.logica;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Docente implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_Docente;
    private String nombre;
    private String apellidos;
    private String cedula; 
    private String anio;  
    private String estado; 

    public Docente() {}

    public Docente(int id_Docente, String nombre, String apellido, String cedula, String anio, String estado) {
        this.id_Docente = id_Docente;
        this.nombre = nombre;
        this.apellidos = apellido;
        this.cedula = cedula;
        this.anio = anio;
        this.estado = estado;
    }

    public int getId_Docente() {
        return id_Docente;
    }

    public void setId_Docente(int id_Docente) {
        this.id_Docente = id_Docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula.matches("\\d{8,10}")){
            this.cedula = cedula;
        } else {
            throw new IllegalArgumentException("La cédula debe contener máximo 10 dígitos numéricos.");
        }
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
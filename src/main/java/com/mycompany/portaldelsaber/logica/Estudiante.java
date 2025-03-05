package com.mycompany.portaldelsaber.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_Estudiante;
    private String nombre;
    private String apellido;
    private String tarjetaIdentidad;  // Cambiado a String
    private String grado;  // Manteniendo como String
    private String anio;  // Cambiado a String

    
    public Estudiante() {}

    public Estudiante(int id_Estudiante, String nombre,  String apellido, String tarjetaIdentidad, String grado, String anio, String observaciones) {
        this.id_Estudiante = id_Estudiante;
        this.nombre = nombre;
        this.tarjetaIdentidad = tarjetaIdentidad;
        this.grado = grado;
        this.anio = anio;

        this.apellido = apellido;
    }

    public int getId_Estudiante() {
        return id_Estudiante;
    }

    public void setId_Estudiante(int id_Estudiante) {
        this.id_Estudiante = id_Estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido () {
        return apellido;
    }

    public void setApellido (String apellido) {
        this.apellido = apellido ;
    }

    public String getTarjetaIdentidad() {
        return tarjetaIdentidad;
    }

    public void setTarjetaIdentidad(String tarjetaIdentidad) {
        this.tarjetaIdentidad = tarjetaIdentidad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }


}

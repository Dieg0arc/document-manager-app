package com.mycompany.portaldelsaber.logica;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_Estudiante;
    private String nombre;
    private String apellido;
    private String registro_civil;
    private String grado;
    private String anio;
    
    @OneToOne
    private Acudiente acudiente;  // Relación con Acudiente
    
    public Estudiante() {}
    
    public Estudiante(int id_Estudiante, String nombre, String apellido, String registrocivil, String grado, String anio, String observaciones) {
        this.id_Estudiante = id_Estudiante;
        this.nombre = nombre;
        this.registro_civil = registrocivil;
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
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getregistro_civil() {
        return registro_civil;
    }
    
    public void setregistro_civil(String registro_civil) {
        if (registro_civil.matches("\\d{10,11}")) {
           this.registro_civil = registro_civil;
        } else {
            throw new IllegalArgumentException("El registro civil debe tener mínimo 10 digitos y máximo 11 digitos.");
        }
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
    
    // Métodos getter y setter para acudiente
    public Acudiente getAcudiente() {
        return acudiente;
    }
    
    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }
}
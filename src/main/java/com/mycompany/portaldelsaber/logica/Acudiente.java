package com.mycompany.portaldelsaber.logica;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acudientes")  // Especifica el nombre correcto de la tabla
public class Acudiente implements Serializable {
    
    @Id
    private String cedulaAcuediente;
    
    private String nombreAcudiente;
    private String apellidoAcudiente;
    private String telefonoAcudiente;
    private String parentesco;
    
    // Este es el campo que falta y causa que aparezca NULL
    private String estudiante_registro_civil;
    
    // Relación bidireccional con Estudiante
    @OneToOne(mappedBy = "acudiente")
    private Estudiante estudiante;
    
    public Acudiente() {
    }
    
    public Acudiente(String cedulaAcuediente, String nombreAcudiente, String apellidoAcudiente, 
                     String telefonoAcudiente, String parentesco, String estudiante_registro_civil) {
        this.cedulaAcuediente = cedulaAcuediente;
        this.nombreAcudiente = nombreAcudiente;
        this.apellidoAcudiente = apellidoAcudiente;
        this.telefonoAcudiente = telefonoAcudiente;
        this.parentesco = parentesco;
        this.estudiante_registro_civil = estudiante_registro_civil;
    }
    
    public String getCedulaAcuediente() {
        return cedulaAcuediente;
    }
    
    public void setCedulaAcuediente(String cedulaAcuediente) {
        this.cedulaAcuediente = cedulaAcuediente;
    }
    
    public String getNombreAcudiente() {
        return nombreAcudiente;
    }
    
    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }
    
    public String getApellidoAcudiente() {
        return apellidoAcudiente;
    }
    
    public void setApellidoAcudiente(String apellidoAcudiente) {
        this.apellidoAcudiente = apellidoAcudiente;
    }
    
    public String getTelefonoAcudiente() {
        return telefonoAcudiente;
    }
    
    public void setTelefonoAcudiente(String telefonoAcudiente) {
        this.telefonoAcudiente = telefonoAcudiente;
    }
    
    public String getParentesco() {
        return parentesco;
    }
    
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
    
    // Getter y Setter para estudiante_registro_civil
    public String getEstudiante_registro_civil() {
        return estudiante_registro_civil;
    }
    
    public void setEstudiante_registro_civil(String estudiante_registro_civil) {
        this.estudiante_registro_civil = estudiante_registro_civil;
    }
    
    // Getter y Setter para la relación con Estudiante
    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
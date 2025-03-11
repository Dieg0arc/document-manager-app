package com.mycompany.portaldelsaber.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Acudiente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_Acudiente;
    
    private String cedula; // Cambiado a String para evitar problemas con ceros a la izquierda
    private String nombre;
    private String apellido;
    private String telefono;

    @OneToMany(mappedBy = "acudiente", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    public Acudiente() {}

    public Acudiente(int id_Acudiente, String cedula, String nombre, String apellido, String telefono, List<Estudiante> estudiantes) {
        this.id_Acudiente = id_Acudiente;
        setCedula(cedula);
        this.nombre = nombre;
        this.apellido = apellido;
        setTelefono(telefono);
        this.estudiantes = estudiantes;
    }

    // Getters y Setters con validaciones
    public int getId_Acudiente() {
        return id_Acudiente;
    }

    public void setId_Acudiente(int id_Acudiente) {
        this.id_Acudiente = id_Acudiente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula.matches("\\d{8,10}")) {
            this.cedula = cedula;
        } else {
            throw new IllegalArgumentException("La cédula debe contener máximo 10 dígitos numéricos.");
        }
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono.matches("3\\d{9}")) {
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("El número de teléfono debe tener exactamente 10 dígitos y comenzar con 3.");
        }
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}

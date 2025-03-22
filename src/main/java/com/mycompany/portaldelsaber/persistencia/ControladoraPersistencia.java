package com.mycompany.portaldelsaber.persistencia;

import com.mycompany.portaldelsaber.logica.Acudiente;
import com.mycompany.portaldelsaber.logica.Estudiante;
import com.mycompany.portaldelsaber.persistencia.exceptions.NonexistentEntityException;
import com.mycompany.portaldelsaber.persistencia.exceptions.PreexistingEntityException;

public class ControladoraPersistencia {
    
    EstudianteJpaController estudianteJPA = new EstudianteJpaController();
    AcudienteJpaController acudienteJPA = new AcudienteJpaController();
    
    // Modificamos este método para manejar la excepción PreexistingEntityException
    public void guardarAcudiente(Acudiente acudiente) {
        try {
            acudienteJPA.create(acudiente);
        } catch (PreexistingEntityException ex) {
            // Puedes manejar la excepción aquí o propagarla
            throw new RuntimeException("Error: El acudiente con cédula " + acudiente.getCedulaAcuediente() + " ya existe.", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al guardar el acudiente: " + ex.getMessage(), ex);
        }
    }
    
    public void guardarEstudiante(Estudiante estudiante) {
        estudianteJPA.create(estudiante);
    }
    
    public void actualizarEstudiante(Estudiante estudiante) {
        try {
            estudianteJPA.edit(estudiante);
        } catch (Exception ex) {
            throw new RuntimeException("Error al actualizar el estudiante: " + ex.getMessage());
        }
    }
    
    public Estudiante buscarEstudiantePorId(int id) {
        return estudianteJPA.findEstudiante(id);
    }
    
    public Acudiente buscarAcudientePorCedula(String cedula) {
        return acudienteJPA.findAcudiente(cedula);
    }
    
    public void eliminarEstudiante(int id) {
        try {
            estudianteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            throw new RuntimeException("Error al eliminar el estudiante: " + ex.getMessage());
        }
    }
    
    public void eliminarAcudiente(String cedula) {
        try {
            acudienteJPA.destroy(cedula);
        } catch (NonexistentEntityException ex) {
            throw new RuntimeException("Error al eliminar el acudiente: " + ex.getMessage());
        }
    }
}
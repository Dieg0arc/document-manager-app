package com.mycompany.portaldelsaber.logica;
import com.mycompany.portaldelsaber.persistencia.ControladoraPersistencia;
import com.mycompany.portaldelsaber.persistencia.EstudianteJpaController;
import com.mycompany.portaldelsaber.persistencia.exceptions.NonexistentEntityException;

public class Controladora {
    
    private ControladoraPersistencia controlPersi = new ControladoraPersistencia();
    private EstudianteJpaController estudianteJPA = new EstudianteJpaController();
    
    public void guardar(String nombre, String observaciones, String tarjeta, int anio, String grado) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        // Agregar otros campos según sea necesario
    }
    
    public void guardarAcudiente(Acudiente acudiente) {
        try {
            controlPersi.guardarAcudiente(acudiente);
        } catch (RuntimeException ex) {
            // Aquí puedes manejar la excepción o propagarla
            throw ex;
        }
    }
    
    public void guardarAcudienteYAsociarAEstudiante(Acudiente acudiente, String registroCivilEstudiante) {
        try {
            // Primero guardamos el acudiente
            guardarAcudiente(acudiente);
            
            // Luego buscamos el estudiante por su registro civil
            Estudiante estudiante = buscarEstudiantePorRegistroCivil(registroCivilEstudiante);
            
            if (estudiante != null) {
                // Asociar el acudiente al estudiante
                estudiante.setAcudiente(acudiente);
                
                // Actualizar el estudiante en la base de datos
                actualizarEstudiante(estudiante);
            } else {
                throw new RuntimeException("No se encontró un estudiante con el registro civil: " + registroCivilEstudiante);
            }
        } catch (RuntimeException ex) {
            throw ex;
        }
    }
    
    // Método para buscar un estudiante por su registro civil
    private Estudiante buscarEstudiantePorRegistroCivil(String registroCivil) {
        // Usar el método no estático del controlador JPA
        return estudianteJPA.findEstudianteByRegistroCivil(registroCivil);
    }
    
    // Método para actualizar un estudiante en la base de datos
    private void actualizarEstudiante(Estudiante estudiante) {
        try {
            // Usar el método no estático
            estudianteJPA.edit(estudiante);
        } catch (Exception ex) {
            throw new RuntimeException("Error al actualizar el estudiante: " + ex.getMessage());
        }
    }
}
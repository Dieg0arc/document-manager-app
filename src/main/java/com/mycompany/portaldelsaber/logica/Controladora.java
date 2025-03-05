
package com.mycompany.portaldelsaber.logica;

import com.mycompany.portaldelsaber.persistencia.ControladoraPersistencia;



public class Controladora {
    
    ControladoraPersistencia controlPersi = new ControladoraPersistencia();

    public void guardar(String nombre, String observaciones, String tarjeta, int anio, String grado) {
         
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);

        
        

    }
    
}

 
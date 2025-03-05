package com.mycompany.portaldelsaber.persistencia;

public class TestInsertarDatos {
    public static void main(String[] args) {
        // Prueba insertar un estudiante
        ConexionBD.insertarEstudiante("1234567890", "Juan", "Pérez", "Jardín", 2023);

        // Prueba insertar un docente
        ConexionBD.insertarDocente("0987654321", "María", "Gómez", 2025, "Activo");
    }
}

package com.mycompany.portaldelsaber.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/portalsaberdb";
    private static final String USUARIO = "root"; // Cambia si tienes otro usuario en MySQL
    private static final String CONTRASEÑA = "";  // Si tienes contraseña, agrégala aquí

    // Método para conectar con la base de datos
    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("✅ Conexión exitosa a la base de datos");
            return conexion;
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }

    // Método para insertar estudiantes
    public static boolean insertarEstudiante(String registrocivil, String nombre, String apellidos, String grado, int anio) {
        String sql = "INSERT INTO estudiantes (registro_civil, nombre, apellidos, grado, anio) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = conectar(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, registrocivil);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, grado);
            ps.setInt(5, anio);
            ps.executeUpdate();
            System.out.println("✅ Estudiante insertado correctamente.");
            return true;
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar estudiante: " + e.getMessage());
            return false;
        }
    }

    // Método para insertar docentes
    public static boolean insertarDocente(String cedula, String nombre, String apellidos, String estado, int anio) {
        String sql = "INSERT INTO docentes (cedula, nombre, apellidos, estado, anio) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = conectar(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, estado);
            ps.setInt(5, anio);
            ps.executeUpdate();
            System.out.println("✅ Docente insertado correctamente.");
            return true;
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar docente: " + e.getMessage());
            return false;
        }
    }
}

package Clases;

import java.sql.*;
import java.util.*;

public class GrafoConsultas {

    private Connection conexion;

    public GrafoConsultas() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, List<Arista>> construirGrafo() {
    	
        Map<String, List<Arista>> grafo = new HashMap<>();

        String sql = """
            SELECT c.paciente_codigo AS paciente_codigo, c.doctor_codigo AS doctor_codigo, c.precio
            FROM consulta c
            JOIN paciente p ON c.paciente_codigo = p.codigo
            JOIN doctor d ON c.doctor_codigo = d.codigo
        """;

        try (Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	String paciente = "el Paciente: " + rs.getInt("paciente_codigo");
            	String doctor = "el Doctor: " + rs.getInt("doctor_codigo");
                int precio = rs.getInt("precio");

                // Relacion paciente -> doctor
                grafo.computeIfAbsent(paciente, k -> new ArrayList<>()).add(new Arista(doctor, precio));

                // Relacion doctor -> paciente
                grafo.computeIfAbsent(doctor, k -> new ArrayList<>()).add(new Arista(paciente, precio));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return grafo;
    }
}


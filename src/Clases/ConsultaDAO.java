package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class ConsultaDAO {

    public static HashMap<Integer, doctor> obtenerDoctoresPorFecha(String fecha) {
    	HashMap<Integer, doctor> doctores = new HashMap<>();

        String sql = "SELECT DISTINCT p.codigo, p.nombre " +
                     "FROM consulta c " +
                     "JOIN doctor p ON c.doctor_codigo = p.codigo " +
                     "WHERE c.fecha = ?";

        try (Connection conn = conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fecha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");

                doctor doc = new doctor(codigo, nombre);
                doctores.put(codigo, doc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return doctores;
    }
}


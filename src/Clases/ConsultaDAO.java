package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class ConsultaDAO {

    public static HashMap<Integer, doctor> obtenerDoctoresPorFecha(String fecha) {
    	HashMap<Integer, doctor> doctores = new HashMap<>();

        String sql = "SELECT DISTINCT p.ci, p.apellido " +
                     "FROM consulta c " +
                     "JOIN doctor p ON c.doctor_codigo = p.codigo " +
                     "WHERE c.fecha = ?";

        try (Connection conn = conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fecha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ci = rs.getInt("ci");
                String apellido = rs.getString("apellido");

                doctor doc = new doctor(ci, apellido);
                doctores.put(ci, doc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return doctores;
    }
}


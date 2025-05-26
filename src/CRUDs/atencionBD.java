package CRUDs;

import hospital.consulta;
import java.sql.*;
import java.util.ArrayList;

public class atencionBD {

    private Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public ArrayList<consulta> obtenerConsultasOrdenadas() {
        ArrayList<consulta> lista = new ArrayList<>();

        String sql = "SELECT c.detalle, p.nombre AS paciente, a.nivel_urgencia " +
                     "FROM consultas c " +
                     "JOIN paciente p ON c.pacienteCodigo = p.codigo " +
                     "JOIN atencion a ON a.consultasCodigo = c.codigo " +
                     "ORDER BY FIELD(a.nivel_urgencia, 'crítico', 'urgente', 'semiurgente', 'no urgente')";

        try (Connection con = conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String detalle = rs.getString("detalle");
                String paciente = rs.getString("paciente");
                String nivel = rs.getString("nivel_urgencia");

                // Asegúrate de que tienes este constructor en tu clase `consulta`
                consulta consulta = new consulta(detalle, paciente, nivel);
                lista.add(consulta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}

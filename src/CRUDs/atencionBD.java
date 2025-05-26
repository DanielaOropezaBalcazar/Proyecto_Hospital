package CRUDs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Clases.consulta;

public class atencionBD {

    private Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public ArrayList<consulta> obtenerConsultasOrdenadas() {
        ArrayList<consulta> lista = new ArrayList<>();

        String sql = "SELECT c.detalle, p.nombre AS paciente, a.nivel_urgencia " +
                "FROM consultas c " +
                "JOIN paciente p ON c.paciente_codigo = p.codigo " +
                "JOIN atencion a ON a.consultas_codigo = c.codigo " +
                "ORDER BY FIELD(a.nivel_urgencia, 'crítico', 'urgente', 'semiurgente', 'no urgente')";

        try (Connection con = conectar();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String detalle = rs.getString("detalle");
                int paciente = rs.getInt("paciente_codigo");
                String nivel = rs.getString("nivel_urgencia");
                consulta consulta = new consulta(detalle, paciente, nivel);
                lista.add(consulta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}

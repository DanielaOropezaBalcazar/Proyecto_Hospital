package CRUDs;

import Clases.consulta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class consultaBD {
    private Connection conexion;

    // Constructor para establecer conexión con la base de datos
    public consultaBD() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crear una nueva consulta
    public void agregarConsulta(consulta consulta) {
        String sql = "INSERT INTO consulta (codigo, detalle, fecha, precio, doctor_codigo, paciente_codigo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, consulta.getCodigo());
            parametro.setString(2, consulta.getDetalle());
            parametro.setDate(3, Date.valueOf(consulta.getFecha()));
            parametro.setInt(4, consulta.getPrecio());
            parametro.setInt(5, consulta.getDoctorCodigo());
            parametro.setInt(6, consulta.getCodigo());
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Editar una consulta existente
    public void editarConsulta(consulta consulta, int codigo) {
        String sql = "UPDATE consulta SET detalle = ?, fecha = ?, precio = ?, doctor_codigo = ?, paciente_codigo = ? WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setString(1, consulta.getDetalle());
            parametro.setDate(2, Date.valueOf(consulta.getFecha()));
            parametro.setInt(3, consulta.getPrecio());
            parametro.setInt(4, consulta.getDoctorCodigo());
            parametro.setInt(5, consulta.getCodigo());
            parametro.setInt(6, codigo);
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Eliminar una consulta por su código
    public void eliminarConsulta(int codigo) {
        String sql = "DELETE FROM consulta WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, codigo);
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Obtener una consulta por su código
    public consulta obtenerConsulta(int codigo) {
        String sql = "SELECT * FROM consulta WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, codigo);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
                return new consulta(
                    rs.getInt("codigo"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getString("detalle"),
                    rs.getInt("precio"),
                    rs.getInt("doctor_codigo"),
                    rs.getInt("paciente_codigo")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todas las consultas
    public List<consulta> obtenerTodas() {
        List<consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM consulta";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                consultas.add(new consulta(
                    rs.getInt("codigo"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getString("detalle"),
                    rs.getInt("precio"),
                    rs.getInt("doctor_codigo"),
                    rs.getInt("paciente_codigo")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultas;
    }

}

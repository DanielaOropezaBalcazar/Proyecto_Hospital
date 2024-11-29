package CRUDs;

import Clases.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class pacienteBD {
    private Connection conexion;

    public pacienteBD() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crear un nuevo paciente
    public void agregarPaciente(paciente paciente) {
        String sql = "INSERT INTO paciente (ci, nombre, apellido, fecha_nacimiento, tipo_sangre, genero) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, paciente.getCi());
            parametro.setString(2, paciente.getNombre());
            parametro.setString(3, paciente.getApellido());
            parametro.setDate(4, Date.valueOf(paciente.getFechaNacimiento()));
            parametro.setString(5, paciente.getTipoSangre());
            parametro.setBoolean(6, paciente.isGenero());
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Editar un paciente existente
    public void editarPaciente(paciente paciente, int codigo) {
        String sql = "UPDATE paciente SET ci = ?, nombre = ?, apellido = ?, fecha_nacimiento = ?, tipo_sangre = ?, genero = ? WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, paciente.getCi());
            parametro.setString(2, paciente.getNombre());
            parametro.setString(3, paciente.getApellido());
            parametro.setDate(4, Date.valueOf(paciente.getFechaNacimiento()));
            parametro.setString(5, paciente.getTipoSangre());
            parametro.setBoolean(6, paciente.isGenero());
            parametro.setInt(7, codigo);
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Eliminar un paciente por su código
    public void eliminarPaciente(int codigo) {
        String sql = "DELETE FROM paciente WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, codigo);
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Obtener un paciente por su código
    public paciente obtenerPaciente(int codigo) {
        String sql = "SELECT * FROM paciente WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, codigo);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
                return new paciente(
                    rs.getInt("ci"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getString("tipo_sangre"),
                    rs.getBoolean("genero")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todos los pacientes
    public List<paciente> obtenerTodos() {
        List<paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                pacientes.add(new paciente(
                	rs.getInt("ci"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getString("tipo_sangre"),
                    rs.getBoolean("genero")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pacientes;
    }


}

package CRUDs;

import Clases.doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class doctorBD {
    private Connection conexion;

    // Constructor para establecer conexión con la base de datos
    public doctorBD() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crear un nuevo doctor
    public void agregarDoctor(doctor doctor) {
        String sql = "INSERT INTO doctor (ci, nombre, apellido, fecha_nacimiento, fecha_ingreso, cargo, salario, especialidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement parametro = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            parametro.setInt(1, doctor.getCi());
            parametro.setString(2, doctor.getNombre());
            parametro.setString(3, doctor.getApellido());
            parametro.setDate(4, Date.valueOf(doctor.getFechaNacimiento()));
            parametro.setDate(5, Date.valueOf(doctor.getFechaIngreso()));
            parametro.setString(6, doctor.getCargo());
            parametro.setInt(7, doctor.getSalario());
            parametro.setString(8, doctor.getEspecialidad());
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Editar un doctor existente
    public void editarDoctor(doctor doctor, int codigo) {
        String sql = "UPDATE doctor SET ci = ?, nombre = ?, apellido = ?, fecha_nacimiento = ?, fecha_ingreso = ?, cargo = ?, salario = ?, especialidad = ? WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, doctor.getCi());
            parametro.setString(2, doctor.getNombre());
            parametro.setString(3, doctor.getApellido());
            parametro.setDate(4, Date.valueOf(doctor.getFechaNacimiento()));
            parametro.setDate(5, Date.valueOf(doctor.getFechaIngreso()));
            parametro.setString(6, doctor.getCargo());
            parametro.setInt(7, doctor.getSalario());
            parametro.setString(8, doctor.getEspecialidad());
            parametro.setInt(9, codigo);
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Eliminar un doctor por su código
    public void eliminarDoctor(int codigo) {
        String sql = "DELETE FROM doctor WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, codigo);
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Obtener un doctor por su código
    public doctor obtenerDoctor(int codigo) {
        String sql = "SELECT * FROM doctor WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, codigo);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
                return new doctor(
                    rs.getInt("codigo"),
                    rs.getInt("ci"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getDate("fecha_ingreso").toLocalDate(),
                    rs.getString("cargo"),
                    rs.getInt("salario"),
                    rs.getString("especialidad")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todos los doctors
    public List<doctor> obtenerTodos() {
        List<doctor> doctores = new ArrayList<>();
        String sql = "SELECT * FROM doctor";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                doctores.add(new doctor(
                    rs.getInt("codigo"),
                    rs.getInt("ci"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getDate("fecha_ingreso").toLocalDate(),
                    rs.getString("cargo"),
                    rs.getInt("salario"),
                    rs.getString("especialidad")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctores;
    }
}

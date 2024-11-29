package CRUDs;

import Clases.empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class empleadoBD {
    private Connection conexion;

    // Constructor para establecer conexión con la base de datos
    public empleadoBD() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crear un nuevo empleado
    public void agregarEmpleado(empleado empleado) {
        String sql = "INSERT INTO empleado (ci, nombre, apellido, fecha_nacimiento, fecha_inicio, cargo, salario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement parametro = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            parametro.setInt(1, empleado.getCi());
            parametro.setString(2, empleado.getNombre());
            parametro.setString(3, empleado.getApellido());
            parametro.setDate(4, Date.valueOf(empleado.getFechaNacimiento()));
            parametro.setDate(5, Date.valueOf(empleado.getFechaIngreso()));
            parametro.setString(6, empleado.getCargo());
            parametro.setInt(7, empleado.getSalario());
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Editar un empleado existente
    public void editarEmpleado(empleado empleado, int codigo) {
        String sql = "UPDATE empleado SET ci = ?, nombre = ?, apellido = ?, fecha_nacimiento = ?, fecha_inicio = ?, cargo = ?, salario = ? WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, empleado.getCi());
            parametro.setString(2, empleado.getNombre());
            parametro.setString(3, empleado.getApellido());
            parametro.setDate(4, Date.valueOf(empleado.getFechaNacimiento()));
            parametro.setDate(5, Date.valueOf(empleado.getFechaIngreso()));
            parametro.setString(6, empleado.getCargo());
            parametro.setInt(7, empleado.getSalario());
            parametro.setInt(8, codigo);
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Eliminar un empleado por su código
    public void eliminarEmpleado(int codigo) {
        String sql = "DELETE FROM empleado WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, codigo);
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Obtener un empleado por su código
    public empleado obtenerEmpleado(int codigo) {
        String sql = "SELECT * FROM empleado WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, codigo);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
                return new empleado(
                    rs.getInt("codigo"),
                    rs.getInt("ci"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getDate("fecha_inicio").toLocalDate(),
                    rs.getString("cargo"),
                    rs.getInt("salario")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todos los empleados
    public List<empleado> obtenerTodos() {
        List<empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                empleados.add(new empleado(
                    rs.getInt("codigo"),
                    rs.getInt("ci"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getDate("fecha_inicio").toLocalDate(),
                    rs.getString("cargo"),
                    rs.getInt("salario")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados;
    }
}

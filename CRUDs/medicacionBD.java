package CRUDs;

import Clases.medicacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class medicacionBD {
    private Connection conexion;

    // Constructor para establecer conexión con la base de datos
    public medicacionBD() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crear una nueva medicación
    public void agregarMedicacion(medicacion medicacion) {
        String sql = "INSERT INTO medicacion (nombre, laboratorio, detalle, precio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setString(1, medicacion.getNombre());
            parametro.setString(2, medicacion.getLaboratorio());
            parametro.setString(3, medicacion.getDetalle());
            parametro.setInt(4, medicacion.getPrecio());
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Editar una medicación existente
    public void editarMedicacion(medicacion medicacion, int codigo) {
        String sql = "UPDATE medicacion SET nombre = ?, laboratorio = ?, detalle = ?, precio = ? WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setString(1, medicacion.getNombre());
            parametro.setString(2, medicacion.getLaboratorio());
            parametro.setString(3, medicacion.getDetalle());
            parametro.setInt(4, medicacion.getPrecio());
            parametro.setInt(5, codigo);
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Eliminar una medicación por su código
    public void eliminarMedicacion(int codigo) {
        String sql = "DELETE FROM medicacion WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, codigo);
            parametro.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Obtener una medicación por su código
    public medicacion obtenerMedicacion(int codigo) {
        String sql = "SELECT * FROM medicacion WHERE codigo = ?";
        try (PreparedStatement parametro = conexion.prepareStatement(sql)) {
            parametro.setInt(1, codigo);
            ResultSet rs = parametro.executeQuery();
            if (rs.next()) {
                return new medicacion(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("laboratorio"),
                    rs.getString("detalle"),
                    rs.getInt("precio")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todas las medicaciones
    public List<medicacion> obtenerTodas() {
        List<medicacion> medicaciones = new ArrayList<>();
        String sql = "SELECT * FROM medicacion";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                medicaciones.add(new medicacion(
                    rs.getInt("codigo"),
                    rs.getString("nombre"),
                    rs.getString("laboratorio"),
                    rs.getString("detalle"),
                    rs.getInt("precio")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicaciones;
    }
}

package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = ""; 

    public static Connection conectar() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión establecida con la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: no se encontró el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return conn;
    }
}


package interfases;

import hospital.conexion;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class consulta extends JFrame {

    private JPanel contentPane;
    private JTable tableConsultas;
    private DefaultTableModel modeloTabla;
    private JTextField txFecha, txMotivo, txNombrePaciente, txNombreDoctor;

    public consulta() {
        setTitle("Gestión de Consultas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(144, 238, 144));
        setContentPane(contentPane);

        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setBounds(20, 20, 80, 20);
        contentPane.add(lblPaciente);

        txNombrePaciente = new JTextField();
        txNombrePaciente.setBounds(100, 20, 200, 20);
        contentPane.add(txNombrePaciente);

        JLabel lblDoctor = new JLabel("Doctor:");
        lblDoctor.setBounds(20, 50, 80, 20);
        contentPane.add(lblDoctor);

        txNombreDoctor = new JTextField();
        txNombreDoctor.setBounds(100, 50, 200, 20);
        contentPane.add(txNombreDoctor);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(20, 80, 80, 20);
        contentPane.add(lblFecha);

        txFecha = new JTextField();
        txFecha.setBounds(100, 80, 200, 20);
        contentPane.add(txFecha);

        JLabel lblMotivo = new JLabel("Motivo:");
        lblMotivo.setBounds(20, 110, 80, 20);
        contentPane.add(lblMotivo);

        txMotivo = new JTextField();
        txMotivo.setBounds(100, 110, 200, 20);
        contentPane.add(txMotivo);

        JButton btnAgregar = new JButton("Agregar Consulta");
        btnAgregar.setBounds(100, 140, 200, 25);
        contentPane.add(btnAgregar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(310, 20, 100, 25);
        contentPane.add(btnBuscar);

        modeloTabla = new DefaultTableModel(new String[]{"Paciente", "Doctor", "Fecha", "Motivo"}, 0);
        tableConsultas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tableConsultas);
        scrollPane.setBounds(20, 180, 740, 350);
        contentPane.add(scrollPane);

        mostrarConsultas();

        btnAgregar.addActionListener(e -> agregarConsulta());
        btnBuscar.addActionListener(e -> buscarPacienteYDoctor());
    }

    private void agregarConsulta() {
        String fecha = txFecha.getText();
        String motivo = txMotivo.getText();
        String nombrePaciente = txNombrePaciente.getText().trim();
        String nombreDoctor = txNombreDoctor.getText().trim();

        if (fecha.isEmpty() || motivo.isEmpty() || nombrePaciente.isEmpty() || nombreDoctor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos.");
            return;
        }

        try (Connection con = conexion.conectar()) {
            PreparedStatement psPaciente = con.prepareStatement("SELECT codigo FROM paciente WHERE nombre = ?");
            psPaciente.setString(1, nombrePaciente);
            ResultSet rsPaciente = psPaciente.executeQuery();
            if (!rsPaciente.next()) {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado.");
                return;
            }
            int pacienteCodigo = rsPaciente.getInt("codigo");

            PreparedStatement psDoctor = con.prepareStatement(
                    "SELECT d.codigo FROM doctor d JOIN empleado e ON d.empleadoCodigo = e.codigo WHERE e.nombre = ?");
            psDoctor.setString(1, nombreDoctor);
            ResultSet rsDoctor = psDoctor.executeQuery();
            if (!rsDoctor.next()) {
                JOptionPane.showMessageDialog(null, "Doctor no encontrado.");
                return;
            }
            int doctorCodigo = rsDoctor.getInt("codigo");

            PreparedStatement psInsert = con.prepareStatement(
                    "INSERT INTO consultas (fecha, detalle, precio, doctorCodigo, pacienteCodigo) VALUES (?, ?, ?, ?, ?)");
            psInsert.setString(1, fecha);
            psInsert.setString(2, motivo);
            psInsert.setDouble(3, 0);
            psInsert.setInt(4, doctorCodigo);
            psInsert.setInt(5, pacienteCodigo);
            psInsert.executeUpdate();

            JOptionPane.showMessageDialog(null, "Consulta guardada.");
            mostrarConsultas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void buscarPacienteYDoctor() {
        String nombrePaciente = txNombrePaciente.getText().trim();
        String nombreDoctor = txNombreDoctor.getText().trim();

        try (Connection con = conexion.conectar()) {
            String mensaje = "";

            // Buscar paciente
            PreparedStatement psPaciente = con.prepareStatement("SELECT * FROM paciente WHERE nombre = ?");
            psPaciente.setString(1, nombrePaciente);
            ResultSet rsPaciente = psPaciente.executeQuery();
            if (rsPaciente.next()) {
                mensaje += "Paciente: " + rsPaciente.getString("nombre") + " " + rsPaciente.getString("apellido") + "\n";
            } else {
                mensaje += "Paciente no encontrado.\n";
            }

            // Buscar doctor
            PreparedStatement psDoctor = con.prepareStatement(
                    "SELECT e.nombre, e.apellido FROM doctor d JOIN empleado e ON d.empleadoCodigo = e.codigo WHERE e.nombre = ?");
            psDoctor.setString(1, nombreDoctor);
            ResultSet rsDoctor = psDoctor.executeQuery();
            if (rsDoctor.next()) {
                mensaje += "Doctor: " + rsDoctor.getString("nombre") + " " + rsDoctor.getString("apellido") + "\n";
            } else {
                mensaje += "Doctor no encontrado.\n";
            }

            JOptionPane.showMessageDialog(null, mensaje);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage());
        }
    }

    private void mostrarConsultas() {
        modeloTabla.setRowCount(0);
        try (Connection con = conexion.conectar();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT p.nombre AS paciente, CONCAT(e.nombre, ' ', e.apellido) AS doctor, c.fecha, c.detalle " +
                             "FROM consultas c " +
                             "JOIN paciente p ON c.pacienteCodigo = p.codigo " +
                             "JOIN doctor d ON c.doctorCodigo = d.codigo " +
                             "JOIN empleado e ON d.empleadoCodigo = e.codigo")) {
            while (rs.next()) {
                modeloTabla.addRow(new Object[]{
                        rs.getString("paciente"),
                        rs.getString("doctor"),
                        rs.getString("fecha"),
                        rs.getString("detalle")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new consulta().setVisible(true);
    }
}


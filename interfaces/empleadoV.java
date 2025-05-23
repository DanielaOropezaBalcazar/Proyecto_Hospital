package interfases;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hospital.conexion;

public class empleado extends JFrame {

    private JPanel contentPane;
    private JTextField txtBuscarNombre;
    private JTextField txtHorarioLlegada;
    private JTextField txtHorarioSalida;
    private JTable tableEmpleados;
    private DefaultTableModel modeloTabla;

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEspecialidad;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                empleado frame = new empleado();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public empleado() {
        setTitle("Gestión de Empleados - Hospital");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 850, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(144, 238, 144));
        setContentPane(contentPane);

        JLabel lblMenu = new JLabel("Menú de Empleados");
        lblMenu.setFont(new Font("Arial", Font.BOLD, 16));
        lblMenu.setBounds(320, 10, 200, 30);
        contentPane.add(lblMenu);

        txtBuscarNombre = new JTextField();
        txtBuscarNombre.setBounds(150, 60, 200, 30);
        contentPane.add(txtBuscarNombre);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(50, 60, 80, 30);
        contentPane.add(btnBuscar);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(400, 60, 50, 30);
        contentPane.add(lblTipo);

        JRadioButton rbDoctor = new JRadioButton("Doctor");
        rbDoctor.setBounds(450, 60, 100, 30);
        rbDoctor.setBackground(new Color(144, 238, 144));
        contentPane.add(rbDoctor);

        JRadioButton rbEnfermero = new JRadioButton("Enfermero");
        rbEnfermero.setBounds(550, 60, 100, 30);
        rbEnfermero.setBackground(new Color(144, 238, 144));
        contentPane.add(rbEnfermero);

        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(rbDoctor);
        grupoTipo.add(rbEnfermero);

        modeloTabla = new DefaultTableModel(
            new Object[][] {},
            new String[] { "NOMBRE", "APELLIDO", "ESPECIALIDAD", "HORARIO_DE_LLEGADA", "HORARIO_DE_SALIDA" }
        );

        tableEmpleados = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tableEmpleados);
        scrollPane.setBounds(50, 110, 730, 250);
        contentPane.add(scrollPane);

        // NUEVOS CAMPOS
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 380, 100, 30);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 380, 150, 30);
        contentPane.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(290, 380, 100, 30);
        contentPane.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(360, 380, 150, 30);
        contentPane.add(txtApellido);

        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(530, 380, 100, 30);
        contentPane.add(lblEspecialidad);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(620, 380, 150, 30);
        contentPane.add(txtEspecialidad);

        JButton btnAgregarEmpleado = new JButton("Agregar Empleado");
        btnAgregarEmpleado.setBounds(300, 420, 200, 30);
        contentPane.add(btnAgregarEmpleado);

        // CAMPOS DE HORARIO
        JLabel lblHorarioLlegada = new JLabel("Horario Llegada:");
        lblHorarioLlegada.setBounds(50, 470, 120, 30);
        contentPane.add(lblHorarioLlegada);

        txtHorarioLlegada = new JTextField();
        txtHorarioLlegada.setBounds(170, 470, 150, 30);
        contentPane.add(txtHorarioLlegada);

        JLabel lblHorarioSalida = new JLabel("Horario Salida:");
        lblHorarioSalida.setBounds(340, 470, 120, 30);
        contentPane.add(lblHorarioSalida);

        txtHorarioSalida = new JTextField();
        txtHorarioSalida.setBounds(460, 470, 150, 30);
        contentPane.add(txtHorarioSalida);

        JButton btnAgregarHorario = new JButton("Agregar Horario");
        btnAgregarHorario.setBounds(630, 470, 150, 30);
        contentPane.add(btnAgregarHorario);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(300, 520, 100, 30);
        contentPane.add(btnEliminar);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(420, 520, 100, 30);
        contentPane.add(btnConfirmar);

        // Mostrar datos al iniciar
        mostrarDatos();

        btnBuscar.addActionListener(e -> {
            String nombreBuscado = txtBuscarNombre.getText().toLowerCase();
            String tipoSeleccionado = rbDoctor.isSelected() ? "doctor" : rbEnfermero.isSelected() ? "enfermero" : "";

            if (!nombreBuscado.isEmpty() && !tipoSeleccionado.isEmpty()) {
                DefaultTableModel modeloFiltrado = new DefaultTableModel(
                    new Object[][] {},
                    new String[] { "NOMBRE", "APELLIDO", "ESPECIALIDAD", "HORARIO_DE_LLEGADA", "HORARIO_DE_SALIDA" }
                );

                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                    String nombre = modeloTabla.getValueAt(i, 0).toString().toLowerCase();
                    String especialidad = modeloTabla.getValueAt(i, 2).toString().toLowerCase();

                    if (nombre.contains(nombreBuscado) && especialidad.contains(tipoSeleccionado)) {
                        modeloFiltrado.addRow(new Object[] {
                            modeloTabla.getValueAt(i, 0),
                            modeloTabla.getValueAt(i, 1),
                            modeloTabla.getValueAt(i, 2),
                            modeloTabla.getValueAt(i, 3),
                            modeloTabla.getValueAt(i, 4)
                        });
                    }
                }

                tableEmpleados.setModel(modeloFiltrado);

                if (modeloFiltrado.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre y seleccione el tipo.");
            }
        });

        btnAgregarHorario.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Ingrese nombre:");
            String apellido = JOptionPane.showInputDialog("Ingrese apellido:");
            String especialidad = JOptionPane.showInputDialog("Ingrese especialidad:");
            String llegada = txtHorarioLlegada.getText();
            String salida = txtHorarioSalida.getText();

            if (nombre != null && apellido != null && especialidad != null && !llegada.isEmpty() && !salida.isEmpty()) {
                try (Connection con = conexion.conectar()) {
                    PreparedStatement ps = con.prepareStatement("INSERT INTO empleado (nombre, apellido, especialidad, horario_llegada, horario_salida) VALUES (?, ?, ?, ?, ?)");
                    ps.setString(1, nombre);
                    ps.setString(2, apellido);
                    ps.setString(3, especialidad);
                    ps.setString(4, llegada);
                    ps.setString(5, salida);
                    ps.executeUpdate();

                    mostrarDatos(); // refrescar tabla
                    JOptionPane.showMessageDialog(null, "Empleado agregado.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Complete todos los campos.");
            }
        });
        btnAgregarHorario.addActionListener(e -> {
            int fila = tableEmpleados.getSelectedRow();
            if (fila >= 0) {
                String nombre = modeloTabla.getValueAt(fila, 0).toString();
                String apellido = modeloTabla.getValueAt(fila, 1).toString();
                String llegada = txtHorarioLlegada.getText();
                String salida = txtHorarioSalida.getText();

                if (!llegada.isEmpty() && !salida.isEmpty()) {
                    try (Connection con = conexion.conectar()) {
                        PreparedStatement ps = con.prepareStatement(
                            "UPDATE empleado SET horario_llegada = ?, horario_salida = ? WHERE nombre = ? AND apellido = ?"
                        );
                        ps.setString(1, llegada);
                        ps.setString(2, salida);
                        ps.setString(3, nombre);
                        ps.setString(4, apellido);
                        ps.executeUpdate();

                        mostrarDatos();
                        JOptionPane.showMessageDialog(null, "Horario agregado.");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al actualizar horario: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese horarios.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila.");
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = tableEmpleados.getSelectedRow();
            if (fila >= 0) {
                String nombre = modeloTabla.getValueAt(fila, 0).toString();
                String apellido = modeloTabla.getValueAt(fila, 1).toString();

                try (Connection con = conexion.conectar()) {
                    PreparedStatement ps = con.prepareStatement("DELETE FROM empleado WHERE nombre = ? AND apellido = ?");
                    ps.setString(1, nombre);
                    ps.setString(2, apellido);
                    ps.executeUpdate();

                    mostrarDatos();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila.");
            }
        });

        btnConfirmar.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Cambios confirmados.");
        });
    }

    public void mostrarDatos() {
        modeloTabla.setRowCount(0);
        try (Connection con = conexion.conectar()) {
            PreparedStatement ps = con.prepareStatement("SELECT nombre, apellido, especialidad, horario_llegada, horario_salida FROM empleado");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modeloTabla.addRow(new Object[] {
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("especialidad"),
                    rs.getString("horario_llegada"),
                    rs.getString("horario_salida")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos: " + e.getMessage());
        }
    }
}



package interfases;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class empleado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtBuscarNombre;
    private JTextField txtHorarioLlegada;
    private JTextField txtHorarioSalida;
    private JTable tableEmpleados;
    private DefaultTableModel modeloTabla;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    empleado frame = new empleado();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public empleado() {
        setTitle("Gestión de Empleados - Hospital");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cambiado a DISPOSE_ON_CLOSE
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(144, 238, 144)); // Color verde claro
        setContentPane(contentPane);

        JLabel lblMenu = new JLabel("Menú de Empleados");
        lblMenu.setFont(new Font("Arial", Font.BOLD, 16));
        lblMenu.setBounds(300, 10, 200, 30);
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
        rbDoctor.setBackground(new Color(144, 238, 144)); // Fondo verde claro
        contentPane.add(rbDoctor);

        JRadioButton rbEnfermero = new JRadioButton("Enfermero");
        rbEnfermero.setBounds(550, 60, 100, 30);
        rbEnfermero.setBackground(new Color(144, 238, 144)); // Fondo verde claro
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
        scrollPane.setBounds(50, 110, 680, 250);
        contentPane.add(scrollPane);

        JButton btnAgregarHorario = new JButton("Agregar_Horario");
        btnAgregarHorario.setBounds(50, 380, 150, 30);
        contentPane.add(btnAgregarHorario);

        JLabel lblHorarioLlegada = new JLabel("Horario_De_Llegada:");
        lblHorarioLlegada.setBounds(220, 380, 150, 30);
        contentPane.add(lblHorarioLlegada);

        txtHorarioLlegada = new JTextField();
        txtHorarioLlegada.setBounds(370, 380, 150, 30);
        contentPane.add(txtHorarioLlegada);

        JLabel lblHorarioSalida = new JLabel("Horario_De_Salida:");
        lblHorarioSalida.setBounds(220, 420, 150, 30);
        contentPane.add(lblHorarioSalida);

        txtHorarioSalida = new JTextField();
        txtHorarioSalida.setBounds(370, 420, 150, 30);
        contentPane.add(txtHorarioSalida);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(550, 380, 100, 30);
        contentPane.add(btnEliminar);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(550, 420, 100, 30);
        contentPane.add(btnConfirmar);

        modeloTabla.addRow(new Object[] { "Juan", "Pérez", "Cardiología", "08:00", "16:00" });
        modeloTabla.addRow(new Object[] { "Ana", "López", "Enfermería", "07:00", "15:00" });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreBuscado = txtBuscarNombre.getText().toLowerCase();
                String tipoSeleccionado = rbDoctor.isSelected() ? "Doctor" : rbEnfermero.isSelected() ? "Enfermero" : "";

                if (!nombreBuscado.isEmpty() && !tipoSeleccionado.isEmpty()) {
                    DefaultTableModel modeloFiltrado = new DefaultTableModel(
                            new Object[][] {},
                            new String[] { "NOMBRE", "APELLIDO", "ESPECIALIDAD", "HORARIO_DE_LLEGADA", "HORARIO_DE_SALIDA" }
                    );

                    for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                        String nombre = modeloTabla.getValueAt(i, 0).toString().toLowerCase();
                        String especialidad = modeloTabla.getValueAt(i, 2).toString().toLowerCase();

                        if (nombre.contains(nombreBuscado) && especialidad.contains(tipoSeleccionado.toLowerCase())) {
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
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre y seleccione el tipo (Doctor o Enfermero).");
                }
            }
        });

        btnAgregarHorario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Ingrese nombre:");
                String apellido = JOptionPane.showInputDialog("Ingrese apellido:");
                String especialidad = JOptionPane.showInputDialog("Ingrese especialidad:");
                String llegada = txtHorarioLlegada.getText();
                String salida = txtHorarioSalida.getText();

                if (nombre != null && apellido != null && especialidad != null && !llegada.isEmpty() && !salida.isEmpty()) {
                    modeloTabla.addRow(new Object[] { nombre, apellido, especialidad, llegada, salida });
                    JOptionPane.showMessageDialog(null, "Empleado agregado con horario.");
                } else {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos.");
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tableEmpleados.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    modeloTabla.removeRow(filaSeleccionada);
                    JOptionPane.showMessageDialog(null, "Empleado eliminado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
                }
            }
        });

        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Cambios confirmados.");
            }
        });
    }
}



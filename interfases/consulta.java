package interfases;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class consulta extends JFrame {

    private JPanel contentPane;
    private JTable tableConsultas;
    private DefaultTableModel modeloTabla;
    private JTextField txPaciente, txMedico, txFecha, txMotivo;
    private JTextField txBuscar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    consulta frame = new consulta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public consulta() {
        setTitle("Gestión de Consultas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cambio realizado aquí
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(144, 238, 144)); // Fondo verde claro
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Gestión de Consultas");
        lblTitulo.setBounds(320, 10, 150, 20);
        contentPane.add(lblTitulo);

        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setBounds(20, 50, 80, 20);
        contentPane.add(lblPaciente);

        JLabel lblMedico = new JLabel("Médico:");
        lblMedico.setBounds(20, 80, 80, 20);
        contentPane.add(lblMedico);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(20, 110, 80, 20);
        contentPane.add(lblFecha);

        JLabel lblMotivo = new JLabel("Motivo:");
        lblMotivo.setBounds(20, 140, 80, 20);
        contentPane.add(lblMotivo);

        txPaciente = new JTextField();
        txPaciente.setBounds(100, 50, 200, 20);
        contentPane.add(txPaciente);

        txMedico = new JTextField();
        txMedico.setBounds(100, 80, 200, 20);
        contentPane.add(txMedico);

        txFecha = new JTextField();
        txFecha.setBounds(100, 110, 200, 20);
        contentPane.add(txFecha);

        txMotivo = new JTextField();
        txMotivo.setBounds(100, 140, 200, 20);
        contentPane.add(txMotivo);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(320, 50, 100, 25);
        contentPane.add(btnAgregar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(320, 80, 100, 25);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(320, 110, 100, 25);
        contentPane.add(btnEliminar);

        JButton btnMostrarTodos = new JButton("Mostrar Todos");
        btnMostrarTodos.setBounds(320, 140, 150, 25);
        contentPane.add(btnMostrarTodos);

        JLabel lblBuscar = new JLabel("Buscar (Paciente):");
        lblBuscar.setBounds(500, 50, 120, 20);
        contentPane.add(lblBuscar);

        txBuscar = new JTextField();
        txBuscar.setBounds(620, 50, 150, 20);
        contentPane.add(txBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(620, 80, 100, 25);
        contentPane.add(btnBuscar);

        // Tabla de consultas
        modeloTabla = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Paciente", "Médico", "Fecha", "Motivo" }
        );
        tableConsultas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tableConsultas);
        scrollPane.setBounds(20, 200, 750, 350);
        contentPane.add(scrollPane);

        // Cambiar colores de otros componentes
        txPaciente.setBackground(new Color(240, 255, 240));
        txMedico.setBackground(new Color(240, 255, 240));
        txFecha.setBackground(new Color(240, 255, 240));
        txMotivo.setBackground(new Color(240, 255, 240));
        txBuscar.setBackground(new Color(240, 255, 240));

        scrollPane.getViewport().setBackground(new Color(240, 255, 240));

        // Acción para agregar consultas
        btnAgregar.addActionListener(e -> {
            String paciente = txPaciente.getText();
            String medico = txMedico.getText();
            String fecha = txFecha.getText();
            String motivo = txMotivo.getText();

            if (!paciente.isEmpty() && !medico.isEmpty() && !fecha.isEmpty() && !motivo.isEmpty()) {
                modeloTabla.addRow(new Object[] { paciente, medico, fecha, motivo });
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Consulta agregada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
            }
        });

        // Acción para editar una consulta seleccionada
        btnEditar.addActionListener(e -> {
            int filaSeleccionada = tableConsultas.getSelectedRow();
            if (filaSeleccionada >= 0) {
                modeloTabla.setValueAt(txPaciente.getText(), filaSeleccionada, 0);
                modeloTabla.setValueAt(txMedico.getText(), filaSeleccionada, 1);
                modeloTabla.setValueAt(txFecha.getText(), filaSeleccionada, 2);
                modeloTabla.setValueAt(txMotivo.getText(), filaSeleccionada, 3);
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Consulta editada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para editar.");
            }
        });

        // Acción para eliminar una consulta
        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = tableConsultas.getSelectedRow();
            if (filaSeleccionada >= 0) {
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Consulta eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
            }
        });

        // Acción para mostrar todas las consultas
        btnMostrarTodos.addActionListener(e -> {
            tableConsultas.setModel(modeloTabla);
        });

        // Acción para buscar consultas por paciente
        btnBuscar.addActionListener(e -> {
            String pacienteBuscado = txBuscar.getText().toLowerCase();
            DefaultTableModel modeloFiltrado = new DefaultTableModel(
                    new Object[][] {},
                    new String[] { "Paciente", "Médico", "Fecha", "Motivo" }
            );

            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                String paciente = modeloTabla.getValueAt(i, 0).toString().toLowerCase();
                if (paciente.contains(pacienteBuscado)) {
                    modeloFiltrado.addRow(new Object[] {
                            modeloTabla.getValueAt(i, 0),
                            modeloTabla.getValueAt(i, 1),
                            modeloTabla.getValueAt(i, 2),
                            modeloTabla.getValueAt(i, 3)
                    });
                }
            }

            tableConsultas.setModel(modeloFiltrado);

            if (modeloFiltrado.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados.");
            }
        });
    }

    private void limpiarCampos() {
        txPaciente.setText("");
        txMedico.setText("");
        txFecha.setText("");
        txMotivo.setText("");
        txBuscar.setText("");
    }
}



package interfases;

import java.awt.EventQueue;
import java.awt.Color; // Importante para usar colores
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class receta extends JFrame {

    private JPanel contentPane;
    private JTable tableRecetas;
    private DefaultTableModel modeloTabla;
    private JTextField txPaciente, txMedico, txMedicamento, txDosis, txIndicaciones, txBuscar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    receta frame = new receta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public receta() {
        setTitle("Gestión de Recetas Médicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cambio realizado aquí
        setBounds(100, 100, 800, 600);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(144, 238, 144)); // Color verde claro para el fondo
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Gestión de Recetas Médicas");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setBounds(320, 10, 214, 29);
        contentPane.add(lblTitulo);

        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setBounds(20, 50, 80, 20);
        contentPane.add(lblPaciente);

        JLabel lblMedico = new JLabel("Médico:");
        lblMedico.setBounds(20, 80, 80, 20);
        contentPane.add(lblMedico);

        JLabel lblMedicamento = new JLabel("Medicamento:");
        lblMedicamento.setBounds(20, 110, 100, 20);
        contentPane.add(lblMedicamento);

        JLabel lblDosis = new JLabel("Dosis:");
        lblDosis.setBounds(20, 140, 80, 20);
        contentPane.add(lblDosis);

        JLabel lblIndicaciones = new JLabel("Indicaciones:");
        lblIndicaciones.setBounds(20, 170, 100, 20);
        contentPane.add(lblIndicaciones);

        txPaciente = new JTextField();
        txPaciente.setBounds(120, 50, 200, 20);
        txPaciente.setBackground(new Color(255, 255, 255)); // Fondo verde claro
        contentPane.add(txPaciente);

        txMedico = new JTextField();
        txMedico.setBounds(120, 80, 200, 20);
        txMedico.setBackground(new Color(255, 255, 255)); // Fondo verde claro
        contentPane.add(txMedico);

        txMedicamento = new JTextField();
        txMedicamento.setBounds(120, 110, 200, 20);
        txMedicamento.setBackground(new Color(255, 255, 255)); // Fondo verde claro
        contentPane.add(txMedicamento);

        txDosis = new JTextField();
        txDosis.setBounds(120, 140, 200, 20);
        txDosis.setBackground(new Color(255, 255, 255)); // Fondo verde claro
        contentPane.add(txDosis);

        txIndicaciones = new JTextField();
        txIndicaciones.setBounds(120, 170, 200, 20);
        txIndicaciones.setBackground(new Color(255, 255, 255)); // Fondo verde claro
        contentPane.add(txIndicaciones);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(340, 50, 100, 25);
        contentPane.add(btnAgregar); // No se cambia el fondo de este botón

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(340, 80, 100, 25);
        contentPane.add(btnEditar); // No se cambia el fondo de este botón

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(340, 110, 100, 25);
        contentPane.add(btnEliminar); // No se cambia el fondo de este botón

        JButton btnMostrarTodos = new JButton("Mostrar Todos");
        btnMostrarTodos.setBounds(340, 140, 150, 25);
        contentPane.add(btnMostrarTodos); // No se cambia el fondo de este botón

        JLabel lblBuscar = new JLabel("Buscar (Paciente):");
        lblBuscar.setBounds(520, 50, 120, 20);
        contentPane.add(lblBuscar);

        txBuscar = new JTextField();
        txBuscar.setBounds(640, 50, 120, 20);
        txBuscar.setBackground(new Color(255, 255, 255)); // Fondo verde claro
        contentPane.add(txBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(640, 80, 100, 25);
        contentPane.add(btnBuscar); // No se cambia el fondo de este botón

        // Tabla para mostrar recetas
        modeloTabla = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Paciente", "Médico", "Medicamento", "Dosis", "Indicaciones" }
        );
        tableRecetas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tableRecetas);
        scrollPane.setBounds(20, 220, 750, 300);
        contentPane.add(scrollPane);

        // Acción para agregar recetas
        btnAgregar.addActionListener(e -> {
            String paciente = txPaciente.getText();
            String medico = txMedico.getText();
            String medicamento = txMedicamento.getText();
            String dosis = txDosis.getText();
            String indicaciones = txIndicaciones.getText();

            if (!paciente.isEmpty() && !medico.isEmpty() && !medicamento.isEmpty() && !dosis.isEmpty() && !indicaciones.isEmpty()) {
                modeloTabla.addRow(new Object[] { paciente, medico, medicamento, dosis, indicaciones });
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Receta agregada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
            }
        });

        // Acción para editar recetas
        btnEditar.addActionListener(e -> {
            int filaSeleccionada = tableRecetas.getSelectedRow();
            if (filaSeleccionada >= 0) {
                modeloTabla.setValueAt(txPaciente.getText(), filaSeleccionada, 0);
                modeloTabla.setValueAt(txMedico.getText(), filaSeleccionada, 1);
                modeloTabla.setValueAt(txMedicamento.getText(), filaSeleccionada, 2);
                modeloTabla.setValueAt(txDosis.getText(), filaSeleccionada, 3);
                modeloTabla.setValueAt(txIndicaciones.getText(), filaSeleccionada, 4);
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Receta editada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una receta para editar.");
            }
        });

        // Acción para eliminar recetas
        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = tableRecetas.getSelectedRow();
            if (filaSeleccionada >= 0) {
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Receta eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una receta para eliminar.");
            }
        });

        // Acción para buscar recetas por paciente
        btnBuscar.addActionListener(e -> {
            String textoBusqueda = txBuscar.getText().toLowerCase();
            DefaultTableModel modeloFiltrado = new DefaultTableModel(
                    new Object[][] {},
                    new String[] { "Paciente", "Médico", "Medicamento", "Dosis", "Indicaciones" }
            );

            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                String paciente = modeloTabla.getValueAt(i, 0).toString().toLowerCase();
                if (paciente.contains(textoBusqueda)) {
                    modeloFiltrado.addRow(new Object[] {
                            modeloTabla.getValueAt(i, 0),
                            modeloTabla.getValueAt(i, 1),
                            modeloTabla.getValueAt(i, 2),
                            modeloTabla.getValueAt(i, 3),
                            modeloTabla.getValueAt(i, 4)
                    });
                }
            }

            tableRecetas.setModel(modeloFiltrado);
        });

        // Acción para mostrar todas las recetas
        btnMostrarTodos.addActionListener(e -> {
            tableRecetas.setModel(modeloTabla);
        });
    }

    private void limpiarCampos() {
        txPaciente.setText("");
        txMedico.setText("");
        txMedicamento.setText("");
        txDosis.setText("");
        txIndicaciones.setText("");
        txBuscar.setText("");
    }
}

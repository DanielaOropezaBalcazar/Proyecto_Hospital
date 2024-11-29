package interfases;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;

public class medicacion extends JFrame {

    private JPanel contentPane;
    private JTable tableMedicaciones;
    private DefaultTableModel modeloTabla;
    private JTextField txCodigo, txNombre, txDescripcion, txCantidad, txFechaVencimiento, txBuscar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                medicacion frame = new medicacion();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public medicacion() {
        setTitle("Gestión de Medicaciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cambiado a DISPOSE_ON_CLOSE
        setBounds(100, 100, 800, 600);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(144, 238, 144)); // Color verde claro para el fondo del panel
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Gestión de Medicaciones");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(303, 11, 236, 20);
        contentPane.add(lblTitulo);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 50, 80, 20);
        contentPane.add(lblCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 80, 80, 20);
        contentPane.add(lblNombre);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(20, 110, 100, 20);
        contentPane.add(lblDescripcion);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(20, 140, 80, 20);
        contentPane.add(lblCantidad);

        JLabel lblFechaVencimiento = new JLabel("Fecha Venc. (yyyy-mm-dd):");
        lblFechaVencimiento.setBounds(20, 170, 180, 20);
        contentPane.add(lblFechaVencimiento);

        txCodigo = new JTextField();
        txCodigo.setBounds(200, 50, 200, 20);
        txCodigo.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txCodigo);

        txNombre = new JTextField();
        txNombre.setBounds(200, 80, 200, 20);
        txNombre.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txNombre);

        txDescripcion = new JTextField();
        txDescripcion.setBounds(200, 110, 200, 20);
        txDescripcion.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txDescripcion);

        txCantidad = new JTextField();
        txCantidad.setBounds(200, 140, 200, 20);
        txCantidad.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txCantidad);

        txFechaVencimiento = new JTextField();
        txFechaVencimiento.setBounds(200, 170, 200, 20);
        txFechaVencimiento.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txFechaVencimiento);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(420, 50, 100, 25);
        contentPane.add(btnAgregar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(420, 80, 100, 25);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(420, 110, 100, 25);
        contentPane.add(btnEliminar);

        JButton btnMostrarTodos = new JButton("Mostrar Todos");
        btnMostrarTodos.setBounds(420, 140, 150, 25);
        contentPane.add(btnMostrarTodos);

        JLabel lblBuscar = new JLabel("Buscar (Nombre):");
        lblBuscar.setBounds(580, 50, 120, 20);
        contentPane.add(lblBuscar);

        txBuscar = new JTextField();
        txBuscar.setBounds(580, 80, 120, 20);
        txBuscar.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(580, 110, 100, 25);
        contentPane.add(btnBuscar);

        // Tabla para mostrar medicaciones
        modeloTabla = new DefaultTableModel(
                new Object[][] {},
                new String[]{"Código", "Nombre", "Descripción", "Cantidad", "Fecha Vencimiento"}
        );
        tableMedicaciones = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tableMedicaciones);
        scrollPane.setBounds(20, 220, 750, 300);
        contentPane.add(scrollPane);

        // Acción para agregar medicación
        btnAgregar.addActionListener(e -> {
            String codigo = txCodigo.getText();
            String nombre = txNombre.getText();
            String descripcion = txDescripcion.getText();
            String cantidad = txCantidad.getText();
            String fechaVencimiento = txFechaVencimiento.getText();

            if (!codigo.isEmpty() && !nombre.isEmpty() && !descripcion.isEmpty() && !cantidad.isEmpty() && !fechaVencimiento.isEmpty()) {
                modeloTabla.addRow(new Object[]{codigo, nombre, descripcion, cantidad, fechaVencimiento});
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Medicación agregada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
            }
        });

        // Acción para editar medicación
        btnEditar.addActionListener(e -> {
            int filaSeleccionada = tableMedicaciones.getSelectedRow();
            if (filaSeleccionada >= 0) {
                modeloTabla.setValueAt(txCodigo.getText(), filaSeleccionada, 0);
                modeloTabla.setValueAt(txNombre.getText(), filaSeleccionada, 1);
                modeloTabla.setValueAt(txDescripcion.getText(), filaSeleccionada, 2);
                modeloTabla.setValueAt(txCantidad.getText(), filaSeleccionada, 3);
                modeloTabla.setValueAt(txFechaVencimiento.getText(), filaSeleccionada, 4);
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Medicación editada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una medicación para editar.");
            }
        });

        // Acción para eliminar medicación
        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = tableMedicaciones.getSelectedRow();
            if (filaSeleccionada >= 0) {
                modeloTabla.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Medicación eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una medicación para eliminar.");
            }
        });

        // Acción para buscar medicación por nombre
        btnBuscar.addActionListener(e -> {
            String textoBusqueda = txBuscar.getText().toLowerCase();
            DefaultTableModel modeloFiltrado = new DefaultTableModel(
                    new Object[][] {},
                    new String[]{"Código", "Nombre", "Descripción", "Cantidad", "Fecha Vencimiento"}
            );

            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                String nombre = modeloTabla.getValueAt(i, 1).toString().toLowerCase();
                if (nombre.contains(textoBusqueda)) {
                    modeloFiltrado.addRow(new Object[]{
                            modeloTabla.getValueAt(i, 0),
                            modeloTabla.getValueAt(i, 1),
                            modeloTabla.getValueAt(i, 2),
                            modeloTabla.getValueAt(i, 3),
                            modeloTabla.getValueAt(i, 4)
                    });
                }
            }

            tableMedicaciones.setModel(modeloFiltrado);
        });

        // Acción para mostrar todas las medicaciones
        btnMostrarTodos.addActionListener(e -> {
            tableMedicaciones.setModel(modeloTabla);
        });
    }

    private void limpiarCampos() {
        txCodigo.setText("");
        txNombre.setText("");
        txDescripcion.setText("");
        txCantidad.setText("");
        txFechaVencimiento.setText("");
        txBuscar.setText("");
    }
}



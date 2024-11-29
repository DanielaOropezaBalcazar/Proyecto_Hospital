package interfases;

import java.awt.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class pacienteV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txBuscar;
    private JTextField txFecha;
    private JTextField txApellido;
    private JTextField txNombre;
    private JTextField txCi;
    private JTable tablePacientes;
    private DefaultTableModel modeloTabla;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pacienteV frame = new pacienteV();
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
    public pacienteV() {
        setTitle("PACIENTES");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        // Panel principal con fondo verde claro
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(204, 255, 204)); // Verde claro
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Configuración de botones con color de fondo
        JButton btnAgregarPaciente = new JButton("Agregar Nuevo Paciente");
        btnAgregarPaciente.setBounds(54, 70, 176, 21);
        btnAgregarPaciente.setBackground(new Color(153, 255, 153)); // Verde claro
        contentPane.add(btnAgregarPaciente);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(42, 110, 85, 21);
        btnEditar.setBackground(new Color(153, 255, 153));
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(42, 150, 85, 21);
        btnEliminar.setBackground(new Color(153, 255, 153));
        contentPane.add(btnEliminar);

        JButton btnMostrarTodos = new JButton("Mostrar todos");
        btnMostrarTodos.setBounds(600, 50, 150, 30);
        btnMostrarTodos.setBackground(new Color(153, 255, 153));
        contentPane.add(btnMostrarTodos);

        // TextField para buscar
        txBuscar = new JTextField();
        txBuscar.setBounds(137, 193, 104, 19);
        contentPane.add(txBuscar);
        txBuscar.setColumns(10);

        JButton btnBuscar = new JButton("Buscar:");
        btnBuscar.setBounds(42, 190, 85, 21);
        btnBuscar.setBackground(new Color(153, 255, 153));
        contentPane.add(btnBuscar);

        // Etiquetas
        JLabel lblTitulo = new JLabel("Menú de Pacientes");
        lblTitulo.setBounds(83, 39, 135, 13);
        contentPane.add(lblTitulo);

        JLabel lblCi = new JLabel("CI:");
        lblCi.setBounds(265, 39, 69, 13);
        contentPane.add(lblCi);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(265, 64, 69, 13);
        contentPane.add(lblNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(265, 88, 69, 13);
        contentPane.add(lblApellido);

        JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaDeNacimiento.setBounds(265, 114, 130, 13);
        contentPane.add(lblFechaDeNacimiento);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(265, 143, 74, 13);
        contentPane.add(lblGenero);

        JCheckBox chckbxMasculino = new JCheckBox("Masculino");
        chckbxMasculino.setBounds(345, 139, 93, 21);
        chckbxMasculino.setBackground(new Color(204, 255, 204)); // Fondo verde claro
        contentPane.add(chckbxMasculino);

        JCheckBox chckbxFemenino = new JCheckBox("Femenino");
        chckbxFemenino.setBounds(440, 139, 93, 21);
        chckbxFemenino.setBackground(new Color(204, 255, 204)); // Fondo verde claro
        contentPane.add(chckbxFemenino);

        txFecha = new JTextField();
        txFecha.setColumns(10);
        txFecha.setBounds(405, 111, 128, 19);
        contentPane.add(txFecha);

        txApellido = new JTextField();
        txApellido.setColumns(10);
        txApellido.setBounds(405, 85, 128, 19);
        contentPane.add(txApellido);

        txNombre = new JTextField();
        txNombre.setColumns(10);
        txNombre.setBounds(405, 61, 128, 19);
        contentPane.add(txNombre);

        txCi = new JTextField();
        txCi.setColumns(10);
        txCi.setBounds(405, 35, 128, 19);
        contentPane.add(txCi);

        // Tabla para mostrar pacientes
        modeloTabla = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Nombre", "Apellido", "Fecha de Nacimiento", "CI", "Género" }
        );
        tablePacientes = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablePacientes);
        scrollPane.setBounds(42, 265, 700, 250);
        contentPane.add(scrollPane);

        // Eventos y acciones...
        btnAgregarPaciente.addActionListener(e -> {
            // Agregar paciente
        });

        btnEliminar.addActionListener(e -> {
            // Eliminar paciente
        });

        btnBuscar.addActionListener(e -> {
            // Buscar paciente
        });

        btnMostrarTodos.addActionListener(e -> {
            // Mostrar todos los pacientes
        });
    }
}


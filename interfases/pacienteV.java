package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

public class pacienteV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txBuscar;
	private JTextField txFecha;
	private JTextField txApellido;
	private JTextField txNombre;
	private JTextField txCi;
	private JTextField txtEliminar;
	private JTextField txEditar;

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
		setBounds(100, 100, 587, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregarPaciente = new JButton("Agregar Nuevo Paciente");
		btnAgregarPaciente.setBounds(54, 70, 176, 21);
		contentPane.add(btnAgregarPaciente);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(42, 110, 85, 21);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(42, 150, 85, 21);
		contentPane.add(btnEliminar);
		
		JButton btnMostrarTodos = new JButton("Mostrar todos");
		btnMostrarTodos.setBounds(405, 234, 128, 21);
		contentPane.add(btnMostrarTodos);
		
		txBuscar = new JTextField();
		txBuscar.setBounds(137, 193, 104, 19);
		contentPane.add(txBuscar);
		txBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar:");
		btnBuscar.setBounds(42, 190, 85, 21);
		contentPane.add(btnBuscar);
		
		JLabel lblTitulo = new JLabel("Menu de Pacientes");
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
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(265, 143, 74, 13);
		contentPane.add(lblGenero);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Masculino");
		chckbxNewCheckBox.setBounds(345, 139, 93, 21);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxFemenino = new JCheckBox("Femenino");
		chckbxFemenino.setBounds(440, 139, 93, 21);
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
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(42, 265, 491, 172);
		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Lista de pacientes registrados:");
		lblNewLabel.setBounds(42, 238, 176, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(440, 169, 98, 21);
		contentPane.add(btnNewButton);
		
		txtEliminar = new JTextField();
		txtEliminar.setToolTipText("");
		txtEliminar.setColumns(10);
		txtEliminar.setBounds(137, 151, 104, 19);
		contentPane.add(txtEliminar);
		
		txEditar = new JTextField();
		txEditar.setToolTipText("");
		txEditar.setColumns(10);
		txEditar.setBounds(137, 111, 104, 19);
		contentPane.add(txEditar);
	}
}

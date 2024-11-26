package interfases;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu_hospital extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_hospital frame = new menu_hospital();
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
	public menu_hospital() {
		setTitle("Menú del Hospital");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 20, 20)); // 2 filas, 2 columnas, con 20px de separación

		// Botón para Ver Pacientes
		JButton btnVerPacientes = new JButton("Ver Pacientes");
		btnVerPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentana("Pacientes");
			}
		});
		contentPane.add(btnVerPacientes);

		// Botón para Ver Doctores
		JButton btnVerDoctores = new JButton("Ver Doctores");
		btnVerDoctores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentana("Doctores");
			}
		});
		contentPane.add(btnVerDoctores);

		// Botón para Ver Citas
		JButton btnVerCitas = new JButton("Ver Citas");
		btnVerCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentana("Citas");
			}
		});
		contentPane.add(btnVerCitas);

		// Botón de Salir
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Saliendo del programa...");
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);
	}

	/**
	 * Método para abrir una nueva ventana.
	 */
	private void abrirVentana(String titulo) {
		// Crear nueva ventana
		JFrame nuevaVentana = new JFrame(titulo);
		nuevaVentana.setTitle("Ventana - " + titulo);
		nuevaVentana.setSize(300, 200);
		nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Permite cerrar solo esta ventana
		nuevaVentana.setLocationRelativeTo(null); // Centrar en pantalla
		nuevaVentana.setVisible(true);
	}
}



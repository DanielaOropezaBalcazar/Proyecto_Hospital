package interfaces;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
        setBounds(100, 100, 820, 568);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        // Cambiar el color de fondo del contentPane a verde claro
        contentPane.setBackground(new Color(144, 238, 144)); // Verde claro

        contentPane.setLayout(null);

        // Botón para Ver Pacientes
        JButton btnVerPacientes = new JButton("Ver Pacientes");
        btnVerPacientes.setBounds(105, 159, 141, 46);
        btnVerPacientes.addActionListener(e -> {
            // Abrir la interfaz PacienteV
            pacienteV paciente = new pacienteV(); 
            paciente.setVisible(true);
        });
        contentPane.add(btnVerPacientes);

        // Botón para Ver Doctores
        JButton btnVerDoctores = new JButton("Ver Empleados");
        btnVerDoctores.setBounds(303, 159, 158, 46);
        btnVerDoctores.addActionListener(e -> {
            // Abrir la interfaz Empleado
            empleadoV empleado = new empleadoV(); 
            empleado.setVisible(true);
        });
        contentPane.add(btnVerDoctores);

        // Botón para Ver Consultas
        JButton btnVerCunsultas = new JButton("Ver Consultas");
        btnVerCunsultas.setBounds(537, 159, 152, 46);
        btnVerCunsultas.addActionListener(e -> {
            // Abrir la interfaz Consulta
            consultaV consulta = new consultaV(); 
            consulta.setVisible(true);
        });
        contentPane.add(btnVerCunsultas);

        // Botón para Ver Recetas
        JButton btnVerCitas = new JButton("Ver Recetas");
        btnVerCitas.setBounds(105, 355, 152, 46);
        btnVerCitas.addActionListener(e -> {
            // Abrir la interfaz Receta
            recetaV receta = new recetaV(); 
            receta.setVisible(true);
        });
        contentPane.add(btnVerCitas);

        // Botón para Ver Medicación
        JButton btnVerMedicacion = new JButton("Ver Medicación");
        btnVerMedicacion.setBounds(324, 355, 152, 46);
        btnVerMedicacion.addActionListener(e -> {
            // Abrir la interfaz Medicacion
            medicacionV medicacion = new medicacionV(); 
            medicacion.setVisible(true);
        });
        contentPane.add(btnVerMedicacion);

        // Botón de Salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(548, 355, 141, 46);
        btnSalir.addActionListener(e -> {
            System.out.println("Saliendo del programa...");
            System.exit(0);
        });
        contentPane.add(btnSalir);

        // Etiquetas con iconos
        JLabel lblPacientesIcon = new JLabel("");
        lblPacientesIcon.setVerticalAlignment(SwingConstants.TOP);
        lblPacientesIcon.setIcon(new ImageIcon(menu_hospital.class.getResource("/imagenes/historial-medico.png")));
        lblPacientesIcon.setBounds(138, 62, 80, 86);
        contentPane.add(lblPacientesIcon);

        JLabel lblDoctoresIcon = new JLabel("");
        lblDoctoresIcon.setVerticalAlignment(SwingConstants.TOP);
        lblDoctoresIcon.setIcon(new ImageIcon(menu_hospital.class.getResource("/imagenes/equipo-medico.png")));
        lblDoctoresIcon.setBounds(347, 62, 80, 86);
        contentPane.add(lblDoctoresIcon);

        JLabel lblConsultasIcon = new JLabel("");
        lblConsultasIcon.setVerticalAlignment(SwingConstants.TOP);
        lblConsultasIcon.setIcon(new ImageIcon(menu_hospital.class.getResource("/imagenes/consulta.png")));
        lblConsultasIcon.setBounds(577, 62, 80, 86);
        contentPane.add(lblConsultasIcon);

        JLabel lblRecetasIcon = new JLabel("");
        lblRecetasIcon.setVerticalAlignment(SwingConstants.TOP);
        lblRecetasIcon.setIcon(new ImageIcon(menu_hospital.class.getResource("/imagenes/receta.png")));
        lblRecetasIcon.setBounds(138, 258, 80, 86);
        contentPane.add(lblRecetasIcon);

        JLabel lblMedicacionIcon = new JLabel("");
        lblMedicacionIcon.setVerticalAlignment(SwingConstants.TOP);
        lblMedicacionIcon.setIcon(new ImageIcon(menu_hospital.class.getResource("/imagenes/medicamento.png")));
        lblMedicacionIcon.setBounds(358, 258, 80, 86);
        contentPane.add(lblMedicacionIcon);

        JLabel lblChatbotIcon = new JLabel("");
        lblChatbotIcon.setVerticalAlignment(SwingConstants.TOP);
        lblChatbotIcon.setIcon(new ImageIcon(menu_hospital.class.getResource("/imagenes/bot-conversacional.png")));
        lblChatbotIcon.setBounds(577, 258, 80, 86);
        contentPane.add(lblChatbotIcon);

        JLabel lblMenuHospital = new JLabel("Menú del Hospital");
        lblMenuHospital.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblMenuHospital.setBounds(333, 11, 158, 20);
        contentPane.add(lblMenuHospital);
    }
}





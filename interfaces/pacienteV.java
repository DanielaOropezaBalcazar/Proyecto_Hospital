package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

import CRUDs.*;
import Clases.*;
import java.awt.Font;

public class pacienteV extends JFrame {

	pacienteBD db = new pacienteBD(); 
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txBuscar;
    private JTextField txFecha;
    private JTextField txApellido;
    private JTextField txNombre;
    private JTextField txCi;
    private JTable tablePacientes;
    private DefaultTableModel modeloTabla;
    private JTextField txSangre;

    
    private JTextField txGenero;
    private JTextField txEliminar;
    private JTextField txEditar;
    private JTextField txAviso;

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
     * @param gen 
     * @param san 
     * @param fec 
     * @param ape 
     * @param nom 
     * @param ci 
     * @return 
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

        JButton btnAgregarPaciente = new JButton("Agregar Nuevo Paciente");
        btnAgregarPaciente.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				int ci = Integer.parseInt(txCi.getText());
				String nom = txNombre.getText();
				String ape = txApellido.getText();
				LocalDate fec = LocalDate.parse(txFecha.getText());
				String san = txSangre.getText();
				boolean gen = Boolean.parseBoolean(txGenero.getText());
				paciente nuevoPaciente = new paciente(ci, nom, ape, fec, san, gen);
                db.agregarPaciente(nuevoPaciente);
                txAviso.setText("Se ha Agregado un paciente nuevo");
        	}
        });
        btnAgregarPaciente.setBounds(54, 70, 176, 21);
        btnAgregarPaciente.setBackground(new Color(153, 255, 153)); // Verde claro
        contentPane.add(btnAgregarPaciente);

        JButton btnEditar = new JButton("Editar");
        btnEditar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txEditar.getText());  		
        		int ci = Integer.parseInt(txCi.getText());
				String nom = txNombre.getText();
				String ape = txApellido.getText();
				LocalDate fec = LocalDate.parse(txFecha.getText());
				String san = txSangre.getText();
				boolean gen = Boolean.parseBoolean(txGenero.getText());
				paciente nuevoPaciente = new paciente(ci, nom, ape, fec, san, gen);
                db.editarPaciente(nuevoPaciente, cod);
                txAviso.setText("Se han Editado los datos");
        	}
        });
        btnEditar.setBounds(42, 110, 85, 21);
        btnEditar.setBackground(new Color(153, 255, 153));
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txEliminar.getText());
        		db.eliminarPaciente(cod);
                txAviso.setText("Se han Eliminado los datos");    		
        	}
        });
        btnEliminar.setBounds(42, 150, 85, 21);
        btnEliminar.setBackground(new Color(153, 255, 153));
        contentPane.add(btnEliminar);

        JButton btnMostrarTodos = new JButton("Mostrar todos");
        btnMostrarTodos.setBounds(580, 39, 150, 30);
        btnMostrarTodos.setBackground(new Color(153, 255, 153));
        contentPane.add(btnMostrarTodos);

        // TextField para buscar
        txBuscar = new JTextField();
        txBuscar.setBounds(137, 193, 104, 19);
        contentPane.add(txBuscar);
        txBuscar.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txBuscar.getText());
        		paciente encontrado = db.obtenerPaciente(cod);
        		if (encontrado != null) {
        			txCi.setText(encontrado.getCi()+"");
        			txNombre.setText(encontrado.getNombre());
        			txApellido.setText(encontrado.getApellido());
        			txFecha.setText((encontrado.getFechaNacimiento()).toString());
        			txSangre.setText(encontrado.getTipoSangre());
        			txGenero.setText(String.valueOf(encontrado.isGenero()));               	
        			txAviso.setText("Se han Encontrado los datos del paciente");
        		} else {
        			txAviso.setText("Datos no encontrados");
        		}
        		
        	}
        });
        btnBuscar.setBounds(42, 190, 85, 21);
        btnBuscar.setBackground(new Color(153, 255, 153));
        contentPane.add(btnBuscar);

        // Etiquetas
        JLabel lblTitulo = new JLabel("Menú de Pacientes");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(42, 39, 181, 13);
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

        JLabel lblSangre = new JLabel("Tipo de Sangre:");
        lblSangre.setBounds(265, 143, 104, 13);
        contentPane.add(lblSangre);

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
        
        txSangre = new JTextField();
        txSangre.setColumns(10);
        txSangre.setBounds(405, 140, 128, 19);
        contentPane.add(txSangre);
        
        JLabel lblGenero_1 = new JLabel("Género:");
        lblGenero_1.setBounds(265, 169, 74, 13);
        contentPane.add(lblGenero_1);
        
        txGenero = new JTextField();
        txGenero.setColumns(10);
        txGenero.setBounds(405, 166, 128, 19);
        contentPane.add(txGenero);
        
        txEliminar = new JTextField();
        txEliminar.setColumns(10);
        txEliminar.setBounds(137, 151, 104, 19);
        contentPane.add(txEliminar);
        
        txEditar = new JTextField();
        txEditar.setColumns(10);
        txEditar.setBounds(137, 111, 104, 19);
        contentPane.add(txEditar);
        
        JLabel lblAviso = new JLabel("AVISO");
        lblAviso.setBounds(265, 215, 74, 13);
        contentPane.add(lblAviso);
        
        txAviso = new JTextField();
        txAviso.setHorizontalAlignment(SwingConstants.CENTER);
        txAviso.setEditable(false);
        txAviso.setColumns(10);
        txAviso.setBounds(328, 207, 269, 30);
        contentPane.add(txAviso);
        
        JButton btnLimpiar = new JButton("Limpiar campos");
        btnLimpiar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txCi.setText("");
        		txNombre.setText("");
        		txApellido.setText("");
        		txFecha.setText("");
        		txSangre.setText("");
        		txGenero.setText("");
        	}
        });
        btnLimpiar.setBackground(new Color(153, 255, 153));
        btnLimpiar.setBounds(580, 88, 150, 30);
        contentPane.add(btnLimpiar);


    }
}


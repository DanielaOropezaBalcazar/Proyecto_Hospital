package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.ButtonGroup;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class pacienteV extends JFrame {

	pacienteBD db = new pacienteBD(); 
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txBuscar;
    private JTextField txFecha;
    private JTextField txApellido;
    private JTextField txNombre;
    private JTextField txCi;
    private JTextField txSangre;
    private JTextField txAviso;
    private JTable tablePacientes;
    private DefaultTableModel modeloTabla;
    private JTextField txEliminar;
    private JTextField txEditar;
    private JRadioButton rdbtnMasculino;
    private JRadioButton rdbtnFemenino;
    private ButtonGroup grupoGenero;

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
        btnAgregarPaciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnAgregarPaciente.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				int ci = Integer.parseInt(txCi.getText());
				String nom = txNombre.getText();
				String ape = txApellido.getText();
				LocalDate fec = LocalDate.parse(txFecha.getText());
				String san = txSangre.getText();
				boolean gen = rdbtnMasculino.isSelected();
				paciente nuevoPaciente = new paciente(ci, nom, ape, fec, san, gen);
                db.agregarPaciente(nuevoPaciente);
                txAviso.setText("Se ha Agregado un paciente nuevo");
        	}
        });
        btnAgregarPaciente.setBounds(569, 39, 173, 41);
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
				boolean gen = rdbtnMasculino.isSelected();
				paciente nuevoPaciente = new paciente(ci, nom, ape, fec, san, gen);
                db.editarPaciente(nuevoPaciente, cod);
                txAviso.setText("Se han Editado los datos");
        	}
        });
        btnEditar.setBounds(35, 67, 85, 21);
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
        btnEliminar.setBounds(35, 107, 85, 21);
        btnEliminar.setBackground(new Color(153, 255, 153));
        contentPane.add(btnEliminar);

        JButton btnMostrarTodos = new JButton("Mostrar todos");
        btnMostrarTodos.setBounds(42, 206, 150, 30);
        btnMostrarTodos.setBackground(new Color(153, 255, 153));
        btnMostrarTodos.addActionListener(e -> {
            List<paciente> lista = new pacienteBD().obtenerTodos();
            mostrarDatosEnTabla(lista);
        });
        contentPane.add(btnMostrarTodos);

        // TextField para buscar
        txBuscar = new JTextField();
        txBuscar.setBounds(130, 150, 104, 19);
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
        			if (encontrado.isGenero()) {
        			    rdbtnMasculino.setSelected(true);
        			} else {
        			    rdbtnFemenino.setSelected(true);
        			}
        			txAviso.setText("Se han Encontrado los datos del paciente");
        		} else {
        			txAviso.setText("Datos no encontrados");
        		}
        		
        	}
        });
        btnBuscar.setBounds(35, 147, 85, 21);
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
        // llamar a "pbtenerDatos" y a "mostrarDatos"
        modeloTabla = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Nombre", "Apellido", "Fecha de Nacimiento", "CI", "Genero" }
        );
        tablePacientes = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablePacientes);
        scrollPane.setBounds(42, 265, 700, 250);
        contentPane.add(scrollPane);
        mostrarDatosEnTabla(new pacienteBD().obtenerTodos());
        
        txSangre = new JTextField();
        txSangre.setColumns(10);
        txSangre.setBounds(405, 140, 128, 19);
        contentPane.add(txSangre);
        
        JLabel lblGenero_1 = new JLabel("Género:");
        lblGenero_1.setBounds(260, 169, 74, 13);
        contentPane.add(lblGenero_1);
        
        txEliminar = new JTextField();
        txEliminar.setColumns(10);
        txEliminar.setBounds(130, 108, 104, 19);
        contentPane.add(txEliminar);
        
        txEditar = new JTextField();
        txEditar.setColumns(10);
        txEditar.setBounds(130, 68, 104, 19);
        contentPane.add(txEditar);
        
        JLabel lblAviso = new JLabel("AVISO");
        lblAviso.setBounds(265, 215, 74, 13);
        contentPane.add(lblAviso);
        
        txAviso = new JTextField();
        txAviso.setHorizontalAlignment(SwingConstants.CENTER);
        txAviso.setEditable(false);
        txAviso.setColumns(10);
        txAviso.setBounds(306, 207, 276, 30);
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
        		grupoGenero.clearSelection();
        	}
        });
        btnLimpiar.setBackground(new Color(153, 255, 153));
        btnLimpiar.setBounds(592, 206, 150, 30);
        contentPane.add(btnLimpiar);
        
        JLabel lblFormatoFecha = new JLabel("(aaaa-mm-dd)");
        lblFormatoFecha.setBounds(543, 114, 85, 13);
        contentPane.add(lblFormatoFecha);
        
        rdbtnMasculino = new JRadioButton("Masculino");
        rdbtnMasculino.setBackground(new Color(204, 255, 204));
        rdbtnMasculino.setBounds(323, 165, 85, 21);
        contentPane.add(rdbtnMasculino);

        rdbtnFemenino = new JRadioButton("Femenino");
        rdbtnFemenino.setBackground(new Color(204, 255, 204));
        rdbtnFemenino.setBounds(410, 165, 103, 21);
        contentPane.add(rdbtnFemenino);

        grupoGenero = new ButtonGroup();
        grupoGenero.add(rdbtnMasculino);
        grupoGenero.add(rdbtnFemenino);

    }
    
    private void mostrarDatosEnTabla(List<paciente> lista) {
        modeloTabla.setRowCount(0);
        for (paciente p : lista) {
            modeloTabla.addRow(new Object[]{
                p.getNombre(),
                p.getApellido(),
                p.getFechaNacimiento(),
                p.getCi(),
                p.getTipoSangre(),
                p.isGenero() ? "Masculino" : "Femenino"
            });
        }
    }

}
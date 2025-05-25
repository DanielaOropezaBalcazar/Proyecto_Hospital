package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUDs.doctorBD;
import Clases.doctor;

public class doctorV extends JFrame {

	doctorBD db = new doctorBD(); 
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txBuscar;
    private JTextField txFechaNacimiento;
    private JTextField txApellido;
    private JTextField txNombre;
    private JTextField txCi;
    private JTable tableDoctores;
    private DefaultTableModel modeloTabla;
    private JTextField txFechaIngreso;

    
    private JTextField txCargo;
    private JTextField txEliminar;
    private JTextField txEditar;
    private JTextField txAviso;
    private JTextField txSalario;
    private JTextField txEspecialidad;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    doctorV frame = new doctorV();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    public doctorV() {
        setTitle("DOCTORES");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 797, 652);

        // Panel principal con fondo verde claro
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(204, 255, 204)); // Verde claro
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAgregar = new JButton("Agregar Nuevo");
        btnAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnAgregar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				int ci = Integer.parseInt(txCi.getText());
				String nom = txNombre.getText();
				String ape = txApellido.getText();
				LocalDate fecnac = LocalDate.parse(txFechaNacimiento.getText());
				LocalDate fecin = LocalDate.parse(txFechaIngreso.getText());
				String car = txCargo.getText();
				int sal = Integer.parseInt(txSalario.getText());
				String esp = txEspecialidad.getText();
				doctor nuevodoctor = new doctor(ci, nom, ape, fecnac, fecin, car, sal, esp);
                db.agregarDoctor(nuevodoctor);
                txAviso.setText("Se ha Agregado un doctor nuevo");
        	}
        });
        btnAgregar.setBounds(249, 81, 176, 21);
        btnAgregar.setBackground(new Color(153, 255, 153)); // Verde claro
        contentPane.add(btnAgregar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txEditar.getText());  		
				int ci = Integer.parseInt(txCi.getText());
				String nom = txNombre.getText();
				String ape = txApellido.getText();
				LocalDate fecnac = LocalDate.parse(txFechaNacimiento.getText());
				LocalDate fecin = LocalDate.parse(txFechaIngreso.getText());
				String car = txCargo.getText();
				int sal = Integer.parseInt(txSalario.getText());
				String esp = txEspecialidad.getText();
				doctor nuevodoctor = new doctor(ci, nom, ape, fecnac, fecin, car, sal, esp);
				db.editarDoctor(nuevodoctor, cod);
                txAviso.setText("Se han Editado los datos");
        	}
        });
        btnEditar.setBounds(237, 121, 85, 21);
        btnEditar.setBackground(new Color(153, 255, 153)); // Verde claro
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txEliminar.getText());
        		db.eliminarDoctor(cod);
                txAviso.setText("Se han Eliminado los datos");    		
        	}
        });
        btnEliminar.setBounds(237, 161, 85, 21);
        btnEliminar.setBackground(new Color(153, 255, 153)); // Verde claro
        contentPane.add(btnEliminar);

        JButton btnMostrarTodos = new JButton("Mostrar todos");
        btnMostrarTodos.setBounds(52, 76, 150, 30);
        btnMostrarTodos.setBackground(new Color(153, 255, 153)); // Verde claro
        contentPane.add(btnMostrarTodos);
        
        btnMostrarTodos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mostrarDatosEnTabla(db.obtenerTodos());
        		txAviso.setText("Mostrando todos los doctores");
        	}
        });

        // TextField para buscar
        txBuscar = new JTextField();
        txBuscar.setBounds(332, 204, 104, 19);
        contentPane.add(txBuscar);
        txBuscar.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txBuscar.getText());
        		doctor encontrado = db.obtenerDoctor(cod);
        		if (encontrado != null) {
        			txCi.setText(encontrado.getCi()+"");
        			txNombre.setText(encontrado.getNombre());
        			txApellido.setText(encontrado.getApellido());
        			txFechaNacimiento.setText((encontrado.getFechaNacimiento()).toString());
        			txFechaIngreso.setText((encontrado.getFechaIngreso()).toString());
        			txCargo.setText(encontrado.getCargo());
        			txSalario.setText(encontrado.getSalario()+"");   
        			txEspecialidad.setText(encontrado.getEspecialidad());
        			txAviso.setText("Se han Encontrado los datos del doctor");
        		} else {
        			txAviso.setText("Datos no encontrados");
        		}
        		
        	}
        });
        btnBuscar.setBounds(237, 201, 85, 21);
        btnBuscar.setBackground(new Color(153, 255, 153)); // Verde claro
        contentPane.add(btnBuscar);

        // Etiquetas
        JLabel lblTitulo = new JLabel("Menú de doctores");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(276, 38, 210, 13);
        contentPane.add(lblTitulo);

        JLabel lblCi = new JLabel("CI:");
        lblCi.setBounds(460, 81, 69, 13);
        contentPane.add(lblCi);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(460, 106, 69, 13);
        contentPane.add(lblNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(460, 130, 69, 13);
        contentPane.add(lblApellido);

        JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaDeNacimiento.setBounds(460, 156, 130, 13);
        contentPane.add(lblFechaDeNacimiento);

        JLabel lblFechaIngreso = new JLabel("Fecha de Ingreso:");
        lblFechaIngreso.setBounds(460, 185, 104, 13);
        contentPane.add(lblFechaIngreso);

        txFechaNacimiento = new JTextField();
        txFechaNacimiento.setColumns(10);
        txFechaNacimiento.setBounds(600, 153, 128, 19);
        contentPane.add(txFechaNacimiento);

        txApellido = new JTextField();
        txApellido.setColumns(10);
        txApellido.setBounds(600, 127, 128, 19);
        contentPane.add(txApellido);

        txNombre = new JTextField();
        txNombre.setColumns(10);
        txNombre.setBounds(600, 103, 128, 19);
        contentPane.add(txNombre);

        txCi = new JTextField();
        txCi.setColumns(10);
        txCi.setBounds(600, 77, 128, 19);
        contentPane.add(txCi);

        // Tabla 
        modeloTabla = new DefaultTableModel(
            new Object[][] {},
            new String[] { "NOMBRE", "APELLIDO", "ESPECIALIDAD", "CARGO", "SALARIO" }
        );
        tableDoctores = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tableDoctores);
        scrollPane.setBounds(40, 307, 700, 250);
        contentPane.add(scrollPane);
        mostrarDatosEnTabla(new doctorBD().obtenerTodos());
        
        txFechaIngreso = new JTextField();
        txFechaIngreso.setColumns(10);
        txFechaIngreso.setBounds(600, 182, 128, 19);
        contentPane.add(txFechaIngreso);
        
        JLabel lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(460, 211, 74, 13);
        contentPane.add(lblCargo);
        
        txCargo = new JTextField();
        txCargo.setColumns(10);
        txCargo.setBounds(600, 208, 128, 19);
        contentPane.add(txCargo);
        
        txEliminar = new JTextField();
        txEliminar.setColumns(10);
        txEliminar.setBounds(332, 162, 104, 19);
        contentPane.add(txEliminar);
        
        txEditar = new JTextField();
        txEditar.setColumns(10);
        txEditar.setBounds(332, 122, 104, 19);
        contentPane.add(txEditar);
        
        JLabel lblAviso = new JLabel("AVISO");
        lblAviso.setBounds(40, 257, 74, 13);
        contentPane.add(lblAviso);
        
        txAviso = new JTextField();
        txAviso.setHorizontalAlignment(SwingConstants.CENTER);
        txAviso.setEditable(false);
        txAviso.setColumns(10);
        txAviso.setBounds(98, 249, 269, 30);
        contentPane.add(txAviso);
        
        JButton btnLimpiar = new JButton("Limpiar campos");
        btnLimpiar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txCi.setText("");
        		txNombre.setText("");
        		txApellido.setText("");
        		txFechaNacimiento.setText("");
        		txFechaIngreso.setText("");
        		txCargo.setText("");
        		txSalario.setText("");
        		txEspecialidad.setText("");
        	}
        });
        btnLimpiar.setBounds(52, 121, 150, 30);
        btnLimpiar.setBackground(new Color(153, 255, 153)); // Verde claro
        contentPane.add(btnLimpiar);
        
        JLabel lblSalario = new JLabel("Salario:");
        lblSalario.setBounds(460, 237, 74, 13);
        contentPane.add(lblSalario);
        
        txSalario = new JTextField();
        txSalario.setColumns(10);
        txSalario.setBounds(600, 234, 128, 19);
        contentPane.add(txSalario);
        
        JLabel lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(460, 263, 93, 13);
        contentPane.add(lblEspecialidad);
        
        txEspecialidad = new JTextField();
        txEspecialidad.setColumns(10);
        txEspecialidad.setBounds(600, 260, 128, 19);
        contentPane.add(txEspecialidad);
        
    }
    
    private void mostrarDatosEnTabla(List<doctor> listaDoctores) {
        modeloTabla.setRowCount(0); // Limpia la tabla
        for (doctor d : listaDoctores) {
            modeloTabla.addRow(new Object[]{
                d.getNombre(),
                d.getApellido(),
                d.getEspecialidad(),
                d.getCargo(),
                d.getSalario()
            });
        }
    }

}


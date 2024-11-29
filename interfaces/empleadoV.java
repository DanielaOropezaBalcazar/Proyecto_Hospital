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

public class empleadoV extends JFrame {

	empleadoBD db = new empleadoBD(); 
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txBuscar;
    private JTextField txFechaNacimiento;
    private JTextField txApellido;
    private JTextField txNombre;
    private JTextField txCi;
    private JTable tableEmpleados;
    private DefaultTableModel modeloTabla;
    private JTextField txFechaInicio;

    
    private JTextField txCargo;
    private JTextField txEliminar;
    private JTextField txEditar;
    private JTextField txAviso;
    private JTextField txSalario;

	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    empleadoV frame = new empleadoV();
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
    public empleadoV() {
        setTitle("EMPLEADOS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 797, 652);

        // Panel principal con fondo verde claro
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(144, 238, 144)); // Verde claro
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAgregar = new JButton("Agregar Nuevo");
        btnAgregar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				int ci = Integer.parseInt(txCi.getText());
				String nom = txNombre.getText();
				String ape = txApellido.getText();
				LocalDate fecnac = LocalDate.parse(txFechaNacimiento.getText());
				LocalDate fecin = LocalDate.parse(txFechaInicio.getText());
				String car = txCargo.getText();
				int sal = Integer.parseInt(txSalario.getText());
				empleado nuevoEmpleado = new empleado(ci, nom, ape, fecnac, fecin, car, sal);
                db.agregarEmpleado(nuevoEmpleado);
                txAviso.setText("Se ha Agregado un empleado nuevo");
        	}
        });
        btnAgregar.setBounds(249, 81, 176, 21);
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
				LocalDate fecin = LocalDate.parse(txFechaInicio.getText());
				String car = txCargo.getText();
				int sal = Integer.parseInt(txSalario.getText());
				empleado nuevoEmpleado = new empleado(ci, nom, ape, fecnac, fecin, car, sal);
                db.editarEmpleado(nuevoEmpleado, cod);
                txAviso.setText("Se han Editado los datos");
        	}
        });
        btnEditar.setBounds(237, 121, 85, 21);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txEliminar.getText());
        		db.eliminarEmpleado(cod);
                txAviso.setText("Se han Eliminado los datos");    		
        	}
        });
        btnEliminar.setBounds(237, 161, 85, 21);
        contentPane.add(btnEliminar);

        JButton btnMostrarTodos = new JButton("Mostrar todos");
        btnMostrarTodos.setBounds(52, 76, 150, 30);
        contentPane.add(btnMostrarTodos);

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
        		empleado encontrado = db.obtenerEmpleado(cod);
        		if (encontrado != null) {
        			txCi.setText(encontrado.getCi()+"");
        			txNombre.setText(encontrado.getNombre());
        			txApellido.setText(encontrado.getApellido());
        			txFechaNacimiento.setText((encontrado.getFechaNacimiento()).toString());
        			txFechaInicio.setText((encontrado.getFechaIngreso()).toString());
        			txCargo.setText(encontrado.getCargo());
        			txSalario.setText(encontrado.getSalario()+"");       			
        			txAviso.setText("Se han Encontrado los datos del empleado");
        		} else {
        			txAviso.setText("Datos no encontrados");
        		}
        		
        	}
        });
        btnBuscar.setBounds(237, 201, 85, 21);
        contentPane.add(btnBuscar);

        // Etiquetas
        JLabel lblTitulo = new JLabel("Menú de Empleados");
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

        JLabel lblFechaInicio = new JLabel("Fecha de Ingreso:");
        lblFechaInicio.setBounds(460, 185, 104, 13);
        contentPane.add(lblFechaInicio);

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
                new String[] { }
        );
        tableEmpleados = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tableEmpleados);
        scrollPane.setBounds(40, 307, 700, 250);
        contentPane.add(scrollPane);
        
        txFechaInicio = new JTextField();
        txFechaInicio.setColumns(10);
        txFechaInicio.setBounds(600, 182, 128, 19);
        contentPane.add(txFechaInicio);
        
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
        		txFechaInicio.setText("");
        		txCargo.setText("");
        		txSalario.setText("");
        	}
        });
        btnLimpiar.setBounds(52, 121, 150, 30);
        contentPane.add(btnLimpiar);
        
        JLabel lblSalario = new JLabel("Salario:");
        lblSalario.setBounds(460, 237, 74, 13);
        contentPane.add(lblSalario);
        
        txSalario = new JTextField();
        txSalario.setColumns(10);
        txSalario.setBounds(600, 234, 128, 19);
        contentPane.add(txSalario);


    }
}


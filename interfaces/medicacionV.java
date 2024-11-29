package interfaces;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUDs.medicacionBD;
import CRUDs.pacienteBD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import CRUDs.*;
import Clases.*;

public class medicacionV extends JFrame {
	
    medicacionBD db = new medicacionBD(); 
    
    private JPanel contentPane;
    private JTable tableMedicaciones;
    private DefaultTableModel modeloTabla;
    private JTextField txCodigo, txNombre, txLaboratorio, txDetalle, txPrecio, txEditar;
    private JTextField txEliminar;
    private JTextField txBuscar;
    private JTextField txAviso;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	medicacionV frame = new medicacionV();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public medicacionV() {
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
        lblCodigo.setBounds(85, 51, 80, 20);
        contentPane.add(lblCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(85, 81, 80, 20);
        contentPane.add(lblNombre);

        JLabel lblLaboratorio = new JLabel("Laboratorio:");
        lblLaboratorio.setBounds(85, 111, 100, 20);
        contentPane.add(lblLaboratorio);

        JLabel lblDetalle = new JLabel("Detalle:");
        lblDetalle.setBounds(85, 141, 80, 20);
        contentPane.add(lblDetalle);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(85, 170, 100, 20);
        contentPane.add(lblPrecio);

        txCodigo = new JTextField();
        txCodigo.setEditable(false);
        txCodigo.setBounds(200, 50, 200, 20);
        txCodigo.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txCodigo);

        txNombre = new JTextField();
        txNombre.setBounds(200, 80, 200, 20);
        txNombre.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txNombre);

        txLaboratorio = new JTextField();
        txLaboratorio.setBounds(200, 110, 200, 20);
        txLaboratorio.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txLaboratorio);

        txDetalle = new JTextField();
        txDetalle.setBounds(200, 140, 200, 20);
        txDetalle.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txDetalle);

        txPrecio = new JTextField();
        txPrecio.setBounds(200, 170, 200, 20);
        txPrecio.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txPrecio);

        JButton btnAgregar = new JButton("Agregar Nuevo");
        btnAgregar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				String nom = txNombre.getText();
				String lab = txLaboratorio.getText();
				String det = txDetalle.getText();
				int pre = Integer.parseInt(txPrecio.getText());
				medicacion nuevaMedicacion = new medicacion(nom, lab, det, pre);
                db.agregarMedicacion(nuevaMedicacion);
                txAviso.setText("Se ha Agregado una medicacion nueva");
        	}
        });
        btnAgregar.setBounds(430, 48, 224, 25);
        contentPane.add(btnAgregar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txEditar.getText()); 
				String nom = txNombre.getText();
				String lab = txLaboratorio.getText();
				String det = txDetalle.getText();
				int pre = Integer.parseInt(txPrecio.getText());
				medicacion nuevaMedicacion = new medicacion(cod, nom, lab, det, pre);
                db.editarMedicacion(nuevaMedicacion, cod);
                txAviso.setText("Se han Editado los datos");
        	}
        });
        btnEditar.setBounds(420, 90, 100, 25);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txEliminar.getText());
        		db.eliminarMedicacion(cod);
                txAviso.setText("Se han Eliminado los datos");   
        	}
        });
        btnEliminar.setBounds(420, 120, 100, 25);
        contentPane.add(btnEliminar);

        JButton btnMostrarTodos = new JButton("Mostrar Todos");
        btnMostrarTodos.setBounds(462, 183, 157, 25);
        contentPane.add(btnMostrarTodos);

        txEditar = new JTextField();
        txEditar.setBounds(542, 93, 120, 20);
        txEditar.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txEditar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txBuscar.getText());
                medicacion encontrado = db.obtenerMedicacion(cod);
                if (encontrado != null) {
                	txCodigo.setText(encontrado.getCodigo()+"");
            		txNombre.setText(encontrado.getNombre());
            		txLaboratorio.setText(encontrado.getLaboratorio());
            		txDetalle.setText(encontrado.getDetalle());
                	txPrecio.setText(encontrado.getPrecio()+"");
                	txAviso.setText("Se han Encontrado los datos de la medicacion");
                } else {
                	txAviso.setText("Datos no encontrados");
                }
        	}
        });
        btnBuscar.setBounds(420, 148, 100, 25);
        contentPane.add(btnBuscar);

        // Tabla para mostrar medicaciones
        modeloTabla = new DefaultTableModel(
                new Object[][] {},
                new String[]{"Código", "Nombre", "Descripción", "Cantidad", "Fecha Vencimiento"}
        );
        tableMedicaciones = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tableMedicaciones);
        scrollPane.setBounds(20, 253, 750, 267);
        contentPane.add(scrollPane);
        
        txEliminar = new JTextField();
        txEliminar.setBackground(Color.WHITE);
        txEliminar.setBounds(542, 123, 120, 20);
        contentPane.add(txEliminar);
        
        txBuscar = new JTextField();
        txBuscar.setBackground(Color.WHITE);
        txBuscar.setBounds(542, 151, 120, 20);
        contentPane.add(txBuscar);
        
        JLabel lblAviso = new JLabel("AVISO");
        lblAviso.setBounds(58, 214, 80, 20);
        contentPane.add(lblAviso);
        
        JButton btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
            	txCodigo.setText("");
        		txNombre.setText("");
        		txLaboratorio.setText("");
        		txDetalle.setText("");
            	txPrecio.setText("");
        	}
        });
        btnLimpiar.setBounds(462, 218, 157, 25);
        contentPane.add(btnLimpiar);
        
        txAviso = new JTextField();
        txAviso.setHorizontalAlignment(SwingConstants.CENTER);
        txAviso.setEditable(false);
        txAviso.setBounds(127, 211, 273, 28);
        contentPane.add(txAviso);
        txAviso.setColumns(10);

    }

}



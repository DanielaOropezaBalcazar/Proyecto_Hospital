package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import CRUDs.consultaBD;
import CRUDs.doctorBD;
import Clases.consulta;
import Clases.doctor;

public class consultaV extends JFrame {
	
    consultaBD db = new consultaBD(); 

    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable tableConsultas;
    private DefaultTableModel modeloTabla;
    private JTextField txPaciente, txMedico, txFecha, txMotivo;
    private JTextField txBuscar;
    private JTextField txPrecio;
    private JTextField txAviso;
    private JTextField txAgregar;
    private JTextField txEditar;
    private JTextField txEliminar;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    consultaV frame = new consultaV();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public consultaV() {
        setTitle("Gestión de Consultas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cambio realizado aquí
        setBounds(100, 100, 800, 600);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(204, 255, 204)); // Fondo verde claro
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Gestión de Consultas");
        lblTitulo.setBounds(113, 20, 150, 20);
        contentPane.add(lblTitulo);

        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setBounds(20, 50, 80, 20);
        contentPane.add(lblPaciente);

        JLabel lblMedico = new JLabel("Médico:");
        lblMedico.setBounds(20, 80, 80, 20);
        contentPane.add(lblMedico);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(20, 110, 80, 20);
        contentPane.add(lblFecha);

        JLabel lblMotivo = new JLabel("Motivo:");
        lblMotivo.setBounds(20, 140, 80, 20);
        contentPane.add(lblMotivo);

        txPaciente = new JTextField();
        txPaciente.setBounds(100, 50, 200, 20);
        contentPane.add(txPaciente);

        txMedico = new JTextField();
        txMedico.setBounds(100, 80, 200, 20);
        contentPane.add(txMedico);

        txFecha = new JTextField();
        txFecha.setBounds(100, 110, 200, 20);
        contentPane.add(txFecha);

        txMotivo = new JTextField();
        txMotivo.setBounds(100, 140, 200, 20);
        contentPane.add(txMotivo);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnAgregar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				int pac = Integer.parseInt(txPaciente.getText());
				int doc = Integer.parseInt(txMedico.getText());
				LocalDate fec = LocalDate.parse(txFecha.getText());
				String mot = txMotivo.getText();
				int pre = Integer.parseInt(txPrecio.getText());
				consulta nuevaConsulta = new consulta(fec, mot, pre, doc, pac);                db.agregarConsulta(nuevaConsulta);
                txAviso.setText("Se ha Agregado una consulta nueva");
        	}
        });
        btnAgregar.setBackground(new Color(153, 255, 153)); // Verde claro
        btnAgregar.setBounds(320, 50, 100, 25);
        contentPane.add(btnAgregar);

        
        JButton btnEditar = new JButton("Editar");
        btnEditar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txEditar.getText());  		
        		int pac = Integer.parseInt(txPaciente.getText());
				int doc = Integer.parseInt(txMedico.getText());
				LocalDate fec = LocalDate.parse(txFecha.getText());
				String mot = txMotivo.getText();
				int pre = Integer.parseInt(txPrecio.getText());
				consulta nuevaConsulta = new consulta(fec, mot, pre, doc, pac);
				db.editarConsulta(nuevaConsulta, cod);
                txAviso.setText("Se han Editado los datos");
        	}
        });
        btnEditar.setBackground(new Color(153, 255, 153)); // Verde claro
        btnEditar.setBounds(320, 80, 100, 25);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txEliminar.getText());
        		db.eliminarConsulta(cod);
                txAviso.setText("Se han Eliminado los datos");    		
        	}
        });
        btnEliminar.setBackground(new Color(153, 255, 153)); // Verde claro
        btnEliminar.setBounds(320, 110, 100, 25);
        contentPane.add(btnEliminar);

        JButton btnMostrarTodos = new JButton("Mostrar Todos");
        btnMostrarTodos.setBackground(new Color(153, 255, 153)); // Verde claro
        btnMostrarTodos.setBounds(620, 110, 150, 25);
        contentPane.add(btnMostrarTodos);
        
        btnMostrarTodos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mostrarDatosEnTabla(db.obtenerTodas());
        		txAviso.setText("Mostrando todas las consultas");
        	}
        });

        txBuscar = new JTextField();
        txBuscar.setBounds(439, 21, 150, 20);
        contentPane.add(txBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int cod = Integer.parseInt(txBuscar.getText());
        		consulta encontrado = db.obtenerConsulta(cod);
        		if (encontrado != null) {
        			txPaciente.setText(encontrado.getPacienteCodigo()+"");
        			txMedico.setText(encontrado.getDoctorCodigo()+"");
        			txMotivo.setText(encontrado.getDetalle());
        			txFecha.setText((encontrado.getFecha()).toString());
        			txPrecio.setText((encontrado.getPrecio())+"");
        			txAviso.setText("Se han Encontrado los datos de la consulta");
        		} else {
        			txAviso.setText("Datos no encontrados");
        		}
        		
        	}
        });
        btnBuscar.setBackground(new Color(153, 255, 153)); // Verde claro
        btnBuscar.setBounds(320, 18, 100, 25);
        contentPane.add(btnBuscar);

        // Tabla de consultas
        modeloTabla = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Paciente", "Médico", "Motivo", "Fecha", "Precio" }
        );
        tableConsultas = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tableConsultas);
        scrollPane.setBounds(20, 200, 750, 350);
        contentPane.add(scrollPane);
        mostrarDatosEnTabla(new consultaBD().obtenerTodas());

        // Cambiar colores de otros componentes
        txPaciente.setBackground(new Color(240, 255, 240));
        txMedico.setBackground(new Color(240, 255, 240));
        txFecha.setBackground(new Color(240, 255, 240));
        txMotivo.setBackground(new Color(240, 255, 240));
        txBuscar.setBackground(new Color(240, 255, 240));
        
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(20, 170, 80, 20);
        contentPane.add(lblPrecio);
        
        txPrecio = new JTextField();
        txPrecio.setBackground(new Color(240, 255, 240));
        txPrecio.setBounds(100, 170, 200, 20);
        contentPane.add(txPrecio);
        
        txAviso = new JTextField();
        txAviso.setBounds(455, 163, 315, 20);
        contentPane.add(txAviso);
        txAviso.setColumns(10);
        
        JLabel lblAviso = new JLabel("AVISO:");
        lblAviso.setBounds(388, 162, 80, 20);
        contentPane.add(lblAviso);
        
        txAgregar = new JTextField();
        txAgregar.setBackground(new Color(240, 255, 240));
        txAgregar.setBounds(439, 53, 150, 20);
        contentPane.add(txAgregar);
        
        txEditar = new JTextField();
        txEditar.setBackground(new Color(240, 255, 240));
        txEditar.setBounds(439, 83, 150, 20);
        contentPane.add(txEditar);
        
        txEliminar = new JTextField();
        txEliminar.setBackground(new Color(240, 255, 240));
        txEliminar.setBounds(439, 113, 150, 20);
        contentPane.add(txEliminar);
        
        JButton btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
    			txPaciente.setText("");
    			txMedico.setText("");
    			txMotivo.setText("");
    			txFecha.setText("");
    			txPrecio.setText("");
        	}
        });
        btnLimpiar.setBackground(new Color(153, 255, 153));
        btnLimpiar.setBounds(620, 38, 150, 25);
        contentPane.add(btnLimpiar);

        //scrollPane.getViewport().setBackground(new Color(240, 255, 240));

    }
    
    private void mostrarDatosEnTabla(List<consulta> listaConsultas) {
        modeloTabla.setRowCount(0); // Limpia la tabla
        for (consulta c : listaConsultas) {
            modeloTabla.addRow(new Object[]{
                c.getPacienteCodigo(),
                c.getDoctorCodigo(),
                c.getDetalle(),
                c.getFecha(),
                c.getPrecio()
            });
        }
    }
}


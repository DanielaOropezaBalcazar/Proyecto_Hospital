package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

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

import CRUDs.consultaBD;
import Clases.ConsultaDAO;
import Clases.doctor;

public class consultasFechaV extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    consultaBD db = new consultaBD();

    private JPanel contentPane;
    private JTable tableMedicaciones;
    private DefaultTableModel modeloTabla;
    private JTextField txAnio;
    private JTextField txAviso;
    private JTextField txMes;
    private JTextField txDia;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                consultasFechaV frame = new consultasFechaV();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public consultasFechaV() {
        setTitle("Consultas por Fecha");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 443, 446);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(204, 255, 204)); // Verde claro
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Gestión de Consultas por Fechas");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(86, 10, 300, 20);
        contentPane.add(lblTitulo);

        JLabel lblFecha = new JLabel("Ingrese la Fecha:");
        lblFecha.setBounds(39, 58, 149, 20);
        contentPane.add(lblFecha);

        txAnio = new JTextField();
        txAnio.setEditable(true);
        txAnio.setBounds(65, 129, 69, 20);
        txAnio.setBackground(new Color(255, 255, 255)); // Fondo verde claro para el campo
        contentPane.add(txAnio);

        JButton btnBuscar = new JButton("Buscar");

        btnBuscar.setBackground(new Color(153, 255, 153)); // Verde claro
        btnBuscar.setBounds(152, 54, 84, 28);
        contentPane.add(btnBuscar);

        // Tabla 
        modeloTabla = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Nro. Identidad", "Apellido" });
        tableMedicaciones = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tableMedicaciones);
        scrollPane.setBounds(39, 220, 347, 153);
        contentPane.add(scrollPane);

        JLabel lblAviso = new JLabel("AVISO");
        lblAviso.setBounds(39, 174, 80, 20);
        contentPane.add(lblAviso);

        txAviso = new JTextField();
        txAviso.setHorizontalAlignment(SwingConstants.CENTER);
        txAviso.setEditable(false);
        txAviso.setBounds(108, 171, 273, 28);
        contentPane.add(txAviso);
        txAviso.setColumns(10);

        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setBounds(70, 99, 80, 20);
        contentPane.add(lblAnio);

        JLabel lblMes = new JLabel("Mes:");
        lblMes.setBounds(168, 98, 80, 20);
        contentPane.add(lblMes);

        txMes = new JTextField();
        txMes.setEditable(true);
        txMes.setBackground(Color.WHITE);
        txMes.setBounds(167, 129, 69, 20);
        contentPane.add(txMes);

        JLabel lblDia = new JLabel("Dia:");
        lblDia.setBounds(268, 99, 80, 20);
        contentPane.add(lblDia);

        txDia = new JTextField();
        txDia.setEditable(true);
        txDia.setBackground(Color.WHITE);
        txDia.setBounds(267, 130, 69, 20);
        contentPane.add(txDia);

        JButton btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		txAnio.setText("");
        		txMes.setText("");
        		txDia.setText("");
        	}
        });
        btnLimpiar.setBackground(new Color(153, 255, 153)); // Verde claro
        btnLimpiar.setBounds(246, 54, 140, 28);
        contentPane.add(btnLimpiar);

        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String fecha = obtenerFechaDeCampos();

                modeloTabla.setRowCount(0);

                HashMap<Integer, doctor> doctores = ConsultaDAO.obtenerDoctoresPorFecha(fecha);
                for (Map.Entry<Integer, doctor> entry : doctores.entrySet()) {
                    modeloTabla.addRow(new Object[]{
                        entry.getKey(),
                        entry.getValue().getNombre()
                    });
                }
                // Avisos
                if (doctores.isEmpty()) {
                    txAviso.setText("No hay doctores para la fecha " + fecha);
                } else {
                    txAviso.setText("Mostrando doctores para " + fecha);
                }
            }
        });
    }

    private String obtenerFechaDeCampos() {
        String anio = txAnio.getText().trim();
        String mes = txMes.getText().trim();
        String dia = txDia.getText().trim();

        if (mes.length() == 1)
            mes = "0" + mes;
        if (dia.length() == 1)
            dia = "0" + dia;

        String fecha = anio + "-" + mes + "-" + dia;
        return fecha;
    }
}

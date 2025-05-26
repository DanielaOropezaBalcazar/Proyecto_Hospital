package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.conexion;

public class atencionV extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable tableConsultas;
    private DefaultTableModel modeloTabla;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                atencionV frame = new atencionV();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public atencionV() {
        setTitle("Listado de Consultas Médicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 820, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(144, 238, 144));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Consultas Médicas por Urgencia");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(270, 10, 300, 30);
        contentPane.add(lblTitulo);

        JButton btnMostrarTodos = new JButton("Mostrar Todos");
        btnMostrarTodos.setBounds(320, 50, 150, 30);
        contentPane.add(btnMostrarTodos);

        modeloTabla = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Detalle", "Paciente", "Nivel de Urgencia", "Código Consulta" }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };

        tableConsultas = new JTable(modeloTabla);
        tableConsultas.getColumnModel().getColumn(3).setMinWidth(0);
        tableConsultas.getColumnModel().getColumn(3).setMaxWidth(0);
        tableConsultas.getColumnModel().getColumn(3).setWidth(0);

        JScrollPane scrollPane = new JScrollPane(tableConsultas);
        scrollPane.setBounds(20, 100, 760, 430);
        contentPane.add(scrollPane);

        btnMostrarTodos.addActionListener(e -> cargarConsultasConCola());
    }

    private void cargarConsultasConCola() {
        modeloTabla.setRowCount(0);

        class Consulta {
            String detalle, paciente, urgencia;
            int codigo;

            public Consulta(String detalle, String paciente, String urgencia, int codigo) {
                this.detalle = detalle;
                this.paciente = paciente;
                this.urgencia = urgencia;
                this.codigo = codigo;
            }
        }

        Comparator<Consulta> comparador = Comparator.comparingInt(c -> getPrioridad(c.urgencia));
        PriorityQueue<Consulta> cola = new PriorityQueue<>(comparador);

        String sql = "SELECT c.detalle, CONCAT(p.nombre, ' ', p.apellido) AS paciente, a.nivel_urgencia, c.codigo " +
                     "FROM atencion a " +
                     "JOIN consulta c ON a.consulta_codigo = c.codigo " +
                     "JOIN paciente p ON c.paciente_codigo = p.codigo";

        try (Connection con = conexion.conectar();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Consulta consulta = new Consulta(
                        rs.getString("detalle"),
                        rs.getString("paciente"),
                        rs.getString("nivel_urgencia"),
                        rs.getInt("codigo")
                );
                cola.add(consulta);
            }

            while (!cola.isEmpty()) {
                Consulta c = cola.poll();
                modeloTabla.addRow(new Object[]{c.detalle, c.paciente, c.urgencia, c.codigo});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
        }
    }

    private int getPrioridad(String urgencia) {
        return switch (urgencia.toLowerCase()) {
            case "crítico" -> 1;
            case "urgente" -> 2;
            case "semiurgente" -> 3;
            case "no urgente" -> 4;
            default -> 5;
        };
    }

    private void guardarCambios() {
        try (Connection con = conexion.conectar()) {
            String sqlUpdate = "UPDATE atencion a " +
                    "JOIN consulta c ON a.consulta_codigo = c.codigo " +
                    "SET a.nivel_urgencia = ? WHERE c.codigo = ?";
            PreparedStatement ps = con.prepareStatement(sqlUpdate);

            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                String nivelUrgencia = (String) modeloTabla.getValueAt(i, 2);
                int codigoConsulta = (int) modeloTabla.getValueAt(i, 3);
                ps.setString(1, nivelUrgencia);
                ps.setInt(2, codigoConsulta);
                ps.addBatch();
            }

            ps.executeBatch();
            JOptionPane.showMessageDialog(null, "Cambios guardados exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar cambios: " + e.getMessage());
        }
    }
}

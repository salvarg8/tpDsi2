package GUI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ENTIDADES.RecursoTecnologico;
import ENTIDADES.Turno;
import GESTOR.GestorTurnos;
import GESTOR.RenderRecursosTecnologicos;
import GESTOR.RenderTurnosRecurso;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import DAO.DaoRecursoTecnologico;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PantallaTurnos extends JFrame {

	private JPanel contentPane;
	public static JTable grdRecursosTecnologicos;
	private static JTable grdTurnosRecurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaTurnos frame = new PantallaTurnos();
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
	public PantallaTurnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pedirSeleccion();
	}

	private void pedirSeleccion() {
		ArrayList<String> categorias = new ArrayList<String>();
		categorias.add("TODOS");
		ArrayList<String> tipoTurnos = GestorTurnos.buscarTipoDeRecurso();
		categorias.addAll(tipoTurnos);
		final JComboBox cmbTiposRecursos = new JComboBox(categorias.toArray());
		cmbTiposRecursos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				GestorTurnos.tomarSeleccion((String) cmbTiposRecursos.getSelectedItem());

			}
		});

		cmbTiposRecursos.addKeyListener(new KeyAdapter() {

		});
		cmbTiposRecursos.setBounds(153, 28, 174, 22);
		contentPane.add(cmbTiposRecursos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 572, 331);
		contentPane.add(scrollPane);

		grdRecursosTecnologicos = new JTable();
		this.grdRecursosTecnologicos.setDefaultRenderer(Object.class, new RenderRecursosTecnologicos());
		grdRecursosTecnologicos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) grdRecursosTecnologicos.getModel();
				int fila = grdRecursosTecnologicos.getSelectedRow();
				int rtSeleccionado = Integer.parseInt((String) modelo.getValueAt(fila, 0));
				RecursoTecnologico r = GestorTurnos.getRecursoPorId(rtSeleccionado);

				GestorTurnos.rtSeleccionado(r);

			}
		});
		grdRecursosTecnologicos.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "N\u00FAmero", "Estado", "Centro de Investigaci\u00F3n", "Modelo y Marca" }));
		scrollPane.setViewportView(grdRecursosTecnologicos);

		JLabel lblNewLabel = new JLabel("Gestion de Recursos Tecnol\u00F3gicos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(337, 11, 253, 19);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(592, 86, 326, 331);
		contentPane.add(scrollPane_1);

		grdTurnosRecurso = new JTable();
		grdTurnosRecurso.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Estado", "Fecha Inicio", "Fecha Fin" }));
		scrollPane_1.setViewportView(grdTurnosRecurso);
		this.grdTurnosRecurso.setDefaultRenderer(Object.class, new RenderTurnosRecurso());

		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) grdRecursosTecnologicos.getModel();
				int fila = grdRecursosTecnologicos.getSelectedRow();
				String numeroRecurso = (String) modelo.getValueAt(fila,0);
				DefaultTableModel modelo2 = (DefaultTableModel) grdTurnosRecurso.getModel();
				int fila2 = grdRecursosTecnologicos.getSelectedRow();
				String fechaTurno = (String) modelo.getValueAt(fila2,1);
				
				
				GestorTurnos.turnoSeleccionado(numeroRecurso,fechaTurno);
				
			}
		});
		btnReservar.setBounds(829, 428, 89, 23);
		contentPane.add(btnReservar);

		JLabel lblNewLabel_1 = new JLabel("Recursos Tecnol\u00F3gicos");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 61, 572, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Turnos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(592, 61, 326, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tipo de Recurso");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 32, 133, 14);
		contentPane.add(lblNewLabel_3);
	}

	public static void pedirSeleccionTurnos(String[][] turnosDisponibles) {
		DefaultTableModel modelo = (DefaultTableModel) grdTurnosRecurso.getModel();
		modelo.setRowCount(0);
		int fila = 0;

		for (int i = 0; i < turnosDisponibles.length; i++) {
			if (turnosDisponibles[i][0] == null) {
			} else {
				modelo.addRow(new Vector());
				modelo.setValueAt(turnosDisponibles[i][0], fila, 0);
				modelo.setValueAt(turnosDisponibles[i][1], fila, 1);
				modelo.setValueAt(turnosDisponibles[i][2], fila, 2);
				((DefaultTableCellRenderer) grdTurnosRecurso.getTableHeader().getDefaultRenderer())
						.setHorizontalAlignment(SwingConstants.LEFT);
				fila++;
			}

		}
	}

	public static void pedirSelecRT(String[][] resultado) {
		DefaultTableModel modelo = (DefaultTableModel) grdRecursosTecnologicos.getModel();
		modelo.setRowCount(0);
		for (int i = 0; i < resultado.length; i++) {
			modelo.addRow(new Vector());
			modelo.setValueAt(resultado[i][0], i, 0);
			modelo.setValueAt(resultado[i][1], i, 1);
			modelo.setValueAt(resultado[i][2], i, 2);
			modelo.setValueAt(resultado[i][3], i, 3);
			((DefaultTableCellRenderer) grdRecursosTecnologicos.getTableHeader().getDefaultRenderer())
					.setHorizontalAlignment(SwingConstants.LEFT);

		}
	}

}

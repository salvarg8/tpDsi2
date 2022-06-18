package GESTOR;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderTurnosRecurso extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused,
			int row, int column) {
		setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		super.getTableCellRendererComponent(table, value, selected, focused, row, column);

		String estado = (String) table.getValueAt(row, 0);
		if (estado == "Disponible")
			setBackground(Color.decode("#758bfd"));
		else if (estado == "Reservado")
			setBackground(Color.decode("#ff686b"));
		else
			setBackground(Color.LIGHT_GRAY);

		return this;

	}

}

package Util;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class BooleanTableCellRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    if (value instanceof Boolean) {

      if ((boolean) value == true) {

        setText("Ja");
      } else {

        setText("Nein");
      }
    }
    return this;
  }
}

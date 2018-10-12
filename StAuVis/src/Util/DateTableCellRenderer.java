package Util;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class DateTableCellRenderer extends DefaultTableCellRenderer {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Exemplarvariablen
  SimpleDateFormat dateFormatter;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktor
  public DateTableCellRenderer() {

    String datePattern = "dd.MM.yyyy";
    dateFormatter = new SimpleDateFormat(datePattern);
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Methoden
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    if (value instanceof Date) {
      setText(dateFormatter.format((Date) value));
    }

    return this;
  }
}

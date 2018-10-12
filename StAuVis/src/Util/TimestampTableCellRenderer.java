package Util;

import java.awt.Component;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class TimestampTableCellRenderer extends DefaultTableCellRenderer {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Exemplarvariablen
  SimpleDateFormat timestampFormatter;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren
  public TimestampTableCellRenderer() {

    String timestampPattern = "dd.MM.yyyy HH:mm";
    timestampFormatter = new SimpleDateFormat(timestampPattern);
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Methoden
  /**
   * Formattiert die Timestamps aus der Datenbank in ein leserliches Format mithilfe eines Formatters.
   */
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    if (value instanceof Timestamp) {
      setText(timestampFormatter.format((Date) value));
    }

    return this;
  }
}

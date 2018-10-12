package Main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import Windows.MainWindow;

public class Main {

  public static void main(String[] args) throws SQLException {

    MainWindow mainWindow = new MainWindow();
    mainWindow.setBounds(getScreenCenter().width / 4, getScreenCenter().height / 4, 1200, 800);
    mainWindow.setVisible(true);
  }

  /**
   * Ermittelt die Mitte des Screens.
   * @return die Mitte als Dimension.
   */
  protected static Dimension getScreenCenter() {

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    return d;
  }
}
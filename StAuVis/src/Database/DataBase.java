package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

  static Connection conn = null;

  public static Connection getInstance() {

    if (conn == null) {
      buildConnection();
    }

    return conn;
  }

  private static void buildConnection() {

    String url = "jdbc:jtds:sqlserver://localhost;instance=DREAM-11;DatabaseName=stauvisdata";
    String driver = "net.sourceforge.jtds.jdbc.Driver";
    String userName = "sa";
    String password = "Dev360pass!";
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, userName, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.Notizen;

public class NotizenDao {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstanten für die Spaltennamen
  private static final String CN_ID = "id";
  private static final String CN_INHALT = "inhalt";
  private static final String CN_DATE = "datum";

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTER Methoden
  /**
   * Zieht alle Notizen aus der Datenbank.
   * @return eine ArrayList mit allen Notizen.
   * @throws SQLException
   */
  public ArrayList<Notizen> findAll() throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from notizen");
    ResultSet rs = ps.executeQuery();
    ArrayList<Notizen> notizenList = new ArrayList<>();
    while (rs.next()) {

      Notizen notizenData = new Notizen();
      notizenData.setId(rs.getInt(CN_ID));
      notizenData.setInhalt(rs.getString(CN_INHALT));
      notizenData.setDate(rs.getTimestamp(CN_DATE));
      notizenList.add(notizenData);
    }

    return notizenList;
  }

  /**
   * Zieht alle Spaltennamen aus der Datenbank.
   * @return eine ArrayList mit allen Spaltennamen.
   * @throws SQLException
   */
  /*public ArrayList<String> findUeberschrift() throws SQLException {
  
    PreparedStatement ps = DataBase.getInstance()
        .prepareStatement("select COLUMN_NAME from information_schema.columns where table_name = 'notizen'");
    ResultSet rs = ps.executeQuery();
    ArrayList<String> ueberschriftenList = new ArrayList<>();
    while (rs.next()) {
  
      ueberschriftenList.add(rs.getString("column_name"));
    }
  
    return ueberschriftenList;
  }*/

  /**
   * Zieht die Notiz mit der id.
   * @param id ist für die Identifizierung der Notiz.
   * @return eine ArrayList mit der gesuchten Notiz.
   * @throws SQLException
   */
  public ArrayList<Notizen> findInhaltById(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from notizen where id = ?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    ArrayList<Notizen> notizenList = new ArrayList<Notizen>();
    while (rs.next()) {

      Notizen notizenData = new Notizen();
      notizenData.setId(rs.getInt(CN_ID));
      notizenData.setInhalt(rs.getString(CN_INHALT));
      notizenData.setDate(rs.getTimestamp(CN_DATE));
      notizenList.add(notizenData);
    }

    return notizenList;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // SETTER METHODEN
  /**
   * Erstellt eine neue Notiz. Der Timestamp wird automatisch mitgegeben.
   * @param inhalt der Inhalt der gespeichert werden soll
   * @throws SQLException
   */
  public void newNotiz(String inhalt) throws SQLException {

    PreparedStatement preparedStatement = null;

    String insertTableSQL = "INSERT INTO notizen"
        + "(inhalt, datum) VALUES"
        + "(?,?)";

    preparedStatement = DataBase.getInstance().prepareStatement(insertTableSQL);

    preparedStatement.setString(1, inhalt);
    preparedStatement.setTimestamp(2, getCurrentTimeStamp());

    preparedStatement.executeUpdate();

    System.out.println("Row was inserted !");
  }

  /**
   * Updated eine Notiz. Der Timestamp wird geupdated.
   * @param inhalt der Inhalt der gespeichert werden soll.
   * @param id der zu updatenden Notiz.
   * @throws SQLException
   */
  public void updateNotiz(String inhalt, int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("update notizen set inhalt = ?, datum = ? where id = ?");
    ps.setString(1, inhalt);
    ps.setTimestamp(2, getCurrentTimeStamp());
    ps.setInt(3, id);

    ps.executeUpdate();
    System.out.println("Row was updated !");
  }

  /**
   * Löscht eine Notiz mithilfe der Id.
   * @param id ist die Id der zu löschenden Notiz.
   * @throws SQLException
   */
  public void deleteNotiz(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("delete from notizen where id = ?");
    ps.setInt(1, id);

    ps.executeUpdate();
    System.out.println("Row was deleted !");
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Methoden
  /**
   * Erstellt einen Timestamp für die Datenbank mit der Erstellungszeit.
   * @return einen Timestamp für die Datenbank.
   */
  private static java.sql.Timestamp getCurrentTimeStamp() {

    java.util.Date today = new java.util.Date();
    return new java.sql.Timestamp(today.getTime());
  }
}

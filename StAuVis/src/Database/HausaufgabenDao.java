package Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.Hausaufgaben;

public class HausaufgabenDao {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstanten für die Spaltennamen
  private static final String CN_ID = "id";
  private static final String CN_FACH = "fach";
  private static final String CN_INHALT = "inhalt";
  private static final String CN_BISWANN = "biswann";
  private static final String CN_ERLEDIGT = "erledigt";

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTER Methoden
  /**
   * Zieht alle Hausaufgaben aus der Datenbank.
   * @return eine ArrayList mit allen Hausaufgaben.
   * @throws SQLException
   */
  public ArrayList<Hausaufgaben> findAll() throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from hausaufgaben");
    ResultSet rs = ps.executeQuery();
    ArrayList<Hausaufgaben> hausaufgabenList = new ArrayList<>();
    while (rs.next()) {

      Hausaufgaben hausaufgabenData = new Hausaufgaben();
      hausaufgabenData.setId(rs.getInt(CN_ID));
      hausaufgabenData.setFach(rs.getString(CN_FACH));
      hausaufgabenData.setInhalt(rs.getString(CN_INHALT));
      hausaufgabenData.setBiswann(rs.getDate(CN_BISWANN));
      hausaufgabenData.setErledigt(rs.getBoolean(CN_ERLEDIGT));
      hausaufgabenList.add(hausaufgabenData);
    }

    return hausaufgabenList;
  }

  /**
   * Zieht die Hausaufgabe mit der id.
   * @param id ist für die Identifizierung der Hausaufgabe.
   * @return eine ArrayList mit der gesuchten Hausaufgabe.
   * @throws SQLException
   */
  public ArrayList<Hausaufgaben> findInhaltById(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from hausaufgaben where id = ?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    ArrayList<Hausaufgaben> hausaufgabenList = new ArrayList<Hausaufgaben>();
    while (rs.next()) {

      Hausaufgaben hausaufgabenData = new Hausaufgaben();
      hausaufgabenData.setId(rs.getInt(CN_ID));
      hausaufgabenData.setFach(rs.getString(CN_FACH));
      hausaufgabenData.setInhalt(rs.getString(CN_INHALT));
      hausaufgabenData.setBiswann(rs.getDate(CN_BISWANN));
      hausaufgabenData.setErledigt(rs.getBoolean(CN_ERLEDIGT));
      hausaufgabenList.add(hausaufgabenData);
    }

    return hausaufgabenList;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // SETTER Methoden
  /**
   * Erstellt eine neue Hausaufgabe.
   * @param fach der Hausaufgabe.
   * @param inhalt der Hausaufgabe.
   * @param biswann die Hausaufgabe zu erledigen ist.
   * @param erledigt ist der Status der Hausaufgabe.
   * @throws SQLException
   */
  public void newHausaufgabe(String fach, String inhalt, Date biswann, boolean erledigt) throws SQLException {

    PreparedStatement preparedStatement = null;

    String insertTableSQL = "INSERT INTO hausaufgaben"
        + "(fach, inhalt, biswann, erledigt) VALUES"
        + "(?,?,?,?)";

    preparedStatement = DataBase.getInstance().prepareStatement(insertTableSQL);

    preparedStatement.setString(1, fach);
    preparedStatement.setString(2, inhalt);
    preparedStatement.setDate(3, biswann);
    preparedStatement.setBoolean(4, erledigt);

    preparedStatement.executeUpdate();

    System.out.println("Row was inserted !");
  }

  /**
   * Updatet eine Hausaufgabe mithilfe der Id.
   * @param fach der Hausaufgbae.
   * @param inhalt der Hausaufgabe.
   * @param biswann die Hausaufgabe zu erledigen ist.
   * @param id der Hausaufgabe.
   * @param erledigt ist der Status der Hausaufgabe.
   * @throws SQLException
   */
  public void updateHausaufgabe(String fach, String inhalt, Date biswann, boolean erledigt, int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("update hausaufgaben set fach = ?, inhalt = ?, biswann = ?, erledigt = ? where id = ?");
    ps.setString(1, fach);
    ps.setString(2, inhalt);
    ps.setDate(3, biswann);
    ps.setBoolean(4, erledigt);
    ps.setInt(5, id);

    ps.executeUpdate();
    System.out.println("Row was updated !");
  }

  /**
   * Löscht eine Hausaufgabe mithilfe der Id.
   * @param id
   * @throws SQLException
   */
  public void deleteHausaufgabe(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("delete from hausaufgaben where id = ?");
    ps.setInt(1, id);

    ps.executeUpdate();
    System.out.println("Row was deleted !");
  }
}

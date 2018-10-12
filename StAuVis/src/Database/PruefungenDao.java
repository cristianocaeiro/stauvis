package Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.Pruefungen;

public class PruefungenDao {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstanten für die Spaltennamen
  private static final String CN_ID = "id";
  private static final String CN_FACH = "fach";
  private static final String CN_BEZEICHNUNG = "bezeichnung";
  private static final String CN_DATUM = "datum";
  private static final String CN_NOTE = "note";

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTER Methoden
  /**
   * Zieht alle Prüfungen aus der Datenbank.
   * @return eine ArrayList mit allen Prüfungen.
   * @throws SQLException
   */
  public ArrayList<Pruefungen> findAll() throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from pruefungen");
    ResultSet rs = ps.executeQuery();
    ArrayList<Pruefungen> pruefungenList = new ArrayList<>();
    while (rs.next()) {

      Pruefungen pruefungenData = new Pruefungen();
      pruefungenData.setId(rs.getInt(CN_ID));
      pruefungenData.setFach(rs.getString(CN_FACH));
      pruefungenData.setBezeichnung(rs.getString(CN_BEZEICHNUNG));
      pruefungenData.setDatum(rs.getDate(CN_DATUM));
      pruefungenData.setNote(rs.getInt(CN_NOTE));
      pruefungenList.add(pruefungenData);
    }

    return pruefungenList;
  }

  /**
   * Zieht die Prüfung mit der id.
   * @param id ist für die Identifizierung der Prüfung.
   * @return eine ArrayList mit der gesuchten Prüfung.
   * @throws SQLException
   */
  public ArrayList<Pruefungen> findInhaltById(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from pruefungen where id = ?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    ArrayList<Pruefungen> pruefungenList = new ArrayList<Pruefungen>();
    while (rs.next()) {

      Pruefungen pruefungenData = new Pruefungen();
      pruefungenData.setId(rs.getInt(CN_ID));
      pruefungenData.setFach(rs.getString(CN_FACH));
      pruefungenData.setBezeichnung(rs.getString(CN_BEZEICHNUNG));
      pruefungenData.setDatum(rs.getDate(CN_DATUM));
      pruefungenData.setNote(rs.getInt(CN_NOTE));
      pruefungenList.add(pruefungenData);
    }

    return pruefungenList;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // SETTER Methoden
  /**
   * Erstellt eine neue Prüfung.
   * @param fach der Prüfung.
   * @param bezeichnung der Prüfung.
   * @param datum der Prüfung.
   * @param note der Prüfung.
   * @throws SQLException
   */
  public void newPruefung(String fach, String bezeichnung, Date datum, int note) throws SQLException {

    PreparedStatement preparedStatement = null;

    String insertTableSQL = "INSERT INTO pruefungen"
        + "(fach, bezeichnung, datum, note) VALUES"
        + "(?,?,?,?)";

    preparedStatement = DataBase.getInstance().prepareStatement(insertTableSQL);

    preparedStatement.setString(1, fach);
    preparedStatement.setString(2, bezeichnung);
    preparedStatement.setDate(3, datum);
    preparedStatement.setInt(4, note);

    preparedStatement.executeUpdate();

    System.out.println("Row was inserted !");
  }

  /**
   * Updatet eine Prüfung mithilfe der Id.
   * @param fach der Prüfung.
   * @param bezeichnung der Prüfung.
   * @param datum der Prüfung.
   * @param note der Prüfung.
   * @param id der Prüfung.
   * @throws SQLException
   */
  public void updatePruefung(String fach, String bezeichnung, Date datum, int note, int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("update pruefungen set fach = ?, bezeichnung = ?, datum = ?, note = ? where id = ?");
    ps.setString(1, fach);
    ps.setString(2, bezeichnung);
    ps.setDate(3, datum);
    ps.setInt(4, note);
    ps.setInt(5, id);

    ps.executeUpdate();
    System.out.println("Row was updated !");
  }

  /**
   * Löscht die Prüfung mithilfe der Id.
   * @param id der zu löschenden Prüfung.
   * @throws SQLException
   */
  public void deleteTodo(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("delete from pruefungen where id = ?");
    ps.setInt(1, id);

    ps.executeUpdate();
    System.out.println("Row was deleted !");
  }
}

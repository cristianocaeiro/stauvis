package Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.Zeiterfassung;

public class ZeiterfassungDao {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstanten für die Spaltennamen
  private static final String CN_ID = "id";
  private static final String CN_DATUM = "datum";
  private static final String CN_STUNDEN = "stunden";
  private static final String CN_PAUSE = "pause";
  private static final String CN_KOMMENTAR = "kommentar";

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTER Methoden
  /**
   * Zieht alle Zeiterfassungen aus der Datenbank.
   * @return eine ArrayList mit allen Zeiterfassungen.
   * @throws SQLException
   */
  public ArrayList<Zeiterfassung> findAll() throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from zeiterfassung");
    ResultSet rs = ps.executeQuery();
    ArrayList<Zeiterfassung> zeiterfassungList = new ArrayList<>();
    while (rs.next()) {

      Zeiterfassung zeiterfassungData = new Zeiterfassung();
      zeiterfassungData.setId(rs.getInt(CN_ID));
      zeiterfassungData.setDatum(rs.getDate(CN_DATUM));
      zeiterfassungData.setStunden(rs.getDouble(CN_STUNDEN));
      zeiterfassungData.setPause(rs.getDouble(CN_PAUSE));
      zeiterfassungData.setKommentar(rs.getString(CN_KOMMENTAR));
      zeiterfassungList.add(zeiterfassungData);
    }

    return zeiterfassungList;
  }

  /**
   * Zieht die Zeiterfassung mit der id.
   * @param id ist für die Identifizierung der Zeiterfassung.
   * @return eine ArrayList mit der gesuchten Zeiterfassung.
   * @throws SQLException
   */
  public ArrayList<Zeiterfassung> findInhaltById(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from ´zeiterfassung where id = ?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    ArrayList<Zeiterfassung> zeiterfassungList = new ArrayList<Zeiterfassung>();
    while (rs.next()) {

      Zeiterfassung zeiterfassungData = new Zeiterfassung();
      zeiterfassungData.setId(rs.getInt(CN_ID));
      zeiterfassungData.setDatum(rs.getDate(CN_DATUM));
      zeiterfassungData.setStunden(rs.getDouble(CN_STUNDEN));
      zeiterfassungData.setPause(rs.getDouble(CN_PAUSE));
      zeiterfassungData.setKommentar(rs.getString(CN_KOMMENTAR));
      zeiterfassungList.add(zeiterfassungData);
    }

    return zeiterfassungList;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // SETTER Methoden
  /**
   * Erstellt eine neue Zeiterfassung.
   * @param datum der Zeiterfassung.
   * @param stunden anzahl der gearbeiteten Stunden.
   * @param pause anzahl der Pausenstunden.
   * @param kommentar zur Zeiterfassung.
   * @throws SQLException
   */
  public void newZeiterfassung(Date datum, double stunden, double pause, String kommentar) throws SQLException {

    PreparedStatement preparedStatement = null;

    String insertTableSQL = "INSERT INTO zeiterfassung"
        + "(datum, stunden, pause, kommentar) VALUES"
        + "(?,?,?, ?)";

    preparedStatement = DataBase.getInstance().prepareStatement(insertTableSQL);

    preparedStatement.setDate(1, datum);
    preparedStatement.setDouble(2, stunden);
    preparedStatement.setDouble(3, pause);
    preparedStatement.setString(4, kommentar);

    preparedStatement.executeUpdate();

    System.out.println("Row was inserted !");
  }

  /**
   * Löscht eine Zeiterfassung.
   * @param id der zu löschenden Zeiterfassung.
   * @throws SQLException
   */
  public void deleteZeiterfassung(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("delete from zeiterfassung where id = ?");
    ps.setInt(1, id);

    ps.executeUpdate();
    System.out.println("Row was deleted !");
  }
}

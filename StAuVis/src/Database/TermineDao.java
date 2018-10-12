package Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.Termine;

public class TermineDao {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  private static final String CN_ID = "id";
  private static final String CN_WANN = "wann";
  private static final String CN_UHRZEIT = "uhrzeit";
  private static final String CN_WAS = "was";
  private static final String CN_WO = "wo";

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTER Methoden
  /**
   * Zieht alle Termine aus der Datenbank.
   * @return eine ArrayList mit allen Terminen.
   * @throws SQLException
   */
  public ArrayList<Termine> findAll() throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from termine");
    ResultSet rs = ps.executeQuery();
    ArrayList<Termine> termineList = new ArrayList<>();
    while (rs.next()) {

      Termine termineData = new Termine();
      termineData.setId(rs.getInt(CN_ID));
      termineData.setWann(rs.getDate(CN_WANN));
      termineData.setUhrzeit(rs.getString(CN_UHRZEIT));
      termineData.setWas(rs.getString(CN_WAS));
      termineData.setWo(rs.getString(CN_WO));
      termineList.add(termineData);
    }

    return termineList;
  }

  /**
   * Zieht die Termine mit der id.
   * @param id ist für die Identifizierung der Termine.
   * @return eine ArrayList mit den gesuchten Terminen.
   * @throws SQLException
   */
  public ArrayList<Termine> findInhaltById(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from termine where id = ?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    ArrayList<Termine> termineList = new ArrayList<Termine>();
    while (rs.next()) {

      Termine termineData = new Termine();
      termineData.setId(rs.getInt(CN_ID));
      termineData.setWann(rs.getDate(CN_WANN));
      termineData.setUhrzeit(rs.getString(CN_UHRZEIT));
      termineData.setWas(rs.getString(CN_WAS));
      termineData.setWo(rs.getString(CN_WO));
      termineList.add(termineData);
    }

    return termineList;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // SETTER Methoden
  /**
   * Erstellt einen neuen Termin.
   * @param wann der Termin ist.
   * @param was der Inhalt des Termins ist.
   * @param wo der Termin stattfindet.
   * @throws SQLException
   */
  public void newTermin(Date wann, String uhrzeit, String was, String wo) throws SQLException {

    PreparedStatement preparedStatement = null;

    String insertTableSQL = "INSERT INTO termine"
        + "(wann, uhrzeit, was, wo) VALUES"
        + "(?,?,?,?)";

    preparedStatement = DataBase.getInstance().prepareStatement(insertTableSQL);

    preparedStatement.setDate(1, wann);
    preparedStatement.setString(2, uhrzeit);
    preparedStatement.setString(3, was);
    preparedStatement.setString(4, wo);

    preparedStatement.executeUpdate();

    System.out.println("Row was inserted !");
  }

  /**
   * Updatet einen Termin mithilfe der Id.
   * @param wann der Termin ist.
   * @param was der Inhalt des Termins ist.
   * @param wo der Termin stattfindet.
   * @throws SQLException
   */
  public void updateTermin(Date wann, String uhrzeit, String was, String wo, int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("update termine set wann = ?, uhrzeit = ?, was = ?, wo = ? where id = ?");
    ps.setDate(1, wann);
    ps.setString(2, uhrzeit);
    ps.setString(3, was);
    ps.setString(4, wo);
    ps.setInt(5, id);

    ps.executeUpdate();
    System.out.println("Row was updated !");
  }

  /**
   * Löscht einen Termin.
   * @param id des zu löschenden Termins.
   * @throws SQLException
   */
  public void deleteTermin(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("delete from termine where id = ?");
    ps.setInt(1, id);

    ps.executeUpdate();
    System.out.println("Row was deleted !");
  }
}

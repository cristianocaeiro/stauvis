package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entities.Faecher;

public class FaecherDao {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstanten für die Spaltennamen
  private static final String CN_ID = "id";
  private static final String CN_NAME = "name";

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTER Methoden
  /**
   * Zieht alle Fächer aus der Datenbank.
   * @return eine ArrayList mit allen Fächern.
   * @throws SQLException
   */
  public List<Faecher> findAll() throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from faecher");
    ResultSet rs = ps.executeQuery();
    List<Faecher> fachList = new ArrayList<>();
    while (rs.next()) {

      Faecher fachData = new Faecher();
      fachData.setId(rs.getInt(CN_ID));
      fachData.setName(rs.getString(CN_NAME));
      fachList.add(fachData);
    }

    return fachList;
  }

  /**
   * Zieht das Fach mit der id.
   * @param id ist für die Identifizierung des Fachs.
   * @return eine ArrayList mit dem gesuchten Fach.
   * @throws SQLException
   */
  public ArrayList<Faecher> findInhaltById(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from faecher where id = ?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    ArrayList<Faecher> fachList = new ArrayList<Faecher>();
    while (rs.next()) {

      Faecher fachData = new Faecher();
      fachData.setId(rs.getInt(CN_ID));
      fachData.setName(rs.getString(CN_NAME));
      fachList.add(fachData);
    }

    return fachList;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // SETTER Methoden
  /**
   * Erstellt ein neues Fach.
   * @param name des Fachs.
   * @throws SQLException
   */
  public void newFach(String name) throws SQLException {

    PreparedStatement preparedStatement = null;

    String insertTableSQL = "INSERT INTO faecher"
        + "(name) VALUES"
        + "(?)";

    preparedStatement = DataBase.getInstance().prepareStatement(insertTableSQL);

    preparedStatement.setString(1, name);
    preparedStatement.executeUpdate();

    System.out.println("Row was inserted !");
  }

  /**
   * Löscht ein Fach mithilfe der Id.
   * @param id des zu löschenden Fachs.
   * @throws SQLException
   */
  public void deleteFach(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("delete from faecher where id = ?");
    ps.setInt(1, id);

    ps.executeUpdate();
    System.out.println("Row was deleted !");
  }
}

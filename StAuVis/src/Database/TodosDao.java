package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.Todos;

public class TodosDao {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstanten für die Spaltennamen
  private static final String CN_ID = "id";
  private static final String CN_WAS = "was";
  private static final String CN_BISWANN = "biswann";
  private static final String CN_ERSTELLT = "erstellt";

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTER Methoden
  /**
   * Zieht alle Todos aus der Datenbank.
   * @return eine ArrayList mit allen Todos.
   * @throws SQLException
   */
  public ArrayList<Todos> findAll() throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from todos");
    ResultSet rs = ps.executeQuery();
    ArrayList<Todos> todosList = new ArrayList<>();
    while (rs.next()) {

      Todos todosData = new Todos();
      todosData.setId(rs.getInt(CN_ID));
      todosData.setWas(rs.getString(CN_WAS));
      todosData.setBiswann(rs.getString(CN_BISWANN));
      todosData.setDate(rs.getTimestamp(CN_ERSTELLT));
      todosList.add(todosData);
    }

    return todosList;
  }

  /**
   * Zieht das Todo mit der id.
   * @param id ist für die Identifizierung des Todos.
   * @return eine ArrayList mit dem gesuchten Todo.
   * @throws SQLException
   */
  public ArrayList<Todos> findInhaltById(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("select * from todos where id = ?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    ArrayList<Todos> todosList = new ArrayList<Todos>();
    while (rs.next()) {

      Todos todosData = new Todos();
      todosData.setId(rs.getInt(CN_ID));
      todosData.setWas(rs.getString(CN_WAS));
      todosData.setBiswann(rs.getString(CN_BISWANN));
      todosData.setDate(rs.getTimestamp(CN_ERSTELLT));
      todosList.add(todosData);
    }

    return todosList;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // SETTER Methoden
  /**
   * Erstellt ein neues Todo.
   * @param was das Todo ist.
   * @param biswann das Todo zu erledigen ist.
   * @throws SQLException
   */
  public void newTodo(String was, String biswann) throws SQLException {

    PreparedStatement preparedStatement = null;

    String insertTableSQL = "INSERT INTO todos"
        + "(was, biswann, erstellt) VALUES"
        + "(?,?,?)";

    preparedStatement = DataBase.getInstance().prepareStatement(insertTableSQL);

    preparedStatement.setString(1, was);
    preparedStatement.setString(2, biswann);
    preparedStatement.setTimestamp(3, getCurrentTimeStamp());

    preparedStatement.executeUpdate();

    System.out.println("Row was inserted !");
  }

  /**
   * Updatet ein Todo mithilfe der Id.
   * @param was das Todo ist.
   * @param biswann das Todo zu erledigen ist.
   * @param id des zu updatetenden Todos.
   * @throws SQLException
   */
  public void updateTodo(String was, String biswann, int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("update todos set was = ?, biswann = ?, erstellt = ? where id = ?");
    ps.setString(1, was);
    ps.setString(2, biswann);
    ps.setTimestamp(3, getCurrentTimeStamp());
    ps.setInt(4, id);

    ps.executeUpdate();
    System.out.println("Row was updated !");
  }

  /**
   * Löscht das Todo mithilfe der Id.
   * @param id des zu löschenden Todos.
   * @throws SQLException
   */
  public void deleteTodo(int id) throws SQLException {

    PreparedStatement ps = DataBase.getInstance().prepareStatement("delete from todos where id = ?");
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

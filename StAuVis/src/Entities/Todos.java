package Entities;

import java.sql.Timestamp;

import Database.TodosDao;

public class Todos {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Inhalt der Todos
  private Integer id;
  private String was;
  private String biswann;
  private Timestamp date;
  private static TodosDao dao;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  /**
   * Um den DAO der Todos zu erhalten.
   * @return den DAO der Todos.
   */
  public static TodosDao getDao() {

    if (dao == null) {
      dao = new TodosDao();
    }
    return dao;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTERS und SETTERS
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getWas() {
    return was;
  }

  public void setWas(String was) {
    this.was = was;
  }

  public String getBiswann() {
    return biswann;
  }

  public void setBiswann(String biswann) {
    this.biswann = biswann;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }
}

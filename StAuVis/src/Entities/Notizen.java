package Entities;

import java.sql.Timestamp;

import Database.NotizenDao;

public class Notizen {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Inhalt der Notiz
  private String inhalt;
  private Timestamp date;
  private Integer id;
  private static NotizenDao dao;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  /**
   * Um den DAO der Notiz zu erhalten
   * @return den DAO von Notizen
   */
  public static NotizenDao getDao() {

    if (dao == null) {
      dao = new NotizenDao();
    }
    return dao;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTERS und SETTERS
  public String getInhalt() {
    return inhalt;
  }

  public void setInhalt(String inhalt) {
    this.inhalt = inhalt;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}

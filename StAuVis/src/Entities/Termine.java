package Entities;

import java.sql.Date;

import Database.TermineDao;

public class Termine {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // inhalt der Termine
  private Integer id;
  private Date wann;
  private String uhrzeit;
  private String was;
  private String wo;
  private static TermineDao dao;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  /**
   * Um den DAO der Termine zu erhalten.
   * @return den DAO der Termine.
   */
  public static TermineDao getDao() {

    if (dao == null) {
      dao = new TermineDao();
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

  public Date getWann() {
    return wann;
  }

  public void setWann(Date wann) {
    this.wann = wann;
  }

  public String getWas() {
    return was;
  }

  public void setWas(String was) {
    this.was = was;
  }

  public String getWo() {
    return wo;
  }

  public void setWo(String wo) {
    this.wo = wo;
  }

  public String getUhrzeit() {
    return uhrzeit;
  }

  public void setUhrzeit(String uhrzeit) {
    this.uhrzeit = uhrzeit;
  }
}

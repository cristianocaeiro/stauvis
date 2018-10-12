package Entities;

import java.sql.Date;

import Database.HausaufgabenDao;

public class Hausaufgaben {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  private Integer id;
  private String fach;
  private String inhalt;
  private Date biswann;
  private boolean erledigt;
  private static HausaufgabenDao dao;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  /**
   * Um den DAO der Hausaufgaben zu erhalten.
   * @return den DAO der Hausaufgaben.
   */
  public static HausaufgabenDao getDao() {

    if (dao == null) {
      dao = new HausaufgabenDao();
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

  public String getFach() {
    return fach;
  }

  public void setFach(String fach) {
    this.fach = fach;
  }

  public String getInhalt() {
    return inhalt;
  }

  public void setInhalt(String inhalt) {
    this.inhalt = inhalt;
  }

  public Date getBiswann() {
    return biswann;
  }

  public void setBiswann(Date biswann) {
    this.biswann = biswann;
  }

  public boolean isErledigt() {
    return erledigt;
  }

  public void setErledigt(boolean erledigt) {
    this.erledigt = erledigt;
  }
}

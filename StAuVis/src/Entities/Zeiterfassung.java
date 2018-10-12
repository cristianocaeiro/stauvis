package Entities;

import java.sql.Date;

import Database.ZeiterfassungDao;

public class Zeiterfassung {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Inhalt der Zeiterfassung
  private Integer id;
  private Date datum;
  private Double stunden;
  private Double pause;
  private String kommentar;
  private static ZeiterfassungDao dao;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  /**
   * Um den DAO der Zeiterfassung zu erhalten
   * @return den DAO der Zeiterfassung
   */
  public static ZeiterfassungDao getDao() {

    if (dao == null) {
      dao = new ZeiterfassungDao();
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

  public Date getDatum() {
    return datum;
  }

  public void setDatum(Date datum) {
    this.datum = datum;
  }

  public String getKommentar() {
    return kommentar;
  }

  public void setKommentar(String kommentar) {
    this.kommentar = kommentar;
  }

  public Double getStunden() {
    return stunden;
  }

  public void setStunden(Double stunden) {
    this.stunden = stunden;
  }

  public Double getPause() {
    return pause;
  }

  public void setPause(Double pause) {
    this.pause = pause;
  }
}

package Entities;

import java.sql.Date;

import Database.PruefungenDao;

public class Pruefungen {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  private int id;
  private String fach;
  private String bezeichnung;
  private Date datum;
  private int note;
  private static PruefungenDao dao;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  /**
   * Um den DAO der Pruefungen zu erhalten.
   * @return den DAO der Pruefungen.
   */
  public static PruefungenDao getDao() {

    if (dao == null) {
      dao = new PruefungenDao();
    }
    return dao;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // SETTERS und GETTERS
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFach() {
    return fach;
  }

  public void setFach(String fach) {
    this.fach = fach;
  }

  public String getBezeichnung() {
    return bezeichnung;
  }

  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }

  public Date getDatum() {
    return datum;
  }

  public void setDatum(Date datum) {
    this.datum = datum;
  }

  public int getNote() {
    return note;
  }

  public void setNote(int note) {
    this.note = note;
  }
}

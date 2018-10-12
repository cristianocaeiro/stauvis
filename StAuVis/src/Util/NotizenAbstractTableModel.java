package Util;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entities.Notizen;

@SuppressWarnings("serial")
public class NotizenAbstractTableModel extends AbstractTableModel {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Exemplarvariablen
  String[] ueberschriften;
  ArrayList<Notizen> alleDaten;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren
  public NotizenAbstractTableModel() throws SQLException {
    ueberschriften = new String[] { "Inhalt", "Datum" };
    getNotizenModelData();
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTER und SETTER Methoden
  /**
   * Anzahl der Spalten.
   */
  @Override
  public int getColumnCount() {
    return ueberschriften.length;
  }

  /**
   * Anzahl der Reihen.
   */
  @Override
  public int getRowCount() {
    return alleDaten.size();
  }

  /**
   * Gibt das Objekt mithilfe row index und column index wieder.
   */
  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {

    try {
      getNotizenModelData();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    Notizen notiz = alleDaten.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return notiz.getInhalt();
      case 1:
        return notiz.getDate();
      default:
        return null;
    }
  }

  /**
   * Gibt die Namen der Spalten wieder.
   */
  @Override
  public String getColumnName(int column) {
    return ueberschriften[column];
  }

  public ArrayList<Notizen> getAlleDaten() {
    return alleDaten;
  }

  public void setAlleDaten(ArrayList<Notizen> alleDaten) {
    this.alleDaten = alleDaten;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Hilfsmethoden
  /**
   * Zieht die Notizen Daten aus der Datenbank
   * @throws SQLException
   */
  public void getNotizenModelData() throws SQLException {
    alleDaten = Notizen.getDao().findAll();
  }
}

package Util;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entities.Zeiterfassung;

@SuppressWarnings("serial")
public class ZeiterfassungAbstractTableModel extends AbstractTableModel {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Exemplarvariablen
  String[] ueberschriften;
  ArrayList<Zeiterfassung> alleDaten;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren

  public ZeiterfassungAbstractTableModel() throws SQLException {

    ueberschriften = new String[] { "Datum", "Stunden", "Pause", "Kommentar" };
    getZeiterfassungModelData();
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  //GETTER und SETTER Methoden
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
      getZeiterfassungModelData();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    Zeiterfassung zeiterfassung = alleDaten.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return zeiterfassung.getDatum();
      case 1:
        return zeiterfassung.getStunden();
      case 2:
        return zeiterfassung.getPause();
      case 3:
        return zeiterfassung.getKommentar();
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

  public ArrayList<Zeiterfassung> getAlleDaten() {
    return alleDaten;
  }

  public void setAlleDaten(ArrayList<Zeiterfassung> alleDaten) {
    this.alleDaten = alleDaten;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Hilfsmethoden
  /**
  * Zieht die Zeiterfassung Daten aus der Datenbank
  * @throws SQLException
  */
  public void getZeiterfassungModelData() throws SQLException {
    alleDaten = Zeiterfassung.getDao().findAll();
  }
}

package Util;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entities.Termine;

@SuppressWarnings("serial")
public class TermineAbstractTableModel extends AbstractTableModel {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Exemplarvariablen
  String[] ueberschriften;
  ArrayList<Termine> alleDaten;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren
  public TermineAbstractTableModel() throws SQLException {
    ueberschriften = new String[] { "Datum", "Uhrzeit", "Was ?", "Wo ?" };
    getTermineModelData();
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
      getTermineModelData();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    Termine termin = alleDaten.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return termin.getWann();
      case 1:
        return termin.getUhrzeit();
      case 2:
        return termin.getWas();
      case 3:
        return termin.getWo();
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

  public ArrayList<Termine> getAlleDaten() {
    return alleDaten;
  }

  public void setAlleDaten(ArrayList<Termine> alleDaten) {
    this.alleDaten = alleDaten;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Hilfsmethoden
  /**
   * Zieht die Notizen Daten aus der Datenbank
   * @throws SQLException
   */
  public void getTermineModelData() throws SQLException {
    alleDaten = Termine.getDao().findAll();
  }
}

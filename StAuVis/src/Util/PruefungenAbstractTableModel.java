package Util;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entities.Pruefungen;

@SuppressWarnings("serial")
public class PruefungenAbstractTableModel extends AbstractTableModel {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Exemplarvariablen
  String[] ueberschriften;
  ArrayList<Pruefungen> alleDaten;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren
  public PruefungenAbstractTableModel() throws SQLException {

    ueberschriften = new String[] { "Fach", "Bezeichnung", "Datum", "Note" };
    getPruefungenModelData();
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
      getPruefungenModelData();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    Pruefungen pruefungen = alleDaten.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return pruefungen.getFach();
      case 1:
        return pruefungen.getBezeichnung();
      case 2:
        return pruefungen.getDatum();
      case 3:
        return pruefungen.getNote();
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

  public ArrayList<Pruefungen> getAlleDaten() {
    return alleDaten;
  }

  public void setAlleDaten(ArrayList<Pruefungen> alleDaten) {
    this.alleDaten = alleDaten;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Hilfsmethoden
  /**
  * Zieht die Todos Daten aus der Datenbank
  * @throws SQLException
  */
  public void getPruefungenModelData() throws SQLException {
    alleDaten = Pruefungen.getDao().findAll();
  }
}

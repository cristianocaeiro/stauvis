package Util;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entities.Hausaufgaben;

@SuppressWarnings("serial")
public class HausaufgabenAbstractTableModel extends AbstractTableModel {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Exemplarvariablen
  String[] ueberschriften;
  ArrayList<Hausaufgaben> alleDaten;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren
  public HausaufgabenAbstractTableModel() throws SQLException {

    ueberschriften = new String[] { "Fach", "Inhalt", "Bis wann ?", "Erledigt ?" };
    getHausaufgabenModelData();
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
      getHausaufgabenModelData();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    Hausaufgaben hausaufgaben = alleDaten.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return hausaufgaben.getFach();
      case 1:
        return hausaufgaben.getInhalt();
      case 2:
        return hausaufgaben.getBiswann();
      case 3:
        return hausaufgaben.isErledigt();
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

  public ArrayList<Hausaufgaben> getAlleDaten() {
    return alleDaten;
  }

  public void setAlleDaten(ArrayList<Hausaufgaben> alleDaten) {
    this.alleDaten = alleDaten;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Hilfsmethoden
  /**
  * Zieht die Hausaufgaben Daten aus der Datenbank
  * @throws SQLException
  */
  public void getHausaufgabenModelData() throws SQLException {
    alleDaten = Hausaufgaben.getDao().findAll();
  }
}

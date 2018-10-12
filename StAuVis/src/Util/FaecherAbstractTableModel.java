package Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entities.Faecher;

@SuppressWarnings("serial")
public class FaecherAbstractTableModel extends AbstractTableModel {

  // Exemplarvariablen
  String[] ueberschriften;
  List<Faecher> alleDaten;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren
  public FaecherAbstractTableModel() throws SQLException {

    ueberschriften = new String[] { "Name" };
    getFaecherModelData();
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
      getFaecherModelData();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    Faecher fach = alleDaten.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return fach.getName();
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

  public List<Faecher> getAlleDaten() {
    return alleDaten;
  }

  public void setAlleDaten(ArrayList<Faecher> alleDaten) {
    this.alleDaten = alleDaten;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Hilfsmethoden
  /**
  * Zieht die Hausaufgaben Daten aus der Datenbank
  * @throws SQLException
  */
  public void getFaecherModelData() throws SQLException {
    alleDaten = Faecher.getDao().findAll();
  }
}

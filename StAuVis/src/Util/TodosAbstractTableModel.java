package Util;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entities.Todos;

@SuppressWarnings("serial")
public class TodosAbstractTableModel extends AbstractTableModel {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Exemplarvariablen
  String[] ueberschriften;
  ArrayList<Todos> alleDaten;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren
  public TodosAbstractTableModel() throws SQLException {

    ueberschriften = new String[] { "Was ?", "Bis wann ?", "Erstellt am" };
    getTodosModelData();
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
      getTodosModelData();
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    Todos todo = alleDaten.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return todo.getWas();
      case 1:
        return todo.getBiswann();
      case 2:
        return todo.getDate();
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

  public ArrayList<Todos> getAlleDaten() {
    return alleDaten;
  }

  public void setAlleDaten(ArrayList<Todos> alleDaten) {
    this.alleDaten = alleDaten;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Hilfsmethoden
  /**
  * Zieht die Todos Daten aus der Datenbank
  * @throws SQLException
  */
  public void getTodosModelData() throws SQLException {
    alleDaten = Todos.getDao().findAll();
  }
}

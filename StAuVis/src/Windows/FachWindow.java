package Windows;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Entities.Faecher;
import Util.FaecherAbstractTableModel;
import Util.UtilColors;

@SuppressWarnings("serial")
public class FachWindow extends JDialog {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // JElements
  private JLabel labelFaecher;
  private JScrollPane scrollpane;
  private JLabel labelNeuesFach;
  private JTextField textfieldNeuesFach;
  private JPanel panelButtons;
  private JButton buttonSpeichern;
  private JButton buttonLoeschen;
  private JButton buttonFertig;
  private JTable table;
  private FaecherAbstractTableModel tablemodel;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktor
  public FachWindow(JFrame owner) throws SQLException {

    // Modaler super Aufruf
    super(owner, true);

    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
    gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
    gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
    getContentPane().setLayout(gridBagLayout);
    GridBagConstraints gbc_labelFaecher = new GridBagConstraints();
    gbc_labelFaecher.gridwidth = 2;
    gbc_labelFaecher.insets = new Insets(0, 0, 5, 0);
    gbc_labelFaecher.gridx = 0;
    gbc_labelFaecher.gridy = 0;
    getContentPane().add(getLabelFaecher(), gbc_labelFaecher);
    GridBagConstraints gbc_scrollpane = new GridBagConstraints();
    gbc_scrollpane.gridwidth = 2;
    gbc_scrollpane.insets = new Insets(0, 0, 5, 0);
    gbc_scrollpane.fill = GridBagConstraints.BOTH;
    gbc_scrollpane.gridx = 0;
    gbc_scrollpane.gridy = 1;
    getContentPane().add(getScrollpane(), gbc_scrollpane);
    GridBagConstraints gbc_labelNeuesFach = new GridBagConstraints();
    gbc_labelNeuesFach.anchor = GridBagConstraints.WEST;
    gbc_labelNeuesFach.insets = new Insets(0, 0, 5, 5);
    gbc_labelNeuesFach.gridx = 0;
    gbc_labelNeuesFach.gridy = 2;
    getContentPane().add(getLabelNeuesFach(), gbc_labelNeuesFach);
    GridBagConstraints gbc_textfieldNeuesFach = new GridBagConstraints();
    gbc_textfieldNeuesFach.insets = new Insets(0, 0, 5, 0);
    gbc_textfieldNeuesFach.fill = GridBagConstraints.HORIZONTAL;
    gbc_textfieldNeuesFach.gridx = 1;
    gbc_textfieldNeuesFach.gridy = 2;
    getContentPane().add(getTextfieldNeuesFach(), gbc_textfieldNeuesFach);
    GridBagConstraints gbc_panelButtons = new GridBagConstraints();
    gbc_panelButtons.gridwidth = 2;
    gbc_panelButtons.insets = new Insets(0, 0, 0, 5);
    gbc_panelButtons.fill = GridBagConstraints.BOTH;
    gbc_panelButtons.gridx = 0;
    gbc_panelButtons.gridy = 3;
    getContentPane().add(getPanelButtons(), gbc_panelButtons);
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTERS und SETTERS
  public JLabel getLabelFaecher() {
    if (labelFaecher == null) {
      labelFaecher = new JLabel("F\u00E4cher");
      labelFaecher.setForeground(Color.WHITE);
    }
    return labelFaecher;
  }

  public JScrollPane getScrollpane() throws SQLException {
    if (scrollpane == null) {
      scrollpane = new JScrollPane();
      scrollpane.setViewportView(getTable());
    }
    return scrollpane;
  }

  public JLabel getLabelNeuesFach() {
    if (labelNeuesFach == null) {
      labelNeuesFach = new JLabel("Neues Fach");
      labelNeuesFach.setForeground(Color.WHITE);
    }
    return labelNeuesFach;
  }

  public JTextField getTextfieldNeuesFach() {
    if (textfieldNeuesFach == null) {
      textfieldNeuesFach = new JTextField();
      textfieldNeuesFach.setColumns(10);
    }
    return textfieldNeuesFach;
  }

  public JPanel getPanelButtons() {
    if (panelButtons == null) {
      panelButtons = new JPanel();
      panelButtons.setBackground(UtilColors.getPanelColor());
      panelButtons.add(getButtonSpeichern());
      panelButtons.add(getButtonLoeschen());
      panelButtons.add(getButtonFertig());
    }
    return panelButtons;
  }

  public JButton getButtonSpeichern() {
    if (buttonSpeichern == null) {
      buttonSpeichern = new JButton("Speichern");
      buttonSpeichern.setBackground(UtilColors.getButtonColor());

      // Speicher Aktion
      buttonSpeichern.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

          try {
            Faecher.getDao().newFach(textfieldNeuesFach.getText());
            refreshTable();
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
      });
    }
    return buttonSpeichern;
  }

  public JButton getButtonLoeschen() {
    if (buttonLoeschen == null) {
      buttonLoeschen = new JButton("L\u00F6schen");
      buttonLoeschen.setBackground(UtilColors.getButtonColor());

      // Löschen Aktion
      buttonLoeschen.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

          try {
            Faecher.getDao().deleteFach((tablemodel.getAlleDaten().get(table.convertRowIndexToModel(table.getSelectedRow())).getId()));
            refreshTable();
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
      });
    }
    return buttonLoeschen;
  }

  public JButton getButtonFertig() {
    if (buttonFertig == null) {
      buttonFertig = new JButton("Fertig");
      buttonFertig.setBackground(UtilColors.getButtonColor());

      // Fertig Aktion
      buttonFertig.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

          setVisible(false);
          dispose();
        }
      });
    }
    return buttonFertig;
  }

  public JTable getTable() throws SQLException {
    if (table == null) {
      table = new JTable();
      table.setBackground(UtilColors.getTableColor());

      // Setzen des Models
      tablemodel = new FaecherAbstractTableModel();
      table.setModel(tablemodel);

      // Single Selection aktivieren
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // Automatische Sortierung aktivieren
      table.setAutoCreateRowSorter(true);
    }
    return table;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Hilfsmethoden
  /**
   * Lädt die Tabelle neu.
   * @throws SQLException
   */
  private void refreshTable() throws SQLException {

    tablemodel.getFaecherModelData();
    tablemodel.fireTableDataChanged();
  }
}

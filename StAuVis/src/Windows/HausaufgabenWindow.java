package Windows;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.toedter.calendar.JDateChooser;

import Entities.Faecher;
import Entities.Hausaufgaben;
import Util.UtilColors;

@SuppressWarnings("serial")
public class HausaufgabenWindow extends JFrame {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // JElements
  private JLabel labelInhalt;
  private JTextPane textpaneInhalt;
  private JLabel labelBiswann;
  private JPanel panelButtons;
  private JButton buttonSpeichern;
  private JButton buttonAbbrechen;
  private JPanel panelFach;
  private JLabel labelFach;
  private JButton buttonFach;
  private JComboBox<Faecher> comboboxFach;
  private JLabel labelErledigt;
  private JComboBox<String> comboboxErledigt;
  String[] erledigtArray;
  private JDateChooser dateChooser;

  // Update
  boolean updateBool;
  int updateId;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktor
  public HausaufgabenWindow() throws SQLException {

    // ComboBox füllen
    getComboboxArray();
    erledigtArray = new String[] { "Nein", "Ja" };

    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
    gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
    getContentPane().setLayout(gridBagLayout);
    GridBagConstraints gbc_panelFach = new GridBagConstraints();
    gbc_panelFach.insets = new Insets(0, 0, 5, 5);
    gbc_panelFach.fill = GridBagConstraints.VERTICAL;
    gbc_panelFach.gridx = 0;
    gbc_panelFach.gridy = 0;
    getContentPane().add(getPanelFach(), gbc_panelFach);
    GridBagConstraints gbc_buttonFach = new GridBagConstraints();
    gbc_buttonFach.insets = new Insets(0, 0, 5, 0);
    gbc_buttonFach.gridx = 1;
    gbc_buttonFach.gridy = 0;
    getContentPane().add(getButtonFach(), gbc_buttonFach);
    GridBagConstraints gbc_comboboxFach = new GridBagConstraints();
    gbc_comboboxFach.gridwidth = 2;
    gbc_comboboxFach.insets = new Insets(0, 0, 5, 5);
    gbc_comboboxFach.fill = GridBagConstraints.HORIZONTAL;
    gbc_comboboxFach.gridx = 0;
    gbc_comboboxFach.gridy = 1;
    getContentPane().add(getComboboxFach(), gbc_comboboxFach);
    GridBagConstraints gbc_labelInhalt = new GridBagConstraints();
    gbc_labelInhalt.gridwidth = 2;
    gbc_labelInhalt.insets = new Insets(0, 0, 5, 0);
    gbc_labelInhalt.gridx = 0;
    gbc_labelInhalt.gridy = 2;
    getContentPane().add(getLabelInhalt(), gbc_labelInhalt);
    GridBagConstraints gbc_textpaneInhalt = new GridBagConstraints();
    gbc_textpaneInhalt.gridwidth = 2;
    gbc_textpaneInhalt.insets = new Insets(0, 0, 5, 0);
    gbc_textpaneInhalt.fill = GridBagConstraints.BOTH;
    gbc_textpaneInhalt.gridx = 0;
    gbc_textpaneInhalt.gridy = 3;
    getContentPane().add(getTextpaneInhalt(), gbc_textpaneInhalt);
    GridBagConstraints gbc_labelBiswann = new GridBagConstraints();
    gbc_labelBiswann.gridwidth = 2;
    gbc_labelBiswann.insets = new Insets(0, 0, 5, 0);
    gbc_labelBiswann.gridx = 0;
    gbc_labelBiswann.gridy = 4;
    getContentPane().add(getLabelBiswann(), gbc_labelBiswann);
    GridBagConstraints gbc_dateChooser = new GridBagConstraints();
    gbc_dateChooser.gridwidth = 2;
    gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
    gbc_dateChooser.fill = GridBagConstraints.BOTH;
    gbc_dateChooser.gridx = 0;
    gbc_dateChooser.gridy = 5;
    getContentPane().add(getDateChooser(), gbc_dateChooser);
    GridBagConstraints gbc_labelErledigt = new GridBagConstraints();
    gbc_labelErledigt.gridwidth = 2;
    gbc_labelErledigt.insets = new Insets(0, 0, 5, 0);
    gbc_labelErledigt.gridx = 0;
    gbc_labelErledigt.gridy = 6;
    getContentPane().add(getLabelErledigt(), gbc_labelErledigt);
    GridBagConstraints gbc_comboboxErledigt = new GridBagConstraints();
    gbc_comboboxErledigt.gridwidth = 2;
    gbc_comboboxErledigt.insets = new Insets(0, 0, 5, 5);
    gbc_comboboxErledigt.fill = GridBagConstraints.HORIZONTAL;
    gbc_comboboxErledigt.gridx = 0;
    gbc_comboboxErledigt.gridy = 7;
    getContentPane().add(getComboboxErledigt(), gbc_comboboxErledigt);
    GridBagConstraints gbc_panelButtons = new GridBagConstraints();
    gbc_panelButtons.gridwidth = 2;
    gbc_panelButtons.fill = GridBagConstraints.BOTH;
    gbc_panelButtons.gridx = 0;
    gbc_panelButtons.gridy = 8;
    getContentPane().add(getPanelButtons(), gbc_panelButtons);
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTERS und SETTERS
  public JLabel getLabelInhalt() {
    if (labelInhalt == null) {
      labelInhalt = new JLabel("Inhalt");
      labelInhalt.setForeground(Color.WHITE);
    }
    return labelInhalt;
  }

  public JTextPane getTextpaneInhalt() {
    if (textpaneInhalt == null) {
      textpaneInhalt = new JTextPane();
    }
    return textpaneInhalt;
  }

  public JLabel getLabelBiswann() {
    if (labelBiswann == null) {
      labelBiswann = new JLabel("Bis wann ?");
      labelBiswann.setForeground(Color.WHITE);
    }
    return labelBiswann;
  }

  public JPanel getPanelButtons() {
    if (panelButtons == null) {
      panelButtons = new JPanel();
      panelButtons.setBackground(UtilColors.getPanelColor());
      panelButtons.add(getButtonSpeichern());
      panelButtons.add(getButtonAbbrechen());
    }
    return panelButtons;
  }

  public JButton getButtonSpeichern() {
    if (buttonSpeichern == null) {
      buttonSpeichern = new JButton("Speichern");
      buttonSpeichern.setBackground(UtilColors.getButtonColor());

      // Speichern Aktion
      buttonSpeichern.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

          // Wenn Update
          if (updateBool) {
            boolean boolErledigt;
            if (comboboxErledigt.getSelectedItem().equals("Ja")) {
              boolErledigt = true;
            } else {
              boolErledigt = false;
            }
            try {
              Hausaufgaben.getDao().updateHausaufgabe((String) comboboxFach.getSelectedItem(), textpaneInhalt.getText(), new Date(dateChooser.getDate().getTime()), boolErledigt, updateId);
              setVisible(false);
              dispose();
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
          }
          // Wenn neu
          else {
            boolean boolErledigt;
            if (comboboxErledigt.getSelectedItem().equals("Ja")) {
              boolErledigt = true;
            } else {
              boolErledigt = false;
            }
            try {
              Hausaufgaben.getDao().newHausaufgabe(((Faecher) comboboxFach.getSelectedItem()).getName(), textpaneInhalt.getText(), new Date(dateChooser.getDate().getTime()), boolErledigt);
              setVisible(false);
              dispose();
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
          }
        }
      });
    }
    return buttonSpeichern;
  }

  public JButton getButtonAbbrechen() {
    if (buttonAbbrechen == null) {
      buttonAbbrechen = new JButton("Abbrechen");
      buttonAbbrechen.setBackground(UtilColors.getButtonColor());

      // Abbrechen Aktion
      buttonAbbrechen.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          dispose();
        }
      });
    }
    return buttonAbbrechen;
  }

  public JPanel getPanelFach() {
    if (panelFach == null) {
      panelFach = new JPanel();
      panelFach.setBackground(UtilColors.getWindowColor());
      panelFach.add(getLabelFach());
    }
    return panelFach;
  }

  public JLabel getLabelFach() {
    if (labelFach == null) {
      labelFach = new JLabel("Fach");
      labelFach.setForeground(Color.WHITE);
    }
    return labelFach;
  }

  public JButton getButtonFach() {
    if (buttonFach == null) {
      buttonFach = new JButton("Neues Fach");
      buttonFach.setBackground(UtilColors.getButtonColor());

      buttonFach.addActionListener(new ActionListener() {

        // Neues Fach Aktion
        @Override
        public void actionPerformed(ActionEvent e) {

          try {
            FachWindow fachWindow = new FachWindow(HausaufgabenWindow.this);
            fachWindow.setBounds(getLocation().x + getSize().width, getLocation().y, 300, 400);
            fachWindow.getContentPane().setBackground(UtilColors.getWindowColor());
            fachWindow.setVisible(true);
            refreshComboBoxFaecher();
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
      });
    }
    return buttonFach;
  }

  public boolean isUpdateBool() {
    return updateBool;
  }

  public void setUpdateBool(boolean updateBool) {
    this.updateBool = updateBool;
  }

  public int getUpdateId() {
    return updateId;
  }

  public void setUpdateId(int updateId) {
    this.updateId = updateId;
  }

  public JComboBox<Faecher> getComboboxFach() {
    if (comboboxFach == null) {
      try {
        comboboxFach = new JComboBox<Faecher>(getComboboxArray());
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return comboboxFach;
  }

  public JLabel getLabelErledigt() {
    if (labelErledigt == null) {
      labelErledigt = new JLabel("Erledigt ?");
      labelErledigt.setForeground(Color.WHITE);
    }
    return labelErledigt;
  }

  public JComboBox<String> getComboboxErledigt() {
    if (comboboxErledigt == null) {
      comboboxErledigt = new JComboBox<String>(erledigtArray);
    }
    return comboboxErledigt;
  }

  public JDateChooser getDateChooser() {
    if (dateChooser == null) {
      dateChooser = new JDateChooser();
    }
    return dateChooser;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Hilfsmethoden
  /**
   * Fächer für die Combobox.
   * @return ein Faecher Array.
   * @throws SQLException
   */
  private Faecher[] getComboboxArray() throws SQLException {

    List<Faecher> faecherList = Faecher.getDao().findAll();
    return faecherList.toArray(new Faecher[faecherList.size()]);
  }

  /**
   * Refresht das Faecher Array.
   * @throws SQLException
   */
  private void refreshComboBoxFaecher() throws SQLException {
    getComboboxFach().removeAllItems();
    Faecher.getDao().findAll().forEach(fach -> getComboboxFach().addItem(fach));
  }
}
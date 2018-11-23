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
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Entities.Faecher;
import Entities.Pruefungen;
import Util.UtilColors;

/*
 * TODO
 * MIT DEN PRÜFUNGEN WEITER MACHEN; COMBOBOX LOGIK AUS HAUSAUFGABENWINDOW NEHMEN; BUTTON FÜR NEUE FÄCHER IN WINDOW HINZUFÜGEN MIT VERBINDUNG ZUM GLEICHEN FAECHERWINDOW
 */

@SuppressWarnings("serial")
public class PruefungenWindow extends JFrame {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  //JElements
  private JLabel labelFach;
  private JComboBox comboboxFach;
  private JLabel labelBezeichnung;
  private JTextField textfieldBezeichnung;
  private JLabel labelDatum;

  private JDateChooser datechooser;
  private JLabel labelNote;
  private JTextField textfieldNote;
  private JPanel panel;
  private JButton buttonSpeichern;
  private JButton buttonAbbrechen;

  // Update
  boolean updateBool;
  int updateId;
  private JButton buttonNeuesfach;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  public PruefungenWindow() {

    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
    gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
    getContentPane().setLayout(gridBagLayout);
    GridBagConstraints gbc_labelFach = new GridBagConstraints();
    gbc_labelFach.insets = new Insets(0, 0, 5, 5);
    gbc_labelFach.gridx = 0;
    gbc_labelFach.gridy = 0;
    getContentPane().add(getLabelFach(), gbc_labelFach);
    GridBagConstraints gbc_buttonNeuesfach = new GridBagConstraints();
    gbc_buttonNeuesfach.insets = new Insets(0, 0, 5, 0);
    gbc_buttonNeuesfach.gridx = 1;
    gbc_buttonNeuesfach.gridy = 0;
    getContentPane().add(getButtonNeuesfach(), gbc_buttonNeuesfach);
    GridBagConstraints gbc_comboboxFach = new GridBagConstraints();
    gbc_comboboxFach.gridwidth = 2;
    gbc_comboboxFach.insets = new Insets(0, 0, 5, 0);
    gbc_comboboxFach.fill = GridBagConstraints.HORIZONTAL;
    gbc_comboboxFach.gridx = 0;
    gbc_comboboxFach.gridy = 1;
    try {
      getContentPane().add(getComboboxFach(), gbc_comboboxFach);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    GridBagConstraints gbc_labelBezeichnung = new GridBagConstraints();
    gbc_labelBezeichnung.gridwidth = 2;
    gbc_labelBezeichnung.insets = new Insets(0, 0, 5, 0);
    gbc_labelBezeichnung.gridx = 0;
    gbc_labelBezeichnung.gridy = 2;
    getContentPane().add(getLabelBezeichnung(), gbc_labelBezeichnung);
    GridBagConstraints gbc_textfieldBezeichnung = new GridBagConstraints();
    gbc_textfieldBezeichnung.gridwidth = 2;
    gbc_textfieldBezeichnung.insets = new Insets(0, 0, 5, 0);
    gbc_textfieldBezeichnung.fill = GridBagConstraints.HORIZONTAL;
    gbc_textfieldBezeichnung.gridx = 0;
    gbc_textfieldBezeichnung.gridy = 3;
    getContentPane().add(getTextfieldBezeichnung(), gbc_textfieldBezeichnung);
    GridBagConstraints gbc_labelDatum = new GridBagConstraints();
    gbc_labelDatum.gridwidth = 2;
    gbc_labelDatum.insets = new Insets(0, 0, 5, 0);
    gbc_labelDatum.gridx = 0;
    gbc_labelDatum.gridy = 4;
    getContentPane().add(getLabelDatum(), gbc_labelDatum);
    GridBagConstraints gbc_datechooser = new GridBagConstraints();
    gbc_datechooser.gridwidth = 2;
    gbc_datechooser.insets = new Insets(0, 0, 5, 0);
    gbc_datechooser.fill = GridBagConstraints.BOTH;
    gbc_datechooser.gridx = 0;
    gbc_datechooser.gridy = 5;
    getContentPane().add(getDatechooser(), gbc_datechooser);
    GridBagConstraints gbc_labelNote = new GridBagConstraints();
    gbc_labelNote.gridwidth = 2;
    gbc_labelNote.insets = new Insets(0, 0, 5, 0);
    gbc_labelNote.gridx = 0;
    gbc_labelNote.gridy = 6;
    getContentPane().add(getLabelNote(), gbc_labelNote);
    GridBagConstraints gbc_textfieldNote = new GridBagConstraints();
    gbc_textfieldNote.gridwidth = 2;
    gbc_textfieldNote.insets = new Insets(0, 0, 5, 0);
    gbc_textfieldNote.fill = GridBagConstraints.HORIZONTAL;
    gbc_textfieldNote.gridx = 0;
    gbc_textfieldNote.gridy = 7;
    getContentPane().add(getTextfieldNote(), gbc_textfieldNote);
    GridBagConstraints gbc_panel = new GridBagConstraints();
    gbc_panel.gridwidth = 2;
    gbc_panel.fill = GridBagConstraints.BOTH;
    gbc_panel.gridx = 0;
    gbc_panel.gridy = 8;
    getContentPane().add(getPanel(), gbc_panel);
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTERS und SETTERS
  public JLabel getLabelFach() {
    if (labelFach == null) {
      labelFach = new JLabel("Fach");
      labelFach.setForeground(Color.WHITE);
    }
    return labelFach;
  }

  public JComboBox<Faecher> getComboboxFach() throws SQLException {
    if (comboboxFach == null) {
      comboboxFach = new JComboBox(getComboboxArray());
    }
    return comboboxFach;
  }

  public JLabel getLabelBezeichnung() {
    if (labelBezeichnung == null) {
      labelBezeichnung = new JLabel("Bezeichnung");
      labelBezeichnung.setForeground(Color.WHITE);
    }
    return labelBezeichnung;
  }

  public JTextField getTextfieldBezeichnung() {
    if (textfieldBezeichnung == null) {
      textfieldBezeichnung = new JTextField();
      textfieldBezeichnung.setColumns(10);
    }
    return textfieldBezeichnung;
  }

  public JLabel getLabelDatum() {
    if (labelDatum == null) {
      labelDatum = new JLabel("Datum");
      labelDatum.setForeground(Color.WHITE);
    }
    return labelDatum;
  }

  public JDateChooser getDatechooser() {
    if (datechooser == null) {
      datechooser = new JDateChooser();
    }
    return datechooser;
  }

  public JLabel getLabelNote() {
    if (labelNote == null) {
      labelNote = new JLabel("Note");
      labelNote.setForeground(Color.WHITE);
    }
    return labelNote;
  }

  public JTextField getTextfieldNote() {
    if (textfieldNote == null) {
      textfieldNote = new JTextField();
      textfieldNote.setColumns(10);
    }
    return textfieldNote;
  }

  public JPanel getPanel() {
    if (panel == null) {
      panel = new JPanel();
      panel.setBackground(UtilColors.getPanelColor());
      panel.add(getButtonSpeichern());
      panel.add(getButtonAbbrechen());
    }
    return panel;
  }

  public JButton getButtonSpeichern() {
    if (buttonSpeichern == null) {
      buttonSpeichern = new JButton("Speichern");
      buttonSpeichern.setBackground(UtilColors.getButtonColor());

      buttonSpeichern.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

          if (updateBool) {

            try {
              Pruefungen.getDao().updatePruefung((String) comboboxFach.getSelectedItem(), textfieldBezeichnung.getText(), new Date(datechooser.getDate().getTime()), Integer.parseInt(textfieldNote.getText()), updateId);
            } catch (NumberFormatException e1) {
              e1.printStackTrace();
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
            setVisible(false);
            dispose();
          } else {

            try {
              Pruefungen.getDao().newPruefung(((Faecher) comboboxFach.getSelectedItem()).getName(), textfieldBezeichnung.getText(), new Date(datechooser.getDate().getTime()), Integer.parseInt(textfieldNote.getText()));
            } catch (NumberFormatException e1) {
              e1.printStackTrace();
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
            setVisible(false);
            dispose();
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

  public void setLabelFach(JLabel labelFach) {
    this.labelFach = labelFach;
  }

  public void setComboboxFach(JComboBox comboboxFach) {
    this.comboboxFach = comboboxFach;
  }

  public void setLabelBezeichnung(JLabel labelBezeichnung) {
    this.labelBezeichnung = labelBezeichnung;
  }

  public void setTextfieldBezeichnung(JTextField textfieldBezeichnung) {
    this.textfieldBezeichnung = textfieldBezeichnung;
  }

  public void setLabelDatum(JLabel labelDatum) {
    this.labelDatum = labelDatum;
  }

  public void setDatechooser(JDateChooser datechooser) {
    this.datechooser = datechooser;
  }

  public void setLabelNote(JLabel labelNote) {
    this.labelNote = labelNote;
  }

  public void setTextfieldNote(JTextField textfieldNote) {
    this.textfieldNote = textfieldNote;
  }

  public void setPanel(JPanel panel) {
    this.panel = panel;
  }

  public void setButtonSpeichern(JButton buttonSpeichern) {
    this.buttonSpeichern = buttonSpeichern;
  }

  public void setButtonAbbrechen(JButton buttonAbbrechen) {
    this.buttonAbbrechen = buttonAbbrechen;
  }

  public JButton getButtonNeuesfach() {
    if (buttonNeuesfach == null) {
      buttonNeuesfach = new JButton("Neues Fach");
      buttonNeuesfach.setBackground(UtilColors.getButtonColor());

      buttonNeuesfach.addActionListener(new ActionListener() {

        // Neues Fach Aktion
        @Override
        public void actionPerformed(ActionEvent e) {

          try {
            FachWindow fachWindow = new FachWindow(PruefungenWindow.this);
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
    return buttonNeuesfach;
  }

  /**
   * Refresht das Faecher Array.
   * @throws SQLException
   */
  private void refreshComboBoxFaecher() throws SQLException {
    getComboboxFach().removeAllItems();
    Faecher.getDao().findAll().forEach(fach -> {
      try {
        getComboboxFach().addItem(fach);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });
  }

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
}

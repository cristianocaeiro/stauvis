package Windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

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

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  public PruefungenWindow() {

    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] { 0, 0 };
    gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
    getContentPane().setLayout(gridBagLayout);
    GridBagConstraints gbc_labelFach = new GridBagConstraints();
    gbc_labelFach.insets = new Insets(0, 0, 5, 0);
    gbc_labelFach.gridx = 0;
    gbc_labelFach.gridy = 0;
    getContentPane().add(getLabelFach(), gbc_labelFach);
    GridBagConstraints gbc_comboboxFach = new GridBagConstraints();
    gbc_comboboxFach.insets = new Insets(0, 0, 5, 0);
    gbc_comboboxFach.fill = GridBagConstraints.HORIZONTAL;
    gbc_comboboxFach.gridx = 0;
    gbc_comboboxFach.gridy = 1;
    getContentPane().add(getComboboxFach(), gbc_comboboxFach);
    GridBagConstraints gbc_labelBezeichnung = new GridBagConstraints();
    gbc_labelBezeichnung.insets = new Insets(0, 0, 5, 0);
    gbc_labelBezeichnung.gridx = 0;
    gbc_labelBezeichnung.gridy = 2;
    getContentPane().add(getLabelBezeichnung(), gbc_labelBezeichnung);
    GridBagConstraints gbc_textfieldBezeichnung = new GridBagConstraints();
    gbc_textfieldBezeichnung.insets = new Insets(0, 0, 5, 0);
    gbc_textfieldBezeichnung.fill = GridBagConstraints.HORIZONTAL;
    gbc_textfieldBezeichnung.gridx = 0;
    gbc_textfieldBezeichnung.gridy = 3;
    getContentPane().add(getTextfieldBezeichnung(), gbc_textfieldBezeichnung);
    GridBagConstraints gbc_labelDatum = new GridBagConstraints();
    gbc_labelDatum.insets = new Insets(0, 0, 5, 0);
    gbc_labelDatum.gridx = 0;
    gbc_labelDatum.gridy = 4;
    getContentPane().add(getLabelDatum(), gbc_labelDatum);
    GridBagConstraints gbc_datechooser = new GridBagConstraints();
    gbc_datechooser.insets = new Insets(0, 0, 5, 0);
    gbc_datechooser.fill = GridBagConstraints.BOTH;
    gbc_datechooser.gridx = 0;
    gbc_datechooser.gridy = 5;
    getContentPane().add(getDatechooser(), gbc_datechooser);
    GridBagConstraints gbc_labelNote = new GridBagConstraints();
    gbc_labelNote.insets = new Insets(0, 0, 5, 0);
    gbc_labelNote.gridx = 0;
    gbc_labelNote.gridy = 6;
    getContentPane().add(getLabelNote(), gbc_labelNote);
    GridBagConstraints gbc_textfieldNote = new GridBagConstraints();
    gbc_textfieldNote.insets = new Insets(0, 0, 5, 0);
    gbc_textfieldNote.fill = GridBagConstraints.HORIZONTAL;
    gbc_textfieldNote.gridx = 0;
    gbc_textfieldNote.gridy = 7;
    getContentPane().add(getTextfieldNote(), gbc_textfieldNote);
    GridBagConstraints gbc_panel = new GridBagConstraints();
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
    }
    return labelFach;
  }

  public JComboBox getComboboxFach() {
    if (comboboxFach == null) {
      comboboxFach = new JComboBox();
    }
    return comboboxFach;
  }

  public JLabel getLabelBezeichnung() {
    if (labelBezeichnung == null) {
      labelBezeichnung = new JLabel("Bezeichnung");
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
      panel.add(getButtonSpeichern());
      panel.add(getButtonAbbrechen());
    }
    return panel;
  }

  public JButton getButtonSpeichern() {
    if (buttonSpeichern == null) {
      buttonSpeichern = new JButton("Speichern");
    }
    return buttonSpeichern;
  }

  public JButton getButtonAbbrechen() {
    if (buttonAbbrechen == null) {
      buttonAbbrechen = new JButton("Abbrechen");
    }
    return buttonAbbrechen;
  }
}

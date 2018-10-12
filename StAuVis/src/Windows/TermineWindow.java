package Windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.lavantech.gui.comp.TimePanel;
import com.toedter.calendar.JDateChooser;

import Entities.Termine;

@SuppressWarnings("serial")
public class TermineWindow extends JFrame {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // JElements
  private JLabel labelWann;
  private JDateChooser datechooserWas;
  private JLabel labelWas;
  private JTextPane textpaneWas;
  private JLabel labelWo;
  private JTextField textfieldWo;
  private JPanel panelButtons;
  private JButton buttonSpeichern;
  private JButton buttonAbbrechen;
  private TimePanel timepanelWann;

  // Update
  boolean updateBool;
  int updateId;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren
  public TermineWindow() {
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] { 0, 0 };
    gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
    getContentPane().setLayout(gridBagLayout);
    GridBagConstraints gbc_labelWann = new GridBagConstraints();
    gbc_labelWann.insets = new Insets(0, 0, 5, 0);
    gbc_labelWann.gridx = 0;
    gbc_labelWann.gridy = 0;
    getContentPane().add(getLabelWann(), gbc_labelWann);
    GridBagConstraints gbc_datechooserWas = new GridBagConstraints();
    gbc_datechooserWas.insets = new Insets(0, 0, 5, 0);
    gbc_datechooserWas.fill = GridBagConstraints.BOTH;
    gbc_datechooserWas.gridx = 0;
    gbc_datechooserWas.gridy = 1;
    getContentPane().add(getDatechooserWas(), gbc_datechooserWas);
    GridBagConstraints gbc_timepanelWann = new GridBagConstraints();
    gbc_timepanelWann.insets = new Insets(0, 0, 5, 0);
    gbc_timepanelWann.fill = GridBagConstraints.BOTH;
    gbc_timepanelWann.gridx = 0;
    gbc_timepanelWann.gridy = 2;
    getContentPane().add(getTimepanelWann(), gbc_timepanelWann);
    GridBagConstraints gbc_labelWas = new GridBagConstraints();
    gbc_labelWas.insets = new Insets(0, 0, 5, 0);
    gbc_labelWas.gridx = 0;
    gbc_labelWas.gridy = 3;
    getContentPane().add(getLabelWas(), gbc_labelWas);
    GridBagConstraints gbc_textpaneWas = new GridBagConstraints();
    gbc_textpaneWas.insets = new Insets(0, 0, 5, 0);
    gbc_textpaneWas.fill = GridBagConstraints.BOTH;
    gbc_textpaneWas.gridx = 0;
    gbc_textpaneWas.gridy = 4;
    getContentPane().add(getTextpaneWas(), gbc_textpaneWas);
    GridBagConstraints gbc_labelWo = new GridBagConstraints();
    gbc_labelWo.insets = new Insets(0, 0, 5, 0);
    gbc_labelWo.gridx = 0;
    gbc_labelWo.gridy = 5;
    getContentPane().add(getLabelWo(), gbc_labelWo);
    GridBagConstraints gbc_textfieldWo = new GridBagConstraints();
    gbc_textfieldWo.insets = new Insets(0, 0, 5, 0);
    gbc_textfieldWo.fill = GridBagConstraints.HORIZONTAL;
    gbc_textfieldWo.gridx = 0;
    gbc_textfieldWo.gridy = 6;
    getContentPane().add(getTextfieldWo(), gbc_textfieldWo);
    GridBagConstraints gbc_panelButtons = new GridBagConstraints();
    gbc_panelButtons.fill = GridBagConstraints.BOTH;
    gbc_panelButtons.gridx = 0;
    gbc_panelButtons.gridy = 7;
    getContentPane().add(getPanelButtons(), gbc_panelButtons);
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTERS und SETTERS
  public JLabel getLabelWann() {
    if (labelWann == null) {
      labelWann = new JLabel("Wann ?");
    }
    return labelWann;
  }

  public JDateChooser getDatechooserWas() {
    if (datechooserWas == null) {
      datechooserWas = new JDateChooser();
    }
    return datechooserWas;
  }

  public JLabel getLabelWas() {
    if (labelWas == null) {
      labelWas = new JLabel("Was ?");
    }
    return labelWas;
  }

  public JTextPane getTextpaneWas() {
    if (textpaneWas == null) {
      textpaneWas = new JTextPane();
    }
    return textpaneWas;
  }

  public JLabel getLabelWo() {
    if (labelWo == null) {
      labelWo = new JLabel("Wo ?");
    }
    return labelWo;
  }

  public JTextField getTextfieldWo() {
    if (textfieldWo == null) {
      textfieldWo = new JTextField();
      textfieldWo.setColumns(10);
    }
    return textfieldWo;
  }

  public JPanel getPanelButtons() {
    if (panelButtons == null) {
      panelButtons = new JPanel();
      panelButtons.add(getButtonSpeichern());
      panelButtons.add(getButtonAbbrechen());
    }
    return panelButtons;
  }

  public JButton getButtonSpeichern() {
    if (buttonSpeichern == null) {
      buttonSpeichern = new JButton("Speichern");

      buttonSpeichern.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

          String uhrzeit = new String(timepanelWann.getCalendar().get(Calendar.HOUR_OF_DAY) + ":" + timepanelWann.getCalendar().get(Calendar.MINUTE));

          if (updateBool) {

            try {
              Termine.getDao().updateTermin(new Date(datechooserWas.getDate().getTime()), uhrzeit, textpaneWas.getText(), textfieldWo.getText(), updateId);
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
          } else {
            try {
              Termine.getDao().newTermin(new Date(datechooserWas.getDate().getTime()), uhrzeit, textpaneWas.getText(), textfieldWo.getText());
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
          }
          setVisible(false);
          dispose();
        }
      });
    }
    return buttonSpeichern;
  }

  public JButton getButtonAbbrechen() {
    if (buttonAbbrechen == null) {
      buttonAbbrechen = new JButton("Abbrechen");

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

  public TimePanel getTimepanelWann() {
    if (timepanelWann == null) {
      timepanelWann = new TimePanel();
    }
    return timepanelWann;
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
}

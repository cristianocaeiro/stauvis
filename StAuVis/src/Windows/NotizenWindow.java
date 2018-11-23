package Windows;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import Entities.Notizen;
import Util.UtilColors;

@SuppressWarnings("serial")
public class NotizenWindow extends JFrame {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // JElements
  private JLabel labelDatum;
  private JTextPane textpane;
  private JPanel panel;
  private JButton buttonSpeichern;
  private JButton buttonAbbrechen;

  // Update
  boolean updateBool;
  int updateId;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren
  public NotizenWindow() {
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] { 0, 0 };
    gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
    gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
    getContentPane().setLayout(gridBagLayout);
    GridBagConstraints gbc_labelDatum = new GridBagConstraints();
    gbc_labelDatum.insets = new Insets(0, 0, 5, 0);
    gbc_labelDatum.gridx = 0;
    gbc_labelDatum.gridy = 0;
    getContentPane().add(getLabelDatum(), gbc_labelDatum);
    GridBagConstraints gbc_textpane = new GridBagConstraints();
    gbc_textpane.insets = new Insets(0, 0, 5, 0);
    gbc_textpane.fill = GridBagConstraints.BOTH;
    gbc_textpane.gridx = 0;
    gbc_textpane.gridy = 1;
    getContentPane().add(getTextpane(), gbc_textpane);
    GridBagConstraints gbc_panel = new GridBagConstraints();
    gbc_panel.fill = GridBagConstraints.BOTH;
    gbc_panel.gridx = 0;
    gbc_panel.gridy = 2;
    getContentPane().add(getPanel(), gbc_panel);
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTERS und SETTERS
  public JLabel getLabelDatum() {
    if (labelDatum == null) {
      labelDatum = new JLabel("Notiz");
      labelDatum.setForeground(Color.WHITE);
    }
    return labelDatum;
  }

  public JTextPane getTextpane() {
    if (textpane == null) {
      textpane = new JTextPane();
      textpane.setContentType("text");
    }
    return textpane;
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

      // Speichern Aktion
      buttonSpeichern.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

          // Wenn Update
          if (updateBool) {
            try {
              Notizen.getDao().updateNotiz(textpane.getText(), updateId);
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
          }
          // Wenn neu
          else {
            try {
              Notizen.getDao().newNotiz(textpane.getText());
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

package Windows;

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
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Entities.Todos;

@SuppressWarnings("serial")
public class TodosWindow extends JFrame {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  //JElements
  private JLabel labelWas;
  private JTextPane textpaneWas;
  private JLabel labelBiswann;
  private JTextField textfieldBiswann;
  private JPanel panelButtons;
  private JButton buttonSpeichern;
  private JButton buttonAbbrechen;

  // Update
  boolean updateBool;
  int updateId;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  public TodosWindow() {
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] { 0, 0 };
    gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
    gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
    getContentPane().setLayout(gridBagLayout);
    GridBagConstraints gbc_labelWas = new GridBagConstraints();
    gbc_labelWas.insets = new Insets(0, 0, 5, 0);
    gbc_labelWas.gridx = 0;
    gbc_labelWas.gridy = 0;
    getContentPane().add(getLabelWas(), gbc_labelWas);
    GridBagConstraints gbc_textpaneWas = new GridBagConstraints();
    gbc_textpaneWas.insets = new Insets(0, 0, 5, 0);
    gbc_textpaneWas.fill = GridBagConstraints.BOTH;
    gbc_textpaneWas.gridx = 0;
    gbc_textpaneWas.gridy = 1;
    getContentPane().add(getTextpaneWas(), gbc_textpaneWas);
    GridBagConstraints gbc_labelBiswann = new GridBagConstraints();
    gbc_labelBiswann.insets = new Insets(0, 0, 5, 0);
    gbc_labelBiswann.gridx = 0;
    gbc_labelBiswann.gridy = 2;
    getContentPane().add(getLabelBiswann(), gbc_labelBiswann);
    GridBagConstraints gbc_textfieldBiswann = new GridBagConstraints();
    gbc_textfieldBiswann.insets = new Insets(0, 0, 5, 0);
    gbc_textfieldBiswann.fill = GridBagConstraints.HORIZONTAL;
    gbc_textfieldBiswann.gridx = 0;
    gbc_textfieldBiswann.gridy = 3;
    getContentPane().add(getTextfieldBiswann(), gbc_textfieldBiswann);
    GridBagConstraints gbc_panelButtons = new GridBagConstraints();
    gbc_panelButtons.fill = GridBagConstraints.BOTH;
    gbc_panelButtons.gridx = 0;
    gbc_panelButtons.gridy = 4;
    getContentPane().add(getPanelButtons(), gbc_panelButtons);
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

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

  public JLabel getLabelBiswann() {
    if (labelBiswann == null) {
      labelBiswann = new JLabel("Bis wann ?");
    }
    return labelBiswann;
  }

  public JTextField getTextfieldBiswann() {
    if (textfieldBiswann == null) {
      textfieldBiswann = new JTextField();
      textfieldBiswann.setColumns(10);
    }
    return textfieldBiswann;
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

          if (updateBool) {
            try {
              Todos.getDao().updateTodo(textpaneWas.getText(), textfieldBiswann.getText(), updateId);
              setVisible(false);
              dispose();
            } catch (SQLException e1) {
              e1.printStackTrace();
            }
          } else {
            try {
              Todos.getDao().newTodo(textpaneWas.getText(), textfieldBiswann.getText());
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
      buttonAbbrechen.addActionListener(new ActionListener() {

        // Fenster schlieﬂen wenn auf abbrechen geklickt wird
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

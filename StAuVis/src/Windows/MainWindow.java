package Windows;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.toedter.calendar.JDateChooser;

import Entities.Hausaufgaben;
import Entities.Notizen;
import Entities.Pruefungen;
import Entities.Termine;
import Entities.Todos;
import Entities.Zeiterfassung;
import Util.BooleanTableCellRenderer;
import Util.DateTableCellRenderer;
import Util.HausaufgabenAbstractTableModel;
import Util.NotizenAbstractTableModel;
import Util.PruefungenAbstractTableModel;
import Util.TermineAbstractTableModel;
import Util.TimestampTableCellRenderer;
import Util.TodosAbstractTableModel;
import Util.ZeiterfassungAbstractTableModel;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // JElements
  private JLabel labelZeiterfassungTitel;
  private JLabel labelZeiterfassungDatum;
  private JLabel labelZeiterfassungStundenzahl;
  private JLabel labelZeiterfassungPause;
  private JDateChooser datechooserZeiterfassungDatum;
  private JTextField textfieldZeiterfassungStundenzahl;
  private JTextField textfieldZeiterfassungPause;
  private JButton buttonZeiterfassungSpeichern;
  private JLabel labelTermineTitel;
  private JScrollPane scrollpaneTermine;
  private JTable tableTermine;
  private TermineAbstractTableModel tablemodelTermine;
  private JButton buttonTerminePlus;
  private JButton buttonTermineMinus;
  private JTabbedPane tabbedpane;
  private JScrollPane scrollpaneNotizen;
  private JTable tableNotizen;
  private NotizenAbstractTableModel tablemodelNotizen;
  private JButton buttonRefresh;
  private JPanel panelButtons;
  private JButton buttonBearbeiten;
  private JButton buttonLoeschen;
  private JButton buttonNeu;
  private JPanel panelSuchen;
  private JLabel labelSuchen;
  private JTextField textfieldSuchen;
  private JLabel labelTodos;
  private JPanel panelTodos;
  private JScrollPane scrollpaneTodos;
  private JTable tableTodos;
  private TodosAbstractTableModel tablemodelTodos;
  private JButton buttonTodosErledigt;
  private JButton buttonTodosNeu;
  private JLabel labelCredits;
  private JLabel labelTitel;
  private JLabel labelUhrzeit;
  private JLabel labelDatum;
  private JScrollPane scrollpaneZeiterfassung;
  private JTable tableZeiterfassung;
  private ZeiterfassungAbstractTableModel tablemodelZeiterfassung;
  private JLabel labelZeiterfassungKommentar;
  private JTextField textfieldZeiterfassungKommentar;
  private JScrollPane scrollpaneHausaufgaben;
  private JTable tableHausaufgaben;
  private HausaufgabenAbstractTableModel tablemodelHausaufgaben;
  private JScrollPane scrollpanePruefungen;
  private JTable tablePruefungen;
  private PruefungenAbstractTableModel tablemodelPruefungen;

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // Konstruktoren
  public MainWindow() throws SQLException {

    // Window Einstellungen
    addWindowListeners();
    changeLookAndFeelDesign();

    // Positionierung der Elemente im Haupt-Gridlayout
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
    getContentPane().setLayout(gridBagLayout);
    GridBagConstraints gbc_labelZeiterfassungTitel = new GridBagConstraints();
    gbc_labelZeiterfassungTitel.gridwidth = 3;
    gbc_labelZeiterfassungTitel.insets = new Insets(0, 0, 5, 5);
    gbc_labelZeiterfassungTitel.gridx = 0;
    gbc_labelZeiterfassungTitel.gridy = 0;
    getContentPane().add(getLabelZeiterfassungTitel(), gbc_labelZeiterfassungTitel);
    GridBagConstraints gbc_labelTermineTitel = new GridBagConstraints();
    gbc_labelTermineTitel.gridwidth = 5;
    gbc_labelTermineTitel.insets = new Insets(0, 0, 5, 5);
    gbc_labelTermineTitel.gridx = 3;
    gbc_labelTermineTitel.gridy = 0;
    getContentPane().add(getLabelTermineTitel(), gbc_labelTermineTitel);
    GridBagConstraints gbc_labelZeiterfassungDatum = new GridBagConstraints();
    gbc_labelZeiterfassungDatum.anchor = GridBagConstraints.WEST;
    gbc_labelZeiterfassungDatum.insets = new Insets(0, 0, 5, 5);
    gbc_labelZeiterfassungDatum.gridx = 0;
    gbc_labelZeiterfassungDatum.gridy = 1;
    getContentPane().add(getLabelZeiterfassungDatum(), gbc_labelZeiterfassungDatum);
    GridBagConstraints gbc_datechooserZeiterfassungDatum = new GridBagConstraints();
    gbc_datechooserZeiterfassungDatum.insets = new Insets(0, 0, 5, 5);
    gbc_datechooserZeiterfassungDatum.fill = GridBagConstraints.BOTH;
    gbc_datechooserZeiterfassungDatum.gridx = 1;
    gbc_datechooserZeiterfassungDatum.gridy = 1;
    getContentPane().add(getDatechooserZeiterfassungDatum(), gbc_datechooserZeiterfassungDatum);
    GridBagConstraints gbc_scrollpaneTermine = new GridBagConstraints();
    gbc_scrollpaneTermine.gridwidth = 6;
    gbc_scrollpaneTermine.gridheight = 4;
    gbc_scrollpaneTermine.insets = new Insets(0, 0, 5, 5);
    gbc_scrollpaneTermine.fill = GridBagConstraints.BOTH;
    gbc_scrollpaneTermine.gridx = 3;
    gbc_scrollpaneTermine.gridy = 1;
    getContentPane().add(getScrollpaneTermine(), gbc_scrollpaneTermine);
    GridBagConstraints gbc_buttonTerminePlus = new GridBagConstraints();
    gbc_buttonTerminePlus.insets = new Insets(0, 0, 5, 5);
    gbc_buttonTerminePlus.gridx = 9;
    gbc_buttonTerminePlus.gridy = 1;
    getContentPane().add(getButtonTerminePlus(), gbc_buttonTerminePlus);
    GridBagConstraints gbc_labelUhrzeit = new GridBagConstraints();
    gbc_labelUhrzeit.gridwidth = 3;
    gbc_labelUhrzeit.insets = new Insets(0, 0, 5, 5);
    gbc_labelUhrzeit.gridx = 10;
    gbc_labelUhrzeit.gridy = 1;
    getContentPane().add(getLabelUhrzeit(), gbc_labelUhrzeit);
    GridBagConstraints gbc_labelZeiterfassungStundenzahl = new GridBagConstraints();
    gbc_labelZeiterfassungStundenzahl.anchor = GridBagConstraints.WEST;
    gbc_labelZeiterfassungStundenzahl.insets = new Insets(0, 0, 5, 5);
    gbc_labelZeiterfassungStundenzahl.gridx = 0;
    gbc_labelZeiterfassungStundenzahl.gridy = 2;
    getContentPane().add(getLabelZeiterfassungStundenzahl(), gbc_labelZeiterfassungStundenzahl);
    GridBagConstraints gbc_textfieldZeiterfassungStundenzahl = new GridBagConstraints();
    gbc_textfieldZeiterfassungStundenzahl.insets = new Insets(0, 0, 5, 5);
    gbc_textfieldZeiterfassungStundenzahl.fill = GridBagConstraints.HORIZONTAL;
    gbc_textfieldZeiterfassungStundenzahl.gridx = 1;
    gbc_textfieldZeiterfassungStundenzahl.gridy = 2;
    getContentPane().add(getTextfieldZeiterfassungStundenzahl(), gbc_textfieldZeiterfassungStundenzahl);
    GridBagConstraints gbc_buttonZeiterfassungSpeichern = new GridBagConstraints();
    gbc_buttonZeiterfassungSpeichern.gridheight = 2;
    gbc_buttonZeiterfassungSpeichern.insets = new Insets(0, 0, 5, 5);
    gbc_buttonZeiterfassungSpeichern.gridx = 2;
    gbc_buttonZeiterfassungSpeichern.gridy = 2;
    getContentPane().add(getButtonZeiterfassungSpeichern(), gbc_buttonZeiterfassungSpeichern);
    GridBagConstraints gbc_labelDatum = new GridBagConstraints();
    gbc_labelDatum.gridwidth = 3;
    gbc_labelDatum.insets = new Insets(0, 0, 5, 5);
    gbc_labelDatum.gridx = 10;
    gbc_labelDatum.gridy = 2;
    getContentPane().add(getLabelDatum(), gbc_labelDatum);
    GridBagConstraints gbc_labelZeiterfassungPause = new GridBagConstraints();
    gbc_labelZeiterfassungPause.anchor = GridBagConstraints.WEST;
    gbc_labelZeiterfassungPause.insets = new Insets(0, 0, 5, 5);
    gbc_labelZeiterfassungPause.gridx = 0;
    gbc_labelZeiterfassungPause.gridy = 3;
    getContentPane().add(getLabelZeiterfassungPause(), gbc_labelZeiterfassungPause);
    GridBagConstraints gbc_textfieldZeiterfassungPause = new GridBagConstraints();
    gbc_textfieldZeiterfassungPause.insets = new Insets(0, 0, 5, 5);
    gbc_textfieldZeiterfassungPause.fill = GridBagConstraints.HORIZONTAL;
    gbc_textfieldZeiterfassungPause.gridx = 1;
    gbc_textfieldZeiterfassungPause.gridy = 3;
    getContentPane().add(getTextfieldZeiterfassungPause(), gbc_textfieldZeiterfassungPause);
    GridBagConstraints gbc_labelTitel = new GridBagConstraints();
    gbc_labelTitel.gridwidth = 3;
    gbc_labelTitel.insets = new Insets(0, 0, 5, 0);
    gbc_labelTitel.gridx = 10;
    gbc_labelTitel.gridy = 3;
    getContentPane().add(getLabelTitel(), gbc_labelTitel);
    GridBagConstraints gbc_labelZeiterfassungKommentar = new GridBagConstraints();
    gbc_labelZeiterfassungKommentar.anchor = GridBagConstraints.NORTHWEST;
    gbc_labelZeiterfassungKommentar.insets = new Insets(0, 0, 5, 5);
    gbc_labelZeiterfassungKommentar.gridx = 0;
    gbc_labelZeiterfassungKommentar.gridy = 4;
    getContentPane().add(getLabelZeiterfassungKommentar(), gbc_labelZeiterfassungKommentar);
    GridBagConstraints gbc_textfieldZeiterfassungKommentar = new GridBagConstraints();
    gbc_textfieldZeiterfassungKommentar.anchor = GridBagConstraints.NORTH;
    gbc_textfieldZeiterfassungKommentar.insets = new Insets(0, 0, 5, 5);
    gbc_textfieldZeiterfassungKommentar.fill = GridBagConstraints.HORIZONTAL;
    gbc_textfieldZeiterfassungKommentar.gridx = 1;
    gbc_textfieldZeiterfassungKommentar.gridy = 4;
    getContentPane().add(getTextfieldZeiterfassungKommentar(), gbc_textfieldZeiterfassungKommentar);
    GridBagConstraints gbc_buttonTermineMinus = new GridBagConstraints();
    gbc_buttonTermineMinus.anchor = GridBagConstraints.NORTH;
    gbc_buttonTermineMinus.insets = new Insets(0, 0, 5, 5);
    gbc_buttonTermineMinus.gridx = 9;
    gbc_buttonTermineMinus.gridy = 4;
    getContentPane().add(getButtonTermineMinus(), gbc_buttonTermineMinus);
    GridBagConstraints gbc_labelTodos = new GridBagConstraints();
    gbc_labelTodos.insets = new Insets(0, 0, 5, 5);
    gbc_labelTodos.gridx = 10;
    gbc_labelTodos.gridy = 5;
    getContentPane().add(getLabelTodos(), gbc_labelTodos);
    GridBagConstraints gbc_tabbedpane = new GridBagConstraints();
    gbc_tabbedpane.gridwidth = 4;
    gbc_tabbedpane.insets = new Insets(0, 0, 5, 5);
    gbc_tabbedpane.fill = GridBagConstraints.BOTH;
    gbc_tabbedpane.gridx = 0;
    gbc_tabbedpane.gridy = 6;
    getContentPane().add(getTabbedpane(), gbc_tabbedpane);
    GridBagConstraints gbc_buttonRefresh = new GridBagConstraints();
    gbc_buttonRefresh.insets = new Insets(0, 0, 5, 5);
    gbc_buttonRefresh.gridx = 4;
    gbc_buttonRefresh.gridy = 6;
    getContentPane().add(getButton_2(), gbc_buttonRefresh);
    GridBagConstraints gbc_panelTodos = new GridBagConstraints();
    gbc_panelTodos.gridwidth = 6;
    gbc_panelTodos.insets = new Insets(0, 0, 5, 5);
    gbc_panelTodos.fill = GridBagConstraints.BOTH;
    gbc_panelTodos.gridx = 5;
    gbc_panelTodos.gridy = 6;
    getContentPane().add(getPanelTodos(), gbc_panelTodos);
    GridBagConstraints gbc_panelButtons = new GridBagConstraints();
    gbc_panelButtons.anchor = GridBagConstraints.WEST;
    gbc_panelButtons.gridwidth = 3;
    gbc_panelButtons.insets = new Insets(0, 0, 0, 5);
    gbc_panelButtons.fill = GridBagConstraints.VERTICAL;
    gbc_panelButtons.gridx = 0;
    gbc_panelButtons.gridy = 7;
    getContentPane().add(getPanelButtons(), gbc_panelButtons);
    GridBagConstraints gbc_panelSuchen = new GridBagConstraints();
    gbc_panelSuchen.insets = new Insets(0, 0, 0, 5);
    gbc_panelSuchen.fill = GridBagConstraints.BOTH;
    gbc_panelSuchen.gridx = 3;
    gbc_panelSuchen.gridy = 7;
    getContentPane().add(getPanelSuchen(), gbc_panelSuchen);
    GridBagConstraints gbc_labelCredits = new GridBagConstraints();
    gbc_labelCredits.insets = new Insets(0, 0, 0, 5);
    gbc_labelCredits.gridx = 10;
    gbc_labelCredits.gridy = 7;
    getContentPane().add(getLabelCredits(), gbc_labelCredits);
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // GETTER und SETTER der JElements
  public JLabel getLabelZeiterfassungTitel() {
    if (labelZeiterfassungTitel == null) {
      labelZeiterfassungTitel = new JLabel("Zeiterfassung");
    }
    return labelZeiterfassungTitel;
  }

  public JLabel getLabelZeiterfassungDatum() {
    if (labelZeiterfassungDatum == null) {
      labelZeiterfassungDatum = new JLabel("Datum");
    }
    return labelZeiterfassungDatum;
  }

  public JLabel getLabelZeiterfassungStundenzahl() {
    if (labelZeiterfassungStundenzahl == null) {
      labelZeiterfassungStundenzahl = new JLabel("Stundenanzahl");
    }
    return labelZeiterfassungStundenzahl;
  }

  public JLabel getLabelZeiterfassungPause() {
    if (labelZeiterfassungPause == null) {
      labelZeiterfassungPause = new JLabel("Pause");
    }
    return labelZeiterfassungPause;
  }

  public JDateChooser getDatechooserZeiterfassungDatum() {
    if (datechooserZeiterfassungDatum == null) {
      datechooserZeiterfassungDatum = new JDateChooser();
    }
    return datechooserZeiterfassungDatum;
  }

  public JTextField getTextfieldZeiterfassungStundenzahl() {
    if (textfieldZeiterfassungStundenzahl == null) {
      textfieldZeiterfassungStundenzahl = new JTextField();
      textfieldZeiterfassungStundenzahl.setColumns(10);
    }
    return textfieldZeiterfassungStundenzahl;
  }

  public JTextField getTextfieldZeiterfassungPause() {
    if (textfieldZeiterfassungPause == null) {
      textfieldZeiterfassungPause = new JTextField();
      textfieldZeiterfassungPause.setColumns(10);
    }
    return textfieldZeiterfassungPause;
  }

  public JButton getButtonZeiterfassungSpeichern() {
    if (buttonZeiterfassungSpeichern == null) {
      buttonZeiterfassungSpeichern = new JButton("Speichern");

      setupButtonZeiterfassungSpeichern();
    }
    return buttonZeiterfassungSpeichern;
  }

  public JLabel getLabelTermineTitel() {
    if (labelTermineTitel == null) {
      labelTermineTitel = new JLabel("Termine");
    }
    return labelTermineTitel;
  }

  public JScrollPane getScrollpaneTermine() throws SQLException {
    if (scrollpaneTermine == null) {
      scrollpaneTermine = new JScrollPane();
      scrollpaneTermine.setViewportView(getTableTermine());
    }
    return scrollpaneTermine;
  }

  public JTable getTableTermine() throws SQLException {
    if (tableTermine == null) {
      tableTermine = new JTable();

      setupTableTermine();
    }
    return tableTermine;
  }

  public JButton getButtonTerminePlus() {
    if (buttonTerminePlus == null) {
      buttonTerminePlus = new JButton("+");

      setupButtonTerminePlus();
    }
    return buttonTerminePlus;
  }

  public JButton getButtonTermineMinus() {
    if (buttonTermineMinus == null) {
      buttonTermineMinus = new JButton("-");

      setupButtonTermineMinus();
    }
    return buttonTermineMinus;
  }

  public JTabbedPane getTabbedpane() throws SQLException {
    if (tabbedpane == null) {
      tabbedpane = new JTabbedPane(JTabbedPane.TOP);
      tabbedpane.addTab("Hausaufgaben", null, getScrollpaneHausaufgaben(), null);
      tabbedpane.addTab("Zeiterfassung", null, getScrollpaneZeiterfassung(), null);
      tabbedpane.addTab("Notizen", null, getScrollpaneNotizen(), null);
      tabbedpane.addTab("Prüfungen", null, getScrollpanePruefungen(), null);

      tabbedpane.addChangeListener(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
          if (tabbedpane.getSelectedIndex() == 0) {

            getButton_5().setEnabled(true);
            getButton_3().setEnabled(true);
          }
          if (tabbedpane.getSelectedIndex() == 1) {

            getButton_5().setEnabled(false);
            getButton_3().setEnabled(false);
          }
          if (tabbedpane.getSelectedIndex() == 2) {

            getButton_5().setEnabled(true);
            getButton_3().setEnabled(true);
          }
          if (tabbedpane.getSelectedIndex() == 3) {

            getButton_5().setEnabled(true);
            getButton_3().setEnabled(true);
          }
        }
      });
    }
    return tabbedpane;
  }

  public JScrollPane getScrollpaneNotizen() throws SQLException {
    if (scrollpaneNotizen == null) {
      scrollpaneNotizen = new JScrollPane();
      scrollpaneNotizen.setViewportView(getTableNotizen());
    }
    return scrollpaneNotizen;
  }

  public JTable getTableNotizen() throws SQLException {
    if (tableNotizen == null) {
      tableNotizen = new JTable() {
        // Bearbeitung der Zellen deaktivieren
        @Override
        public boolean isCellEditable(int row, int column) {
          return false;
        }
      };
      setupTableNotizen();
    }
    return tableNotizen;
  }

  public NotizenAbstractTableModel getTablemodelNotizen() {
    return tablemodelNotizen;
  }

  public void setTablemodelNotizen(NotizenAbstractTableModel tablemodelNotizen) throws SQLException {
    this.tablemodelNotizen = tablemodelNotizen;
  }

  public JButton getButton_2() {
    if (buttonRefresh == null) {
      buttonRefresh = new JButton("Refresh");
      setupButtonRefresh();
    }
    return buttonRefresh;
  }

  public JPanel getPanelButtons() {
    if (panelButtons == null) {
      panelButtons = new JPanel();
      panelButtons.add(getButton_5());
      panelButtons.add(getButton_3());
      panelButtons.add(getButton_4());
    }
    return panelButtons;
  }

  public JButton getButton_3() {
    if (buttonBearbeiten == null) {
      buttonBearbeiten = new JButton("Bearbeiten");
      setupButtonBearbeiten();
    }
    return buttonBearbeiten;
  }

  public JButton getButton_4() {
    if (buttonLoeschen == null) {
      buttonLoeschen = new JButton("L\u00F6schen");
      setupButtonLoeschen();
    }
    return buttonLoeschen;
  }

  public JButton getButton_5() {
    if (buttonNeu == null) {
      buttonNeu = new JButton("Neu");
      setupButtonNeu();
    }
    return buttonNeu;
  }

  public JPanel getPanelSuchen() {
    if (panelSuchen == null) {
      panelSuchen = new JPanel();
      panelSuchen.add(getLabelSuchen());
      panelSuchen.add(getTextField_2());
    }
    return panelSuchen;
  }

  public JLabel getLabelSuchen() {
    if (labelSuchen == null) {
      labelSuchen = new JLabel("Suchen:");
    }
    return labelSuchen;
  }

  public JTextField getTextField_2() {
    if (textfieldSuchen == null) {
      textfieldSuchen = new JTextField();
      textfieldSuchen.setColumns(10);
    }
    return textfieldSuchen;
  }

  public JLabel getLabelTodos() {
    if (labelTodos == null) {
      labelTodos = new JLabel("To-Do's");
    }
    return labelTodos;
  }

  public JPanel getPanelTodos() throws SQLException {
    if (panelTodos == null) {
      panelTodos = new JPanel();
      GridBagLayout gbl_panelTodos = new GridBagLayout();
      gbl_panelTodos.columnWidths = new int[] { 0, 0 };
      gbl_panelTodos.rowHeights = new int[] { 0, 0, 0, 0 };
      gbl_panelTodos.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
      gbl_panelTodos.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
      panelTodos.setLayout(gbl_panelTodos);
      GridBagConstraints gbc_scrollpaneTodos = new GridBagConstraints();
      gbc_scrollpaneTodos.insets = new Insets(0, 0, 5, 0);
      gbc_scrollpaneTodos.fill = GridBagConstraints.BOTH;
      gbc_scrollpaneTodos.gridx = 0;
      gbc_scrollpaneTodos.gridy = 0;
      panelTodos.add(getScrollpaneTodos(), gbc_scrollpaneTodos);
      GridBagConstraints gbc_buttonTodosErledigt = new GridBagConstraints();
      gbc_buttonTodosErledigt.fill = GridBagConstraints.HORIZONTAL;
      gbc_buttonTodosErledigt.insets = new Insets(0, 0, 5, 0);
      gbc_buttonTodosErledigt.gridx = 0;
      gbc_buttonTodosErledigt.gridy = 1;
      panelTodos.add(getButtonTodosErledigt(), gbc_buttonTodosErledigt);
      GridBagConstraints gbc_buttonTodosNeu = new GridBagConstraints();
      gbc_buttonTodosNeu.fill = GridBagConstraints.HORIZONTAL;
      gbc_buttonTodosNeu.gridx = 0;
      gbc_buttonTodosNeu.gridy = 2;
      panelTodos.add(getButtonTodosNeu(), gbc_buttonTodosNeu);
    }
    return panelTodos;
  }

  public JScrollPane getScrollpaneTodos() throws SQLException {
    if (scrollpaneTodos == null) {
      scrollpaneTodos = new JScrollPane();
      scrollpaneTodos.setViewportView(getTableTodos());
    }
    return scrollpaneTodos;
  }

  public JTable getTableTodos() throws SQLException {
    if (tableTodos == null) {
      tableTodos = new JTable() {

        // Bearbeitung der Zellen deaktivieren
        @Override
        public boolean isCellEditable(int row, int column) {
          return false;
        }
      };
      setupTableTodos();
    }
    return tableTodos;
  }

  public JButton getButtonTodosErledigt() {
    if (buttonTodosErledigt == null) {
      buttonTodosErledigt = new JButton("Erledigt");

      setupButtonTodosErledigt();
    }
    return buttonTodosErledigt;
  }

  public JButton getButtonTodosNeu() {
    if (buttonTodosNeu == null) {
      buttonTodosNeu = new JButton("Neu");

      setupButtonTodosNeu();
    }
    return buttonTodosNeu;
  }

  public JLabel getLabelCredits() {
    if (labelCredits == null) {
      labelCredits = new JLabel("@CristianoCaeiro - Dream-Team");
    }
    return labelCredits;
  }

  public JLabel getLabelTitel() {
    if (labelTitel == null) {
      labelTitel = new JLabel("StAuVis");
    }
    return labelTitel;
  }

  public JLabel getLabelUhrzeit() {
    if (labelUhrzeit == null) {
      labelUhrzeit = new JLabel("Uhrzeit");
    }
    return labelUhrzeit;
  }

  public JLabel getLabelDatum() {
    if (labelDatum == null) {
      labelDatum = new JLabel("Datum");
    }
    return labelDatum;
  }

  public TodosAbstractTableModel getTablemodelTodos() {
    return tablemodelTodos;
  }

  public void setTablemodelTodos(TodosAbstractTableModel tablemodelTodos) {
    this.tablemodelTodos = tablemodelTodos;
  }

  public JScrollPane getScrollpaneZeiterfassung() throws SQLException {
    if (scrollpaneZeiterfassung == null) {
      scrollpaneZeiterfassung = new JScrollPane();
      scrollpaneZeiterfassung.setViewportView(getTableZeiterfassung());
    }
    return scrollpaneZeiterfassung;
  }

  public JTable getTableZeiterfassung() throws SQLException {
    if (tableZeiterfassung == null) {
      tableZeiterfassung = new JTable();

      setupTableZeiterfassung();
    }
    return tableZeiterfassung;
  }

  public JLabel getLabelZeiterfassungKommentar() {
    if (labelZeiterfassungKommentar == null) {
      labelZeiterfassungKommentar = new JLabel("Kommentar");
    }
    return labelZeiterfassungKommentar;
  }

  public JTextField getTextfieldZeiterfassungKommentar() {
    if (textfieldZeiterfassungKommentar == null) {
      textfieldZeiterfassungKommentar = new JTextField();
      textfieldZeiterfassungKommentar.setColumns(10);
    }
    return textfieldZeiterfassungKommentar;
  }

  public TermineAbstractTableModel getTablemodelTermine() {
    return tablemodelTermine;
  }

  public void setTablemodelTermine(TermineAbstractTableModel tablemodelTermine) {
    this.tablemodelTermine = tablemodelTermine;
  }

  public JScrollPane getScrollpaneHausaufgaben() throws SQLException {
    if (scrollpaneHausaufgaben == null) {
      scrollpaneHausaufgaben = new JScrollPane();
      scrollpaneHausaufgaben.setViewportView(getTableHausaufgaben());
    }
    return scrollpaneHausaufgaben;
  }

  public JTable getTableHausaufgaben() throws SQLException {
    if (tableHausaufgaben == null) {
      tableHausaufgaben = new JTable();

      setupTableHausaufgaben();
    }
    return tableHausaufgaben;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // TABLES
  /**
   * Lädt die Daten und die Strukturen der Tabellen neu.
   * @throws SQLException
   */
  private void refreshTables() throws SQLException {

    tablemodelNotizen.getNotizenModelData();
    tablemodelNotizen.fireTableDataChanged();

    tablemodelTodos.getTodosModelData();
    tablemodelTodos.fireTableDataChanged();

    tablemodelZeiterfassung.getZeiterfassungModelData();
    tablemodelZeiterfassung.fireTableDataChanged();

    tablemodelTermine.getTermineModelData();
    tablemodelTermine.fireTableDataChanged();

    tablemodelHausaufgaben.getHausaufgabenModelData();
    tablemodelHausaufgaben.fireTableDataChanged();

    tablemodelPruefungen.getPruefungenModelData();
    tablemodelPruefungen.fireTableDataChanged();

    tablemodelTermine.getTermineModelData();
    tablemodelTermine.fireTableDataChanged();
  }

  /**
   * Setup für die Notizen Tabelle.
   * @throws SQLException
   */
  private void setupTableNotizen() throws SQLException {
    // Tabelle zum Start mit Daten füllen
    tablemodelNotizen = new NotizenAbstractTableModel();
    tableNotizen.setModel(tablemodelNotizen);

    // Beschränkung auf eine Markierung
    tableNotizen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // Sortierung aktivieren
    tableNotizen.setAutoCreateRowSorter(true);

    // Datum formatieren
    TimestampTableCellRenderer timestampTableCellRenderer = new TimestampTableCellRenderer();
    tableNotizen.getColumnModel().getColumn(1).setCellRenderer(timestampTableCellRenderer);
    // Datum Spalte Breite anpassen
    tableNotizen.getColumnModel().getColumn(1).setMaxWidth(120);
    tableNotizen.getColumnModel().getColumn(1).setMinWidth(120);

    // Doppelklick Aktion in der Tabelle; öffnen des Eintrags
    tableNotizen.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          Notizen notiz = tablemodelNotizen.getAlleDaten().get(tableNotizen.convertRowIndexToModel(tableNotizen.getSelectedRow()));
          NotizenWindow notizenWindow = new NotizenWindow();
          notizenWindow.getTextpane().setText(notiz.getInhalt());
          notizenWindow.setUpdateBool(true);
          notizenWindow.setUpdateId(notiz.getId());
          notizenWindow.setBounds(getScreenCenter().width / 2 - 310, getScreenCenter().height / 2 - 225, 620, 450);
          notizenWindow.setVisible(true);
        }
      }
    });
  }

  /**
   * Setup für die Todos Table
   * @throws SQLException
   */
  private void setupTableTodos() throws SQLException {
    // Tabelle mit Daten füllen
    tablemodelTodos = new TodosAbstractTableModel();
    tableTodos.setModel(tablemodelTodos);

    // Beschränkung auf eine Markierung
    tableTodos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // Sortierung aktivieren
    tableTodos.setAutoCreateRowSorter(true);

    // Datum Spalte formattieren
    TimestampTableCellRenderer ttr = new TimestampTableCellRenderer();
    tableTodos.getColumnModel().getColumn(2).setCellRenderer(ttr);

    // Spaltenbreite anpassen
    tableTodos.getColumnModel().getColumn(1).setMaxWidth(90);
    tableTodos.getColumnModel().getColumn(1).setMinWidth(90);
    tableTodos.getColumnModel().getColumn(2).setMaxWidth(110);
    tableTodos.getColumnModel().getColumn(2).setMinWidth(110);

    // Öffnen der Todos beim Doppelklick
    tableTodos.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          Todos todo = tablemodelTodos.getAlleDaten().get(tableTodos.convertRowIndexToModel(tableTodos.getSelectedRow()));
          TodosWindow todosWindow = new TodosWindow();
          todosWindow.getTextpaneWas().setText(todo.getWas());
          todosWindow.getTextfieldBiswann().setText(todo.getBiswann());
          todosWindow.setUpdateBool(true);
          todosWindow.setUpdateId(todo.getId());
          todosWindow.setBounds(getScreenCenter().width / 2 - 175, getScreenCenter().height / 2 - 225, 350, 450);
          todosWindow.setVisible(true);
        }
      }
    });
  }

  /**
   * Setup für die Zeiterfassung Table
   * @throws SQLException
   */
  private void setupTableZeiterfassung() throws SQLException {

    // Tabelle mit Daten füllen
    tablemodelZeiterfassung = new ZeiterfassungAbstractTableModel();
    tableZeiterfassung.setModel(tablemodelZeiterfassung);

    // Beschränkung auf eine Markierung
    tableZeiterfassung.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // Sortierung aktivieren
    tableZeiterfassung.setAutoCreateRowSorter(true);

    // Date Spalte formattieren
    DateTableCellRenderer dcr = new DateTableCellRenderer();
    tableZeiterfassung.getColumnModel().getColumn(0).setCellRenderer(dcr);

    // Spaltenbreite anpassen
    tableZeiterfassung.getColumnModel().getColumn(0).setMaxWidth(80);
    tableZeiterfassung.getColumnModel().getColumn(0).setMinWidth(80);
    tableZeiterfassung.getColumnModel().getColumn(1).setMaxWidth(70);
    tableZeiterfassung.getColumnModel().getColumn(1).setMinWidth(70);
    tableZeiterfassung.getColumnModel().getColumn(2).setMaxWidth(70);
    tableZeiterfassung.getColumnModel().getColumn(2).setMinWidth(70);
  }

  /**
   * Setup für die Termine Tabelle.
   * @throws SQLException
   */
  private void setupTableTermine() throws SQLException {
    tablemodelTermine = new TermineAbstractTableModel();
    tableTermine.setModel(tablemodelTermine);

    // Beschränkung auf eine Markierung
    tableTermine.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // Sortierung aktivieren
    tableTermine.setAutoCreateRowSorter(true);

    // Date Spalte formattieren
    DateTableCellRenderer dcr = new DateTableCellRenderer();
    tableTermine.getColumnModel().getColumn(0).setCellRenderer(dcr);

    // Spaltenbreite anpassen
    tableTermine.getColumnModel().getColumn(0).setMaxWidth(75);
    tableTermine.getColumnModel().getColumn(0).setMinWidth(75);
    tableTermine.getColumnModel().getColumn(1).setMaxWidth(60);
    tableTermine.getColumnModel().getColumn(1).setMinWidth(60);
    tableTermine.getColumnModel().getColumn(3).setMaxWidth(70);
    tableTermine.getColumnModel().getColumn(3).setMinWidth(70);

    tableTermine.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          Termine termin = tablemodelTermine.getAlleDaten().get(tableTermine.convertRowIndexToModel(tableTermine.getSelectedRow()));
          TermineWindow termineWindow = new TermineWindow();
          termineWindow.getDatechooserWas().setDate(termin.getWann());
          termineWindow.getTextpaneWas().setText(termin.getWas());
          termineWindow.getTextfieldWo().setText(termin.getWo());
          termineWindow.setUpdateBool(true);
          termineWindow.setUpdateId(termin.getId());
          termineWindow.setBounds(getScreenCenter().width / 2 - 200, getScreenCenter().height / 2 - 175, 400, 350);
          termineWindow.setVisible(true);
        }
      }
    });
  }

  /**
   * Setup für die Hausaufgaben Tabelle
   * @throws SQLException
   */
  private void setupTableHausaufgaben() throws SQLException {
    tablemodelHausaufgaben = new HausaufgabenAbstractTableModel();
    tableHausaufgaben.setModel(tablemodelHausaufgaben);

    // Beschränkung auf eine Markierung
    tableHausaufgaben.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // Sortierung aktivieren
    tableHausaufgaben.setAutoCreateRowSorter(true);

    // Date Spalte formattieren
    DateTableCellRenderer dcr = new DateTableCellRenderer();
    tableHausaufgaben.getColumnModel().getColumn(2).setCellRenderer(dcr);
    BooleanTableCellRenderer bcr = new BooleanTableCellRenderer();
    tableHausaufgaben.getColumnModel().getColumn(3).setCellRenderer(bcr);

    // Spaltenbreite anpassen
    tableHausaufgaben.getColumnModel().getColumn(0).setMaxWidth(100);
    tableHausaufgaben.getColumnModel().getColumn(0).setMinWidth(100);
    tableHausaufgaben.getColumnModel().getColumn(2).setMaxWidth(80);
    tableHausaufgaben.getColumnModel().getColumn(2).setMinWidth(80);
    tableHausaufgaben.getColumnModel().getColumn(3).setMaxWidth(75);
    tableHausaufgaben.getColumnModel().getColumn(3).setMinWidth(75);

    // Doppelklick auf Zeile der Tabelle Aktion zum Updaten
    tableHausaufgaben.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          Hausaufgaben hausaufgabe = tablemodelHausaufgaben.getAlleDaten().get(tableHausaufgaben.convertRowIndexToModel(tableHausaufgaben.getSelectedRow()));
          HausaufgabenWindow hausaufgabeWindow;
          try {
            hausaufgabeWindow = new HausaufgabenWindow();
            hausaufgabeWindow.getComboboxFach().getModel().setSelectedItem(hausaufgabe.getFach());
            hausaufgabeWindow.getTextpaneInhalt().setText(hausaufgabe.getInhalt());
            hausaufgabeWindow.getDateChooser().setDate(hausaufgabe.getBiswann());
            String erledigt = new String();
            if (hausaufgabe.isErledigt()) {
              erledigt = "Ja";
            } else {
              erledigt = "Nein";
            }
            hausaufgabeWindow.getComboboxErledigt().setSelectedItem(erledigt);
            hausaufgabeWindow.setUpdateBool(true);
            hausaufgabeWindow.setUpdateId(hausaufgabe.getId());
            hausaufgabeWindow.setBounds(getScreenCenter().width / 2 - 200, getScreenCenter().height / 2 - 175, 400, 350);
            hausaufgabeWindow.setVisible(true);
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
      }
    });
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // WINDOW
  /**
   * Fügt WindowListener hinzu.
   */
  private void addWindowListeners() {
    // Window Listener
    addWindowListener(new WindowAdapter() {

      // Aktion sobald das Fenster in den Fokus kommt.
      @Override
      public void windowActivated(WindowEvent e) {
        try {
          refreshTables();
        } catch (SQLException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
  }

  /**
   * Ändert das Look and Feel des Designs.
   */
  private void changeLookAndFeelDesign() {
    // Einstellen des Look and Feels
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
  }

  /**
   * Ermittelt die Mitte des Screens.
   * @return die Mitte als Dimension.
   */
  protected static Dimension getScreenCenter() {

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    return d;
  }

  /*##############################################################################################################################################################*/
  /*##############################################################################################################################################################*/

  // BUTTONS
  /**
   * Set up des Refresh Buttons.
   */
  private void setupButtonRefresh() {
    buttonRefresh.addActionListener(new ActionListener() {

      // Das neu laden der Table beim klicken auf dem Refresh Button
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          refreshTables();
        } catch (SQLException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
  }

  /**
   * Set up des Bearbeiten Buttons.
   */
  private void setupButtonBearbeiten() {
    buttonBearbeiten.addActionListener(new ActionListener() {

      // Bearbeiten bzw. öffnen des Tabelleneintrags nach dem klicken des Bearbeiten Buttons
      @Override
      public void actionPerformed(ActionEvent e) {

        if (tabbedpane.getSelectedIndex() == 2) {
          Notizen notiz = tablemodelNotizen.getAlleDaten().get(tableNotizen.convertRowIndexToModel(tableNotizen.getSelectedRow()));
          NotizenWindow notizenWindow = new NotizenWindow();
          notizenWindow.getTextpane().setText(notiz.getInhalt());
          notizenWindow.setUpdateBool(true);
          notizenWindow.setUpdateId(notiz.getId());
          notizenWindow.setBounds(getScreenCenter().width / 2 - 310, getScreenCenter().height / 2 - 225, 620, 450);
          notizenWindow.setVisible(true);
        }
        if (tabbedpane.getSelectedIndex() == 0) {
          Hausaufgaben hausaufgabe = tablemodelHausaufgaben.getAlleDaten().get(tableHausaufgaben.convertRowIndexToModel(tableHausaufgaben.getSelectedRow()));
          HausaufgabenWindow hausaufgabeWindow;
          try {
            hausaufgabeWindow = new HausaufgabenWindow();
            hausaufgabeWindow.getComboboxFach().getModel().setSelectedItem(hausaufgabe.getFach());
            hausaufgabeWindow.getTextpaneInhalt().setText(hausaufgabe.getInhalt());
            hausaufgabeWindow.getDateChooser().setDate(hausaufgabe.getBiswann());
            String erledigt = new String();
            if (hausaufgabe.isErledigt()) {
              erledigt = "Ja";
            } else {
              erledigt = "Nein";
            }
            hausaufgabeWindow.getComboboxErledigt().setSelectedItem(erledigt);
            hausaufgabeWindow.setUpdateBool(true);
            hausaufgabeWindow.setUpdateId(hausaufgabe.getId());
            hausaufgabeWindow.setBounds(getScreenCenter().width / 2 - 200, getScreenCenter().height / 2 - 175, 400, 350);
            hausaufgabeWindow.setVisible(true);
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
        if (tabbedpane.getSelectedIndex() == 3) {

          Pruefungen pruefung = tablemodelPruefungen.getAlleDaten().get(tablePruefungen.convertRowIndexToModel(tablePruefungen.getSelectedRow()));
          PruefungenWindow pruefungWindow = new PruefungenWindow();
          try {
            pruefungWindow.getComboboxFach().getModel().setSelectedItem(pruefung.getFach());
          } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
          pruefungWindow.getTextfieldBezeichnung().setText((pruefung.getBezeichnung()));
          pruefungWindow.getDatechooser().setDate(pruefung.getDatum());
          pruefungWindow.getTextfieldNote().setText("" + pruefung.getNote());
          pruefungWindow.setUpdateBool(true);
          pruefungWindow.setUpdateId(pruefung.getId());
          pruefungWindow.setBounds(getScreenCenter().width / 2 - 310, getScreenCenter().height / 2 - 225, 620, 450);
          pruefungWindow.setVisible(true);
        }
      }

      // TO DO
    });
  }

  /**
   * Set up des Löschen Buttons.
   */
  private void setupButtonLoeschen() {
    buttonLoeschen.addActionListener(new ActionListener() {

      // Löschen des Tabelleneintrags beim klicken des Löschen Buttons
      @Override
      public void actionPerformed(ActionEvent e) {

        // Notizen
        if (tabbedpane.getSelectedIndex() == 2) {
          try {
            Notizen.getDao().deleteNotiz((tablemodelNotizen.getAlleDaten().get(tableNotizen.convertRowIndexToModel(tableNotizen.getSelectedRow())).getId()));
            refreshTables();
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
        // Zeiterfassung
        if (tabbedpane.getSelectedIndex() == 1) {
          try {
            Zeiterfassung.getDao().deleteZeiterfassung((tablemodelZeiterfassung.getAlleDaten().get(tableZeiterfassung.convertRowIndexToModel(tableZeiterfassung.getSelectedRow())).getId()));
            refreshTables();
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
        if (tabbedpane.getSelectedIndex() == 0) {
          try {
            Hausaufgaben.getDao().deleteHausaufgabe((tablemodelHausaufgaben.getAlleDaten().get(tableHausaufgaben.convertRowIndexToModel(tableHausaufgaben.getSelectedRow())).getId()));
            refreshTables();
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
        if (tabbedpane.getSelectedIndex() == 3) {
          try {
            Pruefungen.getDao().deletePruefung((tablemodelPruefungen.getAlleDaten().get(tablePruefungen.convertRowIndexToModel(tablePruefungen.getSelectedRow())).getId()));
            refreshTables();
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
      }
    });
  }

  /**
   * Set up des Neu Buttons.
   */
  private void setupButtonNeu() {
    buttonNeu.addActionListener(new ActionListener() {

      // Neues Notizen Window beim klicken des Neu Buttons
      @Override
      public void actionPerformed(ActionEvent e) {

        if (tabbedpane.getSelectedIndex() == 3) {
          PruefungenWindow pruefungenWindow = new PruefungenWindow();
          pruefungenWindow.setUpdateBool(false);
          pruefungenWindow.setBounds(getScreenCenter().width / 2 - 148, getScreenCenter().height / 2 - 140, 296, 280);
          pruefungenWindow.setVisible(true);
        }
        if (tabbedpane.getSelectedIndex() == 2) {
          NotizenWindow notizenWindow = new NotizenWindow();
          notizenWindow.setUpdateBool(false);
          notizenWindow.setBounds(getScreenCenter().width / 2 - 310, getScreenCenter().height / 2 - 225, 620, 450);
          notizenWindow.setVisible(true);
        }
        if (tabbedpane.getSelectedIndex() == 0) {
          try {
            HausaufgabenWindow hausaufgabenWindow = new HausaufgabenWindow();
            hausaufgabenWindow.setUpdateBool(false);
            hausaufgabenWindow.setBounds(getScreenCenter().width / 2 - 200, getScreenCenter().height / 2 - 200, 400, 400);
            hausaufgabenWindow.setVisible(true);
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        }
      }
    });
  }

  /**
   * Setup des Neues Todo Buttons.
   */
  private void setupButtonTodosNeu() {
    buttonTodosNeu.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        TodosWindow todosWindow = new TodosWindow();
        todosWindow.setUpdateBool(false);
        todosWindow.setBounds(getScreenCenter().width / 2 - 175, getScreenCenter().height / 2 - 225, 350, 450);
        todosWindow.setVisible(true);
      }
    });
  }

  /**
   * Setup des Erledigt Todo Buttons.
   */
  private void setupButtonTodosErledigt() {
    buttonTodosErledigt.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          Todos.getDao().deleteTodo((tablemodelTodos.getAlleDaten().get(tableTodos.convertRowIndexToModel(tableTodos.getSelectedRow()))).getId());
          refreshTables();
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
    });
  }

  /**
   * Setup des Speichern Zeiterfassungs Button.
   */
  private void setupButtonZeiterfassungSpeichern() {
    buttonZeiterfassungSpeichern.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        try {
          Zeiterfassung.getDao().newZeiterfassung(new Date(datechooserZeiterfassungDatum.getDate().getTime()), Double.parseDouble(textfieldZeiterfassungStundenzahl.getText()), Double.parseDouble(textfieldZeiterfassungPause.getText()),
              textfieldZeiterfassungKommentar.getText());
        } catch (NumberFormatException e1) {
          e1.printStackTrace();
        } catch (SQLException e1) {
          e1.printStackTrace();
        }

        textfieldZeiterfassungStundenzahl.setText(null);
        textfieldZeiterfassungPause.setText(null);
        textfieldZeiterfassungKommentar.setText(null);

        try {
          refreshTables();
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
    });
  }

  /**
   * Setup des Plus Termine Button.
   */
  private void setupButtonTerminePlus() {
    buttonTerminePlus.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        TermineWindow termineWindow = new TermineWindow();
        termineWindow.setBounds(getScreenCenter().width / 2 - 200, getScreenCenter().height / 2 - 175, 400, 350);
        termineWindow.setVisible(true);
      }
    });
  }

  /**
   * Setup des Minus Termine Button.
   */
  private void setupButtonTermineMinus() {
    buttonTermineMinus.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        try {
          Termine.getDao().deleteTermin(tablemodelTermine.getAlleDaten().get(tableTermine.convertRowIndexToModel(tableTermine.getSelectedRow())).getId());
          refreshTables();
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
    });
  }

  public JScrollPane getScrollpanePruefungen() throws SQLException {
    if (scrollpanePruefungen == null) {
      scrollpanePruefungen = new JScrollPane();
      scrollpanePruefungen.setViewportView(getTablePruefungen());
    }
    return scrollpanePruefungen;
  }

  public JTable getTablePruefungen() throws SQLException {
    if (tablePruefungen == null) {
      tablePruefungen = new JTable() {

        // Bearbeitung der Zellen deaktivieren
        @Override
        public boolean isCellEditable(int row, int column) {
          return false;
        }
      };
      setupTablePruefungen();
    }
    return tablePruefungen;
  }

  private void setupTablePruefungen() throws SQLException {

    // Tabelle zum Start mit Daten füllen
    tablemodelPruefungen = new PruefungenAbstractTableModel();
    tablePruefungen.setModel(tablemodelPruefungen);

    // Beschränkung auf eine Markierung
    tablePruefungen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // Sortierung aktivieren
    tablePruefungen.setAutoCreateRowSorter(true);

    // Datum formatieren
    DateTableCellRenderer dateTableCellRenderer = new DateTableCellRenderer();
    tablePruefungen.getColumnModel().getColumn(2).setCellRenderer(dateTableCellRenderer);
    // Spaltenbreite anpassen
    tablePruefungen.getColumnModel().getColumn(0).setMaxWidth(100);
    tablePruefungen.getColumnModel().getColumn(0).setMinWidth(100);
    tablePruefungen.getColumnModel().getColumn(2).setMaxWidth(80);
    tablePruefungen.getColumnModel().getColumn(2).setMinWidth(80);
    tablePruefungen.getColumnModel().getColumn(3).setMaxWidth(40);
    tablePruefungen.getColumnModel().getColumn(3).setMinWidth(40);

    // Doppelklick Aktion in der Tabelle; öffnen des Eintrags
    tablePruefungen.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          Pruefungen pruefung = tablemodelPruefungen.getAlleDaten().get(tablePruefungen.convertRowIndexToModel(tablePruefungen.getSelectedRow()));
          PruefungenWindow pruefungWindow = new PruefungenWindow();
          try {
            pruefungWindow.getComboboxFach().getModel().setSelectedItem(pruefung.getFach());
          } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
          pruefungWindow.getTextfieldBezeichnung().setText((pruefung.getBezeichnung()));
          pruefungWindow.getDatechooser().setDate(pruefung.getDatum());
          pruefungWindow.getTextfieldNote().setText("" + pruefung.getNote());
          pruefungWindow.setUpdateBool(true);
          pruefungWindow.setUpdateId(pruefung.getId());
          pruefungWindow.setBounds(getScreenCenter().width / 2 - 310, getScreenCenter().height / 2 - 225, 620, 450);
          pruefungWindow.setVisible(true);
        }
      }
    });
  }
}

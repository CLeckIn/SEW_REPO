package Einfaches_Spiel.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GewinnPanel extends JPanel {

    private JLabel lblRundenergebnis;
    private JLabel lblGesamtpunkte;
    private JTextField tfSpielerZahl;
    private JTextField tfComputerZahl;
    private JButton btnNochEinmal;

    public GewinnPanel() {
        setLayout(new BorderLayout(10, 10));

        // Oben

        JPanel pnlOben = new JPanel(new GridLayout(2, 2, 5, 5));
        pnlOben.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel lblHeaderRunde = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        lblHeaderRunde.setFont(new Font("SansSerif", Font.PLAIN, 11));

        JLabel lblHeaderGesamt = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);
        lblHeaderGesamt.setFont(new Font("SansSerif", Font.PLAIN, 11));

        // Labels mit weißem Hintergrund
        lblRundenergebnis = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        lblRundenergebnis.setOpaque(true);
        lblRundenergebnis.setBackground(Color.WHITE);
        lblRundenergebnis.setFont(new Font("SansSerif", Font.BOLD, 12));

        lblGesamtpunkte = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
        lblGesamtpunkte.setOpaque(true);
        lblGesamtpunkte.setBackground(Color.WHITE);
        lblGesamtpunkte.setFont(new Font("SansSerif", Font.BOLD, 12));

        pnlOben.add(lblHeaderRunde);
        pnlOben.add(lblHeaderGesamt);
        pnlOben.add(lblRundenergebnis);
        pnlOben.add(lblGesamtpunkte);

        add(pnlOben, BorderLayout.NORTH);

        // Mitte

        JPanel pnlMitte = new JPanel(new GridLayout(2, 2, 10, 5));
        pnlMitte.setBorder(new EmptyBorder(5, 15, 5, 15));

        JLabel lblEingabePrompt = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        lblEingabePrompt.setFont(new Font("SansSerif", Font.PLAIN, 11));

        JLabel lblComputerPrompt = new JLabel("Computer:", SwingConstants.CENTER);
        lblComputerPrompt.setFont(new Font("SansSerif", Font.PLAIN, 11));

        tfSpielerZahl = new JTextField();
        tfSpielerZahl.setFont(new Font("SansSerif", Font.BOLD, 22));

        tfComputerZahl = new JTextField();
        tfComputerZahl.setHorizontalAlignment(JTextField.CENTER);
        tfComputerZahl.setFont(new Font("SansSerif", Font.BOLD, 22));
        tfComputerZahl.setEditable(false);
        tfComputerZahl.setBackground(Color.WHITE);

        pnlMitte.add(lblEingabePrompt);
        pnlMitte.add(lblComputerPrompt);
        pnlMitte.add(tfSpielerZahl);
        pnlMitte.add(tfComputerZahl);

        add(pnlMitte, BorderLayout.CENTER);

        // Unten

        JPanel pnlUnten = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnNochEinmal = new JButton("Noch einmal!");
        pnlUnten.add(btnNochEinmal);

        add(pnlUnten, BorderLayout.SOUTH);
        btnNochEinmal.setEnabled(false);
    }

    // Getter-Methoden für die Elemente
    public JLabel getLblRundenergebnis() { return lblRundenergebnis; }
    public JLabel getLblGesamtpunkte() { return lblGesamtpunkte; }
    public JTextField getTfSpielerZahl() { return tfSpielerZahl; }
    public JTextField getTfComputerZahl() { return tfComputerZahl; }
    public JButton getBtnNochEinmal() { return btnNochEinmal; }

    public void sperreEingabe(boolean gesperrt) {
        tfSpielerZahl.setEditable(!gesperrt);
        btnNochEinmal.setEnabled(gesperrt);
    }

    // Das Panel kümmert sich selbst darum, WIE es die Daten anzeigt:
    public void zeigeErgebnis(String ergebnisText, int gesamtpunkte, String computerZahl) {
        lblRundenergebnis.setText(ergebnisText);
        lblGesamtpunkte.setText("Gesamtpunkte: " + gesamtpunkte);
        tfComputerZahl.setText(computerZahl);
    }

    public void faerbeErgebnis(Color farbe) {
        lblRundenergebnis.setBackground(farbe);
        lblGesamtpunkte.setBackground(farbe);
    }
}
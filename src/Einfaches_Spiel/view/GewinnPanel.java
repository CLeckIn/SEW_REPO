package Einfaches_Spiel.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GewinnPanel extends JFrame {

    private JLabel lblRundenergebnis;
    private JLabel lblGesamtpunkte;

    // Textfelder für die Zahlen
    private JTextField tfSpielerZahl;
    private JTextField tfComputerZahl;

    // Button unten
    private JButton btnNochEinmal;

    public GewinnPanel() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Sachen oben

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


        JLabel lblComputerPrompt = new JLabel("Computer:", SwingConstants.CENTER);


        tfSpielerZahl = new JTextField();
        tfSpielerZahl.setHorizontalAlignment(JTextField.CENTER);
        tfSpielerZahl.setFont(new Font("SansSerif", Font.BOLD, 22));

        tfComputerZahl = new JTextField();
        tfComputerZahl.setHorizontalAlignment(JTextField.CENTER);
        tfComputerZahl.setFont(new Font("SansSerif", Font.BOLD, 22));
        tfComputerZahl.setEditable(false); // Nicht editierbar[cite: 2]
        tfComputerZahl.setBackground(Color.WHITE);

        pnlMitte.add(lblEingabePrompt);
        pnlMitte.add(lblComputerPrompt);
        pnlMitte.add(tfSpielerZahl);
        pnlMitte.add(tfComputerZahl);

        add(pnlMitte, BorderLayout.CENTER);

        // Unten
        JPanel pnlUnten = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnNochEinmal = new JButton("Noch einmal!");
        pnlUnten.add(btnNochEinmal);

        add(pnlUnten, BorderLayout.SOUTH);
    }

    // Getter-Methoden für den Controller
    public JLabel getLblRundenergebnis() { return lblRundenergebnis; }
    public JLabel getLblGesamtpunkte() { return lblGesamtpunkte; }
    public JTextField getTfSpielerZahl() { return tfSpielerZahl; }
    public JTextField getTfComputerZahl() { return tfComputerZahl; }
    public JButton getBtnNochEinmal() { return btnNochEinmal; }
}
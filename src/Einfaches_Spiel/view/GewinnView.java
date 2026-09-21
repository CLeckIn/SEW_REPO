package Einfaches_Spiel.view;

import javax.swing.JFrame;

public class GewinnView extends JFrame {

    private GewinnPanel mainPanel;

    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
        setLocationRelativeTo(null);

        // Panel erzeugen
        mainPanel = new GewinnPanel();
        add(mainPanel);
    }

    public GewinnPanel getMainPanel() {
        return mainPanel;
    }
}
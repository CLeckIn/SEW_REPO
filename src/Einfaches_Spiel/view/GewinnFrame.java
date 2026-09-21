package Einfaches_Spiel.view;

import javax.swing.JFrame;

public class GewinnFrame extends JFrame {

    private GewinnPanel mainPanel;

    public GewinnFrame() {
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
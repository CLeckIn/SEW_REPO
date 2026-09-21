package Einfaches_Spiel.view;

import Einfaches_Spiel.controller.GewinnController;
import Einfaches_Spiel.model.GewinnModel;

import javax.swing.JFrame;

public class GewinnFrame extends JFrame {

    private GewinnPanel mainPanel;

    public GewinnFrame() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
        setLocationRelativeTo(null);

        // 1. Panel erstellen und hinzufügen
        mainPanel = new GewinnPanel();
        add(mainPanel);

        // 2. Model und Controller verknüpfen
        GewinnModel model = new GewinnModel();
        new GewinnController(model, this);

        // 3. Fenster anzeigen
        setVisible(true);
    }

    public GewinnPanel getMainPanel() {
        return mainPanel;
    }
}
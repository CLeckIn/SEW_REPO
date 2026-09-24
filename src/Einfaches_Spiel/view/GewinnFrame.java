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

        // Panel erstellen und hinzufügen
        mainPanel = new GewinnPanel();
        add(mainPanel);

        // Model und Controller verknüpfen
        GewinnModel model = new GewinnModel();
        new GewinnController(model, this);
        setVisible(true);
    }

    public GewinnPanel getMainPanel() {
        return mainPanel;
    }
    public static void main(String[] args) {
        // Startet das Fenster
        new GewinnFrame();
    }
}
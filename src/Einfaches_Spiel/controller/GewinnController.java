package Einfaches_Spiel.controller;

import Einfaches_Spiel.model.GewinnModel;
import Einfaches_Spiel.view.GewinnFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {
    private GewinnModel model;
    private GewinnFrame view;

    public GewinnController(GewinnModel model, GewinnFrame view) {
        this.model = model;
        this.view = view;


        this.view.getMainPanel().getTfSpielerZahl().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        this.view.getMainPanel().getBtnNochEinmal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rundeZuruecksetzen();
            }
        });
    }

    private void start() {
        String eingabeText = view.getMainPanel().getTfSpielerZahl().getText();

        if (eingabeText.length() == 1 && eingabeText.charAt(0) >= '1' && eingabeText.charAt(0) <= '9') {
            int spielerZahl = Integer.parseInt(eingabeText);

            model.berechneComputerZahl();
            model.berechneRunde(spielerZahl);

            view.getMainPanel().zeigeErgebnis(
                    "" + model.getRundenErgebnis(),
                    model.getGesamtPunkte(),
                    "" + model.getComputerZahl()
            );
        }
    }

    private void rundeZuruecksetzen() {
        // Löscht alles außer gesamtpnkte
        view.getMainPanel().getTfSpielerZahl().setText("");
        view.getMainPanel().zeigeErgebnis("", model.getGesamtPunkte(), "");
    }
}
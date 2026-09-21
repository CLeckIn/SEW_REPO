package Einfaches_Spiel.model;

import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte = 30;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 30;
    }

    public int getGesamtPunkte() {
        return this.gesamtPunkte;
    }

    public int getComputerZahl() {
        return this.computerZahl;
    }

    public int getRundenErgebnis() {
        return this.rundenErgebnis;
    }

    public void berechneComputerZahl() {
        Random rand = new Random();
        this.computerZahl = rand.nextInt(9) + 1;
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;

        // 1. Rundenergebnis ermitteln
        if (spielerZahl == this.computerZahl) {
            this.rundenErgebnis = 20;
        } else if (spielerZahl == this.computerZahl + 1 || spielerZahl == this.computerZahl - 1) {
            this.rundenErgebnis = 5;
        } else {
            this.rundenErgebnis = -10;
        }

        // 2. Gesamtpunkte aktualisieren
        this.gesamtPunkte += this.rundenErgebnis;
    }

    public boolean hatGewonnen() {
        return this.gesamtPunkte >= 100;
    }

    public boolean hatVerloren() {
        return this.gesamtPunkte <= 0;
    }
}
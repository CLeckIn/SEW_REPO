package Laps;

import Exceptions.NoLapException;

public class Trainingslauf {
    private String runner;
    private double sekunden;
    private int distanz;

    public Trainingslauf(String runner, int distanz) {
        this.runner = runner;
        this.distanz = distanz;
        this.sekunden = 0.0;
    }

    public void setRunner(String runner) {
        this.runner = runner;
    }

    public String getRunner() {
        return runner;
    }

    public void setSekunden(double sekunden) {
        this.sekunden = sekunden;
    }

    public double getSekunden() {
        return sekunden;
    }

    public void setDistanz(int distanz) {
        this.distanz = distanz;
    }

    public int getDistanz() {
        return distanz;
    }

    public String formartierteZeit() {
        int minuten = (int) sekunden / 60;
        double sekundenRest = sekunden - (minuten * 60);
        return String.format("%d:%04.1f", minuten, sekundenRest);
    }

    public void zeitHinzufuegen(double sekunden) throws NoLapException {
        this.sekunden += sekunden;
    }

    public String laufDaten() {
        return runner + " - " + distanz + " m in " + formartierteZeit() + " (" + sekunden + "s)";
    }
}

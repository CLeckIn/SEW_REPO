package Laps;

public class Rundenzeit {
    private int rundenNr;
    private double sekunden;

    public Rundenzeit(int rundenNr, double sekunden) {
        this.rundenNr = rundenNr;
        this.sekunden = sekunden;
    }

    public int getRundenNr() {
        return rundenNr;
    }

    public double getSekunden() {
        return sekunden;
    }

    @Override
    public String toString() {
        return "Runde " + rundenNr + ": " + sekunden + " s";
    }
}

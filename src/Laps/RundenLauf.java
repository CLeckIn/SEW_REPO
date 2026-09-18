package Laps;

import Exceptions.NoLapException;

public class RundenLauf extends Trainingslauf implements Rundenzaehler {
    private int runde;
    private Rundenzeit[]  zeiten;

    public RundenLauf(String runner, int distanz, int max) {
        super(runner, distanz);
        this.runde = runde;
        this.zeiten = new Rundenzeit[max];
    }

    @Override
    public int aktuelleRunde() {
        return runde;
    }

    @Override
    public void zeitHinzufuegen(double sekunden) throws NoLapException {
        if (runde >= this.zeiten.length) {
            throw new NoLapException("Achtung: Die Rundennummer ist größer als das Array");
        }

        this.runde++;

        Rundenzeit rundenzeit = new Rundenzeit(this.runde, sekunden);

        this.zeiten[this.runde - 1] = rundenzeit;

        super.zeitHinzufuegen(sekunden);
    }

    public int besteRunde() {
        if(runde <= 0) {
            return -1;
        }
        Rundenzeit beste = this.zeiten[0];


        for(int i = 1; i < this.runde; i++) {
            if(zeiten[i] != null) {
                if(zeiten[i].getSekunden() < beste.getSekunden()) {
                    beste = zeiten[i];
                }
            }

        }
        return beste.getRundenNr();
    }

    @Override
    public String laufDaten() {
        String ergebnis = super.laufDaten();

        for(int i = 0; i < this.zeiten.length; i++) {
            if(this.zeiten[i] != null) {
            ergebnis +=  " - " + this.zeiten[i].toString();
            }
        }
        return ergebnis += " - beste Runde: " +besteRunde();
    }

    public boolean equals(RundenLauf rundenlauf) {
        if(rundenlauf == null) {
            return false;
        }

        return this.aktuelleRunde() == rundenlauf.aktuelleRunde()
                && this.getDistanz() == rundenlauf.getDistanz()
                && this.getSekunden() == rundenlauf.getSekunden()
                && this.getRunner().equals(rundenlauf.getRunner());
    }

    @Override
    public int hashCode() {
        int hash = this.aktuelleRunde() + this.getDistanz() + (int) this.getSekunden();

        hash += this.getRunner().hashCode();

        return hash;
    }

    @Override
    public String toString() {
        return this.laufDaten();
    }
}

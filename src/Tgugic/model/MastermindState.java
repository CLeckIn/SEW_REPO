package Tgugic.model;

public class MastermindState {
    public int correctnumber; // Richtige Zahl, falsche Position
    public int correctplace;  // Richtige Zahl, richtige Position
    public boolean won;       // Gewonnen-Status
    public int round;         // Aktuelle Runde

    public MastermindState(int correctnumber, int correctplace, boolean won, int round) {
        this.correctnumber = correctnumber;
        this.correctplace = correctplace;
        this.won = won;
        this.round = round;
    }
}
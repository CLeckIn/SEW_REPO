package Tgugic.model;

import java.util.Random;

public class MastermindLogic {
    private int[] solution = new int[5];
    private int round;

    public MastermindLogic() {
        this.round = 0;
    }

    public void newGame() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            solution[i] = rand.nextInt(10); // Zufallszahl 0-9
        }
        this.round = 1;
    }

    public int getRoundCount() {
        return round;
    }

    public MastermindState calculateState(int[] numbers) throws NoGameException {
        if (round == 0) throw new NoGameException("Du musst erst ein Spiel starten!");

        int correctplace = 0;
        int correctnumber = 0;

        // Kopien für die Berechnung, damit das Original nicht verändert wird
        int[] solCopy = solution.clone();
        int[] numCopy = numbers.clone();

        // 1. Perfekte Treffer zählen
        for (int i = 0; i < 5; i++) {
            if (numCopy[i] == solCopy[i]) {
                correctplace++;
                solCopy[i] = -1; // Als "verbraucht" markieren
                numCopy[i] = -2;
            }
        }

        // 2. Falsche Positionen zählen
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numCopy[i] == solCopy[j]) {
                    correctnumber++;
                    solCopy[j] = -1; // Als "verbraucht" markieren
                    numCopy[i] = -2;
                    break;
                }
            }
        }

        boolean won = (correctplace == 5);
        if (!won) round++;

        return new MastermindState(correctnumber, correctplace, won, round);
    }

    public int[] getSolution() throws NoGameException {
        if (round == 0) throw new NoGameException("Es läuft gerade kein Spiel!");
        round = 0; // Spiel beenden
        return solution;
    }
}
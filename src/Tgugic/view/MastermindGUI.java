package Tgugic.view;

import Tgugic.model.MastermindState;

public interface MastermindGUI {
    void startGame();
    void setState(MastermindState state);
    void showSolution(int[] numbers);
    int[] getNumbers();
    void showError(String message);
}
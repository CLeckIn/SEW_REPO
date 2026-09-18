package Laps;

import Exceptions.NoLapException;

public class TestLauf {
    public static void main(String[] args) {

        RundenLauf lauf = new RundenLauf("Susanna", 2000, 4);
        try {
        lauf.zeitHinzufuegen(113.9);
        lauf.zeitHinzufuegen(113.3);
        lauf.zeitHinzufuegen(115.7);
        lauf.zeitHinzufuegen(116.8);
        System.out.println(lauf.toString()); // ToString testen
        } catch (NoLapException e) {
            System.out.println("Zeithinzufuegen: " + e.getMessage());
        }
        try {
        lauf.zeitHinzufuegen(118.3);
        } catch (NoLapException e) {
            System.out.println("Zeithinzufuegen: " + e.getMessage());
        }

        RundenLauf lauf1 = new RundenLauf("Susanna", 2000, 4);
        RundenLauf lauf2 = new RundenLauf("Susanna", 2000, 4);

        System.out.println("lauf1.equals(lauf2) = " + lauf1.equals(lauf2));
    }
}

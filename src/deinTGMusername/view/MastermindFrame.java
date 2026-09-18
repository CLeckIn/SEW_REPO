package deinTGMusername.view;

import javax.swing.*;
import java.awt.*;

public class MastermindFrame extends JFrame {
    public MastermindFrame() {
        setTitle("Mastermind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new MastermindLayout());

        // Verhindert, dass das Layout bei zu kleiner Fenstergröße zerfällt (was heißt, das es eben nicht zerstört wird)
        this.setMinimumSize(new Dimension(500, 350));
        setSize(500, 350);

        setVisible(true);
    }
}
package GUI;

import javax.swing.*;

public class NameFrame extends JFrame {
    public NameFrame() {
        super("Name Beispiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new NamePanel());
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NameFrame::new);
    }
}

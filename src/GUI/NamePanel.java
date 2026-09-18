package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NamePanel extends JPanel {
    private final JLabel nameLabel;
    private final JButton vornameButton;
    private final JButton nachnameButton;
    private final JButton clearButton;

    private static final String VORNAME = "Toni";
    private static final String NACHNAME = "Test";

    public NamePanel() {
        setLayout(new GridLayout(4, 1, 8, 8));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 12, 12));
        setPreferredSize(new Dimension(300, 220));

        nameLabel = new JLabel("Name");
        vornameButton = new JButton("Vorname");
        nachnameButton = new JButton("Nachname");
        clearButton = new JButton("Clear");

        JButtonHandler handler = new JButtonHandler();
        vornameButton.addActionListener(handler);
        nachnameButton.addActionListener(handler);
        clearButton.addActionListener(handler);

        add(nameLabel);
        add(vornameButton);
        add(nachnameButton);
        add(clearButton);
    }

    private class JButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == vornameButton) {
                nameLabel.setText(VORNAME);
            } else if (source == nachnameButton) {
                nameLabel.setText(NACHNAME);
            } else if (source == clearButton) {
                nameLabel.setText("Name");
            }
        }
    }
}

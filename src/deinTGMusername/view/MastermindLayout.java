package deinTGMusername.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MastermindLayout extends JPanel {
    private FormPanel[] formPanels = new FormPanel[10];

    public MastermindLayout() {
        setLayout(new BorderLayout(5, 5));

        // Oben: Eingabefelder und Buttons
        JPanel northPanel = new JPanel(new BorderLayout(5, 5));
        northPanel.setPreferredSize(new Dimension(500, 80));

        JPanel inputPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        for (int i = 0; i < 5; i++) {
            JTextField tf = new JTextField();
            tf.setFont(new Font("Arial", Font.PLAIN, 20));
            tf.setHorizontalAlignment(JTextField.CENTER);
            inputPanel.add(tf);
        }
        northPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 2, 2));
        JButton btnCheck = new JButton("Check");
        JButton btnNeu = new JButton("Neu");
        JButton btnLoesung = new JButton("Lösung");

        btnCheck.setActionCommand("CHECK");
        btnNeu.setActionCommand("NEU");
        btnLoesung.setActionCommand("LOESUNG");

        ButtonHandler handler = new ButtonHandler();
        btnCheck.addActionListener(handler);
        btnNeu.addActionListener(handler);
        btnLoesung.addActionListener(handler);

        buttonPanel.add(btnCheck);
        buttonPanel.add(btnNeu);
        buttonPanel.add(btnLoesung);
        northPanel.add(buttonPanel, BorderLayout.EAST);
        add(northPanel, BorderLayout.NORTH);

        // Mitte: Das 2x5 Spielfeld
        JPanel centerPanel = new JPanel(new GridLayout(2, 5, 5, 5));
        for (int i = 0; i < 10; i++) {
            formPanels[i] = new FormPanel();
            centerPanel.add(formPanels[i]);
        }
        add(centerPanel, BorderLayout.CENTER);

        // Unten: Statusmeldung
        add(new JLabel("Gewonnen, du hast meine Zahlen erraten!", SwingConstants.CENTER), BorderLayout.SOUTH);
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            int[] shapes = {FormPanel.CIRCLE, FormPanel.SQUARE, FormPanel.TRIANGLE, FormPanel.SQUARE, FormPanel.CIRCLE};

            if ("NEU".equals(cmd)) {
                // Obere Zeile füllen
                for (int i = 0; i < 5; i++) formPanels[i].draw(shapes[i], Color.GREEN, true);
            } else if ("LOESUNG".equals(cmd)) {
                // Untere Zeile füllen
                for (int i = 5; i < 10; i++) formPanels[i].draw(shapes[i - 5], Color.ORANGE, false);
            } else if ("CHECK".equals(cmd)) {
                // Alles leeren
                for (FormPanel fp : formPanels) fp.clear();
            }
        }
    }
}
package GUI;
import javax.swing.*;
import java.awt.*;


public class MeinPanel  extends JPanel {
    public MeinPanel() {
        BorderLayout basis = new BorderLayout();
        this.setLayout(basis);

        JLabel yellowLabel = new JLabel("Toni");

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(34, 196, 222));
        yellowLabel.setPreferredSize(new Dimension(200, 180));

        this.add(yellowLabel);
    }
}

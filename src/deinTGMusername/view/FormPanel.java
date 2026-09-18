package deinTGMusername.view;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {
    public static final int CIRCLE = 0;
    public static final int SQUARE = 1;
    public static final int TRIANGLE = 2;

    private int form = -1; // -1 heißt: Feld ist leer
    private Color color;
    private boolean filled;

    public FormPanel() {
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    }

    // Damit zeichnen wir ein Symbol in das Feld
    public void draw(int form, Color color, boolean filled) {
        this.form = form;
        this.color = color;
        this.filled = filled;
        repaint();
    }

    // Damit machen wir das Feld wieder leer
    public void clear() {
        this.form = -1;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (form == -1) return; // Wenn leer, dann nichts zeichnen

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(this.color);

        int size = Math.min(getWidth(), getHeight()) - 10;
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        if (form == CIRCLE) {
            if (filled) g2.fillOval(x, y, size, size);
            else g2.drawOval(x, y, size, size);
        } else if (form == SQUARE) {
            if (filled) g2.fillRect(x, y, size, size);
            else g2.drawRect(x, y, size, size);
        } else if (form == TRIANGLE) {
            int[] xPoints = {x + size / 2, x, x + size};
            int[] yPoints = {y, y + size, y + size};
            if (filled) g2.fillPolygon(xPoints, yPoints, 3);
            else g2.drawPolygon(xPoints, yPoints, 3);
        }
    }
}
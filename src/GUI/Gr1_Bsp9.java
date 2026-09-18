package GUI;

import javax.swing.*;
import java.awt.*;
public class Gr1_Bsp9 extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawOval(100, 0, 50, 50);
        g.drawOval(90 , 0, 70, 70);
        g.drawOval(80 , 0, 90, 90);
        g.drawOval(70 , 0,110, 110);
        g.drawOval(60 , 0,130,130);
        g.drawOval(50 , 0,150,150);
        g.drawOval(40 , 0,170,170);
        g.drawOval(30, 0, 190, 190);
    }

}

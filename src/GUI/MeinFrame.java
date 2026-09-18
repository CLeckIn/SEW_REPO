package GUI;

import javax.swing.*;
import java.awt.*;

public class MeinFrame extends JFrame {
    public MeinFrame() {
        super("Toni Gugic 2CHIT");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        MeinPanel content = new MeinPanel();
        Gr1_Bsp9 oval = new Gr1_Bsp9();
        this.setLocation(50,50);
        this.add(content);

        this.pack();
        this.setVisible(true);


    }

    public static void main(String[] args) {
        new MeinFrame();
    }

}

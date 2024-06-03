package game;

import javax.swing.*;
import java.awt.*;

/**
 * A background for the quit button shown in the end of level screen.
 */
public class quitButtonBackground extends JButton {
    private Image quit;
    Dimension minSize;

    public quitButtonBackground(){
        quit = new ImageIcon("data/Quit.png").getImage();
        minSize = new Dimension(192,50);
        setMinimumSize(minSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(quit, 0,0, 192, 50, null);
    }
}

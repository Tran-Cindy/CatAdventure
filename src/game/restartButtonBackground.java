package game;

import javax.swing.*;
import java.awt.*;

/**
 * A background for the restart button shown in the end of level screen.
 */
public class restartButtonBackground extends JButton {
    private Image restart;
    Dimension minSize;

    public restartButtonBackground(){
        restart = new ImageIcon("data/Restart.png").getImage();
        minSize = new Dimension(192,50);
        setMinimumSize(minSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(restart, 0,0, 192, 50, null);
    }
}

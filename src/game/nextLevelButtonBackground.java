package game;

import javax.swing.*;
import java.awt.*;

/**
 * A background for the nextLevel button shown in the end of level screen.
 */
public class nextLevelButtonBackground extends JButton {
    private Image nextLevel;
    Dimension minSize;

    public nextLevelButtonBackground(){
        nextLevel = new ImageIcon("data/NextLevel.png").getImage();
        minSize = new Dimension(192,50);
        setMinimumSize(minSize);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(nextLevel, 0,0, 192, 50, null);
    }
}

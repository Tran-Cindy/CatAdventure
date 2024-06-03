package game;

import javax.swing.*;
import java.awt.*;

/**
 * Background for a screen shown when the cat loses all lives.
 */
public class GameOverMenuBackground extends JPanel {
    private Image gameOverScreen;

    public GameOverMenuBackground(){
        gameOverScreen = new ImageIcon("data/gameOverScreen.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(gameOverScreen, 0,0, 800, 600, null) ;
    }
}

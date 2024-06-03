package game;

import javax.swing.*;
import java.awt.*;

/**
 * The background for the end of level screen.
 */
public class SplashMenuBackground extends JPanel {
    private Image endOfLevelScreen;
    private Image endOfLevelHearts;
    private Image endOfLevelStar;

    private Game game;
    private GameLevel level;

    public SplashMenuBackground(Game g, GameLevel lvl){
        game = g;
        level = lvl;

        if (level instanceof Level1){
        endOfLevelScreen = new ImageIcon("data/endOfLevel1.png").getImage();
        } else if (level instanceof Level2){
            endOfLevelScreen = new ImageIcon("data/endOfLevel2.png").getImage();
        } else if (level instanceof Level3){
            endOfLevelScreen = new ImageIcon("data/endOfLevel3.png").getImage();
        } else if (level instanceof Level4){
            endOfLevelScreen = new ImageIcon("data/endOfLevel4.png").getImage();
        }


        endOfLevelStar = new ImageIcon("data/endOfLevelStar.png").getImage();
        endOfLevelHearts = new ImageIcon("data/endOfLevelHearts.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(endOfLevelScreen, 0,0, 800, 600, null) ;

        //draws remaining lives, and number of stars collected
        switch(game.getLevel().getCat().getLives()){
            //case 0:

            case 1:
                g.drawImage(endOfLevelHearts, 400,235,43,43,this);
                break;
            case 2:
                g.drawImage(endOfLevelHearts, 400,235,43,43,this);
                g.drawImage(endOfLevelHearts, 445,235,43,43,this);
                break;
            case 3:
                g.drawImage(endOfLevelHearts, 400,235,43,43,this);
                g.drawImage(endOfLevelHearts, 445,235,43,43,this);
                g.drawImage(endOfLevelHearts,490,235,43,43,this);
                break;
        }

        switch(game.getLevel().getCat().getStars()){
            case 1:
                g.drawImage(endOfLevelStar, 400,300,43,43,this);
                break;
            case 2:
                g.drawImage(endOfLevelStar, 400,300,43,43,this);
                g.drawImage(endOfLevelStar, 445,300,43,43,this);
                break;
            case 3:
                g.drawImage(endOfLevelStar, 400,300,43,43,this);
                g.drawImage(endOfLevelStar, 445,300,43,43,this);
                g.drawImage(endOfLevelStar, 490,300,43,43,this);
                break;
        }
    }

}

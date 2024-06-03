package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

//subclass extends superclass (inheritance)

/**
 * The view shown when the player plays, used to show different backgrounds, the number of lives and stars.
 */
public class GameView extends UserView {

    private Image background;
    private Image background2;
    private Image background3;
    private Image background4;

    private Cat cat;

    private Image star;
    private Image life;
    private Image tipsButton;
    private GameLevel level;




    public GameView(GameLevel world, Cat c) {
        super(world, 800, 600);

        level = world;

        background = new ImageIcon("data/grassyfield.png").getImage();
        background2 = new ImageIcon("data/forest.png").getImage();
        background3 = new ImageIcon("data/desertscene.png").getImage();
        background4 = new ImageIcon("data/sunsetscene2.png").getImage();

        tipsButton = new ImageIcon("data/tipsButton.png").getImage();


        cat = c;

        life = new ImageIcon("data/hearts.png").getImage();

        star = new ImageIcon("data/starNoSpin.png").getImage();

    }



    //overrides the paintBackground method, and gives it a new image "grassyField.png"
    protected void paintBackground(Graphics2D g) {
        //(int) is used to type cast vec2 to integer

        if (level instanceof Level1) {
            g.drawImage(background, (int) (-this.getCentre().x - 10), 0, 1000, 600, this);
        }

        if (level instanceof Level2) {
            g.drawImage(background2, (int) (-this.getCentre().x - 10), 0, 1000, 600, this);
        }

        if (level instanceof Level3) {
            g.drawImage(background3, (int) (-this.getCentre().x - 10), 0, 1000, 600, this);
        }

        if (level instanceof Level4) {
            g.drawImage(background4, (int) (-this.getCentre().x - 10), 0, 1000, 800, this);
        }

    }


    protected void paintForeground(Graphics2D g){

        switch (cat.getLives()) {
            case 1:
                g.drawImage(life, 15, 14, 43, 43, this);
                break;
                case 2:
                    g.drawImage(life, 15, 14, 43, 43, this);
                    g.drawImage(life, 60, 14, 43, 43, this);
                    break;
                    case 3:
                        g.drawImage(life, 15, 14, 43, 43, this);
                        g.drawImage(life, 60, 14, 43, 43, this);
                        g.drawImage(life, 105, 14, 43, 43, this);
                        break;
            }


            switch (cat.getStars()) {
            case 1:
                g.drawImage(star, 20, 65, 30, 30, this);
                break;
                case 2:
                    g.drawImage(star, 20, 65, 30, 30, this);
                    g.drawImage(star, 55, 65, 30, 30, this);
                    break;
                    case 3:
                        g.drawImage(star, 20, 65, 30, 30, this);
                        g.drawImage(star, 55, 65, 30, 30, this);
                        g.drawImage(star, 90, 65, 30, 30, this);
                        break;
            }

        g.drawImage(tipsButton, 756, 2, 43, 43, this);

    }


    public void updateWorld(GameLevel world) {
        this.setWorld(world);
        level=world;
    }

    public void updateCat(Cat c) {
        cat = c;
    }
}

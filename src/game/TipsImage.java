package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class TipsImage extends StaticBody {

    Shape TipsImageShape= new BoxShape(24,18);
    private GameLevel level;

    /**
     * Uses a GhostlyFixture to display an image.
     * Using a GhostlyFixture ensures that the image does not disrupt gameplay.
     * @param lvl
     */
    public TipsImage(GameLevel lvl) {
        super(lvl);
        level = lvl;

        GhostlyFixture tipsImage = new GhostlyFixture(this, TipsImageShape);

        //originally transparent
        setFillColor(new Color(0f,0f,0f,0f));
        setLineColor(new Color(0f,0f,0f,0f));

    }

    /**
     * If the user clicks on the tips button the tipsImage corresponding to the level is added.
     */
    public void ClickedOn(){
        if (level instanceof Level1) {
            addImage(new BodyImage("data/tipsLevel1.png", 18));
        } else if (level instanceof Level2){
            addImage(new BodyImage("data/tipsLevel2.png", 18));
        } else if (level instanceof Level3){
            addImage(new BodyImage("data/tipsLevel3.png", 18));
        } else if (level instanceof Level4){
            addImage(new BodyImage("data/tipsLevel4.png", 18));
        }
    }

    /**
     * Remove the image from the body.
     */
    public void ClickedOff(){
        //the image is removed when the user clicks on anywhere that is not the button
        removeAllImages();
    }
}

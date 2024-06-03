package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The enemy used in level 1 that moves randomly.
 */
public class GhostEnemy extends Walker {

    //final = can only be assigned once
    private static final float walkingSpeed = 1f;
    Shape GhostShapeLeft = new PolygonShape(-1.96f,-1.74f, 0.53f,-1.95f, 1.72f,-1.17f, 1.96f,-0.34f, 1.95f,1.35f, 0.42f,1.88f, -1.5f,1.7f);
    Shape GhostShapeRight = new PolygonShape(2.16f,-1.88f, -1.62f,-1.91f, -1.97f,-0.2f, -1.95f,1.22f, -0.94f,1.89f, 0.45f,1.81f, 1.11f,1.3f);
    BodyImage GhostLeft = new BodyImage("data/ghost.png", 4f);
    BodyImage GhostRight = new BodyImage("data/ghostRight.png", 4f);

    public GhostEnemy(GameLevel lvl) {
        super(lvl);

        SolidFixture Ghost = new SolidFixture(this, GhostShapeLeft);
        this.addImage(GhostLeft);
    }

    public void ghostMoveLeft(){
        removeAllImages();
        addImage(GhostLeft);
        startWalking(-walkingSpeed);
    }

    public void ghostMoveRight(){
        removeAllImages();
        addImage(GhostRight);
        startWalking(walkingSpeed);
    }


}

package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A platform that looks like sand.
 */
public class SandPlatform extends StaticBody {
    Shape platformShape = new PolygonShape(-2.608f,-0.568f, -1.7f,-0.823f, 1.778f,-0.83f, 2.582f,-0.601f, 2.562f,0.739f, 2.288f,0.817f, -2.517f,0.804f);

    public SandPlatform(GameLevel lvl) {
        super(lvl);
        SolidFixture sandPlatform = new SolidFixture(this, platformShape);
        sandPlatform.setFriction(0.5f);

        this.addImage(new BodyImage("data/sandPlatform.png", 1.7f));
    }
}

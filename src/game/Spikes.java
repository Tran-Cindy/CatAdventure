package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A spike that does damage if stepped on.
 */
public class Spikes extends StaticBody  {
    private static final BodyImage image = new BodyImage("data/spikes.png", 1.7f);
    private static final BodyImage image2 = new BodyImage("data/spikesSunset.png", 1.7f);
    private static SoundClip spikesSound;

    static{
        try {
            spikesSound = new SoundClip("data/hitMetal.wav") ;
            System.out.println("spike sound loaded");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }


    //Making spikes, which causes the character to lose health
    //Made using 2 fixtures (that have a convex shape) and adding them to the same body
    Shape leftSpikeShape = new PolygonShape(0.084f,-0.837f, -0.955f,-0.824f, -1.284f,-0.713f, -1.215f,-0.066f, -0.536f,0.801f, 0.052f,-0.008f);
    Shape rightSpikeShape = new PolygonShape(0.042f,-0.824f, 0.962f,-0.837f, 1.271f,-0.746f, 1.245f,-0.109f, 0.604f,0.818f, 0.049f,0.002f);

    public Spikes(GameLevel lvl) {
        super(lvl);

        if (lvl instanceof Level1 | lvl instanceof Level2) {
            SolidFixture leftSpike = new SolidFixture(this, leftSpikeShape);
            SolidFixture rightSpike = new SolidFixture(this, rightSpikeShape);
            this.addImage(image); //adds an image to the body
        } else if (lvl instanceof Level4){
            SolidFixture leftSpike2 = new SolidFixture(this, leftSpikeShape);
            SolidFixture rightSpike2 = new SolidFixture(this, rightSpikeShape);
            this.addImage(image2);
        }
    }

    @Override
    public void destroy(){
        spikesSound.play();
        super.destroy();
    }
}

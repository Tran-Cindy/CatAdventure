package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Are collected by the cat.
 * Required by some levels to progress to the next level.
 */

public class Stars extends DynamicBody  {
    private static SoundClip starSound;

    static{
        try {
            starSound = new SoundClip("data/collectStarSound.wav") ;
            System.out.println("star sound loaded");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    private static final Shape starsShape = new CircleShape(1);

    private static final BodyImage image = new BodyImage("data/star.gif", 2f);

    public Stars(GameLevel lvl) {
        super(lvl,starsShape);
        addImage(image);
    }

    @Override
    public void destroy(){
        starSound.play();
        super.destroy();
    }
}

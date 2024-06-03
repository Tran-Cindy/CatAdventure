package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Plays the walking on sand sound everytime the cat walks on a SandPlatform/
 */
public class SandPlatformSound implements CollisionListener {
    private static SoundClip walkSound;
    static{
        try {
            walkSound = new SoundClip("data/walkOnSand.wav") ;
            walkSound.setVolume(1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof SandPlatform) {
            walkSound.play();
        } else {
            walkSound.stop();
        }
    }
}

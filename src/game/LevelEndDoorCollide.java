package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Detects when the player has collided with the LevelEndDoor.
 */
public class LevelEndDoorCollide implements CollisionListener {
    private GameLevel level;
    private Game game;

    private static SoundClip completedSound;

    static{
        try {
            completedSound = new SoundClip("data/winSound.wav") ;
            System.out.println("level complete sound loaded");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public LevelEndDoorCollide (GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof LevelEndDoor
                && level.isComplete()){
            completedSound.play();
            game.endOfLevel();
        }
    }
}

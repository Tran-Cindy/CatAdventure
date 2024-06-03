package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

//the impact the projectile has on the GhostEnemy

/**
 * Determines the impact a projectile has on an enemy, this is specific to the level.
 */
public class ProjectileDamage implements CollisionListener {
    private GameLevel level;
    private Game game;

    private static SoundClip projectileHitSound; //plays when the player is hit with a bullet

    static{
        try {
            projectileHitSound = new SoundClip("data/hitGhost.wav") ;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public ProjectileDamage(GameLevel lvl, Game g){
        level = lvl;
        game = g;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (level instanceof Level1 || level instanceof Level3 || level instanceof Level4) {
            //reportingBody = projectile, it is destroyed after it hits something
            //destroy() = removes the body from the world

            collisionEvent.getReportingBody().destroy();
            projectileHitSound.play();

            if (collisionEvent.getOtherBody() instanceof GhostEnemy) {
                System.out.println("hit ghost with ball");
                collisionEvent.getOtherBody().destroy(); //destroys the ghost
            }

            if (collisionEvent.getOtherBody() instanceof MovingEnemy) {
                System.out.println("hit ghost with ball");
                collisionEvent.getOtherBody().destroy(); //destroys the ghost
            }
        }

        if (level instanceof Level2){
            collisionEvent.getReportingBody().destroy();
            if (collisionEvent.getOtherBody() instanceof Cat) {
                projectileHitSound.play();
                System.out.println("hit player with ball");
                level.getCat().setLives(level.getCat().getLives()-1); //decrease 1 life from the player

                //if there's no lives left after the deduction above, then output gameover screen
                if(level.getCat().getLives() ==0){
                    game.gameOver();
                }
            }
        }
    }
}

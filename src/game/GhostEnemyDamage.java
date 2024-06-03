package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * CollisionListener that detects when the player is walked into the GhostEnemy,
 */
public class GhostEnemyDamage implements CollisionListener {
    private Cat cat;
    private Game game;
    public GhostEnemyDamage (Cat c, Game g) {
        game = g;
        cat = c;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {

        //reportingBody = cat
        //instanceof = tests if the object (the body that cat has collided with) is an instance of type GhostEnemy
        if (collisionEvent.getOtherBody() instanceof GhostEnemy){
            System.out.println("hit ghost");

            collisionEvent.getOtherBody().destroy(); //removes the ghost, because if not removed the student dies too easily
            cat.setLives(cat.getLives()-1); //removes a life from cat

            if (cat.getLives() == 0){
                game.gameOver();
            }

            System.out.println(cat.getLives());
        }
    }
}

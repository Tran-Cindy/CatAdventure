package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Detects when the cat has collided with a spike and decreases a life.
 */
public class SpikesDamage implements CollisionListener {

    private Cat cat;
    private Game game;

    public SpikesDamage (Cat c, Game g){
        cat = c;
        game = g;
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Spikes){
            System.out.println("hit");
            collisionEvent.getOtherBody().destroy(); //removes the platform
            cat.setLives(cat.getLives()-1); //removes a life

            if (cat.getLives() == 0){
                game.gameOver();
            }

            System.out.println(cat.getLives());
        }
    }

}

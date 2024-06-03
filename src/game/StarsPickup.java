package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Detects when the cat collides with a star, and adds stars onto the cat.
 */
public class StarsPickup implements CollisionListener {

    private Cat cat;

    public StarsPickup(Cat c){

        cat = c;
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Stars){
            cat.addStars();
            collisionEvent.getOtherBody().destroy(); //removes the star
        }
    }
}

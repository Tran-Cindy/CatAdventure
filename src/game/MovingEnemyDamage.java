package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Detects when the cat hits the MovingEnemy.
 */
public class MovingEnemyDamage implements CollisionListener {
    private Cat cat;
    private Game game;

    public MovingEnemyDamage (Cat c, Game g) {
        game = g;
        cat = c;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof MovingEnemy){
            System.out.println("hit moving enemy");

            collisionEvent.getOtherBody().destroy();
            cat.setLives(cat.getLives()-1); //removes a life from cat

            if (cat.getLives() == 0){
                game.gameOver();
            }

            System.out.println(cat.getLives());
        }
    }
}

package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.Shape;

/**
 * An enemy implemented in Level2, that is immune to shots made by the cat.
 */
public class Level2Enemy extends Walker {
    BodyImage bullet = new BodyImage("data/moonBall.png", 0.8f);
    BodyImage lvl2EnemyImage = new BodyImage("data/kirby.png", 4f);
    PolygonShape lvl2EnemyShape = new PolygonShape(2.11f,-1.94f, 1.24f,2.0f, -0.18f,2.0f, -2.15f,0.41f, -0.34f,-1.92f);
    private GameLevel level;
    private Game game;
    public Level2Enemy(GameLevel lvl, Game g) {
        super(lvl);
        level = lvl;
        game = g;

        SolidFixture lvl2Enemy = new SolidFixture(this, lvl2EnemyShape);
        this.addImage(lvl2EnemyImage);
    }

    public void shoot(){
        DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.4f));
        ProjectileDamage damage = new ProjectileDamage(level, game);
        projectile.addCollisionListener(damage);

        projectile.addImage(bullet);
        projectile.setPosition(new Vec2(this.getPosition().x-4, this.getPosition().y+2));
        projectile.setLinearVelocity(new Vec2(-20, 0));
    }
}

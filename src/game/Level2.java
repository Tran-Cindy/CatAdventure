package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * The second level of the game, no requirements are required to pass.
 */
public class Level2 extends GameLevel {
    private WoodPlatform woodPlatform1;
    private WoodPlatform woodPlatform2;
    private WoodPlatform woodPlatform3;
    private WoodPlatform woodPlatform4;

    private WoodPlatform woodPlatform5;

    //private Spikes spike1;
    private Spikes spike2;
    private Spikes spike3;

    private Level2Enemy enemy1;
    public Level2(Game game) {
        super(game);

        getCat().setPosition(new Vec2(-19, -10));
        getCat().setLives(3);
        getCat().setStars(0);

        //making woodPlatforms
        woodPlatform1 = new WoodPlatform(this);
        woodPlatform1.setPosition(new Vec2(-2, -7));

        woodPlatform2 = new WoodPlatform(this);
        woodPlatform2.setPosition(new Vec2(6, -5));

        woodPlatform3 = new WoodPlatform(this);
        woodPlatform3.setPosition(new Vec2(17, -8));

        woodPlatform4 = new WoodPlatform(this);
        woodPlatform4.setPosition(new Vec2(25, -5));

        //Making spikes
        /*spike1 = new Spikes(this);
        spike1.setPosition(new Vec2(-8, -13));*/

        spike2 = new Spikes(this);
        spike2.setPosition(new Vec2(11.5f, -7));

        spike3 = new Spikes(this);
        spike3.setPosition(new Vec2(31, -5));

        //Making a stonePlatform to place the door on
        woodPlatform5 = new WoodPlatform(this) ;
        woodPlatform5.setPosition(new Vec2(36, 0));
        getLevel1Door().setPosition(new Vec2(38, 3));

        //Adding stars to the level
        getS1().setPosition(new Vec2(-2, -6));
        getS2().setPosition(new Vec2(17, -7));
        getS3().setPosition(new Vec2(25, -4));

        //Adding an enemy to the level
        enemy1 = new Level2Enemy(this, game);
        enemy1.setPosition(new Vec2(6, -13));

        //the enemy will fire bullets after a certain amount of time
        Level2EnemyShoot es = new Level2EnemyShoot(enemy1);
        Timer enemyShootTimer = new Timer(2000, es);
        enemyShootTimer.setInitialDelay(1000);
        enemyShootTimer.start();

        getRightWall().setPosition(new Vec2(43, -5f));

    }

    //no requirements for this level
    @Override
    public boolean isComplete() {
        return true;
    }
}

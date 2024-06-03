package game;

import org.jbox2d.common.Vec2;

/**
 * The third level of the game, 2 stars have to be collected to pass.
 */
public class Level3 extends GameLevel {
    private SandPlatform sandPlatform1;
    private SandPlatform sandPlatform2;
    private SandPlatform sandPlatform3;
    private SandPlatform sandPlatform4;
    private SandPlatform sandPlatform5;

    private SandPlatform sandPlatform6;
    private SandPlatform sandPlatform7;
    private SandPlatform sandPlatform8;
    private Trampoline trampoline;
    public Level3(Game game) {
        super(game);

        getCat().setPosition(new Vec2(-19, 2));
        getCat().setLives(3);
        getCat().setStars(0);

        getLevel1Door().setPosition(new Vec2(40, 5));

        //making sandPlatforms
        sandPlatform1 = new SandPlatform(this) ;
        sandPlatform1.setPosition(new Vec2(-19, 1));

        sandPlatform2 = new SandPlatform(this) ;
        sandPlatform2.setPosition(new Vec2(-13, -5));

        sandPlatform3 = new SandPlatform(this) ;
        sandPlatform3.setPosition(new Vec2(-2, -5));

        sandPlatform4 = new SandPlatform(this) ;
        sandPlatform4.setPosition(new Vec2(4, 1));

        sandPlatform5 = new SandPlatform(this) ;
        sandPlatform5.setPosition(new Vec2(16, 1));

        sandPlatform6 = new SandPlatform(this) ;
        sandPlatform6.setPosition(new Vec2(22, -5));

        sandPlatform7 = new SandPlatform(this) ;
        sandPlatform7.setPosition(new Vec2(28, 1));

        sandPlatform8 = new SandPlatform(this) ;
        sandPlatform8.setPosition(new Vec2(38, 2));

        //in case the player falls
        trampoline = new Trampoline(this);
        trampoline.setPosition(new Vec2(10,-13));

        //setting stars position
        getS1().setPosition(new Vec2(4, 2));
        getS2().setPosition(new Vec2(28, 2));
        getS3().setPosition(new Vec2(16,-13));

        SandPlatformSound sandSound = new SandPlatformSound();
        getCat().addCollisionListener(sandSound);

        //Adding an enemy
        MovingEnemyDamage med = new MovingEnemyDamage(getCat(), game);

        MovingEnemy enemy1 = new MovingEnemy(this);
        enemy1.setPosition(new Vec2(-7.5f,-13));

        MovingEnemy enemy2 = new MovingEnemy(this);
        enemy2.setPosition(new Vec2(38,-13));

        MovingEnemy enemy3 = new MovingEnemy(this);
        enemy3.setPosition(new Vec2(22,-13));

        getCat().addCollisionListener(med);

        getRightWall().setPosition(new Vec2(43, -5f));

    }

    @Override
    public boolean isComplete() {
        //if the player has collected 2 or more stars they can go to the next level
        if (getCat().getStars() >= 2){
            return true;
        }
        return false;
    }
}

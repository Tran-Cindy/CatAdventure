package game;

import org.jbox2d.common.Vec2;

/**
 * The fourth level of the game, 3 stars have to be collected to pass.
 */
public class Level4 extends GameLevel{
    private StonePlatform stonePlatform1;
    private StonePlatform stonePlatform2;
    private StonePlatform stonePlatform3;
    private StonePlatform stonePlatform4;
    private StonePlatform stonePlatform5;
    private StonePlatform stonePlatform6;
    private StonePlatform stonePlatform7;
    private MovingEnemy enemy1;
    private MovingEnemy enemy2;

    private Spikes spike1;
    private Trampoline trampoline1;
    public Level4(Game game) {
        super(game);

        getTipsImage().setPosition(new Vec2(0, 0));

        getLevel1Door().setPosition(new Vec2(46, -5));

        getCat().setPosition(new Vec2(-10, 2));
        getCat().setLives(3);
        getCat().setStars(0);

        getRightWall().setPosition(new Vec2(50, -5f));

        MovingEnemyDamage med = new MovingEnemyDamage(getCat(), game);
        getCat().addCollisionListener(med);

        enemy1 = new MovingEnemy(this);
        enemy1.setPosition(new Vec2(-14, -13));

        trampoline1 = new Trampoline(this);
        trampoline1.setPosition(new Vec2(-10, -13));

        stonePlatform1 = new StonePlatform(this) ;
        stonePlatform1.setPosition(new Vec2(-4, -8));

        stonePlatform2 = new StonePlatform(this) ;
        stonePlatform2.setPosition(new Vec2(2, -2));

        stonePlatform3 = new StonePlatform(this) ;
        stonePlatform3.setPosition(new Vec2(8, -2));

        stonePlatform4 = new StonePlatform(this) ;
        stonePlatform4.setPosition(new Vec2(14, -8));

        getS1().setPosition(new Vec2(14, -7));

        stonePlatform4 = new StonePlatform(this) ;
        stonePlatform4.setPosition(new Vec2(26, -8));

        stonePlatform5 = new StonePlatform(this) ;
        stonePlatform5.setPosition(new Vec2(32, -2));

        stonePlatform6 = new StonePlatform(this) ;
        stonePlatform6.setPosition(new Vec2(26, 6));

        enemy2 = new MovingEnemy(this);
        enemy2.setPosition(new Vec2(26, -13));

        getS2().setPosition(new Vec2(26, 7));
        getS3().setPosition(new Vec2(38, -13));

        stonePlatform7 = new StonePlatform(this) ;
        stonePlatform7.setPosition(new Vec2(44, -8));

        spike1 = new Spikes(this);
        spike1.setPosition(new Vec2(20, -13));
    }

    @Override
    public boolean isComplete() {
        //if the player has collected all the stars
        if (getCat().getStars() == 3){
            return true;
        }
        return false;
    }
}

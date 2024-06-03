package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.*;

/**
 * The general features that every level contains.
 */

public abstract class GameLevel extends World {
    //things that are shared by all worlds
    private Cat cat;
    private Stars s1;
    private Stars s2;
    private Stars s3;
    private LevelEndDoor levelEndDoor;
    private StaticBody ceiling;
    private StaticBody rightWall;
    private TipsImage ti;

    public TipsImage getTipsImage() {
        return ti;
    }

    private Game game;

    public Stars getS1() {
        return s1;
    }

    public Stars getS2() {
        return s2;
    }

    public Stars getS3() {
        return s3;
    }

    public StaticBody getCeiling() {
        return ceiling;
    }
    public StaticBody getRightWall() {
        return rightWall;
    }


    public GameLevel(Game game){
        this.game = game;

        //making transparent ceiling so the character does not jump outside the view of the window
        ti = new TipsImage(this);
        ti.setPosition(new Vec2(-10, 0));

        Shape ceilingShape = new BoxShape(25f, 0.5f);
        ceiling = new StaticBody(this, ceilingShape );
        ceiling.setPosition(new Vec2(-5, 16f));

        // a (alpha value) set to 0 makes it transparent (has a range of 0-1)
        // r=0, g=0, b=0 is black
        ceiling.setFillColor(new Color(0f,0f,0f,0f));
        ceiling.setLineColor(new Color(0f,0f,0f,0f));

        //making the start wall
        //making the left wall
        Shape wallShape = new BoxShape(0.5f, 20f);
        StaticBody leftWall = new StaticBody(this, wallShape );
        leftWall.setPosition(new Vec2(-21, -5f));
        leftWall.setFillColor(new Color(0f,0f,0f,0f));
        leftWall.setLineColor(new Color(0f,0f,0f,0f));

        //making the right wall
        rightWall = new StaticBody(this, wallShape );
        rightWall.setPosition(new Vec2(46, -5f));
        rightWall.setFillColor(new Color(0f,0f,0f,0f));
        rightWall.setLineColor(new Color(0f,0f,0f,0f));

        //making the ground
        Shape shape = new BoxShape(60, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -14.5f));
        //making it transparent
        ground.setFillColor(new Color(0f,0f,0f,0f));
        ground.setLineColor(new Color(0f,0f,0f,0f));

        cat = new Cat(this, game);
        levelEndDoor = new LevelEndDoor(this) ;
        cat.addCollisionListener(new LevelEndDoorCollide(this, game));

        //Creating stars for the character to pickup
        s1 = new Stars(this);
        s2 = new Stars(this);
        s3 = new Stars(this);

        StarsPickup sp = new StarsPickup(cat);
        cat.addCollisionListener(sp);

        //Creating a spiked platform - the player will lose health if they step on it
        SpikesDamage sd = new SpikesDamage(getCat(), game) ;
        cat.addCollisionListener(sd);

    }


    public LevelEndDoor getLevel1Door() {
        return levelEndDoor;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public abstract boolean isComplete();


}

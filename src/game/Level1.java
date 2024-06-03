package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * The first level of the game, no requirements are required to pass.
 */
public class Level1  extends GameLevel{
    private IcePlatform icePlatform1;
    private IcePlatform icePlatform2;
    private StonePlatform stonePlatform1;
    private StonePlatform stonePlatform2;
    private StonePlatform stonePlatform3;
    private StonePlatform stonePlatform4;
    private StonePlatform stonePlatform5;
    private StonePlatform stonePlatform6;
    private StonePlatform stonePlatform7;

    private Spikes spikePlatform;
    private Trampoline trampoline;

    //Ghosts - do damage

    private GhostEnemy Ghost1;
    private GhostEnemy Ghost2;

    public Level1(Game game){
        //base class will create the student, professor
        super(game);

        /* create level specific platforms, enemies,
           pickups, collision listeners, etc.*/

        // making stonePlatforms
        stonePlatform1 = new StonePlatform(this);
        stonePlatform1.setPosition(new Vec2(2, -4f));

        stonePlatform2 = new StonePlatform(this);
        stonePlatform2.setPosition(new Vec2(10.5f, -2f));

        stonePlatform3 = new StonePlatform(this);
        stonePlatform3.setPosition(new Vec2(7f, 8f));

        stonePlatform4 = new StonePlatform(this);
        stonePlatform4.setPosition(new Vec2(-0.5f, 5f));

        stonePlatform5 = new StonePlatform(this);
        stonePlatform5.setPosition(new Vec2(27f, 1f));

        stonePlatform6 = new StonePlatform(this);
        stonePlatform6.setPosition(new Vec2(35f, 2f));

        stonePlatform7 = new StonePlatform(this);
        stonePlatform7.setPosition(new Vec2(42f, 4f));

        //making icePlatforms
        icePlatform1 = new IcePlatform(this);
        icePlatform1.setPosition(new Vec2(-6, -6f));

        icePlatform2 = new IcePlatform(this);
        icePlatform2.setPosition(new Vec2(16, 2f));

        //making a trampoline
        trampoline = new Trampoline(this) ;
        trampoline.setPosition(new Vec2(21, -13f));


        //Creating and initialising stars
        getS1().setPosition(new Vec2(-0.5f,6));

        getS2().setPosition(new Vec2(-6,-5));

        getS3().setPosition(new Vec2(35,3));


        //Creating a spiked platform - the player will lose health if they step on it

        spikePlatform = new Spikes(this);
        Vec2 coordinateForSpikes1 = new Vec2(21, 0);
        spikePlatform.setPosition(coordinateForSpikes1);

        //creating an enemy - ghost

        GhostEnemyDamage gd = new GhostEnemyDamage(getCat(), game);

        Ghost1 = new GhostEnemy(this);
        Ghost1.setPosition(new Vec2(10,-10));

        Ghost2 = new GhostEnemy(this);
        Ghost2.setPosition(new Vec2(35,-10));

        //creating timers to move the ghost left and right
        //delay = in milliseconds and is the delay between each event occurring
        //setInitialDelay = the timer is not fired as soon as the game starts

        GhostMover gm = new GhostMover(Ghost1, Ghost2);

        //these timers are created so that the GhostEnemy can randomly move left or right whilst the game is running
        Timer ghost1Timer = new Timer(1000, gm);
        ghost1Timer.setInitialDelay(200);
        ghost1Timer.start();

        Timer ghost2Timer = new Timer(1000, gm);
        ghost2Timer.setInitialDelay(200);
        ghost2Timer.start();

        getCat().addCollisionListener(gd);


        getCat().setPosition(new Vec2(-19, -10));
        getCat().setLives(3);

        getLevel1Door().setPosition(new Vec2(44f, 7f));

    }

    //No requirements for level 1
    @Override
    public boolean isComplete() {
        return true;
    }
}

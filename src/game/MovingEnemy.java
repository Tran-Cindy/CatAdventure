package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * An enemy that follows the cat, is used in Level3 and Level4.
 */
public class MovingEnemy extends Walker implements StepListener {
    private GameLevel level;
    private BodyImage MovingEnemyLeft = new BodyImage("data/enemy3Left.png", 4f);
    private BodyImage MovingEnemyRight = new BodyImage("data/enemy3Right.png", 4f);
    private PolygonShape MovingEnemyShape = new PolygonShape(1.25f,-1.97f, -1.24f,-1.99f, -1.25f,1.58f, -0.67f,1.97f, 1.23f,1.95f);
    private float Speed = 2;
    public static final float RANGE = 6;
    // the range at which it can detect the movements of the player and moves to towards them

    private enum State {
        MOVE_LEFT, MOVE_RIGHT, STAND_STILL
    }

    private State state;

    /**
     * Creates a MovingEnemy FSM.
     * @param lvl The level to create a MovingEnemy in
     */

    public MovingEnemy(GameLevel lvl) {
        super(lvl);

        SolidFixture movingEnemy = new SolidFixture(this, MovingEnemyShape);
        level = lvl;
        this.addImage(MovingEnemyLeft);
        getWorld().addStepListener(this);

    }

    /**
     * If the cat is on the left, calculate the gap between the cat and the MovingEnemy.
     * @return Whether the cat is on the left of the MovingEnemy and is within its range.
     */
    public boolean inRangeLeft() {
        Body cat = level.getCat();
        float gap = getPosition().x - cat.getPosition().x; //the gap on the left between the enemy and the player
        return gap < RANGE && gap > 0;    //gap in (0,RANGE)
    }

    /**
     * If the cat is on the right, calculate the gap between the cat and the MovingEnemy.
     * @return Whether the cat is on the right of the MovingEnemy and is within its range.
     */
    public boolean inRangeRight() {
        Body cat = level.getCat();
        float gap = getPosition().x - cat.getPosition().x; //the gap on the right between the enemy and the player
        return gap > -RANGE && gap < 0;  //gap in (-RANGE, 0)
    }

    /**
     * Changes the state.
     * @param stepEvent
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        //if it's in the range of sight of the enemy
        if (inRangeRight()) {
            removeAllImages(); //removes all images from the cat
            addImage(MovingEnemyRight);
            if (state != State.MOVE_RIGHT) {
                state = State.MOVE_RIGHT;
                startWalking(Speed) ;
            }
        } else if (inRangeLeft()) {
            removeAllImages(); //removes all images from the cat
            addImage(MovingEnemyLeft);
            if (state != State.MOVE_LEFT) {
                state = State.MOVE_LEFT;
                startWalking(-Speed) ;
            }

            //if it's not in the range of sight of the enemy, the enemy shouldn't move
        } else {
            removeAllImages(); //removes all images from the cat
            addImage(MovingEnemyLeft);
            if (state != State.STAND_STILL) {
                state = State.STAND_STILL;
                stopWalking();
            }
        }
        refreshWalk();
    }

    /**
     * Prevents walking from being slowed down by friction.
     */
    private void refreshWalk() {
        switch (state) {
            case MOVE_LEFT:
                startWalking(-Speed) ;
                break;
            case MOVE_RIGHT:
                startWalking(Speed);
                break;
            default: // nothing to do
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}

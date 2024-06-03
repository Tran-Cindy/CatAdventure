package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

/**
 * Tracks the movement of the cat.
 */
public class Tracker implements StepListener {
    private GameView view;
    private Cat cat;



    public Tracker(GameView view, Cat cat){
        this.cat = cat;
        this.view = view;

    }
    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {
        //the y coordinate is -1 so that it does not show the view beneath the ground

        Vec2 coordinateForCentre = new Vec2((cat.getPosition().x)+8, -1f);
        view.setCentre(coordinateForCentre);
    }
}

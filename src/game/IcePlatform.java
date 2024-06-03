package game;

import city.cs.engine.*;

//StaticBody as the IcePlatform does not move

/**
 * A platform that looks like ice and has less friction.
 */
public class IcePlatform extends StaticBody {

    Shape platformShape = new PolygonShape(1.738f,-0.805f, -1.534f,-0.805f, -2.511f,-0.562f, -2.479f,0.684f, -2.166f,0.818f, 2.192f,0.812f, 2.479f,0.69f, 2.518f,-0.632f);

    public IcePlatform(GameLevel lvl) {
        super(lvl);
        SolidFixture icePlatform = new SolidFixture(this, platformShape);
        icePlatform.setFriction(0); //makes the platform slippery, as it is ice

        //this refers to the current object in the constructor
        //so, it would add it to the icePlatform
        this.addImage(new BodyImage("data/icePlatform.png", 1.7f));
    }
}

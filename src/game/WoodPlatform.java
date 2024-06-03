package game;

import city.cs.engine.*;

/**
 * A platform that looks like wood.
 */
public class WoodPlatform extends StaticBody {
    Shape platformShape = new PolygonShape(-2.585f,-0.517f, -1.697f,-0.776f, 1.73f,-0.808f, 2.553f,-0.556f, 2.546f,0.818f, -2.52f,0.818f);
    public WoodPlatform(GameLevel lvl) {
        super(lvl);
        SolidFixture woodPlatform= new SolidFixture(this, platformShape);

        this.addImage(new BodyImage("data/woodPlatform.png", 1.7f));
    }
}

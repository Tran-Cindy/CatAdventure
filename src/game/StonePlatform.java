package game;

import city.cs.engine.*;

/**
 * A platform that looks like stone.
 */
public class StonePlatform extends StaticBody {
    Shape platformShape = new PolygonShape(-2.252f,0.781f, 2.164f,0.781f, 2.428f,0.693f, 2.453f,-0.591f, 1.642f,-0.811f, -1.598f,-0.792f, -2.479f,-0.528f, -2.447f,0.705f);
    Shape platformShape2 = new PolygonShape(-1.631f,-0.814f, -2.577f,-0.579f, -2.558f,0.713f, -2.16f,0.843f, 2.166f,0.843f, 2.545f,0.706f, 2.564f,-0.814f);
    public StonePlatform(GameLevel lvl) {
        super(lvl);

        if(lvl instanceof Level1 | lvl instanceof Level2) {
            SolidFixture stonePlatform = new SolidFixture(this, platformShape);
            this.addImage(new BodyImage("data/stonePlatform.png", 1.7f));
        } else if (lvl instanceof Level4){
            SolidFixture stonePlatform2 = new SolidFixture(this, platformShape2);
            this.addImage(new BodyImage("data/stonePlatformSunset.png", 1.7f));
        }
    }
}

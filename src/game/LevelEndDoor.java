package game;

import city.cs.engine.*;

/**
 * The door that is displayed at the end of every level,
 */
public class LevelEndDoor extends StaticBody  {
    Shape doorShape = new PolygonShape(1.08f,-2.39f, 1.05f,2.46f, -0.85f,2.43f, -1.12f,2.09f, -0.67f,-2.34f);
    public LevelEndDoor(GameLevel lvl) {
        super(lvl);

        if (lvl instanceof Level1 || lvl instanceof Level2) {
            SolidFixture door = new SolidFixture(this, doorShape);
            this.addImage(new BodyImage("data/door.png", 5f));
        } else if (lvl instanceof Level3 || lvl instanceof Level4){
            SolidFixture door = new SolidFixture(this, doorShape);
            this.addImage(new BodyImage("data/doorSunset.png", 5f));
        }
    }
}

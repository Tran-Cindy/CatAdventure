package game;

import city.cs.engine.*;

/**
 * A trampoline with a higher restitution, allowing the cat to jump higher.
 */
public class Trampoline extends StaticBody  {
    Shape trampolineShape = new PolygonShape(-0.714f,0.895f, 0.768f,0.878f, 1.651f,0.676f, 1.524f,-0.925f, -1.537f,-0.904f, -1.655f,0.671f);
    Shape trampolineShape2 = new PolygonShape(-1.567f,0.556f, -0.907f,0.831f, 0.457f,0.946f, 1.376f,0.787f, 1.567f,0.612f, 1.559f,-0.927f, -1.479f,-0.919f);
    public Trampoline(GameLevel lvl) {
        super(lvl);

        if(lvl instanceof Level1 | lvl instanceof Level3) {
            SolidFixture trampoline = new SolidFixture(this, trampolineShape);
            trampoline.setRestitution(1.2f); //makes the collision more elastic, higher restitution = more elastic
            this.addImage(new BodyImage("data/trampoline.png", 1.9f));
        } else if (lvl instanceof Level4){
            SolidFixture trampoline2 = new SolidFixture(this, trampolineShape2);
            trampoline2.setRestitution(1.2f);
            this.addImage(new BodyImage("data/trampolineSunset.png", 1.9f));
        }
    }
}

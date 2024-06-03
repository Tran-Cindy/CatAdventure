package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Detects when a key is pressed to control the movement of the cat, and when the cat does damage.
 */
public class CatController implements KeyListener  {
    Cat cat;

    public CatController(Cat cat) {

        this.cat = cat;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //VK = virtual key
        if (code == KeyEvent.VK_LEFT) {
            cat.moveLeft();
        } else if (code == KeyEvent.VK_RIGHT) {
            cat.moveRight();
        }  else if (code == KeyEvent.VK_UP) {
            cat.jump(13);
            } else if (code == KeyEvent.VK_S){
            cat.shoot();
        } else if (code == KeyEvent.VK_SHIFT){
            //SPRINTING
            cat.setWalkingSpeed(6);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        cat.stopWalking();
        cat.setWalkingSpeed(3);
    }
}

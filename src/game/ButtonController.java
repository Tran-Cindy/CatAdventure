package game;

import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

//loading packages
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Used to display an image with tips on how to beat a level.
 */

public class ButtonController implements MouseListener {
    //controls the TipsImage
    private GameLevel level;
    TipsImage tipsImage;

    /**
     * Used to detect if the player clicks within specific coordinates.
     * @param lvl The level that the ButtonController is created in
     * @param ti The tipsImage that is specific to its level
     */
    public ButtonController(GameLevel lvl, TipsImage ti){
        level = lvl;
        tipsImage = ti;
    }

    /**
     * Sets the tipsImage specific to the level
     * @param tipsImage
     */
    public void setTipsImage(TipsImage tipsImage) {
        this.tipsImage = tipsImage;
    }

    /**
     * Sets the level of the ButtonController
     * @param level
     */
    public void setLevel(GameLevel level) {
        this.level = level;
    }

    /**
     * If the mouse is clicked within certain points the tipsImage is displayed
     * If it is clicked off, those points then the image is removed
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Point mousePoint = e.getPoint();
        System.out.println(mousePoint);

        if (mousePoint.getX() >= 756 && mousePoint.getX() <= 796
                && mousePoint.getY() >= 4 && mousePoint.getY() <=44) {
            System.out.println("true, clicked on");

            tipsImage.ClickedOn();
        } else {
            System.out.println("false, clicked off");

            tipsImage.ClickedOff();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }


    //try this for hover
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

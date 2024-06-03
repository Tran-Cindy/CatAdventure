package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls the random movement of GhostEnemy.
 */
public class GhostMover implements ActionListener {
    GhostEnemy Ghost1;
    GhostEnemy Ghost2;
    public GhostMover(GhostEnemy g1, GhostEnemy g2) {
        Ghost1 = g1;
        Ghost2 = g2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int SwitchGhost1Direction;
        int SwitchGhost2Direction;

        //type cast to int, only whole numbers can be used
        SwitchGhost1Direction = (int) (Math.random()*2); //randomly generates a number between 0 inclusive, 2 exclusive
        SwitchGhost2Direction = (int) (Math.random()*2); //randomly generates a number between 0 inclusive, 2 exclusive

        // 1 = move right, 0 = move left
        if(SwitchGhost1Direction == 1){
            Ghost1.ghostMoveRight();
        } else if(SwitchGhost1Direction == 0){
            Ghost1.ghostMoveLeft();
        }

        if(SwitchGhost2Direction == 1){
            Ghost2.ghostMoveRight();
        } else if(SwitchGhost1Direction == 0){
            Ghost2.ghostMoveLeft();
        }
    }
}

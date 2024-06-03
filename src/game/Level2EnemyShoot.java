package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controls the shooting of Level2Enemy.
 */
public class Level2EnemyShoot implements ActionListener {
    private Level2Enemy Enemy1;
    public Level2EnemyShoot(Level2Enemy e1){
        Enemy1 = e1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Enemy1.shoot();
    }
}

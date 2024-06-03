package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverMenu {
    private JButton restartButton;
    private JPanel gameOverPanel;
    private JButton quitButton;

    public GameOverMenu (Game game) {
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("restart!");
                game.restartGame();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("quit");
                System.exit(0);
            }
        });

    }

    public JPanel getGameOverPanel() {
        return gameOverPanel;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    private void createUIComponents() {
        gameOverPanel = new GameOverMenuBackground();
        restartButton = new restartButtonBackground();
        quitButton = new quitButtonBackground();
    }
}

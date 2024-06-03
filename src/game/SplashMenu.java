package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashMenu {
    private JPanel mainPanel;
    private JButton nextLevelButton;
    private JButton quitButton;
    private JButton restartButton;

    private Game g;
    private GameLevel lvl;

    public SplashMenu(Game game, GameLevel level){
        g= game;
        lvl = level;
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

        nextLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("next level button pressed");
                game.goToNextLevel();
            }
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getNextLevelButton() {
        return nextLevelButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    private void createUIComponents() {
        //Custom backgrounds for each component

        mainPanel = new SplashMenuBackground(g,lvl);
        restartButton = new restartButtonBackground();
        nextLevelButton = new nextLevelButtonBackground();
        quitButton = new quitButtonBackground();
    }
}

package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;


/**
 * Your main game entry point
 */
public class Game {
    private GameLevel level;
    private GameView view;
    private CatController controller;

    private Tracker tracker;

    private BackgroundMusic music;
    private JFrame frame;

    private SplashMenu menu;

    private GameOverMenu gameOverMenu;

    private boolean GameOverMenuClicked = false;
    private boolean MainMenuClicked = false;
    private ButtonController buttonController;

    /** Initialise a new Game. */

    public Game() {


        level = new Level1(this);

        //1. make an empty game world
        //Level1 world = new Level1();


        //3. make a view to look into the game world
        view = new GameView(level, level.getCat());

        //making the student move according to key pressed
        controller = new CatController(level.getCat());
        view.addKeyListener(controller);

        //Registers the user's clicks on the button
        buttonController = new ButtonController(level, level.getTipsImage()) ;
        view.addMouseListener(buttonController);

        //Allows the view to move depending on the character
        tracker = new Tracker(view, level.getCat());

        //registers the steplistener to the world
        level.addStepListener(tracker);

        music = new BackgroundMusic(level);
        music.playMusic(level);

        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);


        //4. create a Java window (frame) and add the game
        //   view to it
        frame = new JFrame("Cat Adventure");
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
        JFrame debugView = new DebugViewer(level, 800, 600);

        // start our game world simulation!
        level.start();

        //to be able to see the jumping
        view.requestFocus();
    }

    /**
     * Triggered when the player loses all lives.
     */
    public void gameOver(){
        level.stop();
        
        GameOverMenuClicked = true;
        frame.remove(view);
        gameOverMenu = new GameOverMenu(this);

        gameOverMenu.getGameOverPanel().setPreferredSize(new Dimension(800,600));

        frame.add(gameOverMenu.getGameOverPanel());
        frame.pack();

    }

    /**
     * Outputs the menu to select either quit, restart or next level
     */
    public void endOfLevel(){
        MainMenuClicked = true;
        frame.remove(view);
        menu = new SplashMenu(this, level);

        menu.getMainPanel().setPreferredSize(new Dimension(800,600));

        frame.add(menu.getMainPanel());
        frame.pack();
    }

    /**
     * Called when the restartButton is clicked
     */
    public void restartGame(){
        if (level instanceof Level1){
            stopCurrentLevel();

            if (MainMenuClicked== true) {
                removeEndOfLevelScreen();
            } else if (GameOverMenuClicked == true){
                removeGameOverScreen();
            }

            addBackGameView();

            level = new Level1(this);

            LevelChanger(level);
            music.playMusic(level);

            //reset back to default
            MainMenuClicked = false;
            GameOverMenuClicked = false;

        } else if (level instanceof Level2){
            stopCurrentLevel();

            try {
                frame.remove(gameOverMenu.getGameOverPanel());
            } catch (Exception e){

            }

            if (MainMenuClicked== true) {
                removeEndOfLevelScreen();
            } else if (GameOverMenuClicked == true){
                removeGameOverScreen();
            }


            addBackGameView();

            level = new Level2(this);
            music.playMusic(level);

            LevelChanger(level);

            //reset back to default
            MainMenuClicked = false;
            GameOverMenuClicked = false;
        } else if (level instanceof Level3){
            stopCurrentLevel();

            try {
                frame.remove(gameOverMenu.getGameOverPanel());
            } catch (Exception e){

            }

            if (MainMenuClicked== true) {
                removeEndOfLevelScreen();
            } else if (GameOverMenuClicked == true){
                removeGameOverScreen();
            }

            addBackGameView();

            level = new Level3(this);
            music.playMusic(level);

            LevelChanger(level);

            //reset back to default
            MainMenuClicked = false;
            GameOverMenuClicked = false;
        } else if (level instanceof Level4){
            stopCurrentLevel();

            try {
                frame.remove(gameOverMenu.getGameOverPanel());
            } catch (Exception e){

            }

            if (MainMenuClicked== true) {
                removeEndOfLevelScreen();
            } else if (GameOverMenuClicked == true){
                removeGameOverScreen();
            }

            addBackGameView();

            level = new Level4(this);
            music.playMusic(level);

            LevelChanger(level);

            //reset back to default
            MainMenuClicked = false;
            GameOverMenuClicked = false;
        }

    }

    /**
     * Changes the game's level
     */
    public void goToNextLevel(){
        if (level instanceof Level1){
            stopCurrentLevel();

            removeEndOfLevelScreen();

            addBackGameView();

            level = new Level2(this);

            music.playMusic(level);
            LevelChanger(level);
        }
        else if (level instanceof Level2){
            stopCurrentLevel();

            removeEndOfLevelScreen();

            addBackGameView();

            level = new Level3(this);

            music.playMusic(level);
            LevelChanger(level);
        }
        else if (level instanceof Level3){
            stopCurrentLevel();

            removeEndOfLevelScreen();

            addBackGameView();

            level = new Level4(this);

            music.playMusic(level);
            LevelChanger(level);
        }
        else if (level instanceof Level4){
            stopCurrentLevel();

            removeEndOfLevelScreen();

            addBackGameView();

            level = new Level1(this);

            music.playMusic(level);
            LevelChanger(level);
        }
    }

    /**
     * Adds back the view to the game.
     */
    public void addBackGameView(){
        frame.add(view);
        frame.pack();
    }

    /**
     * Removes the endOfLevelScreen
     */
    public void removeEndOfLevelScreen(){
        frame.remove(menu.getMainPanel());
    }

    /**
     * Removes the gameOverScreen
     */
    public void removeGameOverScreen(){
        frame.remove(gameOverMenu.getGameOverPanel());
    }

    /**
     * Stops the level and stops the music
     */
    public void stopCurrentLevel(){
        level.stop();
        music.stopMusic();
    }

    /**
     * Changes the level
     * @param newLvl the next level after the current one
     */
    public void LevelChanger(GameLevel newLvl){
        //level now refers to the new level

        view.updateWorld(level);
        view.updateCat(level.getCat());

        music.updateLevel(level);

        tracker = new Tracker(view, level.getCat());
        level.addStepListener(tracker);

        controller.setCat(level.getCat()) ;
        buttonController.setLevel(level);
        buttonController.setTipsImage(level.getTipsImage());

        level.start();

        view.requestFocus();
    }

    /**
     * Gets the level
     * @return level
     */
    public GameLevel getLevel() {
        return level;
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();

    }


}

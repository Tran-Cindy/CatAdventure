package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Controls the starting and stopping of background music
 */

public class BackgroundMusic {
    private static SoundClip gameMusic;

    private GameLevel level;

    public BackgroundMusic (GameLevel lvl){
        level = lvl;
    }

    public void stopMusic(){
        gameMusic.stop();
    }

    //takes in the level so that it can update the level to play different music
    public void playMusic(GameLevel newLevel){
        level = newLevel;
        //Level 1 music
        if (level instanceof Level1) {
            try {
                gameMusic = new SoundClip("data/level1Music.wav");   // Open an audio input stream
                gameMusic.setVolume(0.5);
                gameMusic.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e); //catching the exception incase the file is not there
            }
        } else if (level instanceof Level2) {
            try {
                gameMusic = new SoundClip("data/level2Music.wav");
                gameMusic.setVolume(0.5);
                gameMusic.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        } else if (level instanceof Level3){
            try {
                gameMusic = new SoundClip("data/level3Music.wav");
                gameMusic.setVolume(0.5);
                gameMusic.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        } else if (level instanceof Level4){
            try {
                gameMusic = new SoundClip("data/level4Music.wav");
                gameMusic.setVolume(0.5);
                gameMusic.loop();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
    }

    public void updateLevel(GameLevel lvl) {
        level = lvl;
    }
}

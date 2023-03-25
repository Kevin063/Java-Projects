package PA3;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//Class for playing game sounds
public class sound {
	//Helper function to play a sound
		 public static void playSound(String soundFile) {
			    File f = new File("./" + soundFile);
			    AudioInputStream audioIn;
				try {
					audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
				    Clip clip = AudioSystem.getClip();
				    clip.open(audioIn);
				    clip.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					e.printStackTrace();
				}  
			}
}

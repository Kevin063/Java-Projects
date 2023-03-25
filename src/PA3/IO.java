package PA3;
//Abstract class for handing user interactions and generate outputs, supporting mutiple classes
import java.io.*;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public interface IO {

//Helper function for pause
	 public static void pressEnterToContinue()
	 { 
	        System.out.println("Press Enter key to continue...");
	        try
	        {
	    		Scanner s=new Scanner(System.in);
	    		String input=s.nextLine();
	        }  
	        catch(Exception e)
	        {}  
	 }
//Helper function for clear console
	 public static void clearconsole() {
		 System.out.println(new String(new char[3]).replace("\0", "\r\n"));
		 System.out.flush();  
	 }
}
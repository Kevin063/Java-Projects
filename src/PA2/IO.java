package PA2;
import java.io.IOException;//Abstract class for handing user interactions and generate outputs
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public abstract class IO {

//Helper function
	 public static void pressEnterToContinue()
	 { 
	        System.out.println("Press Enter key to continue...");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
//Helper function for clear console
	 public static void clearconsole() {
		 System.out.println(new String(new char[50]).replace("\0", "\r\n"));
		 System.out.flush();  
	 }
}
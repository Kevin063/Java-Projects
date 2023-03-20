package PA3;
//Abstract class for handing user interactions and generate outputs, supporting mutiple classes
import java.io.IOException;
public interface IO {

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
		 System.out.println(new String(new char[3]).replace("\0", "\r\n"));
		 System.out.flush();  
	 }
}
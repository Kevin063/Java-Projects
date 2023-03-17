package PA2;
import java.io.IOException;
//Abstract class for handing user interactions and generate outputs
import java.util.Scanner;

public abstract class IO {
//Read input to choose a mainpage action
	public static void readmainpage(leaderboard lb) {
	    int inChar;
	    System.out.println("Enter a Character:");
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		System.out.flush();
        switch(input) {
        case("1"):{}
        case("2"):{}
        case("3"):return;
        default:{
			System.out.println("Please input a valid game number!");
			readmainpage(lb);
        }
        }  
	  }
		}

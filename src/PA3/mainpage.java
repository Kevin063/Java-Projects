package PA3;
//The class that start a game or mutiple games from a console, and record match leaderboard.
import java.util.Scanner;
public class mainpage {
	public static void init() {
		PA3.leaderboard lb = leaderboard.readleaderboard();
		String logo = 
				" █████╗ ██████╗ ███████╗██╗  ██╗    ██╗    ██╗ ██████╗ ██████╗ ██╗     ██████╗ \n" +
                "██╔══██╗██╔══██╗██╔════╝╚██╗██╔╝    ██║    ██║██╔═══██╗██╔══██╗██║     ██╔══██╗\n" +
                "███████║██████╔╝█████╗   ╚███╔╝     ██║ █╗ ██║██║   ██║██████╔╝██║     ██║  ██║\n" +
                "██╔══██║██╔═══╝ ██╔══╝   ██╔██╗     ██║███╗██║██║   ██║██╔══██╗██║     ██║  ██║\n" +
                "██║  ██║██║     ███████╗██╔╝ ██╗    ╚███╔███╔╝╚██████╔╝██║  ██║███████╗██████╔╝\n" +
                "╚═╝  ╚═╝╚═╝     ╚══════╝╚═╝  ╚═╝     ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═════╝ \n";
		String welcomeMsg = 
				"|                           WELCOME TO APEX WORLD                              |\n" +logo+"\n"+
                "|                                                                              |\n" +
                "|     ____________________________________________________________________     |\n" +
                "|    |                                                                    |    |\n" +
                "|    |                                                                    |    |\n" +
                "|    |                            PRESS 1 TO                              |    |\n" +
                "|    |                         START NEW GAME                             |    |\n" +
                "|    |                                                                    |    |\n" +
                "|    |                                                                    |    |\n" +
                "|    ||                                                                  ||    |\n" +
                "|    |                                                                    |    |\n" +
                "|     ____________________________________________________________________     |\n" +
                "|    |                                                                    |    |\n" +
                "|    |                                                                    |    |\n" +
                "|    |                            PRESS 2 TO                              |    |\n" +
                "|    |                         VIEW LEADERBOARD                           |    |\n" +
                "|    |                                                                    |    |\n" +
                "|    ||                                                                  ||    |\n" +
                "|    |                                                                    |    |\n" +
                "|     ____________________________________________________________________     |\n" +
                "|    |                                                                    |    |\n" +
                "|    |                                                                    |    |\n" +
                "|    |                            PRESS 3 TO                              |    |\n" +
                "|    |                            QUIT GAME                               |    |\n" +
                "|    |                                                                    |    |\n" +
                "|    ||                                                                  ||    |\n" +
                "|    |                                                                    |    |\n" +
                "|______________________________________________________________________________|\n";

    	IO.clearconsole();
		System.out.println(welcomeMsg);
		readmainpage(lb);
	}
	//Read input to choose a mainpage action
		public static void readmainpage(leaderboard lb) {
		    int inChar;
		    System.out.println("Input your action");
			Scanner s=new Scanner(System.in);
			String input=s.nextLine();
			System.out.flush();
	        switch(input) {
	        case("1"):{
	        	sound.playSound("sounds/gamestart.wav");
	        	game g=new game();
	        	g.play(lb);
	        	IO.clearconsole();
	        	IO.clearconsole();
	        	IO.clearconsole();
	        	init();
	        	break;
	        }
	        case("2"):{
	        	sound.playSound("sounds/leaderboard.wav");
	        	IO.clearconsole();
	        	lb.printleaderboard();
	        	IO.pressEnterToContinue();
	        	mainpage.init();
	        	break;
	        	}
	        case("3"):{
				System.out.println("The game has been saved, see you next time!");	
	        	return;
	        }
	        default:{
				System.out.println("Please input a valid game number!");
				readmainpage(lb);
	        }
	        }  
		  }
}

package PA2;
import java.util.Scanner;
//The game process and user interactions.
public class game {
	private int score;
	private int gold;
	private map map;
	private String player;
	public game() {
		score=0;
		gold=0;
		this.player=this.readplayername();
		this.map=map.readmap();
	}
	public void play(leaderboard lb) {
	    System.out.print("\033[0;32m");
		System.out.println("The game starts!");
	    System.out.print("\033[0;0m");
		System.out.println(
				"W/w: move up\r\n"
				+ "• A/a: move left\r\n"
				+ "• S/s: move down\r\n"
				+ "• D/d: move right\r\n"
				+ "• Q/q: quit game\r\n"
				+ "• I/i: show information\r\n"
				+ "• M/m: enter market");
		IO.pressEnterToContinue();
		boolean exit=false;
		while(!exit) {
			System.out.println("Enter your hero team's action:");
			Scanner s=new Scanner(System.in);
			String input=s.nextLine();
			IO.clearconsole();
	        switch(input) {
	        case("q"):
	        case("Q"):{
	        	exit=true;
	        	lb.recordwinner(player, score);
	        	lb.saveleaderboard();
	        	System.out.print("\033[0;32m");
	        	System.out.println("Your score has been saved, see you next time!");
	        	System.out.print("\033[0;0m");
	        	break;
	        }
	        case("2"):{
	        	break;
	        	}
	        case("3"):{
	        	break;
	        }
	        default:{
				System.out.println("Please input a valid action, below is the supported input!");
				System.out.println(
						"W/w: move up\r\n"
						+ "• A/a: move left\r\n"
						+ "• S/s: move down\r\n"
						+ "• D/d: move right\r\n"
						+ "• Q/q: quit game\r\n"
						+ "• I/i: show information\r\n"
						+ "• M/m: enter market");
				continue;
	        }
	        }  
		}
	}
	public int getscore() {
		return score;
	}
	public int getgold() {
		return gold;
	}
	public static String readplayername() {
		Scanner s=new Scanner(System.in);
		System.out.print("Please enter the player's surname.");
		String name=s.nextLine();
		return name;
	}
}

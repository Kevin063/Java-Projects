//The class that start a game or mutiple games from a console, and record match leaderboard.
import java.util.Scanner;
public class gamelibrary {
	private static leaderboard lb;
	public static void init() {
		lb=new leaderboard();
		System.out.println("Welcome to the game library! You can choose the game that you like the most!");
		while(true) {
		game gm=IO.readgame();
		String[] playerlist=gm.getplayerlist();
		//Record all appearing players
		for(int i=0;i<playerlist.length;i++) {
			lb.recordplayer(playerlist[i]);
		}
		String winner=gm.playgame();
		if (winner.equals("quit")) {	
			System.out.println("The user has quited the game from the console command!");
		}
		else if (winner.equals("stalemate")) {
			System.out.println("The game ends with a stalemate");
			lb.recordstalemate();
		}
		else lb.recordwinner(winner, gm);
		System.out.print("Wanna play again? Enter \"Y\" to reset the game, otherwise to quit");
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		if(!input.equals("Y")){
			lb.printleaderboard();
			break;
		}
		}
		
	}
}

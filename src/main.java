

import java.util.Scanner;

public class main {
	//The main function with user tutorials and begin a new game
	private static leaderboard lb;
	private static void init() {
		lb=new leaderboard();
		while(true) {
		game gm=IO.readgame();
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
public static void main(String[] args) {
	init();	
}
}
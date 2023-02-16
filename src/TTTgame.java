import java.util.Scanner;
//Class for the TTT game
public class TTTgame extends game{
	public String gamename() {
			return "TTT";
			}
	//Read gameconfig, and start a game, then display leaderboard afterward.
	public String playgame() {
		System.out.println("Welcome to the game!\nAs any other Tic Tac Toe games, your goal is to have three marks in a line.\nBut here you can set your own board size!");
		System.out.println(this.getgameboard().build_out());
		System.out.println("The game starts! You can take actions by entering grid locations, like\"2,3\". You can always end the game by entering \"quit\" in the console.");
		String winner=this.gameprocess();
		this.getgameboard().resetboard();
		return winner;
	}
	//Play a game, return the winner index
	private String gameprocess() {
		int player=0;
		while(true) {
		//Players take turns to act
		if (player==this.getplayernum()) player=1;
		else player++;
		System.out.print("Action for the Player "+this.getplayerlist()[player-1]+":");
		action act=new action(this.getgameboard());
		if(act.getquit()) return "quit";
		if(this.getgameboard().execute_action(act,player)) {
			System.out.println(this.getgameboard().build_out());
			System.out.println("Player"+player+", You win!");
			return this.getplayerlist()[player-1];
		}//If someone win afterward, end the game
		else System.out.println(this.getgameboard().build_out());
		if(this.getgameboard().checkstalemate()) return "stalemate";
		}
	}
public TTTgame() {
	super();
}
}

package PA12;
import java.util.Scanner;
//Game logic and process for TTT
public class TTTgame extends game{
	public TTTgame() {
		this.playernum=IO.readplayernum();
		this.playerlist=IO.readplayername(playernum);
		this.gameboard=new TTTboard();
	}
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
		action act=new TTTaction(this.getgameboard(),player);
		if(act.getquit()) return "quit";
		if(this.getgameboard().execute_action(act,player)) {
			System.out.println(this.getgameboard().build_out());
			System.out.println("Player "+this.getplayerlist()[player-1]+", You win!\n-------------------------------------");
			return this.getplayerlist()[player-1];
		}//If someone win afterward, end the game
		else System.out.println(this.getgameboard().build_out());
		if(this.getgameboard().checkstalemate()) return "stalemate";
		}
	}
}

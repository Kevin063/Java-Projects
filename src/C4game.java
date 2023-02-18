//Game logic and process for C4
public class C4game extends game{
	public C4game() {
		this.playernum=IO.readplayernum();
		this.playerlist=IO.readplayername(playernum);
		this.gameboard=new C4board();
	}
	public String gamename() {
		return "C4";
		}
	public String playgame() {
		System.out.println("Welcome to the game!\nConnect 4 is a two-player connection rack game, in which the players choose a color and then take turns dropping colored tokens into a grid that you customized.");
		System.out.println(this.getgameboard().build_out());
		System.out.println("The game starts! You can take actions by entering the column that you want to drop the token, like\"3\". You can always end the game by entering \"quit\" in the console.");
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
		action act=new C4action(this.getgameboard(),player);
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

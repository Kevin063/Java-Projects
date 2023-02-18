//Game logic and process for OC
public class OCgame extends game{
	public OCgame() {

		this.playernum=2;
		this.playerlist=IO.readplayername(playernum);
		this.gameboard=new OCboard();
	}
	public String gamename() {
		return "OC";
		}
	public String playgame() {
		System.out.println("Welcome to the game!\nOrder and Chaos is a variant of the game tic-tac-toe on a gameboard with the size that you customized.");
		System.out.println(this.getgameboard().build_out());
		System.out.println("The game starts! You can take actions by entering the piece you want, and grid locations, like\"x,2,3\". You can always end the game by entering \"quit\" in the console.");
		String winner=this.gameprocess();
		this.getgameboard().resetboard();
		return winner;
	}
	private String gameprocess() {
		int player=2;
		while(true) {
		//Players take turns to act
		if (player==1) player=2;
		else player=1;
		if (player==1)System.out.print("Action for the Order Player "+this.getplayerlist()[0]+":");
		else System.out.print("Action for the Chaos Player "+this.getplayerlist()[1]+":");
		OCaction act=new OCaction(this.getgameboard(),player);
		if(act.getquit()) return "quit";
		if(this.getgameboard().execute_action(act,act.player)) {
			System.out.println(this.getgameboard().build_out());
			System.out.println("Order Player "+this.getplayerlist()[0]+", You win!\n-------------------------------------");
			return this.getplayerlist()[0];
		}//If someone win afterward, end the game
		else System.out.println(this.getgameboard().build_out());
		if(this.getgameboard().checkstalemate()) {
			System.out.println(this.getgameboard().build_out());
			System.out.println("Chaos Player"+this.getplayerlist()[1]+", You win!\n-------------------------------------");
			return this.getplayerlist()[1];
		}
		}
	}
}

//Class for the game config, a game contains a board, and is playable.
public class game {
	private int playernum;
	private int wincondition;
	private board gameboard;
	private String[] playerlist;
	public game() {
		this.gameboard=new board();
		this.playernum=IO.readplayernum();
		this.playerlist=IO.readplayername(playernum);
	}
	public int getplayernum() {
		return this.playernum;
	}
	public int getwincondition() {
		return this.wincondition;
	}
	public board getgameboard() {
		return this.gameboard;
	}
	public String[] getplayerlist() {
		return this.playerlist;
	}
	public String playgame() {
		return "quit";
	}
	public void getaction() {}
	public String gamename() {
		return null;
	}
}

//Class for the game config, a game contains a board, and is playable.
public class game {
	protected int playernum;
	protected board gameboard;
	protected String[] playerlist;
	public game() {
	}
	public int getplayernum() {
		return this.playernum;
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

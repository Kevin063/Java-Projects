
public class player {
	private String surname;
	private int TTTwin;
	private int OCwin;
	private int Cfourwin;
	public player(String surname){
		this.surname=surname;
		int TTTwin,OCwin,fourwin=0;
	}
	public void playerwin(game gm) {
		if(gm.gamename().equals("TTT")) this.TTTwin++;
	}
	public void printplayer(){
		System.out.println("won TTT "+TTTwin+" times, OC "+OCwin+"times, C4 "+Cfourwin+" times.");
	}
}

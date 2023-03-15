package PA1;
//Class for storing player info and win history
public class player {
	private String surname;
	private int TTTwin;
	private int OCwin;
	private int C4win;
	public player(){}
	public player(String surname){
		this.surname=surname;
		int TTTwin,OCwin,fourwin=0;
	}
	public void playerwin(game gm) {
		if(gm.gamename().equals("TTT")) this.TTTwin++;
		if(gm.gamename().equals("OC")) this.OCwin++;
		if(gm.gamename().equals("C4")) this.C4win++;
	}
	public void printplayer(){
		System.out.println("Player "+this.surname+" won TTT "+TTTwin+" times, OC "+OCwin+" times, C4 "+C4win+" times.");
	}
}

package PA3;
//Class for storing player info and win history
public class player {
	private String surname;
	private int bestscore;
	public player(){}
	public player(String surname){
		this.surname=surname;
		int TTTwin,OCwin,fourwin=0;
	}
	public void playerwin(int score) {
		if (bestscore<score) bestscore=score;
	}
	public void printplayer(){
		System.out.print("║   "+this.surname+String.format("%"+(11-this.surname.length())+"s", "")+"║       "+this.bestscore+String.format("%"+(11-Math.log10(bestscore+1))+"s", "")+"║\n");
	}
	public int getbestscore() {
		return this.bestscore;
	}
}

package TTT;
//The action class can be used for future features, like regrets or endgame recordings.
public class action {
	private int x;
	private int y;
	public action(int a, int b) {
		x=a;
		y=b;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
}

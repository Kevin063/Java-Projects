package PA12;

import java.util.Scanner;
//Class for storing any user input as a game action that can be applied to the gameboard
public class action {
	protected int x;
	protected int y;
	protected boolean quit=false;
	protected int player;
	public action() {}
	public action(int a, int b,int p) {
		x=a;
		y=b;
		player=p;
	}	
	public action(int p) {
		player=p;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public boolean getquit() {
		return quit;
	}
}

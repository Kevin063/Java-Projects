//Class for handing user interactions and generate outputs
import java.util.Scanner;

public abstract class IO {
//Read input to choose a game
	public static game readgame() {
		System.out.print("Please choose your game from our game list!\n1.Tic Tac Toe");
		Scanner s=new Scanner(System.in);
		int input=s.nextInt();
		if (input==1) {
			return new TTTgame();
		}
		else if (input==1) {
			return new game();
		}
		else {
			System.out.println("Please input a valid game number!");
			return readgame();
		}
		}
	public static int readheight() {
	System.out.print("Please enter your board height :");
	Scanner s=new Scanner(System.in);
	int height=s.nextInt();
	if (height<3) {
		System.out.println("Please enter a larger board height!");
		return readheight();
	}
	else return height;
}
//Read width from IO, start-over if less than 3.
	public static int readwidth() {
	System.out.print("Please enter your board width :");
	Scanner s=new Scanner(System.in);
	int width=s.nextInt();
	if (width<3) {
		System.out.println("Please enter a larger board width!");
		return readwidth();
	}
	else return width;
}
//Read playernum from IO, start-over if less than 2.
	public static int readplayernum() {
	System.out.print("Please enter your player number :");
	Scanner s=new Scanner(System.in);
	int playernum=s.nextInt();
	if (playernum<2) {
		System.out.println("Please enter a larger playernum!");
		return readplayernum();
	}
	else return playernum;
}
	public static String[] readplayername(int num) {
		String[] list=new String[num];
		Scanner s=new Scanner(System.in);
		for(int i=0;i<num;i++) {
			System.out.print("Please enter the surname for the player "+(i+1)+":");
			list[i]=s.nextLine();
		}
		return list;
	}
//Read playernum from IO, start-over if less than 2.
	public static int readwincondition() {
	System.out.print("Please enter your winning combo condition :");
	Scanner s=new Scanner(System.in);
	int playernum=s.nextInt();
	if (playernum<2) {
		System.out.println("Please enter a larger playernum!");
		return readplayernum();
	}
	else return playernum;
}
}

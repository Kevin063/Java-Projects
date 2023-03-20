package PA12;
//Abstract class for handing user interactions and generate outputs
import java.util.Scanner;
public abstract class IO {
//Read input to choose a game
	public static game readgame() {
		System.out.print("Please choose your game from our game list!\n1. Tic Tac Toe\n2. Order and Chaos\n3. Connect 4\n");
		Scanner s=new Scanner(System.in);
		int input=s.nextInt();
		if (input==1) {
			return new TTTgame();
		}
		else if (input==2) {
			return new OCgame();
		}
		else if (input==3) {
			return new C4game();
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
//Read wincondition for TTT from IO, start-over if less than 3.
	public static int readTTTwincondition(int limit) {
		System.out.print("Please enter your winning combo condition for TTT:");
		Scanner s=new Scanner(System.in);
		int condition=s.nextInt();
		if (condition<3) {
			System.out.println("Please enter a larger condition!");
			return readTTTwincondition(limit);
		}
		else if (condition>limit){
			System.out.println("Please enter a smaller condition!");
			return readTTTwincondition(limit);
		}
		else return condition;
}
	//Read wincondition for OC from IO, start-over if larger than the width/height.
	public static int readOCwincondition(int limit) {
		System.out.print("Please enter your winning combo condition for OC:");
		Scanner s=new Scanner(System.in);
		int condition=s.nextInt();
		if (condition<3) {
			System.out.println("Please enter a larger condition!");
			return readOCwincondition(limit);
		}
		else if (condition>limit){
			System.out.println("Please enter a smaller condition!");
			return readOCwincondition(limit);
		}
		else return condition;
	}
	//Read wincondition for OC from IO, start-over if larger than the width/height.
	public static int readC4wincondition(int limit) {
		System.out.print("Please enter your winning combo condition for C4:");
		Scanner s=new Scanner(System.in);
		int condition=s.nextInt();
		if (condition<3) {
			System.out.println("Please enter a larger condition!");
			return readC4wincondition(limit);
		}
		else if (condition>limit){
			System.out.println("Please enter a smaller condition!");
			return readC4wincondition(limit);
		}
		else return condition;
	}
}

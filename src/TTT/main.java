package TTT;

import java.util.Scanner;

public class main {
	static int height;
	static int width;
//Read height from IO, start-over if less than 3.
	private static int readheight() {
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
	private static int readwidth() {
	System.out.print("Please enter your board width :");
	Scanner s=new Scanner(System.in);
	int width=s.nextInt();
	if (width<3) {
		System.out.println("Please enter a larger board width!");
		return readwidth();
	}
	else return width;
}
//Read and validate an action from user input
	private static action readaction(board bd) {
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		if(input.indexOf(",")==-1) {
			System.out.println("Invaild format for the input! Please try again.");
			return readaction(bd);
		}//No "," in the input
		int x = Integer.parseInt(input.substring(0,input.indexOf(",")));
		int y = Integer.parseInt(input.substring(input.indexOf(",")+1));
		if(x<0||x>height-1) {
			System.out.println("Invaild format for the input! Please try again.");
			return readaction(bd);
		}
		if(y<0||y>width-1) {
			System.out.println("Invaild format for the input! Please try again.");
			return readaction(bd);
		}
		action act=new action(x,y);
		if (!bd.vaild_action(act)) {
			System.out.println("The grid is occupied yet! Please choose another location.");	
			return readaction(bd);
		}
	//I'm missing something here! What if the input is not an int? like: CS611,CS112. I should handle this in real cases!
		return act;
	}
	//The main function with user tutorials and game logics
	private static void game() {
		System.out.println("Please start with your size input (minimum 3X3):");
		height=readheight();
		System.out.println("");
		width=readwidth();
		System.out.println("");
		System.out.println("Your board size is: "+height+"X"+width);
		board bd=new board(height,width);
		boolean user=true;//True for Player1, False for Player2
		System.out.println(bd.build_out());
		System.out.println("The game starts! You can take actions by entering grid locations, like\"2,3\"");
		while (true){//Each loop refers to an action
			int player;
			if(user) player=1;
			else player=2;
			System.out.print("Action for the Player"+player+":");
			action act=readaction(bd);
			if(bd.execute_action(act,player)) {
				System.out.println(bd.build_out());
				System.out.println("Player"+player+", You win!");
				break;
			}//If someone win afterward, end the game
			else System.out.println(bd.build_out());
			user=!user;
		}
		System.out.print("Wanna play again? Enter \"Y\" to reset the game, otherwise to quit");
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		if(input.equals("Y")) game();
		else System.out.println("See you next time!");
	}
public static void main(String[] args) {
	System.out.println("Welcome to the game!\nAs any other Tic Tac Toe games, your goal is to have three marks in a line.\nBut here you can set your own board size!");
	game();
}
}
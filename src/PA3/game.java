package PA3;
import java.util.Scanner;
//The game process and user interactions.
public class game {
	private int score;
	private int gold;
	private map map;
	private String player;
	private hero[] heroes;
	//Init a game and set name and map
	public game() {
		score=0;
		gold=0;
		this.player=this.readplayername();
		this.map=map.readmap();
		this.heroes=new hero[5];
		this.heroes[0]=hero.readHero();
	}
	//The recursive process for a game
	public void play(leaderboard lb) {
    	System.out.print("\033[0;31m");
		System.out.print("You wake up in a dark dungeon, guarded by a group of dwarven goblins.\nFinally you waited until one night, pried open the iron door of the cell, and when you were about to walk out of the dungeon, a goblin jailer noticed you!");
	    System.out.print("\033[0;0m");
		IO.clearconsole();
		IO.pressEnterToContinue();
		battle tutorial=new tutorial(heroes);
		if(!tutorial.startRound()) {
        	lb.saveleaderboard();
        	IO.clearconsole();
        	System.out.print("\033[0;32m");
        	IO.pressEnterToContinue();
		}
	    System.out.print("\033[0;0m");
	    
	    System.out.print("\033[0;32m");
		System.out.println("Now that you have escaped from this prison guarded by goblins, a Bounty Hunter named Twisted Fate is willing to take risks with you, and you embark on a journey of adventure in "+this.map.getMaptype());
		System.out.println("Twisted Fate has joined the team!");
	    System.out.print("\033[0;0m");
	    IO.pressEnterToContinue();
	    map.printMap();
		System.out.println(
				"• W/w: move up\r\n"
				+ "• A/a: move left\r\n"
				+ "• S/s: move down\r\n"
				+ "• D/d: move right\r\n"
				+ "• Q/q: Back to the mainpage\r\n"
				+ "• I/i: show information\r\n"
				+ "• M/m: enter market");
		boolean exit=false;
		while(!exit) {
			System.out.println("Enter your hero team's action:");
			Scanner s=new Scanner(System.in);
			String input=s.nextLine();
			IO.clearconsole();
	        switch(input) {
	        case("q"):
	        case("Q"):{
	        	exit=true;
	        	lb.recordwinner(player, score);
	        	lb.saveleaderboard();
	        	System.out.print("\033[0;32m");
	        	System.out.println("Your score has been saved, see you next time!");
	        	System.out.print("\033[0;0m");
	        	IO.pressEnterToContinue();
	        	break;
	        }
	        case("w"):
	        case("W"):
	        case("a"):
	        case("A"):
	        case("s"):
	        case("S"):
	        case("d"):
	        case("D"):{
	        	if(map.move(input.toUpperCase())) {
	        		if(marketcheck()) {
	        			System.out.print("\033[0;32m");
	        			System.out.println(market.encounterMessage(map));
	        			System.out.print("\033[0;0m");
	        		}
	        		else if(battlecheck()) {
	        			battle b=new battle(heroes,map, score);
	        			if(!b.startRound()) {
	        	        	exit=true;
	        	        	lb.recordwinner(player, score);
	        	        	lb.saveleaderboard();
	        	        	IO.clearconsole();
	        	        	System.out.print("\033[0;32m");
	        	        	IO.pressEnterToContinue();
	        	        	System.out.println("Your score has been saved, see you next time!");
	        	        	System.out.print("\033[0;0m");
	        			}
	        		}
	        	}
	        	break;
	        	}
	        default:{
				System.out.println("Please input a valid action, below is the supported input!");
				System.out.println(
						"W/w: move up\r\n"
						+ "• A/a: move left\r\n"
						+ "• S/s: move down\r\n"
						+ "• D/d: move right\r\n"
						+ "• Q/q: quit game\r\n"
						+ "• I/i: show information\r\n"
						+ "• M/m: enter market");
				continue;
	        }
	        }  
		}
	}
	public int getscore() {
		return score;
	}
	public int getgold() {
		return gold;
	}
	//read player name from IO
	public static String readplayername() {
		Scanner s=new Scanner(System.in);
		System.out.print("Please enter the player's surname.");
		String name=s.nextLine();
		return name;
	}
//Check whether meet a monster battle
	public boolean battlecheck() {
	if(map.getloc()==' ') {
		double x=Math.random();
		if(x<map.getmonsterindex()) {
			return true;
		}
	}
	return false;
	}
//Check whether enter a market
	public boolean marketcheck() {
	if(map.getloc()=='M') {
			return true;
		}
	return false;
	}
}

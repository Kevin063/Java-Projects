package PA3;
import java.util.Scanner;
//The game process and user interactions.
public class game {
	private int score;
	private int gold;
	private map map;
	private String player;
	private hero[] heroes;
	private boolean herobouns;
	private boolean boss;
	//Init a game and set name and map
	public game() {
		gold=0;
		herobouns=false;
		boss=false;
		this.player=this.readplayername();
		this.map=map.readmap();
		switch(map.getMaptype()) {
		case("Olympus"): score=5000; break;
		case("kingsCanyon"): score=10000; break;
		case("StormPoint"): score=15000; break;
		default: score=5000;
		}
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
		else score+=tutorial.getScorevalue();
	    System.out.print("\033[0;0m");
	    
	    System.out.print("\033[0;32m");
		System.out.println("Now that you have escaped from this prison guarded by goblins, a Bounty Hunter named Twisted Fate is willing to take risks with you, and you embark on a journey of adventure in "+this.map.getMaptype());
		System.out.println("Twisted Fate has joined the team!");
	    System.out.print("\033[0;0m");
	    this.heroes[1]=new twistedfate();
	    IO.pressEnterToContinue();
		System.out.println(
				"• W/w: move up\r\n"
				+ "• A/a: move left\r\n"
				+ "• S/s: move down\r\n"
				+ "• D/d: move right\r\n"
				+ "• Q/q: Back to the mainpage\r\n"
				+ "• I/i: show information\r\n"
				+ "• B/b: check bag\r\n"
				+ "• M/m: enter market");
		boolean exit=false;
		while(!exit) {
			map.printMap();
			checkBouns();
			checkBoss();
			if (boss) {
			    IO.setRed();
				System.out.println("!!!!!!");
				System.out.println("The final boss has arrive!");
			    IO.resetColor();
			    battle boss=new finalboss(heroes);
    			if(!boss.startRound()) {
    	        	exit=true;
    	        	IO.setRed();
    	        	System.out.println("Your heroes didn't defeat the Mecha:PRIME Warick. Maybe another group of adventures might finish your incomplete dream today.");
    	        	IO.resetColor();
    	        	IO.pressEnterToContinue();
    	        	lb.recordwinner(player, score);
    	        	lb.saveleaderboard();
    	        	IO.clearconsole();
    	        	IO.setGreen();
    	        	IO.pressEnterToContinue();
    	        	System.out.println("Your score has been saved, see you next time!");
    	        	IO.resetColor();
    	        	break;
    			}
    			else {
    				exit=true;
    				IO.setGreen();
    				System.out.println("Congratulations! You have defeated the Mecha:PRIME Warick. Your adventrue will be remembered by everyone in "+map.getMaptype()+".");
    				IO.pressEnterToContinue();
    				lb.recordwinner(player, score);
    	        	lb.saveleaderboard();
    	        	System.out.println("Your score has been saved, see you next time!");
    	        	IO.resetColor();
    	        	break;
    			}
			}
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
	        case("i"):
	        case("I"):{
	        	hero h=chooseHero();
	        	System.out.println("Your total score: "+this.score+".");
	        	h.printStats();
	        	IO.pressEnterToContinue();
	        	break;
	        }
	        case("b"):
	        case("B"):{
	        	hero h=chooseHero();
	        	h.getInv().open(h);
	        	IO.pressEnterToContinue();
	        	break;
	        }
	        case("m"):
	        case("M"):{
	        	if(map.marketcheck()) {
	        	hero h=chooseHero();
	        	map.getMarket().entermarket(map,h);
	        	map.printMap();
	        	IO.pressEnterToContinue();
	        	break;
	        	}
	        	else {
					System.out.println("No market is found at the current location!");
					IO.pressEnterToContinue();
					continue;
	        	}
	        	
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
	        		sound.playSound("sounds/move.wav");
	        		if(map.marketcheck()) {
	        			System.out.print("\033[0;32m");
	        			System.out.println(market.encounterMessage(map));
	        			System.out.print("\033[0;0m");
	        		}
	        		else if(battlecheck()) {
	        			IO.setRed();
	        			System.out.println("You have encounter a group of monsters!");
	        			IO.resetColor();
	        			IO.pressEnterToContinue();
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
	        			else {
	        				score+=b.getScorevalue();
	        			}
	        		}
	        	}
	        	break;
	        	}
	        case("Boss"): boss=true; break;//Used for testing boss battle 
	        default:{
				System.out.println("Please input a valid action, below is the supported input!");
				System.out.println(
						"• W/w: move up\r\n"
						+ "• A/a: move left\r\n"
						+ "• S/s: move down\r\n"
						+ "• D/d: move right\r\n"
						+ "• Q/q: quit game\r\n"
						+ "• I/i: show information\r\n"
						+ "• B/b: check bag\r\n"
						+ "• M/m: enter market");
				IO.pressEnterToContinue();
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
//Check whether meet a monster b	attle
	public boolean battlecheck() {
	if(map.getMarket()==null) {
		double x=Math.random();
		if(x<map.getmonsterindex()) {
			return true;
		}
	}
	return false;
	}
//Let players to show a hero list
	public void showHero() {
		String frametop= 
				  "╔══════════════════════════════════╗\n"
              + "║              Heroes              ║\n"
              + "╠══════════════╦═══════════════════╣\n"
              + "║     Slot     ║       Name        ║\n"
              + "╠══════════════╬═══════════════════╣\n";
		String framebot="╚══════════════╩═══════════════════╝";
		System.out.print(frametop);
		for(int i=0;i<heroes.length;i++) {
			if (heroes[i]==null) break;
			System.out.print("║      "+(i+1)+String.format("%"+(7)+"s", "")+"║    "+heroes[i].getName()+String.format("%"+(15-heroes[i].getName().length())+"s", "")+"║\n");
		}
		System.out.print(framebot);
		
	}
//Let players to choose a hero from list
	public hero chooseHero() {
			Scanner s=new Scanner(System.in);
			System.out.println("Please choose a hero:");
			showHero();
			System.out.print("\n");
			int input=0;
			try
			{
				input=s.nextInt()-1;//The pos 1 is the index 0 in slots.
			}
	        catch(Exception e)
	        {
				System.out.println("Please input a vaild number!");
				IO.clearconsole();
				IO.pressEnterToContinue();
				return chooseHero();
	        }  
			if(input<0){
				System.out.println("Please input a vaild number!");
				IO.clearconsole();
				IO.pressEnterToContinue();
				return chooseHero();
	        } 
				if(heroes[input]!=null) return heroes[input];
				else {
					System.out.println("That position is empty in the hero list!");
					return chooseHero();
		}
	}
//Trigger for a new hero to join
	public void checkBouns() {
		if (score>20000&&!herobouns) {
		    System.out.print("\033[0;32m");
			System.out.println("Hearing your adventrue, a Bounty Hunter named Genshin is willing to take risks with you, and you embark on a journey of adventure in "+this.map.getMaptype());
			System.out.println("Genshin has joined the team!");
		    System.out.print("\033[0;0m");
		    this.heroes[2]=new genshin();
		    herobouns=true;
		}
	}
//Trigger for the final boss battle
	public void checkBoss() {
		if (score>50000&&!boss) {
			boss=true;
		}
	}
	
}

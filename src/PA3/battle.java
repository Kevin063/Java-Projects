package PA3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class battle {
	protected map map;
	protected LinkedList<hero> heroes;
	protected LinkedList<monster> monster;
	protected hero[] heroslot;
	protected monster[] monsterslot;
	protected int scorevalue;
	protected boolean escape=false;
	public battle(hero[] h, LinkedList<monster> monster, map m, int score) {
		this.heroes=new LinkedList<hero>(Arrays.asList(h));
		this.monster=generateMonster(m, score);
		heroslot=new hero[3];//The default battlesize;
		monsterslot=new monster[m.getBattlesize()];
		heroslot=new hero[m.getBattlesize()];
	}
	public battle(hero[] h, map m, int score) {
		this(h, generateMonster(m, score), m, score);
	}
	//Start a battleround
	public boolean startRound() {
		showStats();
	    System.out.print("\033[0;32m");
		System.out.println("Your turn!");
	    System.out.print("\033[0;0m");	
		for (int i=0;i<heroslot.length;i++) {
			if(heroslot[i]!=null) {
				System.out.println("Turn for Hero "+heroslot[i].getName()+".");
				heroAction(heroslot[i]);
				if(escape) {//Escape gives no score
					this.scorevalue=0;
					return true;
			}
		}
		}
		if (winCheck(true)) return false;
		else if (winCheck(false)) return true;
		else return startRound();
	}
	//Read action for a hero
	public void heroAction(hero h) {
		System.out.println(
				"• A : Attack a monster\r\n"
				+ "• S: Check your spellbook\r\n"
				+ "• R: Rest for the turn\r\n"
				+ "• E: Try to escape from the battle\r\n"
				+ "• I: show information");
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
        switch(input) {
        case("A"):{
        	monster target=monsterslot[readTarget(false)];
        	break;
        }
        case("S"):{
        	break;
        	}
        case("R"):{
        	break;
        }
        case("E"):{
        	if(Math.random()<this.map.getEscapeChance()) {
        	    escape=true;
        		System.out.print("\034[0;32m");
        		System.out.println("Your team successfully escape the battle!");
        	    System.out.print("\034[0;0m");
        	}
        	else {
        	    System.out.print("\031[0;32m");
        		System.out.println("Your attempt to escape fails!");
        	    System.out.print("\031[0;0m");	
        	}
        	break;
        }
        case("I"):{
        	showStats();
        	heroAction(h);
        }
        default:{
			System.out.println("Please input a valid action!");
			heroAction(h);
        }
	}
	}
	//Read a target, 1 for the hero team, 0 for the monster team
	public int readTarget(boolean type) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the position that you are targetting:");
		int input=s.nextInt();
		if(type) {
			if(heroslot[input]!=null) return input;
			else {
				System.out.print("That position is empty in the heroes' team!");
				return readTarget(type);
			}
		}
		else {
			if(monsterslot[input]!=null) return input;
			else {
				System.out.print("That position is empty in the monsters' team!");
				return readTarget(type);
			}
		}
	}
	//Show stats of the both side
	public void showStats() {
		System.out.println("|----------|--------------|----------|--------|");
		System.out.println("| Position |     Hero     |    HP    |   MP   |");
		System.out.println("|----------|--------------|----------|--------|");
		for (int i=0;i<heroslot.length;i++) {
			if(heroslot[i]!=null) {
				System.out.printf("|    "+i+"     | %12s | %8d | %6d |\n", heroslot[i].getName(), heroslot[i].getHP(), heroslot[i].getMP());
			}
		}
		System.out.println("|----------|--------------|----------|");
		//Now print for monsters
		System.out.println("|----------|--------------|----------|");
		System.out.println("| Position |    Monster   |    HP    |");
		System.out.println("|----------|--------------|----------|");
		for (int i=0;i<heroslot.length;i++) {
			if(heroslot[i]!=null) {
				System.out.printf("|    "+i+"     | %12s | %8d |\n", monsterslot[i].getName(), monsterslot[i].getHP());
			}
		}
		System.out.println("|----------|--------------|----------|");
	}
	//Try to draw a character into the battle filed, type=0 for monster, type=1 for hero
	public boolean enterBattle(boolean type, int slot) {
		if(type) {
			if (heroes.isEmpty()) return false;
			else {
				heroslot[slot]=heroes.pop();
				System.out.println("Hero "+(heroslot[slot].getName())+" has entered the battle!");
				return true;
			}
		}
		else {
			if (monster.isEmpty()) return false;
			else {
				monsterslot[slot]=monster.pop();
				System.out.println("A"+(monsterslot[slot].getName())+" has entered the battle!");
				return true;
			}
		}
	}
	//Check whether a team is all eliminated, type=0 for monster, type=1 for hero
	public boolean winCheck(boolean type) {
		if(type) {
		    for (hero h: heroslot) {
		        if (h != null) {
		            return false;
		        }
		    }
		    System.out.println("Everyone is dead or gone. This story is over.");
		    return true;
		}
		else {
		    for (monster m: monsterslot) {
		        if (m != null) {
		            return false;
		        }
		    }
		    System.out.println("All monsters are eliminated, you win the battle!");
		    return true;
		}
	}
	//Generate a group of monster, based on the game configs
	public static LinkedList<monster> generateMonster(map m, int score){
		LinkedList<monster> monsterlist=new LinkedList<monster>();
		return monsterlist;
	}
}

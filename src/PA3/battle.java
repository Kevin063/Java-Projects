package PA3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class battle {
	protected LinkedList<hero> heroes;
	protected LinkedList<monster> monster;
	protected hero[] heroslot;
	protected monster[] monsterslot;
	public battle(hero[] h, LinkedList<monster> monster, map m, int score) {
		this.heroes=new LinkedList<hero>(Arrays.asList(h));
		this.monster=generateMonster(m, score);
		heroslot=new hero[3];//The default battlesize;
		monsterslot=new monster[m.getBattlesize()];
		heroslot=new hero[m.getBattlesize()];
	}
	public battle 
	//Start a battleround
	public boolean startround() {
		showStats();
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		
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
	public boolean enterbattle(boolean type, int slot) {
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
	public boolean wincheck(boolean type) {
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

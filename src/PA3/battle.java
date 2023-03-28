package PA3;

import java.util.Arrays;
import java.util.Iterator;
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
	public battle(hero[] h, LinkedList<monster> monster, int size, int score) {
		this.monster=monster;
		this.heroes=new LinkedList<hero>(Arrays.asList(h));
		monsterslot=new monster[size];
		heroslot=new hero[size];
		scorevalue=calculateScoreValue();
		for (int i=0;i<size;i++) {
			enterBattle(true,i);
			enterBattle(false,i);
		}
	}
	public battle(hero[] h, map m, int score) {
		this(h, generateMonster(m, score), m.getBattlesize(), score);
		this.map=map;
	}
	//Start a battleround
	public boolean startRound() {
		showStats();
		IO.clearconsole();
		IO.pressEnterToContinue();
	    System.out.print("\033[0;32m");
		System.out.println("Your turn!");
	    System.out.print("\033[0;0m");	
		for (int i=0;i<heroslot.length;i++) {//Hero's round
			if(heroslot[i]!=null) {
				System.out.println("Turn for Hero "+heroslot[i].getName()+".");
				heroAction(heroslot[i]);
				if(escape) {//Escape gives no score
					this.scorevalue=0;
					return true;
			}
				if (winCheck(false)) return true;
		}
		}
	    System.out.print("\033[0;31m");
		System.out.println("Monster's turn!");
	    System.out.print("\033[0;0m");
		for (int i=0;i<monsterslot.length;i++) {//Monster's round
			if(monsterslot[i]!=null) {
				System.out.println("Turn for Monster "+monsterslot[i].getName()+".");
				int victim=findTarget();
				attack a=new attack(monsterslot[i],heroslot[victim]);
	        	a.apply();
	        	if(!heroslot[victim].checkAlive()) {
	        	    System.out.print("\033[0;31m");
	        	    IO.clearconsole();
	        		System.out.println(heroslot[victim].getName()+" is killed!");
	        	    System.out.print("\033[0;0m");	
	        	    heroslot[victim]=null;
	        	    enterBattle(true,victim);
	        	}
				if (winCheck(true)) return false;
		}
		}
		return startRound();
	}
	//Read action for a hero
	public void heroAction(hero h) {
		IO.clearconsole();
		System.out.println(
				"• a/A: Attack a monster\r\n"
				+ "• s/S: Check your spellbook\r\n"
				+ "• r/R: Rest for the turn\r\n"
				+ "• e/E: Try to escape from the battle\r\n"
				+ "• i/I: show information");
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
        switch(input) {
        case("a"):
        case("A"):{
        	int pos=readTarget(false);
        	monster target=monsterslot[pos];
        	attack a=new attack(h,target);
        	a.apply();
        	if(!target.checkAlive()) {
        	    System.out.print("\033[0;31m");
        	    IO.clearconsole();
        		System.out.println(target.getName()+" is killed!");
        	    System.out.print("\033[0;0m");	
        	    h.earnGold(target.getvalue());
        	    h.earnExp(target.getvalue());
        	    monsterslot[pos]=null;
        	    enterBattle(false,pos);
        	}
        	break;
        }
        case("s"):
        case("S"):{
        	spell sp=h.getInv().getSpellBook().openBook(h);
        			if(sp==null) heroAction(h);//If quit spellbook
        			else {
        				if(sp.getSpellType()) {
        					sp.cast(heroslot[readTarget(true)]);
        				}
        				else {
            				if(sp.getSpellType()) {
            					sp.cast(heroslot[readTarget(true)]);
        				}
        			}
        			}
        	break;
        	}
        case("r"):
        case("R"):{
    	    System.out.print("\033[0;32m");
    		System.out.println(h.getName()+" has taken a rest.");
    	    System.out.print("\033[0;0m");	
        	break;
        }
        case("e"):
        case("E"):{
        	if(Math.random()<this.map.getEscapeChance()) {
        	    escape=true;
        		System.out.print("\033[0;34m");
        		System.out.println("Your team successfully escape the battle!");
        	    System.out.print("\033[0;0m");
        	}
        	else {
        	    System.out.print("\033[0;31m");
        		System.out.println("Your attempt to escape fails!");
        	    System.out.print("\033[0;0m");	
        	}
        	break;
        }
        case("i"):
        case("I"):{
        	showStats();
        	heroAction(h);
        }
        default:{
			System.out.println("Please input a valid action!");
			heroAction(h);
        }
	}
       IO.pressEnterToContinue();
	}
	//Read a target, 1 for the hero team, 0 for the monster team
	public int readTarget(boolean type) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the position that you are targetting:");
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
			return readTarget(type);
        }  
		if(input<0){
			System.out.println("Please input a vaild number!");
			IO.clearconsole();
			IO.pressEnterToContinue();
			return readTarget(type);
        } 
		if(type) {
			if(heroslot[input]!=null) return input;
			else {
				System.out.println("That position is empty in the heroes' team!");
				return readTarget(type);
			}
		}
		else {
			if(monsterslot[input]!=null) return input;
			else {
				System.out.println("That position is empty in the monsters' team!");
				return readTarget(type);
			}
		}
	}
	//Randomly choose a hero as the monster's target
	public int findTarget() {
		int number=0;
		for (int i=0;i<heroslot.length;i++) {
			if(heroslot[i]!=null) {
				number++;			}
		}
		return ((int)(Math.random()*100))%number;
	}
	//Show stats of the both side
	public void showStats() {
		System.out.println("|----------|--------------|----------|--------|");
		System.out.println("| Position |     Hero     |    HP    |   MP   |");
		System.out.println("|----------|--------------|----------|--------|");
		for (int i=0;i<heroslot.length;i++) {
			if(heroslot[i]!=null) {
				System.out.printf("|    "+(i+1)+"     | %12s | %8d | %6d |\n", heroslot[i].getName(), heroslot[i].getHP(), heroslot[i].getMP());
			}
		}
		System.out.println("|----------|--------------|----------|--------|");
		//Now print for monsters
		System.out.println("|----------|--------------|----------|");
		System.out.println("| Position |    Monster   |    HP    |");
		System.out.println("|----------|--------------|----------|");
		for (int i=0;i<monsterslot.length;i++) {
			if(monsterslot[i]!=null) {
				System.out.printf("|    "+(i+1)+"     | %12s | %8d |\n", monsterslot[i].getName(), monsterslot[i].getHP());
			}
		}
		System.out.println("|----------|--------------|----------|");
	}
	//Try to draw a character into the battle filed, type=0 for monster, type=1 for hero
	public boolean enterBattle(boolean type, int slot) {
		if(type) {
			if (heroes.isEmpty()) return false;
			else {
				hero h=heroes.pop();
				if(h==null) return false;
				heroslot[slot]=h;
				System.out.println("Hero "+(heroslot[slot].getName())+" has entered the battle!");
				return true;
			}
		}
		else {
			if (monster.isEmpty()) return false;
			else {
				monster m=monster.pop();
				if(m==null) return false;
				monsterslot[slot]=m;
				System.out.println("A "+(monsterslot[slot].getName())+" has entered the battle!");
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
		while(score>=2000) {
			monster[]pool= {new globlin(),new globlinpikeman(),new gaintgloblin(),new lancer(),new centipede(), new scyther()};
			int rand=(int)(Math.random()*100)%pool.length;
			if(pool[rand].getvalue()*10>score) continue;//If the monster is too strong
			else {
				monsterlist.add(pool[rand]);
				score-=pool[rand].getvalue()*10;
			}
		}
		return monsterlist;
	}
	//Calculate the scorevalue for a battle
	public int calculateScoreValue() {
		Iterator<monster> it=this.monster.iterator();
		int s=0;
		while(it.hasNext()) {
			s+=it.next().getvalue();
		}
		return s;
	}
	//Getter for scorevalue
	public int getScorevalue() {
		return this.scorevalue;
	}
}

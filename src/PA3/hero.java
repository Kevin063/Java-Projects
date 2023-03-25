package PA3;

import java.util.Scanner;

public abstract class hero extends character {
	protected int gold;
	protected inventory inv;
	protected int exp;
	//Restore all HP and MP for a hero
	public void refresh() {
		this.setHP(this.getMaxHP());
		this.setMP(this.getMaxMP());
	}
	//Earn Exp from battle
	public void earnExp(int amount) {
		exp=exp+amount;
		checkupgrade();
	}
	//Check whether exp is enough used for upgrading, if so, do this and get stats enhanced.
	public void checkupgrade() {
		if(exp>level*100) {
			exp-=level*100;
			level++;
			System.out.println("Hero "+this.getName()+" has upgraded to level "+this.getLevel()+"!");
			setMaxHP((int)(getMaxHP()*(1+0.1*Math.random())));
			setMaxMP((int)(getMaxMP()*(1+0.1*Math.random())));
			setStrength((int)(getStrength()*(1+0.1*Math.random())));
			setDexterity((int)(getDexterity()*(1+0.1*Math.random())));
			setAgility((int)(getAgility()*(1+0.1*Math.random())));
			refresh();
			checkupgrade();
		}
	}
	//Read the starting hero from the player
	public hero readHero() {
		IO.clearconsole();
	    int inChar;
	    System.out.println("Enter a starting hero to begin your adventure, you can recurit more heroes to your team in the future.");
	    System.out.print("\033[0;32m");
	    System.out.println("1. Pathfinder");
	    System.out.print("\033[0;0m");
	    System.out.println("[Pathfinder is the picture of optimism, despite his circumstances. A MRVN (Mobile Robotic Versatile eNtity) with a talent for location scouting and surveying, he booted up decades ago in an abandoned warehouse with no idea who created him or why. With only his MRVN designation to hint at his identity]");
	    System.out.println("Heirloom: Pathfinder has a retractable and reusable grappling hook, which allow his whole team quickly transfer from the wild back to a safe settlement.");
	    System.out.print("\033[0;33m");
	    System.out.println("2. Kings Canyon");
	    System.out.print("\033[0;0m");
	    System.out.println("[Covered by countless rock roofs, adventurers come to Kings Canyon for treasures and golds.]");
	    System.out.print("\033[0;31m");
	    System.out.println("3. Strom Point");
	    System.out.print("\033[0;0m");
	    System.out.println("The strom point is designed to be unfair. Huge threats will crash upon you without mercy. Only for players who want to struggle to survive.");
		Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		System.out.flush();
		map map;
        switch(input) {
        case("1"):{
        	map=new olympus(); 
        	break;
        }
        case("2"):{
        	map=new kingscanyon();
        	break;
        	}
        case("3"):{
        	map=new stormpoint();
        	break;
        }
        default:{
			System.out.println("Please input a valid map number!");
			return readmap();
        }
        }
        System.out.println("World generating...");
        try {
			Thread.sleep(1000);//Simulate the world generation....
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        map.printMap();
        System.out.println("\nThe world generation complete!");
        IO.pressEnterToContinue();
        return map;
	}
	// Getter and setter for gold
	public int getGold() {
	    return gold;
	}
	public void setGold(int gold) {
	    this.gold = gold;
	}
	// Getter and setter for inventory
	public inventory getInv() {
	    return inv;
	}
	public void setInv(inventory inv) {
	    this.inv = inv;
	}
	// Getter and setter for exp
	public int getExp() {
	    return exp;
	}
	public void setExp(int exp) {
	    this.exp = exp;
	}
}

package PA3;

import java.util.Scanner;

public abstract class hero extends character {
	protected int gold;
	protected inventory inv;
	protected int exp;
	protected weapon weapon;
	protected armour armour;
	//Earn Exp from battle
	public void earnExp(int amount) {
		exp=exp+amount;
		checkupgrade();
	}
	//Check whether exp is enough used for upgrading, if so, do this.
	public void checkupgrade() {
		if(exp>level*100) {
			exp-=level*100;
			level++;
			upgrade();
			checkupgrade();
		}
	}
	//Get stats enhanced
	public void upgrade() {
		setMaxHP((int)(getMaxHP()*(1+0.1*Math.random())));
		setMaxMP((int)(getMaxMP()*(1+0.1*Math.random())));
		setStrength((int)(getStrength()*(1+0.1*Math.random())));
		setDexterity((int)(getDexterity()*(1+0.1*Math.random())));
		setAgility((int)(getAgility()*(1+0.1*Math.random())));
		refresh();
		System.out.println("Hero "+this.getName()+" has upgraded to level "+this.getLevel()+"!");
	}
	//Read the starting hero from the player
	public static hero readHero() {
		IO.clearconsole();
	    int inChar;
	    System.out.println("Enter a starting hero to begin your adventure, you can recurit more heroes to your team in the future.");
	    System.out.print("\033[0;34m");
	    System.out.println("1. Pathfinder");
	    System.out.print("\033[0;0m");
	    System.out.println("[Pathfinder is the picture of optimism, despite his circumstances. A MRVN (Mobile Robotic Versatile eNtity) with a talent for location scouting and surveying, he booted up decades ago in an abandoned warehouse with no idea who created him or why. With only his MRVN designation to hint at his identity]");
	    System.out.print("\033[0;31m");
	    System.out.println("Heirloom: Pathfinder has a retractable and reusable grappling hook in his inventory, which allow his whole team quickly transfer from the wild back to a safe settlement.");
	    System.out.print("\033[0;34m");
	    System.out.println("2. Revenant");
	    System.out.print("\033[0;0m");
	    System.out.println("[Revenant used to be human. He used to be the greatest hitman the Mercenary Syndicate ever had. He used to look in the mirror and see his human face looking back. His masters resurrected him as a simulacrum, snatching him from death’s embrace again and again and programming him to forget.]");
	    System.out.print("\033[0;31m");
	    System.out.println("Dattlerate: Revenant can use its undead soul to escape from the spirit world, and it is immune to the first fatal damage per battle.");
	    System.out.print("\033[0;34m");
	    System.out.println("3. Blood Hound");
	    System.out.print("\033[0;0m");
	    System.out.println("[Blood hound is known across the Outlands as one of the greatest game hunters the Frontier has ever seen. Bloodhound believes that destiny is a path that has already been laid out, eventually carrying all to their death.]");
	    System.out.print("\033[0;31m");
	    System.out.println("Raven's Bite: Blood hound hunts down enemies with his hextech scythe. He is born with a weapon that can always hit the enemy's weak point, and this weapon will also grow as the master's level increases. But at the same time, the Blood hound cannot be equipped with other weapons, only to let Raven's Bite CONSUME their power.");
	    System.out.print("\033[0;0m");
	    Scanner s=new Scanner(System.in);
		String input=s.nextLine();
		System.out.flush();
		hero h;
        switch(input) {
        case("1"):{
        	h=new pathfinder();
        	break;
        }
        case("2"):{
        	h=new revenant();
        	break;
        	}
        case("3"):{
        	h=new bloodhound();
        	break;
        }
        default:{
			System.out.println("Please input a valid map number!");
			return readHero();
        }
        }
        System.out.println("This is your Champion: ");
        h.printStats();
        IO.pressEnterToContinue();
        return h;
	}
	//Class for displaying a hero's stats
	public void printStats() {
	    System.out.println("+------------------------+");
	    System.out.println("|    Hero Information    |");
	    System.out.println("+------------------------+");
	    System.out.printf("| %-10s: %10s |\n", "Name", name);
	    System.out.printf("| %-10s: %10d |\n", "Level", level);
	    System.out.printf("| %-10s: %10d |\n", "Max HP", maxHP);
	    System.out.printf("| %-10s: %10d |\n", "Max MP", maxMP);
	    System.out.printf("| %-10s: %10d |\n", "HP", HP);
	    System.out.printf("| %-10s: %10d |\n", "MP", MP);
	    System.out.printf("| %-10s: %10d |\n", "Strength", strength);
	    System.out.printf("| %-10s: %10d |\n", "Dexterity", dexterity);
	    System.out.printf("| %-10s: %10d |\n", "Agility", agility);
	    System.out.printf("| %-10s: %10d |\n", "Gold", gold);
	    System.out.printf("| %-10s: %10d |\n", "Experience", exp);
	    System.out.printf("| %-10s: %10s |\n", "Weapon", weapon == null ? "Unequiped" : weapon.getName());
	    System.out.printf("| %-10s: %10s |\n", "Armour", armour == null ? "Unequiped" : armour.getName());
	    System.out.println("+------------------------+");
	}
	// Getter and setter for gold
	public int getGold() {
	    return gold;
	}
	public void setGold(int gold) {
	    this.gold = gold;
	}
	//Earn gold
	public void earnGold(int gold) {
		this.gold+=gold;
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
	// Get the name for the weapon
	public String getWeapon() {
		if(this.armour==null) return "fist";
		else return this.weapon.getName();
	}
	//Get the weapon damage
	public int getWeaponDamage() {
		if(this.weapon==null) return 0;
		else return this.weapon.getDamage();
	}
	//Get the armor defend
	public int getArmourDefend() {
		if(this.armour==null) return 0;
		else return this.armour.getDefend();
	};
}

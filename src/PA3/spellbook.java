package PA3;
//Class for a spell book in inventory
import java.util.Scanner;

public class spellbook extends inventory {
	item[] inventory;
	public spellbook(item[] inv) {
		super();
		this.inventory=inv;
		int pointer=0;
		for(int i=0;i<inv.length;i++) {
			if(inv[i]!=null&&(inv[i].getType()=="spell")) {
				this.inv[pointer]=inv[i];
				pointer++;
			}
		}
	}
	public spell openBook(hero h) {
		showBook();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the spell that you are using, enter 0 to quit spellbook:");
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
			return openBook(h);
        }
		if(input<=-1) return null;
		if(this.inv[input]==null) {
			System.out.println("That position is empty in the hero's spellbook!");
			openBook(h);
		}
		else {
			if(h.getMP()<((spell)this.inv[input]).getCost()) {
				System.out.print("\033[0;31m");
				System.out.println("No enough MP to cast!");
				System.out.print("\033[0;0m");
				openBook(h);
			}
			else{
				spell sp=(spell)this.inv[input];
				removeSpell(sp);
				return sp;
			}
		}
		return null;
		
	}
	//Display the book in console
	public void showBook() {
        System.out.println("+----------+----------------------+------------+");
        System.out.println("| Position | Spell                | Cost       |");
        System.out.println("+----------+----------------------+------------+");
        for (int i=0;i<this.inv.length;i++) {
        	if(this.inv[i]!=null) {
	            System.out.printf("| %8d | %-20s | %5d mana |\n", i+1, this.inv[i].getName(), ((spell)this.inv[i]).getCost());
        	}
        }
        System.out.println("+----------+----------------------+------------+");
	}
	//Remove a spell used in from inventory
	public void removeSpell(spell sp) {
		for (int i=0;i<this.inventory.length;i++) {
			if(inventory[i]==sp) inventory[i]=null;
		}
	}
	
}

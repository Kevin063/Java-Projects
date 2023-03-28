package PA3;

import java.util.Scanner;

//Class for inventory and display
public class inventory {
	item[] inv;
	int capacity=100;//Default max item number
	int num=0;//Total number of items
	public inventory() {
		inv=new item[capacity];
	}
	//Put an item into the inventory
	public void putitem(item i) {
		if(num==capacity) System.out.println("The inventory is full! You will lose your loots.");
		else {
			inv[num]=i;
			num++;
			
		}
	} 
	//Get an item from the given slot
	public item getitem (int slot) {
		return inv[slot];
	}
	//Use an item in the given slot
	public boolean useitem(int slot) {
		if (checkslot(slot)) {
			return true;
		}
		else {
			IO.setRed();
			System.out.println("No item in this inventory slot! Please specify a existing item.");
			IO.resetColor();
			return false;
		}
	}
	//Print a hero's inventory
	public void printinventory() {
		String frametop= 
				"╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n"
              + "║                                                            Inventory                                                      ║\n"
              + "╠══════════════╦═══════════════════╦════════════════════════════════════════════════════════════════════════════════════════╣\n"
              + "║     Slot     ║       Item        ║                                     Description                                        ║\n"
              + "╠══════════════╬═══════════════════╬════════════════════════════════════════════════════════════════════════════════════════╣\n";
		String framebot=
				"╚══════════════╩═══════════════════╩════════════════════════════════════════════════════════════════════════════════════════╝";
		System.out.print(frametop);
		for(int i=0;i<capacity;i++) {
			if(inv[i]!=null) {
				System.out.print("║       " + (i+1) + String.format("%"+(6-(int)Math.log10(i+2))+"s", "") +
		                   "║       " + inv[i].getName()+ String.format("%"+(12-(inv[i].getName().length()))+"s", "") +
		                   "║ " + inv[i].getDescription() + String.format("%"+(87-inv[i].getDescription().length())+"s", "") + "║\n");
			}
		}
		System.out.println(framebot);
	}
	//Check whether a slot in bag has item
	public boolean checkslot(int i) {
		return (inv[i]!=null);
	}
	//Get spellbook from the inventory
	public spellbook getSpellBook(){
		spellbook spellBook=new spellbook(inv);
		return spellBook;
	}
	//Fill the inventory with random items, used for market pool
	public void fillInv() {
		item[] pool= {new flakjacket(),new flakvest(),new marinearmour(),new platearmour()
				,new fireball(),new frostnova(),new quickheal(),new healingtouch(),new meteorite()
				,new autopistol(),new breachaxe(),new pickaxe(),new pumpshotgun(),new sniperrifle()};
		for(int i=0;i<5;i++) {
			int rand=(int) (((int)1000*Math.random())%(pool.length));
			putitem(pool[rand]);
		}
	}
	//Open inventory
	public void open(hero h) {
		printinventory();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the item that you are using, enter 0 to quit spellbook:");
		int input=0;
		try
		{
			input=s.nextInt()-1;//The pos 1 is the index 0 in slots.
		}
        catch(Exception e)
        {
        	IO.setRed();
			System.out.println("Please input a vaild number!");
			IO.resetColor();
			IO.clearconsole();
			IO.pressEnterToContinue();
			open(h);
			return;
        }
		if(input<=-1) return ;
		if(this.inv[input]==null) {
			IO.setRed();
			System.out.println("That position is empty in the hero's Inventory!");
			IO.resetColor();
			open(h);
			return;
		}
		else {
			if(!this.inv[input].getUsable()) {
				IO.setRed();
				System.out.println("It's not a usable item outside of battle!");
				IO.resetColor();
				IO.pressEnterToContinue();
				open(h);
				return;
			}
			else{
				((usable)this.inv[input]).use(h);
				this.inv[input]=null;
				open(h);
				return;
			}
		}
	}
}

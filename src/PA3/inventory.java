package PA3;
//Class for inventory
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
			System.out.println("No item in this inventory slot! Please specify a existing item.");
			return false;
		}
	}
	public void printinventory() {
		String frametop= 
				 "╔══════════════════════════════════╗\n"
              + "║           Leaderboard            ║\n"
              + "╠══════════════╦═══════════════════╣\n"
              + "║     Slot     ║       Item        ║\n"
              + "╠══════════════╬═══════════════════╣\n";
		String framebot="╚══════════════╩═══════════════════╝";
		System.out.print(frametop);
		for(int i=0;i<capacity;i++) {
			if(inv[i]!=null) {
				System.out.print("║   "+(i+1)+String.format("%"+(11-Math.log10(i+1))+"s", "")+
						"║       "+inv[i].getName()+String.format("%"+(11-inv[i].getName().length())+"s", "")+"║\n");
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
}

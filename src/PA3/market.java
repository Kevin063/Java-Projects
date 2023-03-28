package PA3;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

//Class for supporting the market interactions
public class market {
	int marketSize=10;//default=10
	inventory pool;
	market(){
		pool =new inventory();
		pool.fillInv();
	}
	public void printmarket() {
		String frametop= 
				"╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n"
              + "║                                                                  Market                                  					 ║\n"
              + "╠══════════════╦═════════════════════════════╦════════════════════════════════════════════════════════════════════════════════════════╦═══════════════════╣\n"
              + "║     Slot     ║            Item             ║                                     Description                                        ║       Price       ║ \n"
              + "╠══════════════╬═════════════════════════════╬════════════════════════════════════════════════════════════════════════════════════════╬═══════════════════╣\n";
		String framebot=
				"╚══════════════╩═════════════════════════════╩════════════════════════════════════════════════════════════════════════════════════════╩═══════════════════╝";
		System.out.print(frametop);
		for(int i=0;i<pool.capacity;i++) {
			if(pool.inv[i]!=null) {
				System.out.print("║       " + (i+1) + String.format("%"+(6-(int)Math.log10(i+2))+"s", "") +
		                   "║       " + pool.inv[i].getName()+ String.format("%"+(22-(pool.inv[i].getName().length()))+"s", "") +
		                   "║ " + pool.inv[i].getDescription() + String.format("%"+(87-pool.inv[i].getDescription().length())+"s", "") +
		                   "║       " + (pool.inv[i].getValue()) + String.format("%"+(11-(int)Math.log10(pool.inv[i].getValue()+1))+"s", "") +"║\n");
			}
		}
		System.out.println(framebot);
	}
	//Generate a message when player meet a market
	public static String encounterMessage(map m) {
		switch(m.getMaptype()) {
		case("KingsCanyon"):{
			return("You found a friendly settlement for an Imperial Expeditionary Stronghold.");
		}
		case("Olympus"):{
			return "At the end of the stone road, you find a village inhabited by humans. The residents warmly welcome you and are willing to trade with you.";
		}
		case("StormPoint"):{
			return "In the caverns of the Storm Peaks, you find a settlement inhabited by a tribe of dwarves.";
		}
		default: return "Your found a opened market.";
		}
	}
	//Enter a market
	public void entermarket(map m, hero h) {
		IO.pressEnterToContinue();
		printmarket();
		shopping(h);
	}
	//Shopping at a market
	public void shopping(hero h) {
		Scanner s=new Scanner(System.in);
		IO.setGreen();
		System.out.println("You have "+h.getGold()+" Golds now.");
		IO.setBlue();
		System.out.println("Enter the item slot that you want to buy, enter 0 to quit:");
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
			shopping(h);
			return;
        }  
		if(input==-1) return;
		if(input<0){
			System.out.println("Please input a vaild number!");
			IO.clearconsole();
			IO.pressEnterToContinue();
			shopping(h);
			return;
        } 
			if(pool.inv[input]!=null) {
				if(pool.inv[input].getValue()>h.getGold()){
					System.out.println("You don't have enough gold!");
					IO.clearconsole();
					IO.pressEnterToContinue();
					shopping(h);
					return;
				}
				else{
					buy(h,pool.inv[input]);
					pool.inv[input]=null;
					shopping(h);
				}
			}
			else {
				System.out.println("That position is empty in the market");
				IO.clearconsole();
				IO.pressEnterToContinue();
				shopping(h);
				return;
			}
	}
	public void buy(hero h, item i) {
		IO.setBlue();
		System.out.println("A "+i.getName()+" has been placed into "+h.getName()+"'s inventory.");
		h.setGold(h.getGold()-i.getValue());
		h.getItem(i);
		IO.pressEnterToContinue();
	}
}

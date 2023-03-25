package PA3;

import java.util.Iterator;
import java.util.Map;

//Class for supporting the market interactions
public class market {
	int marketSize=10;//default=10
	item[] inventory;
	market(){
		inventory=new item[marketSize];
	}
	public void printmarket() {
		String frametop= 
				 "╔══════════════════════════════════╗\n"
              + "║           Leaderboard            ║\n"
              + "╠══════════════╦═══════════════════╣\n"
              + "║   Player     ║      Score        ║\n"
              + "╠══════════════╬═══════════════════╣\n";
		String framebot="╚══════════════╩═══════════════════╝";
		System.out.print(frametop);
		for(int i=0;i<marketSize;i++) {
			if(inventory[i]!=null) {
				System.out.print("║   "+inventory[i].get+String.format("%"+(11-this.surname.length())+"s", "")+"║       "+this.bestscore+String.format("%"+(11-Math.log10(bestscore+1))+"s", "")+"║\n");
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
		case("stormPoints"):{
			return "In the caverns of the Storm Peaks, you find a settlement inhabited by a tribe of dwarves.";
		}
		default: return "Your found a opened market.";
		}
	}
}

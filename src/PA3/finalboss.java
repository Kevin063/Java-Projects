package PA3;
//The final boss stage for the game
import java.util.LinkedList;

public class finalboss extends battle{
	public finalboss(hero[] h) {
		super(h,new LinkedList<monster>(),3,0);
		this.map=new olympus();
		monster warick=new warick();
		LinkedList<monster> m=new LinkedList<monster>();
		m.add(warick);
		this.monster=m;
		scorevalue=calculateScoreValue();
		enterBattle(false,0);
		enterBattle(false,1);
	}
	//Start a battleround, has special effect in this boss battle
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
		double ra=Math.random();
			IO.setRed();
			System.out.println("Mecha:PRIME Warick summons a burnning meteorite!");
			IO.resetColor();
			int victimra=findTarget();
			spell mete=new meteorite();
			mete.cast(heroslot[victimra]);
        	if(!heroslot[victimra].checkAlive()) {
        	    System.out.print("\033[0;31m");
        	    IO.clearconsole();
        		System.out.println(heroslot[victimra].getName()+" is killed!");
        	    System.out.print("\033[0;0m");	
        	    heroslot[victimra]=null;
        	    enterBattle(true,victimra);
        	}
			if (winCheck(true)) return false;
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
}

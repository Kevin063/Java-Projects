package PA3;

import java.util.Arrays;
import java.util.LinkedList;
//The Tutorial battle for player to get familiar with the battle
public class tutorial extends battle {
	public tutorial(hero[] h) {
		super(h,new LinkedList<monster>(),3,0);
		monster jailer1=new globlin();
		monster jailer2=new globlin();
		LinkedList<monster> m=new LinkedList<monster>();
		m.add(jailer1);
		m.add(jailer2);
		this.monster=m;
		enterBattle(false,0);
		enterBattle(false,1);
	}
}

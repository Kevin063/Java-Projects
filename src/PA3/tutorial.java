package PA3;
//The Tutorial battle for player to get familiar with the battle
import java.util.Arrays;
import java.util.LinkedList;
public class tutorial extends battle {
	public tutorial(hero[] h) {
		super(h,new LinkedList<monster>(),3,0);
		this.map=new olympus();
		monster jailer1=new jailer();
		monster jailer2=new jailer();
		LinkedList<monster> m=new LinkedList<monster>();
		m.add(jailer1);
		m.add(jailer2);
		this.monster=m;
		enterBattle(false,0);
		enterBattle(false,1);
	}
}

package PA3;

public class quickheal extends spell {
	quickheal(){
	super();
	setName("quickHeal");
	setValue(50);
	setCost(20);
	setSpellType(true);
	setDescription("A spell that rapidly restores health to the target.");
	}
	public void cast(character c){
		int hp=c.getHP();
		c.setHP(Math.min(c.getHP()+50, c.getMaxHP()));
		System.out.println(c.getName()+" heals "+(c.getHP()-hp)+" HPs.");
		IO.pressEnterToContinue();
	}
}

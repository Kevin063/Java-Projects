package PA3;
//A spell that channels positive energy into the target, soothing their injuries and restoring their strength.
public class healingtouch extends spell {
	healingtouch(){
	super();
	setName("HealingTouch");
	setValue(200);
	setCost(150);
	setSpellType(true);
	setDescription("A spell that channels positive energy into the target.");
	}
	public void cast(character c){
		int hp=c.getHP();
		c.setHP(Math.min(c.getHP()+150, c.getMaxHP()));
		System.out.println(c.getName()+" heals "+(c.getHP()-hp)+" HPs.");
		IO.pressEnterToContinue();
	}
}

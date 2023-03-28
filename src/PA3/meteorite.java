package PA3;
//A destructively powerful black magic
public class meteorite extends spell {
	meteorite(){
	super();
	setName("Meteorite");
	setValue(500);
	setCost(200);
	setSpellType(false);
	setDescription("/A destructively powerful black magic");
	}
	public void cast(character c){
		int hp=c.getHP();
		c.setHP(Math.max(c.getHP()-200, 0));
		System.out.println(c.getName()+" get smashed by the meteorite and loss "+(hp-c.getHP())+" HPs.");
		IO.pressEnterToContinue();
	}
}

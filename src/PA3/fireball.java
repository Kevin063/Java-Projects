package PA3;
//An explosive sphere of flames that incinerates everything in its path.
public class fireball extends spell {
	fireball(){
	super();
	setName("FireBall");
	setValue(200);
	setCost(100);
	setSpellType(false);
	setDescription("An explosive sphere of flames that incinerates everything in its path.");
	}
	public void cast(character c){
		sound.playSound("sounds/fire.wav");
		int hp=c.getHP();
		c.setHP(Math.max(c.getHP()-60, 0));
		System.out.println(c.getName()+" get hit by the fireball and loss "+(hp-c.getHP())+" HPs.");
		IO.pressEnterToContinue();
	}
}

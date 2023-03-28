package PA3;
//An icy blast that freezes opponents in their tracks, dealing both damage and slowing their movement.
public class frostnova extends spell {
	frostnova(){
	super();
	setName("FrostNova");
	setValue(200);
	setCost(80);
	setSpellType(false);
	setDescription("An icy blast that freezes opponents in their tracks, dealing both damage and slowing their movement.");
	}
	public void cast(character c){
		sound.playSound("sounds/ice.wav");
		int hp=c.getHP();
		c.setHP(Math.max(c.getHP()-30, 0));
		System.out.println(c.getName()+" get hit by the frost and loss "+(hp-c.getHP())+" HPs.");
		c.setAgility(c.getAgility()-10);
		System.out.println(c.getName()+"'s Agility get nerfed!");
		IO.pressEnterToContinue();
	}
}

package PA3;

public class revenant extends hero {
	private boolean deathrattle;
	public revenant() {
		setName("Revenant");
		setMaxHP(500);
		setMaxMP(300);
		setLevel(1);
		setStrength(60);
		setDexterity(40);
		setAgility(30);
		setGold(0);
		setExp(0);
		setInv(new inventory());
		//Deafult items: flakjacket,pickaxe
		armour a=new flakjacket();
		this.getItem(a);
		this.equipArmour(a);
		weapon w=new pickaxe();
		this.getItem(w);
		this.equipWeapon(w);
		refresh();
	}
	//check whether the character is killed, Revenant can immune death once.
	public boolean checkAlive() {
		if(HP>0) return true;
		else {
			if (deathrattle){
				deathrattle=false;
				setHP(1);
				return true;
			}
			else return false;
		}
	}
	//Reset deathrattle once refresh HP
	public void refresh() {
		super.refresh();
		deathrattle=true;
	}
}

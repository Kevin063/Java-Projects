package PA3;

public class revenant extends hero {
	private boolean deathrattle;
	public revenant() {
		setName("pathfinder");
		setMaxHP(300);
		setMaxMP(200);
		setLevel(1);
		setStrength(20);
		setDexterity(50);
		setAgility(70);
		setGold(0);
		setExp(0);
		setInv(new inventory());
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
		this.refresh();
		deathrattle=true;
	}
}

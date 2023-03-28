package PA3;

public abstract class armour extends item implements usable{
	protected int defend;
	protected int agilityModifier;
	public armour() {
		setUsable(true);
		setType("armour");
		
	}
	//getter for the defend
	public int getDefend() {
		return defend;
	}
	//setter for the defend
	public void setDefend(int d) {
		this.defend=d;
	}
	//Getter for ag
	public int getAgilityModifier() {
	return agilityModifier;
	}
	//Setter for ag
	public void setAgilityModifier(int a) {
		this.agilityModifier=a;
		}
	public void use(hero h) {
		h.equipArmour(this);
	}
}

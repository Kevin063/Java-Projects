package PA3;

public abstract class armour extends item implements usable{
	protected int defend;
	protected int agilityModifier;
	public armour() {
		this.usable=true;
		
	}
	public int getDefend() {
		return defend;
	}
	public int getAgilityModifier() {
	return agilityModifier;
	}
}

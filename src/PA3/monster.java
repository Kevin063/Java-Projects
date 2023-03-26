package PA3;

public abstract class monster extends character {
	private int value;
	// Get the name for the weapon
	public String getWeapon() {
		return "fist";
	}
	//Get the weapon damage, default 0 for monster
	public int getWeaponDamage() {
		return 0;
	}
	//Get the armor defend, default 0 for monster
	public int getArmourDefend() {
		return 0;
	}
	//Get the gold value of the monster
	public abstract int getvalue();
}

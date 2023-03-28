package PA3;

public class weapon extends item {
	protected int damage;
	protected int dexterityModifier;
	protected weapon() {
		setUsable(true);
		setType("weapon");
	}
	//Getter for damage
	public int getDamage() {
		return damage;
	}
	//Setter for damage
	public void setDamage(int d) {
		this.damage=d;
	}
	//Getter for dex moder
	public int getDexterityModifier() {
	return dexterityModifier;
	}
	//Setter for dex moder
	public void setDexterityModifier(int d) {
	dexterityModifier=d;
	}
	//Equip this
	public void use(hero h) {
		h.equipWeapon(this);
	}
}

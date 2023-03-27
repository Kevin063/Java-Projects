package PA3;

public class globlinpikeman extends globlin {
	public globlinpikeman() {
		setName("Globlin Pikeman");
		setMaxHP(100);
		setMaxMP(0);
		setLevel(0);
		setStrength(15);
		setDexterity(30);
		setAgility(30);
		setValue(200);
		refresh();
	}
	public String getWeapon() {
		return "Pike Spear";
	}
}

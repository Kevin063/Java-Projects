package PA3;
//The final boss for this game!
public class warick extends monster {
	public warick() {
	setName("Mecha Warick");
	setMaxHP(5000);
	setMaxMP(5000);
	setLevel(99);
	setStrength(100);
	setDexterity(50);
	setAgility(50);
	setValue(5000);
	refresh();
	}
//Warick switch from three weapon moudles
	public String getWeapon() {
		double i=Math.random();
		if(i<0.5) return "Monosword";
		else if(i<0.75) return "Plasmasword";
		else return "Zeushammer";
	}
}

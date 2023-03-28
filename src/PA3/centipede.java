package PA3;
//Heavy combat platform
public class centipede extends mechanoid{
	public centipede() {
		super();
		setName("Centipede");
		setStrength(80);
		setDexterity(20);
		setAgility(0);
		
	}
	public String getWeapon() {
		return "Heavy Charge Blaster";
	}
}

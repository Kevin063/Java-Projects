package PA3;
//Fast human-sized combat mechanoid
public class lancer extends mechanoid {
	public lancer() {
		super();
		setName("Lancer");
		setStrength(30);
		setDexterity(30);
		setAgility(40);
		
	}
	public String getWeapon() {
		return "Charge Lance";
	}
}

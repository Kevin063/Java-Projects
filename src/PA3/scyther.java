package PA3;
//Fast, spindly, human-sized combat mechanoids 
public class scyther extends mechanoid {
	public scyther() {
		super();
		setName("Scyther");
		setStrength(40);
		setDexterity(10);
		setAgility(50);
		
	}
	public String getWeapon() {
		return "Arm Blade";
	}
}

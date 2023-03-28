package PA3;
//The weakest monster and have variants
public class globlin extends monster {
	public globlin() {
		setName("Globlin");
		setMaxHP(100);
		setMaxMP(0);
		setLevel(1);
		setStrength(20);
		setDexterity(20);
		setAgility(20);
		setValue(200);
		refresh();
	}
}

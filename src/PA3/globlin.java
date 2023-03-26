package PA3;
//The weakest monster
public class globlin extends monster {

	public globlin() {
		setName("globlin");
		setMaxHP(100);
		setMaxMP(0);
		setLevel(1);
		setStrength(20);
		setDexterity(20);
		setAgility(20);
		refresh();
	}
	public int getvalue() {
		return 100;
	}

}

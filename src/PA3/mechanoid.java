package PA3;
//A uniform monster group of mechanoids
public abstract class mechanoid extends monster {
	public mechanoid() {
		setName("Mechanoid");
		setMaxHP(500);
		setLevel(20);
		setValue(500);
		refresh();
	}
}

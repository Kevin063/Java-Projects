package PA3;

public class pathfinder extends hero {
	public pathfinder() {
		setName("pathfinder");
		setMaxHP(300);
		setMaxMP(200);
		setLevel(1);
		setStrength(25);
		setDexterity(50);
		setAgility(70);
		setGold(0);
		setExp(0);
		setInv(new inventory());
		this.inv.putitem(new quickheal());
		this.inv.putitem(new quickheal());
		refresh();
	}
}

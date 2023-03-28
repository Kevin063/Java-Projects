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
		//Deafult items: quickhealx2, autopistol
		this.getItem(new quickheal());
		this.getItem(new quickheal());
		weapon w=new autopistol();
		this.getItem(w);
		this.equipWeapon(w);
		refresh();
	}
}

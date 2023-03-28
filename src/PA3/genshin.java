package PA3;

public class genshin extends hero {
	public genshin() {
	setName("GenShin");
	setMaxHP(100);
	setMaxMP(100);
	setLevel(1);
	setStrength(10);
	setDexterity(20);
	setAgility(90);
	setGold(0);
	setExp(0);
	setInv(new inventory());
	refresh();
	//Deafult items: meteorite, pumpshotgun
	this.getItem(new meteorite());
	weapon w=new pumpshotgun();
	this.getItem(w);
	this.equipWeapon(w);
	
	}
}

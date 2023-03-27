package PA3;
//Hero that can roll a dice after each kill and earn extra money
public class twistedfate extends hero {
	public twistedfate() {
	setName("Twisted Fate");
	setMaxHP(300);
	setMaxMP(500);
	setLevel(1);
	setStrength(40);
	setDexterity(50);
	setAgility(50);
	setGold(1000);
	setExp(0);
	setInv(new inventory());
	refresh();
	}
	//Earn gold and roll a dice
	public void earnGold(int gold) {
		int amount=(int)(Math.random()*100);
		IO.setYellow();
		System.out.println("Twisted Fate rolls his lead dice and extra "+amount+" Golds.");
		IO.resetColor();
		this.gold+=gold+amount;
	}
}

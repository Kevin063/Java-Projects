package PA3;

public class bloodhound extends hero {
	ravensbite r;
	public bloodhound() {
		setName("Blood Hound");
		setMaxHP(400);
		setMaxMP(300);
		setLevel(1);
		setStrength(50);
		setDexterity(60);
		setAgility(40);
		setGold(0);
		setExp(0);
		setInv(new inventory());
		//Default items: Raven's Bite, healing touch
		this.getItem(new healingtouch());
		r=new ravensbite();
		equipWeapon(r);
		refresh();
	}
	//Check whether exp is enough used for upgrading, if so, do this.
	public void checkupgrade() {
		if(exp>level*100) {
			exp-=level*100;
			this.upgrade();
			level++;
			checkupgrade();
		}
	}
	//Get stats and his weapon enhanced
	public void upgrade() {
		setMaxHP((int)(getMaxHP()*(1+0.1*Math.random())));
		setMaxMP((int)(getMaxMP()*(1+0.1*Math.random())));
		setStrength((int)(getStrength()*(1+0.1*Math.random())));
		setDexterity((int)(getDexterity()*(1+0.1*Math.random())));
		setAgility((int)(getAgility()*(1+0.1*Math.random())));
		IO.setGreen();
		refresh();
		System.out.println("All HP and MP are restored!");
		this.r.upgrade();
		System.out.println("Hero "+this.getName()+", as well as his Raven's Bite, has upgraded to level "+this.getLevel()+"!");
		IO.resetColor();
	}
	public void equipweapon() {
		System.out.println("Raven's Bite has absorded the weapon's power!");
	}
}

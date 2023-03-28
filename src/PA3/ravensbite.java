package PA3;
//Bloodhound's weapon
public class ravensbite extends weapon {
	public ravensbite() {
		super();
	setName("Raven's Bite");
	setDescription("The trusty pickaxe dealing a solid strike to your enemies.");	
	setDamage(30);
	setDexterityModifier(99);
	setValue(5000);
	}
	public void upgrade() {
		setDamage((int)(getDamage()*(1+0.1*Math.random())));
	}
}

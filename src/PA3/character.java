package PA3;
//Abstract class for all chars
public abstract class character {
	protected String name;
	protected int level;
	protected int maxHP;
	protected int maxMP;
	protected int HP;
	protected int MP;
	protected int strength;
	protected int dexterity;
	protected int agility;
	public boolean takeDamage(int damage) {
		HP-=damage;
		return checkAlive();
	}
	//check whether the character is killed
	public boolean checkAlive() {
		return HP>0;
	}
	// Getter and setter for name
	public String getName() {
	    return name;
	}
	public void setName(String name) {
	    this.name = name;
	}
	// Getter and setter for level
	public int getLevel() {
	    return level;
	}
	public void setLevel(int level) {
	    this.level = level;
	}
	// Getter and setter for maxHP
	public int getMaxHP() {
	    return maxHP;
	}
	public void setMaxHP(int maxHP) {
	    this.maxHP = maxHP;
	}
	// Getter and setter for maxMP
	public int getMaxMP() {
	    return maxMP;
	}
	public void setMaxMP(int maxMP) {
	    this.maxMP = maxMP;
	}
	// Getter and setter for HP
	public int getHP() {
	    return HP;
	}
	public void setHP(int HP) {
	    this.HP = HP;
	}
	// Getter and setter for MP
	public int getMP() {
	    return MP;
	}
	public void setMP(int MP) {
	    this.MP = MP;
	}
	// Getter and setter for strength
	public int getStrength() {
	    return strength;
	}
	public void setStrength(int strength) {
	    this.strength = strength;
	}
	// Getter and setter for dexterity
	public int getDexterity() {
	    return dexterity;
	}
	public void setDexterity(int dexterity) {
	    this.dexterity = dexterity;
	}
	// Getter and setter for agility
	public int getAgility() {
	    return agility;
	}
	public void setAgility(int agility) {
	    this.agility = agility;
	}
}

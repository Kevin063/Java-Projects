package PA3;
//Class for all spells
public abstract class spell extends item {
	protected boolean spellType;//False for damage spell, True for heal spell.
	protected int cost;
	//Default constructor
	protected spell() {
		setType("spell");
	}
	//cast spell on c
	public void cast(character c) {}
	//Getter for type
	public boolean getSpellType() {
		return spellType;
		}
	//Setter for type
	public void setSpellType(boolean type) {
		this.spellType=type;
		}
	//Getter for cost
	public int getCost() {
		return cost;
	}
	//Setter for cost
	public void setCost(int cost) {
		this.cost=cost;
	}
	}
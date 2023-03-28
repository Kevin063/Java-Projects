package PA3;
//A suit of powered armor. Layered plasteel-weave plates are very effective at stopping attacks.
public class marinearmour extends armour {
	public marinearmour() {
	super();
	setName("Marine Arm");
	setDescription("Layered plasteel-weave plates are very effective at stopping attacks.");
	setDefend(150);
	setAgilityModifier(-40);
	setValue(5000);
}
}

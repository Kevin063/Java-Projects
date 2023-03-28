package PA3;
//Class for autoattack, be be used for attack between any character
public class attack {
	character attacker;
	character defender;
	boolean miss;
	String bodyPart;
	double DamageEfficiency;
	public attack(character attacker, character defender) {
			this.attacker=attacker;
			this.defender=defender;
			getBodyPart();
			boolean miss=Math.random()>(0.7+0.01*attacker.getDexterity()-0.01*defender.getAgility());
			if(Math.random()<0.002*attacker.getDexterity()) miss=false;//Attacker always have a chance to avoid miss
			DamageEfficiency*=1-0.002*defender.getAgility();//Defender always have a chance to mitigate damage
	}
	public void apply() {
		if(miss) {
    	    System.out.print("\033[0;31m");
    	    sound.playSound("sounds/miss.wav");
    		System.out.println(attacker.getName()+" attempt to use the "+attacker.getWeapon()+" hitting "+defender.getName()+"'s "+bodyPart+", but miss.");
    	    System.out.print("\033[0;0m");	
		}
		else {
    	    int damage=(int)((attacker.getWeaponDamage()+attacker.getStrength())*((double)100/(100+defender.getArmourDefend()))*this.DamageEfficiency);
    	    System.out.print("\033[0;31m");
    		System.out.print(attacker.getName()+" use the "+attacker.getWeapon()+" hitting "+defender.getName()+"'s "+bodyPart+", ");
    		if(DamageEfficiency>1) System.out.println("super effective!");
    		else System.out.println("not very effective...");
    		sound.playSound("sounds/hit.wav");
    		System.out.println(defender.getName()+" has taken "+damage+" damages.");
    	    System.out.print("\033[0;0m");
    	    defender.setHP(defender.getHP()-damage);
		}
	}
	//Randomly find a body part, the spirit comes from the game RimWorld (https://rimworldwiki.com/wiki/Body_Parts)
	public void getBodyPart() {
	    String bodyPart;
	    double a=Math.random();
	    if(a<0.405) {
	        bodyPart="torso";
	        DamageEfficiency=1.0;
	    }
	    else if (a<0.42) {
	        bodyPart="neck";
	        DamageEfficiency=1.5;
	    }
	    else if (a<0.441) {
	        bodyPart="left arm";
	        DamageEfficiency=0.8;
	    }
	    else if (a<0.462) {
	        bodyPart="right arm";
	        DamageEfficiency=0.8;
	    }
	    else if (a<0.483) {
	        bodyPart="left hand";
	        DamageEfficiency=0.6;
	    }
	    else if (a<0.504) {
	        bodyPart="right hand";
	        DamageEfficiency=0.6;
	    }
	    else if (a<0.525) {
	        bodyPart="left leg";
	        DamageEfficiency=0.7;
	    }
	    else if (a<0.546) {
	        bodyPart="right leg";
	        DamageEfficiency=0.7;
	    }
	    else if (a<0.567) {
	        bodyPart="left foot";
	        DamageEfficiency=0.5;
	    }
	    else if (a<0.588) {
	        bodyPart="right foot";
	        DamageEfficiency=0.5;
	    }
	    else if (a<0.609) {
	        bodyPart="abdomen";
	        DamageEfficiency=1.0;
	    }
	    else if (a<0.630) {
	        bodyPart="chest";
	        DamageEfficiency=1.0;
	    }
	    else if (a<0.651) {
	        bodyPart="back";
	        DamageEfficiency=1.0;
	    }
	    else if (a<0.672) {
	        bodyPart="shoulder";
	        DamageEfficiency=0.9;
	    }
	    else if (a<0.693) {
	        bodyPart="pelvis";
	        DamageEfficiency=1.0;
	    }
	    else if (a<0.714) {
	        bodyPart="groin";
	        DamageEfficiency=1.1;
	    }
	    else if (a<0.735) {
	        bodyPart="buttocks";
	        DamageEfficiency=0.8;
	    }
	    else if (a<0.756) {
	        bodyPart="thigh";
	        DamageEfficiency=0.7;
	    }
	    else if (a<0.777) {
	        bodyPart="knee";
	        DamageEfficiency=0.6;
	    }
	    else if (a<0.798) {
	        bodyPart="shin";
	        DamageEfficiency=0.6;
	    }
	    else if (a<0.819) {
	        bodyPart="ankle";
	        DamageEfficiency=0.5;
	    }
	    else if (a<0.840) {
	        bodyPart="heel";
	        DamageEfficiency=0.4;
	    }
	    else if (a<0.861) {
	        bodyPart="toe";
	        DamageEfficiency=0.3;
	    }
	    else if (a<0.882) {
	        bodyPart="eye";
	        DamageEfficiency=1.5;
	    }
	    else if (a<0.903) {
	        bodyPart="nose";
	        DamageEfficiency=1.1;
	    }
	    else {
	        bodyPart="torso";
	        DamageEfficiency=1.0;
	    }
	    this.bodyPart=bodyPart;
	    this.DamageEfficiency=DamageEfficiency;
	}
}

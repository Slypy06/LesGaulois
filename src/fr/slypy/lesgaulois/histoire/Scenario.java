package fr.slypy.lesgaulois.histoire;

import fr.slypy.lesgaulois.objets.Equipement;
import fr.slypy.lesgaulois.objets.Musee;
import fr.slypy.lesgaulois.personnages.Druide;
import fr.slypy.lesgaulois.personnages.Gaulois;
import fr.slypy.lesgaulois.personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		
		Druide druide = new Druide("Panoramix", 5);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.fabriquerPotion(3, 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0 && !minus.isVainqueur());
		
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0 && !milexcus.isVainqueur());
		
//		Partie a decommenter
		
		Musee musee = new Musee();
		asterix.faireUneDonnation(musee);
		
		System.out.println(musee.extraireInstructionsOCaml());

	}

}

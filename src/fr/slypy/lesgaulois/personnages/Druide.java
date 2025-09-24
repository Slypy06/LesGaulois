package fr.slypy.lesgaulois.personnages;

import fr.slypy.lesgaulois.objets.Chaudron;

public class Druide {
	
	private int force;
	private String nom;
	private Chaudron chaudron = new Chaudron();
	
	public Druide(String nom, int force) {

		this.force = force;
		this.nom = nom;
		
	}
	
	@Override
	public String toString() {
		
		return "Druide [nom=" + nom + ", force=" + force + "]";
		
	}
	
	public String getNom() {
		
		return nom;
		
	}
	
	public void parler(String texte) {
		
		System.out.println(prendreParole() + '"' + texte + '"');
		
	}
	
	public void fabriquerPotion(int qte, int forcePotion) {
		
		chaudron.remplirChaudron(qte, forcePotion);
		
		parler("J'ai concocté " + qte + " doses de potion magique. Elle a une force de " + forcePotion);
		
	}
	
	public void booster(Gaulois gaulois) {
		
		if(chaudron.resterPotion()) {
			
			if(gaulois.getNom().equals("Obélix")) {
				
				parler("Non, Obélix Non !... Et tu le sais très bien");
				
			} else {
				
				gaulois.boirePotion(chaudron.prendreLouche());
				
				parler("Tiens " + gaulois.getNom() + " un peu de potion magique.");
				
			}
			
		} else {
			
			parler("Désolé " + gaulois.getNom() + " il n'y a plus une seule goutte de potion.");
			
		}
		
	}
	
	private String prendreParole() {
		
		return "Le Druide " + nom + " : ";
		
	}

}

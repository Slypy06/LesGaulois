package fr.slypy.lesgaulois.personnages;

import fr.slypy.lesgaulois.Village;

public class Gaulois {
	
	private int force;
	private String nom;
	private int effetPotion = 1;
	private Village village;
	
	public Gaulois(String nom, int force) {

		this.force = force;
		this.nom = nom;
		
	}
	
	public static void main(String[] args) {
		
		Gaulois asterix = new Gaulois( "Astérix", 8);
		
		System.out.println(asterix);
		
	}

	public String getNom() {
		
		return nom;
		
	}
	
	public void parler(String texte) {
		
		System.out.println(prendreParole() + '"' + texte + '"');
		
	}
	
	private String prendreParole() {
		
		return "Le gaulois " + nom + " : ";
		
	}
	
	public void frapper(Romain romain) {
		
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force * effetPotion) / 3);
		effetPotion -= effetPotion > 1 ? 1 : 0;
		
	}

	public void boirePotion(int effetPotion) {
		
		this.effetPotion = effetPotion;
		
	}

	public void setVillage(Village village) {
		
		this.village = village;
		
	}
	
	public void sePresenter() {
		
		if(village == null) {
			
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
			
		} else if(village.getChef().equals(this)) {
			
			parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village " + village.getNom() + ".");
			
		} else {
			
			parler("Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".");
			
		}
		
	}

	@Override
	public String toString() {
		
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
		
	}

}

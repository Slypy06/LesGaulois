package fr.slypy.lesgaulois.personnages;

public class Gaulois {
	
	private int force;
	private String nom;
	private int effetPotion = 1;
	
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
	
	@Override
	public String toString() {
		
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
		
	}

}

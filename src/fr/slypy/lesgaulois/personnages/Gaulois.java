package fr.slypy.lesgaulois.personnages;

public class Gaulois {
	
	private int force;
	private String nom;
	
	public Gaulois(int force, String nom) {

		this.force = force;
		this.nom = nom;
		
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
	
	

}

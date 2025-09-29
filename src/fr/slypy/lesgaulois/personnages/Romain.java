package fr.slypy.lesgaulois.personnages;

public class Romain {
	
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		
		this.nom = nom;
		this.force = force;
		
	}

	public String getNom() {
		
		return nom;
		
	}

	public void parler(String texte) {
		
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
	}

	public String prendreParole() {
		
		return "Le romain " + nom + " : ";
		
	}

	public void recevoirCoup(int force) {
		
		this.force -= force;
		
		if (this.force > 0) {
			
			parler("Aïe !");
		
		} else {
			
			parler("J'abandonne...");
		
		} 
		
	}
	
	
	@Override
	public String toString() {
		
		return "Romain [nom=" + nom + ", force=" + force + "]";
		
	}
	
}

package fr.slypy.lesgaulois.personnages;

public class Romain {
	
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		
		this.nom = nom;
		this.force = force;
		
		assert isInvariantVerified();
		
	}
	
	public static void main(String[] args) {
		
		Romain r = new Romain("minus", -6);
		
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
		
		assert force > 0;
		
		int prevForce = this.force;
		
		this.force -= force;
		
		if (this.force > 0) {
			
			parler("Aïe !");
		
		} else {
			
			parler("J'abandonne...");
		
		} 
		
		assert (prevForce - this.force) > 0;
		
	}
	
	private boolean isInvariantVerified() {
		
		return force >= 0;
		
	}
	
	@Override
	public String toString() {
		
		return "Romain [nom=" + nom + ", force=" + force + "]";
		
	}
	
}

package fr.slypy.lesgaulois.personnages;

import fr.slypy.lesgaulois.objets.Equipement;

public class Romain {
	
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		
		this.nom = nom;
		this.force = force;
		
		assert isInvariantVerified();
		
	}
	
	public static void main(String[] args) {
		
		Romain r = new Romain("minus", 6);
		
		for(Equipement e : Equipement.values()) {
			
			System.out.println(e);
			
		}
		
		r.sEquipper(Equipement.CASQUE);
		r.sEquipper(Equipement.CASQUE);
		r.sEquipper(Equipement.BOUCLIER);
		r.sEquipper(Equipement.CASQUE);
		
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
	
	public void sEquipper(Equipement e) {
		
		switch(nbEquipement) {
			
			case 0 -> {
					
				equipement[0] = e;
				nbEquipement++;
				
				System.out.println("Le soldat " + nom + " s'équipe avec un " + e + ".");
				
			}
			
			case 1 -> {
				
				if(equipement[0].equals(e)) {
					
					System.out.println("Le soldat " + nom + " possède déjà un " + e + ".");
					
				} else  {
					
					equipement[1] = e;
					nbEquipement++;
					
					System.out.println("Le soldat " + nom + " s'équipe avec un " + e + ".");
					
				}
				
			}
			
			case 2 -> System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			
		}
		
		
		
	}
	
	private boolean isInvariantVerified() {
		
		return force >= 0;
		
	}
	
	@Override
	public String toString() {
		
		return "Romain [nom=" + nom + ", force=" + force + "]";
		
	}
	
}

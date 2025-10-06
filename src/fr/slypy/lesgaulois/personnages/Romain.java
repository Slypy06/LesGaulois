package fr.slypy.lesgaulois.personnages;

import fr.slypy.lesgaulois.objets.Equipement;

public class Romain {

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = false;

	public Romain(String nom, int force) {

		this.nom = nom;
		this.force = force;

		assert isInvariantVerified();

	}

	public static void main(String[] args) {

		Romain r = new Romain("minus", 6);

		for (Equipement e : Equipement.values()) {

			System.out.println(e);

		}

		r.sEquiper(Equipement.CASQUE);
		r.sEquiper(Equipement.CASQUE);
		r.sEquiper(Equipement.BOUCLIER);
		r.sEquiper(Equipement.CASQUE);

	}

	public String getNom() {

		return nom;

	}
	
	public int getForce() {
		
		return force;
		
	}

	public void parler(String texte) {

		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	public String prendreParole() {

		return "Le romain " + nom + " : ";

	}

//	public void recevoirCoup(int force) {
//		
//		assert force > 0;
//		
//		int prevForce = this.force;
//		
//		this.force -= force;
//		
//		if (this.force > 0) {
//			
//			parler("Aïe !");
//		
//		} else {
//			
//			parler("J'abandonne...");
//		
//		} 
//		
//		assert (prevForce - this.force) > 0;
//		
//	}

	public Equipement[] recevoirCoup(int forceCoup) {

		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		
		if(forceCoup <= 0) {
			
			vainqueur = true;
			
			parler("Je n'ai même pas senti le coup");
			
		} else {

			if(force > 0) {
				
				parler("Aïe");
	
			} else {
				
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
	
			}
		
		}

		return equipementEjecte;

	}

	public boolean isVainqueur() {
		
		return vainqueur;
		
	}

	private int calculResistanceEquipement(int forceCoup) {
		
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		
		if (nbEquipement != 0) {
			
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					
					resistanceEquipement += 8;
					
				} else {
					
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				
				}
				
			}
			
			texte += resistanceEquipement + "!";
			
		}
		
		parler(texte);
		forceCoup -= Math.min(resistanceEquipement, forceCoup);
		
		return forceCoup;
		
	}

	private Equipement[] ejecterEquipement() {
		
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			
			if (equipements[i] != null) {
				
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			
			}
		
		}
		
		return equipementEjecte;
		
	}

	public void sEquiper(Equipement e) {

		switch (nbEquipement) {

			case 0 -> {
	
				equipements[0] = e;
				nbEquipement++;
	
				System.out.println("Le soldat " + nom + " s'équipe avec un " + e + ".");
	
			}
	
			case 1 -> {
	
				if (equipements[0].equals(e)) {
	
					System.out.println("Le soldat " + nom + " possède déjà un " + e + ".");
	
				} else {
	
					equipements[1] = e;
					nbEquipement++;
	
					System.out.println("Le soldat " + nom + " s'équipe avec un " + e + ".");
	
				}
	
			}
	
			case 2 -> System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			
			default -> {/*impossible*/}

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

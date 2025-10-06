package fr.slypy.lesgaulois.village;

import fr.slypy.lesgaulois.personnages.Gaulois;

public class Village {
	
	private int NB_VILLAGEOIS_MAX;
	
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;
	
	public Village(String nom, Gaulois chef, int nbVillageoisMax) {

		this.nom = nom;
		this.chef = chef;
		chef.setVillage(this);
		NB_VILLAGEOIS_MAX = nbVillageoisMax;
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
		
	}
	
	public static void main(String[] args) {
		
		Gaulois g1 = new Gaulois("Abraracourcix", 6);
		
		Village v = new Village("Village des Irréductibles", g1, 30);
		
		Gaulois g2 = new Gaulois("Astérix", 8);
		
		v.ajouterVillageois(g2);

		Gaulois gaulois = v.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = v.trouverVillageois(2);
		System.out.println(gaulois);
		
		g1.sePresenter();
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		v.ajouterVillageois(obelix);
		
		Gaulois doublePolemix = new Gaulois("DoublePolémix", 4);
		
		g2.sePresenter();
		obelix.sePresenter();
		doublePolemix.sePresenter();
		
	}

	public void afficherVillageois() {
		
		System.out.println("Dans le village " + '"' + nom + '"' + " du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		
		for(int i = 0; i < nbVillageois; i++) {
			
			System.out.println("- " + villageois[i].getNom());
			
		}
 		
	}
	
	public void ajouterVillageois(Gaulois g) {
		
		if(nbVillageois < NB_VILLAGEOIS_MAX) {
			
			villageois[nbVillageois] = g;
			g.setVillage(this);
			
		}
		
		nbVillageois++;

	}
	
	public Gaulois trouverVillageois(int i) {
		
		if(i <= nbVillageois && i > 0) {
			
			return villageois[i-1];
			
		} else if(i > 0) {
			
			System.out.println("Il n’y a pas autant d'habitants dans notre village !");
			
			return null;
			
		}
		
		return null;
		
	}
	
	public String getNom() {
		
		return nom;
		
	}
	
	public Gaulois getChef() {
		
		return chef;
		
	}

}

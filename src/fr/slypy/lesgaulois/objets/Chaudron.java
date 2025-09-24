package fr.slypy.lesgaulois.objets;

public class Chaudron {
	
	private int quantitePotion;
	private int forcePotion;

	public void remplirChaudron(int quantitePotion, int forcePotion) {
		
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
		
	}
	
	public boolean resterPotion() {
		
		return quantitePotion > 0;
		
	}
	
	public int prendreLouche() {
		
		if(quantitePotion > 0) {
		
			quantitePotion--;
		
			return forcePotion;
		
		}
		
		return 1;
		
	}

}

package fr.slypy.pierresabre.personnages;

public class Ronin extends Humain {

	private int honneur = 1;
	
	public Ronin(String nom, String boissonFavorite, int argent) {
		
		super(nom, boissonFavorite, argent);

	}

	public void donner(Commercant c) {
		
		int amt = getArgent() / 10;
		perdreArgent(amt);
		parler(c.getNom() + " prends ces " + amt + " sous.");
		c.recevoir(amt);
		
	}
	
	public void provoquer(Yakuza y) {
		
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		
		if(honneur * 2 > y.getReputation()) {
			
			parler("Je t'ai eu petit yakuza !");
			honneur++;
			y.perdre();
			
		} else {
			
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			honneur--;
			y.gagner(getArgent());
			perdreArgent(getArgent());
			
		}
		
	}
	
}

package fr.slypy.pierresabre.personnages;

import java.util.Random;

public class GrandMere extends Humain {
	
	private Random r = new Random();

	public GrandMere(String nom, int argent) {
		
		super(nom, "tisane", argent);

	}
	
	@Override
	protected void memoriser(Humain h) {
		
		if(nbConnaissance < 5) {
			
			super.memoriser(h);
			
		} else {
			
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
			
		}
		
	}
	
	public void ragoter() {
		
		for(int i = 0; i < nbConnaissance; i++) {
			
			if(memoire[i] instanceof Traitre) {
				
				parler("Je sais que " + memoire[i].getNom() + " est un Traitre. Petit chenapan !");
				
			} else {
				
				parler("Je crois que " + memoire[i].getNom() + " est un " + humainHasard() + ".");
				
			}
			
		}
		
	}
	
	private String humainHasard() {
		
		return TypeHumain.values()[r.nextInt(TypeHumain.values().length)].toString();
		
	}
	
	private enum TypeHumain {
		
		GRAND_MERE("Grand-Mère"), COMMERCANT("Commercant"), HABITANT("Habitant"), RONIN("Ronin"), SAMOURAI("Samourai"), YAKUZA("Yakuza");
		
		private String nom;
		
		private TypeHumain(String nom) {
			
			this.nom = nom;
			
		}
		
		@Override
		public String toString() {
			
			return nom;
			
		}
		
	}

}

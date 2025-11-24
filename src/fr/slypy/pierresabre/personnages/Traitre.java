package fr.slypy.pierresabre.personnages;

import java.util.Random;

public class Traitre extends Samourai {
	
	private int niveauTraitrise = 0;
	private Random r = new Random();

	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		
		super(seigneur, nom, boissonFavorite, argent);

	}

	@Override
	public void direBonjour() {
		
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut !");
		
	}
	
	public void faireLeGentil() {
		
		if(nbConnaissance < 1) {
			
			parler("Je ne peux faire ami-ami avec personne car je ne connais personne ! Snif.");
			
		} else {
			
			Humain ami = memoire[r.nextInt(nbConnaissance)];
			int don = getArgent() / 20;
			
			parler("Il me faut absolument remonter ma cote de confiance. Je vais faire ami-ami avec " + ami.getNom() + ".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			perdreArgent(don);
			ami.gagnerArgent(don);
			ami.parler("Merci " + getNom() + " vous êtes quelqu'un de bien !");
			
			if(niveauTraitrise > 1) {
				
				niveauTraitrise--;
				
			}
			
		}
		
	}
	
	public void ranconner(Commercant c) {
		
		if(niveauTraitrise < 3) {
			
			int argentRanconne = c.getArgent() / 5;
			
			c.perdreArgent(argentRanconne);
			gagnerArgent(argentRanconne);
			
			niveauTraitrise++;
			
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne moi " + argentRanconne + " sous ou gare à toi !");
			c.parler("Tout de suite grand " + getNom() + ".");
		
		} else {
			
			parler("Mince, je ne peux plus rançonner personne sinon un samourai risque de me démasquer !");
			
		}
		
	}
	
}

package fr.slypy.pierresabre.personnages;

public class Humain {
	
	public static int TAILLE_MEMOIRE = 30;
	
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected int nbConnaissance;
	protected Humain[] memoire = new Humain[TAILLE_MEMOIRE];
	
	public Humain(String nom, String boissonFavorite, int argent) {

		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
		
	}

	protected void parler(String texte) {
		
		System.out.println("(" + nom + ") - " + texte);
		
	}
	
	public void direBonjour() {
		
		parler("Bonjour ! Je m’appelle " + nom + " et j’aime boire du " + boissonFavorite + ".");
		
	}
	
	public void boire() {
		
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
		
	}
	
	public void acheter(String bien, int prix) {
		
		if(argent >= prix) {
			
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous");
			argent -= prix;
			
		} else {
			
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix +" sous.");
			
		}
		
	}

	protected void gagnerArgent(int argent) {
		
		this.argent+=argent;
		
	}
	
	protected void perdreArgent(int argent) {
		
		this.argent-=argent;
		
	}

	public String getNom() {
		
		return nom;
		
	}

	public int getArgent() {
		
		return argent;
		
	}
	
	protected void memoriser(Humain h) {
		
		if(nbConnaissance < TAILLE_MEMOIRE) {
			
			memoire[nbConnaissance] = h;
			nbConnaissance++;
			
		} else {
			
			for(int i = 0; i < TAILLE_MEMOIRE-1; i++) {
				
				memoire[i] = memoire[i+1];
				
			}
			
			memoire[TAILLE_MEMOIRE-1] = h;
			
		}
		
	}
	
	private void repondre(Humain h) {
		
		direBonjour();
		memoriser(h);
		
	}
	
	public void faireConnaissanceAvec(Humain h) {
		
		direBonjour();
		h.repondre(this);
		memoriser(h);
		
	}
	
	public void listerConnaissance() {
		
		if(nbConnaissance > 0) {
			
			StringBuilder b = new StringBuilder();
			
			for(int i = 0; i < nbConnaissance; i++) {
				
				b.append(memoire[i].getNom());
				
				if(i<nbConnaissance-1)
					b.append(", ");
				
			}
			
			parler("Je connais beaucoup de monde dont : " + b.toString());
		
		} else {
			
			parler("Je ne connais personne.");
			
		}
		
	}
	
}

package fr.slypy.pierresabre.personnages;

public class Yakuza extends Humain {

	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		
		super(nom, boissonFavorite, argent);
		this.clan = clan;
		
	}
	
	@Override
	public void direBonjour() {
		
		super.direBonjour();
		parler("Mon clan est celui de " + clan + ".");
		
	}
	
	public void extorquer(Commercant c) {
		
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(c.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		
		int amt = c.seFaireExtorquer();
		
		parler("J’ai piqué les " + amt + " sous de " + c.getNom() + ", ce qui me fait " + getArgent() + " sous dans ma poche. Hi ! Hi !");
		
		gagnerArgent(amt);
		
	}
	
	public int getReputation() {
		
		return reputation;
		
	}
	
	public void perdre() {
		
		parler("J’ai perdu mon duel et mes " + getArgent() + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
		
		perdreArgent(getArgent());
		reputation--;
		
	}
	
	public void gagner(int amt) {
		
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + " ? Je l'ai dépouillé de ses " + amt + " sous.");
		gagnerArgent(amt);
		reputation++;
		
	}

}

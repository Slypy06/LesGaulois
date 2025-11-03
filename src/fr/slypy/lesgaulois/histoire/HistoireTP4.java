package fr.slypy.lesgaulois.histoire;

import fr.slypy.lesgaulois.personnages.Commercant;
import fr.slypy.lesgaulois.personnages.Humain;
import fr.slypy.lesgaulois.personnages.Ronin;
import fr.slypy.lesgaulois.personnages.Yakuza;

public class HistoireTP4 {

	public static void main(String[] args) {
		
		Humain h = new Humain("Prof", "kombucha", 54);
		h.direBonjour();
		h.acheter("une boisson", 12);
		h.boire();
		h.acheter("un jeu", 2);
		h.acheter("un kimono", 50);
		
		Commercant c = new Commercant("Marco", 15);
		c.direBonjour();
		/*c.seFaireExtorquer();
		c.recevoir(15);
		c.boire();+*/
		
		Yakuza y = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
		y.direBonjour();
		y.extorquer(c);
		
		Ronin r = new Ronin("Roro", "shochu", 60);
		r.direBonjour();
		r.donner(c);
		
		r.provoquer(y);
		
	}
	
}

package fr.slypy.pierresabre.histoire;

import fr.slypy.pierresabre.personnages.Commercant;
import fr.slypy.pierresabre.personnages.Ronin;
import fr.slypy.pierresabre.personnages.Samourai;
import fr.slypy.pierresabre.personnages.Traitre;
import fr.slypy.pierresabre.personnages.Yakuza;

public class HistoireTP5 {
	
	public static void main(String[] args) {
		
		Commercant marco = new Commercant("Marco", 20);
		Commercant chonin = new Commercant("Chonin", 40);
		Commercant kumi = new Commercant("Kumi", 10);
		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
		Ronin roro = new Ronin("Roro", "shochu", 60);

		marco.faireConnaissanceAvec(roro);
		marco.faireConnaissanceAvec(yaku);
		marco.faireConnaissanceAvec(chonin);
		marco.faireConnaissanceAvec(kumi);
		
		marco.listerConnaissance();
		roro.listerConnaissance();
		yaku.listerConnaissance();
		
		Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "saké", 80);
		
		akimoto.direBonjour();
		akimoto.boire("thé");
		
		Traitre masako = new Traitre("Miyamoto", "Masako", "whisky", 100);

		masako.faireLeGentil();
		masako.ranconner(kumi);
		masako.ranconner(chonin);
		masako.ranconner(marco);
		
		akimoto.faireConnaissanceAvec(masako);
	
		masako.ranconner(marco);
		
		masako.faireConnaissanceAvec(yaku);
		
		masako.faireLeGentil();
		
		masako.faireConnaissanceAvec(roro);
		
	}
	
}

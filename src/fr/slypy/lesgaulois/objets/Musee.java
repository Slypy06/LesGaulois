package fr.slypy.lesgaulois.objets;

import fr.slypy.lesgaulois.personnages.Gaulois;

public class Musee {
	
	private Trophee[] trophees = new Trophee[200];	
	private int nbTrophees = 0;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		
		if(nbTrophees < 200) {
			
			trophees[nbTrophees] = new Trophee(gaulois, equipement);
			nbTrophees++;
			
		}
		
	}
	
	public String extraireInstructionsOCaml() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("let musee = [");
		
		for(int i = 0; i < nbTrophees; i++) {
			
			Trophee t = trophees[i];
			
			sb.append("\n\t").append('"').append(t.donnerNom()).append('"')
			.append(", ").append('"').append(t.getEquipement()).append('"').append(";");
			
		}
		
		sb.append('\n').append("]");
		
		return sb.toString();
		
	}

}

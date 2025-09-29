package fr.slypy.lesgaulois.objets;

public enum Equipement {

	CASQUE("casque"), BOUCLIER("bouclier");
	
	private String name;
	
	private Equipement(String name) {
		
		this.name = name;
		
	}
	
	@Override
	public String toString() {
		
		return name;
		
	}
	
}

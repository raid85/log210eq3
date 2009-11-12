package modele;


public class Livreur implements Role{

	final boolean GERANT=false, ADMIN=false, LIVREUR=true;

	public boolean isGerant() {
		return GERANT;
	}

	public boolean isAdmin() {
		return ADMIN;
	}

	public boolean isLivreur() {
		return LIVREUR;
	}
	
	
	public String toString(){
		
		return "Livreur";
	}



	
}

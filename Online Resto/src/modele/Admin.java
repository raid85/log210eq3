package modele;


public class Admin implements Role{

	final boolean GERANT=true, ADMIN=true, LIVREUR=true;

	public boolean isGerant() {
		return GERANT;
	}

	public boolean isAdmin() {
		return ADMIN;
	}

	public boolean isLivreur() {
		return LIVREUR;
	}
	
	



	
}

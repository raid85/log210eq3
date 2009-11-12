package modele;


public class Admin implements Role{

	final boolean GERANT=true, ADMIN=true, LIVREUR=true,RIEN = false;

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
		
		return "Admin";
	}
	
	public boolean isNull() {
		return RIEN;
	}


	
}

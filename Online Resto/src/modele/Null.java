package modele;


public class Null implements Role{

	final boolean GERANT=false, ADMIN=false, LIVREUR=false, RIEN=true;

	public boolean isGerant() {
		return GERANT;
	}

	public boolean isAdmin() {
		return ADMIN;
	}

	public boolean isLivreur() {
		return LIVREUR;
	}
	public boolean isNull() {
		return RIEN;
	}
	
	
	public String toString(){
		
		return "Null";
	}



	
}

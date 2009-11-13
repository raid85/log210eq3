package modele;


public class Livreur implements Role{

	final boolean GERANT=false, ADMIN=false, LIVREUR=true, RIEN=false, CLIENT=false;

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
	
	public boolean isClient() {
		return CLIENT;
	}
	
	public String toString(){
		
		return "Livreur";
	}



	
}

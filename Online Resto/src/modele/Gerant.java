package modele;


public class Gerant implements Role{

	final boolean GERANT=true, ADMIN=false, LIVREUR=false, RIEN=false, CLIENT=false;

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
		
		return "Gerant";
	}

	public boolean isNull() {
		return RIEN;
	}
	public boolean isClient() {
		return CLIENT;
	}

	
}

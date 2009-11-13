package modele;


public class RClient implements Role{

	final boolean GERANT=false, ADMIN=false, LIVREUR=false, RIEN=false, CLIENT=true;

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
		
		return "Null";
	}



	
}

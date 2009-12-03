package modele;


public class Livreur implements Role{

	final boolean GERANT=false, ADMIN=false, LIVREUR=true, RIEN=false, CLIENT=false;
	private String Nom ;
	private String Adresse;
	private String Telephone;
	private String ZoneCouverture ;
	private String Disponibilite ;
	
	Livreur() {
		// TODO Auto-generated constructor stub
	}

	Livreur (String nom, String adresse,String telephone, String zoneCouverture,String disponibilite){

		this.setNom(nom);
		this.setAdresse(adresse);
		this.setTelephone(telephone);
		this.setZoneCouverture(zoneCouverture);
		this.setDisponibilite(disponibilite);
	}	


	public void setDisponibilite(String disponibilite) {
		Disponibilite = disponibilite;
	}


	public void setZoneCouverture(String zoneCouverture) {
		ZoneCouverture = zoneCouverture;
	}


	public void setTelephone(String telephone) {
		Telephone = telephone;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public void setAdresse(String adresse) {
		Adresse = adresse;
	}


	public String getDisponibilite() {
		return Disponibilite;
	}


	public String getZoneCouverture() {
		return ZoneCouverture;
	}


	public String getTelephone() {
		return Telephone;
	}


	public String getAdresse() {
		return Adresse;
	}


	public String getNom() {
		return Nom;
	}


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

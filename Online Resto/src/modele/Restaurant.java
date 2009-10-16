package modele;

public class Restaurant {
	private String adresse;
	private String numeroTel;
	private int numRestaurant;
	private Menu menuResto ;
	//Constructeur
	

	public Restaurant(String adresse, String numeroTel, int numRestaurant) {
		super();
		this.adresse = adresse;
		this.numeroTel = numeroTel;
		this.numRestaurant = numRestaurant;
		
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public int getNumRestaurant() {
		return numRestaurant;
	}
}

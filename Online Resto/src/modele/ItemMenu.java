package modele;

public class ItemMenu {
	
	private double prix;
	private String description;
	
	//Constructeur
	public ItemMenu(double prix, String description) {		
		this.prix = prix;
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description + ", " + prix + "$";
	}
	
	
	
}

package modele;

public class ItemMenu {
	
	private int prix;
	private String description;
	
	//Constructeur
	public ItemMenu(int prix, String description) {		
		this.prix = prix;
		this.description = description;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
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

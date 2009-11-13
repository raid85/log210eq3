package modele;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	private String nom ;
	private String adresse;
	private String numeroTel;
	private String zoneCouverture;	
	private String heureOuverture ;
	private String heureFermeture;
	private int idRestaurant;
	
	
	private List<ItemMenu> menu;
	//Constructeur
	
	public Restaurant(String nom ,String adresse, String numeroTel,String zoneCouverture,String heureOuverture,String heureFermeture) {
		super();
		this.nom = nom ;
		this.adresse = adresse;
		this.numeroTel = numeroTel;
		this.zoneCouverture=zoneCouverture;
		this.heureOuverture=heureOuverture;
		this.heureFermeture=heureFermeture;
	
		
		this.menu = new ArrayList<ItemMenu>();
	}

	
	public Restaurant(String nom,String adresse, String numeroTel,String zoneCouverture,String heureOuverture,String heureFermeture,ArrayList<ItemMenu> m) {
		super();
		this.nom = nom ;
		this.adresse = adresse;
		this.numeroTel = numeroTel;
		this.zoneCouverture=zoneCouverture;
		this.heureOuverture=heureOuverture;
		this.heureFermeture=heureFermeture;		
		this.menu=m;
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

	public int getidRestaurant() {
		return idRestaurant;
	}
	
	/**
	 * Cette méthode sert à ajouter une string au Catalogue.
	 * Lors de l'ajout d'une string, les observateurs sont avisés de la 
	 * modification.
	 * @param string
	 */
	public void ajouterItem(ItemMenu item) {
		menu.add(item);
		
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		
	}
	
	/**
	 * Cette méthode sert à retirer une string du Catalogue.
	 * Lors du retrait d'une string, les observateurs sont avisés de la
	 * modification.
	 * @param index
	 */
	public void retirerItem(int index) {
		menu.remove(index);
		
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		
	}
}

package modele;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private String adresse;
	private String numeroTel;
	private int numRestaurant;
	private List<ItemMenu> m;
	//Constructeur
	
	public Restaurant(String adresse, String numeroTel, int numRestaurant) {
		super();
		this.adresse = adresse;
		this.numeroTel = numeroTel;
		this.numRestaurant = numRestaurant;
		this.m = new ArrayList<ItemMenu>();
	}

	
	public Restaurant(String adresse, String numeroTel, int numRestaurant,ArrayList<ItemMenu> m) {
		super();
		this.adresse = adresse;
		this.numeroTel = numeroTel;
		this.numRestaurant = numRestaurant;
		this.m=m;
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
	
	/**
	 * Cette méthode sert à ajouter une string au Catalogue.
	 * Lors de l'ajout d'une string, les observateurs sont avisés de la 
	 * modification.
	 * @param string
	 */
	public void ajouterItem(ItemMenu item) {
		m.add(item);
		
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
		m.remove(index);
		
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		
	}
}

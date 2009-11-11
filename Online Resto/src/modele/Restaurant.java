package modele;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private String adresse;
	private String numeroTel;
	private int numRestaurant;
	private List<ItemMenu> menu;
	//Constructeur
	
	public Restaurant(String adresse, String numeroTel, int numRestaurant) {
		super();
		this.adresse = adresse;
		this.numeroTel = numeroTel;
		this.numRestaurant = numRestaurant;
		this.menu = new ArrayList<ItemMenu>();
	}

	
	public Restaurant(String adresse, String numeroTel, int numRestaurant,ArrayList<ItemMenu> m) {
		super();
		this.adresse = adresse;
		this.numeroTel = numeroTel;
		this.numRestaurant = numRestaurant;
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

	public int getNumRestaurant() {
		return numRestaurant;
	}
	
	/**
	 * Cette m�thode sert � ajouter une string au Catalogue.
	 * Lors de l'ajout d'une string, les observateurs sont avis�s de la 
	 * modification.
	 * @param string
	 */
	public void ajouterItem(ItemMenu item) {
		menu.add(item);
		
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		
	}
	
	/**
	 * Cette m�thode sert � retirer une string du Catalogue.
	 * Lors du retrait d'une string, les observateurs sont avis�s de la
	 * modification.
	 * @param index
	 */
	public void retirerItem(int index) {
		menu.remove(index);
		
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		
	}
}

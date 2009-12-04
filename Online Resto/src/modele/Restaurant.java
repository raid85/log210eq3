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
	private List<Commande> commandes ;
	//Constructeur
	
	public Restaurant(String nom ,String adresse, String numeroTel,String zoneCouverture,String heureOuverture) {
		super();
		this.nom = nom ;
		this.adresse = adresse;
		this.numeroTel = numeroTel;
		this.zoneCouverture=zoneCouverture;
		this.heureOuverture=heureOuverture;
		this.heureFermeture=heureFermeture;
	
		
		this.menu = new ArrayList<ItemMenu>();
		this.commandes = new ArrayList<Commande>();
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
	
	public void ajouterCommande (Commande c){
		commandes.add(c);		
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

	public String getNom() {
		return this.nom ;
	}
	public String toString(){
		//String nom ,String adresse, String numeroTel,String zoneCouverture,String heureOuverture
		String tempo;
		
		tempo = nom + " " + adresse + " " + numeroTel;
		
		
		return tempo;
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
	
	public void modifierItem(int index, ItemMenu item ) {
		menu.remove(index);
		menu.add(index, item);
		
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		
	}
}

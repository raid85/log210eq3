package modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Restaurant extends Observable {
	
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
		
		Commande c = new Commande ("Germain","Demain","H7T2Z8");
		Commande c1 = new Commande ("Germ2","Dem2","H7T2");
		
		ItemMenu tempo = new ItemMenu(33,"Poulet");
		ItemMenu tempo2 = new ItemMenu(332,"Poulet2");
		c.ajouterPlat(tempo);
		c.ajouterPlat(tempo2);
		c1.ajouterPlat(tempo);
		c1.ajouterPlat(tempo2);
		commandes.add(c);
		commandes.add(c1);
	}

	

	
	public void ajouterCommande (Commande c){
		commandes.add(c);		
	}
	
	public Object[] getCommandes (){
		return this.commandes.toArray();
	}
	public Commande getCommande (int index){
		return commandes.get(index);
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

	public List<ItemMenu> getMenu() {
		return menu;
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
	
	public void modifierItem(int index, ItemMenu item ) {
		menu.remove(index);
		menu.add(index, item);
		
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		
	}
	public void retirerMenu(){
	this.menu = new ArrayList<ItemMenu>();
	}
	
}

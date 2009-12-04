package modele;

import java.util.ArrayList;
import java.util.List;

public class Commande {

	private List<ItemMenu> plats;

	private String dateVoulue ;
	private String nomClient ;
	private String codePostal ;
	private boolean accepter, livrer;


	public Commande (String nomClient , String date , String codePostal){
		setAccepter(false);
		setLivrer(false);
		this.dateVoulue = date;
		this.nomClient = nomClient;
		this.codePostal = codePostal ;
		plats = new ArrayList<ItemMenu> () ;

	}

	public void ajouterPlat (ItemMenu item){		
		plats.add(item);

	}
	
	public void enleverPlat (int index){
		plats.remove(index);
	}
	public String toString(){
		return "" + dateVoulue + " " + nomClient + " " + codePostal;
	}

	public List<ItemMenu> getPlats() {
		return plats;
	}

	public void setAccepter(boolean accepter) {
		this.accepter = accepter;
	}

	public boolean isAccepter() {
		return accepter;
	}

	public void setLivrer(boolean livrer) {
		this.livrer = livrer;
	}

	public boolean isLivrer() {
		return livrer;
	}
	
}

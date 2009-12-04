package modele;

import java.util.ArrayList;
import java.util.List;

public class Commande {

	private List<ItemMenu> plats;
	private String idCommande ;

	
	private boolean accepter,completer;

   public Commande(){
		
	}

	public Commande (String idCommande){
		setAccepter(false);
		setCompleter(false);
		plats = new ArrayList<ItemMenu> () ;
		this.idCommande =idCommande;

	}

	public void ajouterPlat (ItemMenu item){		
		plats.add(item);

	}
	
	public void enleverPlat (int index){
		plats.remove(index);
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

	public void setCompleter(boolean completer) {
		this.completer = completer;
	}

	public boolean isCompleter() {
		return completer;
	}
	
}

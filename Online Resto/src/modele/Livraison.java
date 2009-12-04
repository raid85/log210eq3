package modele;

public class Livraison {
	
	private String dateVoulue ;
	private String nomClient ;
	private String codePostal ;
	private Commande commande = new Commande () ;
	private boolean isAccepted, isDelivered ;
	
	public Livraison(String date, String nom , String code, Commande comande){
		this.dateVoulue = date;
		this.nomClient = nom;
		this.codePostal= code;
		this.commande = commande;
	    isAccepted = false ;
	    isDelivered = false ;
		
	}
	
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	public boolean isDelivered() {
		return isDelivered;
	}

}

package modele;

/**
 *  Cette classe est utilis�e lors de l'instanciation du Terminal. Elle ne sert
 * plus par la suite.
 */
import java.util.ArrayList;
import java.util.Observer;

import javax.swing.JOptionPane;

/**
 * Le Terminal est le contr�leur GRASP de l'application. Il re�oit les messages
 * du contr�leur et les achemine vers le Catalogue.
 * @author Fran�ois Caron
 *
 */
public class Terminal {

	//Creation de linstance
	private static Terminal instance = new Terminal();
	
	/**
	 * Le catalogue est la classe int�ressante de l'exemple. La vue veut
	 * observer ce qui se passe avec le catalogue.
	 */
	
	private ListeRestaurants lsRestos;
	private ListeClients lsClients;
	
	
	
	
	//Section pour initier les variables des restaurants pour tests
	private Restaurant unResto = new Restaurant("382 avenue des pins","(514)937-0707",1);
	
	//Section pour initier les variables des usagers pour tests
	private Usager livreurTest = new Usager("livreur","1234","Tres bo", new Livreur());
	private Usager gerantTest = new Usager("gerant","1234","pas bo", new Gerant());
	private Usager adminTest = new Usager("admin","1234","laid", new Admin());
	private Usager listeUsager[] = {livreurTest,gerantTest,adminTest};
	private Usager lUsager;
	
	
	//Consctructeur et ce qui attrait a la gestion des obersvateurs
	private Terminal() {
		
			//chaineResto.ajouterRestaurant(unResto);
		
	   //	catalogue = new Menu(observateur);
	}
	
	public void addRestoObserver(Observer observateur){
		lsRestos = new ListeRestaurants(observateur);
	}
	
	public void addUsagerObserver(Observer observateur){
		lUsager = new Usager(observateur);
	}
	public void addMenuObserver(Observer observateur){
		lsRestos = new ListeRestaurants(observateur);
	}


	
	/**
	 * Cette m�thode sert � ajouter une String dans le catalogue.
	 * @param string
	 */
	public void ajouterItem(Double par1, String par2) {
		ItemMenu item = new ItemMenu(par1,par2);
		unResto.ajouterItem(item);
	}
	
	/**
	 * Cette m�thode sert � retirer une String dans le catalogue.
	 * @param index
	 */
	public void retirerItem(int index) {
		unResto.retirerItem(index);
	}
	
	
	/**
	 * Cette m�thode sert � ajouter une String dans le catalogue.
	 * @param string
	 */
	public void ajouterRestaurant(String adresse, String numeroTel, int numRestaurant) {
		Restaurant unResto = new Restaurant(adresse,numeroTel,numRestaurant);
		lsRestos.ajouterRestaurant(unResto);
	}
	
	/**
	 * Cette m�thode sert � ajouter une String dans le catalogue.
	 * @param string
	 */
	public void ajouterRestaurant(String adresse, String numeroTel, int numRestaurant, ArrayList<ItemMenu> m) {
		Restaurant restoTempo = new Restaurant(adresse,numeroTel,numRestaurant,m);
		lsRestos.ajouterRestaurant(unResto);
	}
	
	/**
	 * Cette m�thode sert � retirer un restaurant dans le catalogue.
	 * @param index
	 */
	public void retirerRestaurant(int index) {
		unResto.retirerItem(index);
	}
	
	public void ajouterClient(String loginName, String password, String infoDuDude) {
		Client clientTempo = new Client(loginName,password,infoDuDude);
		lsClients.ajouterClient(clientTempo);
	}
	
	/**
	 * Cette m�thode sert � retirer un Client dans le catalogue.
	 * @param index
	 */
	public void retirerClient(int index) {
		unResto.retirerItem(index);
	}
	
	
	public void authentifier() {
		int sizeTab = 3;
		boolean connected=false;
		boolean mauvaisPW=false;
		String ligneEntrer,verif1="master",verif2="chix",tempo[];
		Usager loginUser;
		while(!connected){
			ligneEntrer = JOptionPane.showInputDialog("Entrez Votre nom d'utilisateur suivi du mot de passe\nNomUsager:MotDePasse  ");
			tempo = ligneEntrer.split(":");
			
			
		int compteur = 0;
		
		while(!connected && !mauvaisPW && compteur != (listeUsager.length)){
				
						
			if(listeUsager[compteur].getLoginName().equals(tempo[0]) ){
				
				if(listeUsager[compteur].getPassword().equals(tempo[1])){
					connected=true;
					
					lUsager.setLoginName(listeUsager[compteur].getLoginName());
					lUsager.setPassword(listeUsager[compteur].getPassword());
					lUsager.setInfoDuDude(listeUsager[compteur].getInfoDuDude());
					lUsager.setDroits(listeUsager[compteur].getDroits());
					JOptionPane.showMessageDialog(null,"C chill " + lUsager.getDroits());
				}
				else{
					JOptionPane.showMessageDialog(null,"Mauvais mot de passe");
					mauvaisPW=true;
				}
			}
			else{
			
				compteur++;
				
				}
			}
		}
	
		
		
	}
		
	public void deconnexion(){
		
	lUsager.setDroits(new Null());
			
	}

	public static Terminal getInstance(){
		return instance;
	}


	
}

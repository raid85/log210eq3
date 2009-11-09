package modele;

/**
 *  dJ3gc6vA8de7Cette classe est utilisée lors de l'instanciation du Terminal. Elle ne sert
 * plus par la suite.
 */
import java.util.Observer;

import javax.swing.JOptionPane;

/**
 * Le Terminal est le contrôleur GRASP de l'application. Il reçoit les messages
 * du contrôleur et les achemine vers le Catalogue.
 * @author François Caron
 *
 */
public class Terminal {

	//Creation de linstance
	private static Terminal instance = new Terminal();
	
	/**
	 * Le catalogue est la classe intéressante de l'exemple. La vue veut
	 * observer ce qui se passe avec le catalogue.
	 */
	
	private ListeRestaurants chaineResto;
	private ListeUsagers lsUsers;
	
	
	
	
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
		chaineResto = new ListeRestaurants(observateur);
	}
	
	public void addUsagerObserver(Observer observateur){
		lsUsers = new ListeUsagers(observateur);
	}


	
	/**
	 * Cette méthode sert à ajouter une String dans le catalogue.
	 * @param string
	 */
	public void ajouterItem(Double par1, String par2) {
		ItemMenu item = new ItemMenu(par1,par2);
		unResto.ajouterItem(item);
	}
	
	/**
	 * Cette méthode sert à retirer une String dans le catalogue.
	 * @param index
	 */
	public void retirerItem(int index) {
		unResto.retirerItem(index);
	}
	
	/**
	 * Cette méthode sert à ajouter une String dans le catalogue.
	 * @param string
	 */
	public void ajouterUsager(Double par1, String par2) {
		ItemMenu item = new ItemMenu(par1,par2);
		unResto.ajouterItem(item);
	}
	
	/**
	 * Cette méthode sert à retirer une String dans le catalogue.
	 * @param index
	 */
	public void retirerUsager(int index) {
		unResto.retirerItem(index);
	}


	/**
	 * Cette méthode sert à ajouter une String dans le catalogue.
	 * @param string
	 */
	public void ajouterRestaurant(Double par1, String par2) {
		ItemMenu item = new ItemMenu(par1,par2);
		unResto.ajouterItem(item);
	}
	
	/**
	 * Cette méthode sert à retirer une String dans le catalogue.
	 * @param index
	 */
	public void retirerRestaurant(int index) {
		unResto.retirerItem(index);
	}
	
	
	public void authentifier() {
		int sizeTab = 3;
		boolean connected=false;
		boolean mauvaisPW=false;
		String ligneEntrer,verif1="master",verif2="chix",tempo[];
		
		while(!connected){
			ligneEntrer = JOptionPane.showInputDialog("Entrez Votre nom d'utilisateur suivi du mot de passe\nNomUsager:MotDePasse  ");
			tempo = ligneEntrer.split(":");
			
		int compteur = 0;
		
		while(!connected && !mauvaisPW && compteur != (listeUsager.length)){
				
						
			if(listeUsager[compteur].getLoginName().equals(tempo[0]) ){
				
				
				
				
				if(listeUsager[compteur].getPassword().equals(tempo[1])){
					connected=true;
					JOptionPane.showMessageDialog(null,"C chill");
					lUsager=listeUsager[compteur];
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
		
	lUsager = null;
	
		
	}

	public static Terminal getInstance(){
		return instance;
	}


	
}

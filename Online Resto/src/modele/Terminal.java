package modele;


/**
 *  Cette classe est utilisée lors de l'instanciation du Terminal. Elle ne sert
 * plus par la suite.
 */
import java.util.ArrayList;
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
	
	private ListeRestaurants lsRestos;
	private ListeClients lsClients;
	private EtatFenetre letatFen;
	
	
	
	//Section pour initier les variables des restaurants pour tests
	private Restaurant unResto = new Restaurant("restoolivier","382 avenue des pins","(514)937-0707","Laval","9h00","24h00");
	
	//Section pour initier les variables des usagers pour tests
	private Usager livreurTest = new Usager("livreur","1234","Tres bo", new Livreur());
	private Usager gerantTest = new Usager("gerant","1234","pas bo", new Gerant());
	private Usager adminTest = new Usager("admin","1234","laid", new Admin());
	private Usager clientTest = new Usager("client","1234","laid", new RClient());
	private Usager listeUsager[] = {livreurTest,gerantTest,adminTest,clientTest};
	private Usager lUsager;
	
	
	//Consctructeur et ce qui attrait a la gestion des obersvateurs
    Terminal() {
			
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
	public void addFenetreObserver(Observer observateur){
		letatFen = new EtatFenetre(observateur);
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
	public void ajouterRestaurant(String Nom,String adresse, String numeroTel,String zoneCouverture,String heureOuverture,String heureFermeture) {
		Restaurant unResto = new Restaurant(Nom,adresse,numeroTel,zoneCouverture,heureOuverture,heureFermeture);
		lsRestos.ajouterRestaurant(unResto);
		System.out.println(""+unResto.getAdresse()+this.toString());
	}
	
	/**
	 * Cette méthode sert à ajouter une String dans le catalogue.
	 * @param string
	 */
	public void ajouterRestaurant(String nom,String adresse, String numeroTel,String zoneCouverture,String heureOuverture,String heureFermeture, ArrayList<ItemMenu> m) {
		Restaurant restoTempo = new Restaurant(nom,adresse,numeroTel,zoneCouverture,heureOuverture,heureFermeture,m);
		lsRestos.ajouterRestaurant(unResto);
	}
	
	
	/**
	 * Cette méthode sert à retirer une String dans le catalogue.
	 * @param index
	 */
	
	
	/**
	 * Cette méthode sert à retirer un restaurant dans le catalogue.
	 * @param index
	 */
	public void retirerRestaurant(int index) {
		unResto.retirerItem(index);
	}
	
	public void ajouterClient(String loginName, String password, String infoDuDude) {
		//Client clientTempo = new Client(loginName,password,infoDuDude);
		//lsClients.ajouterClient(clientTempo);
		listeUsager[listeUsager.length]= new Usager(loginName,password,infoDuDude,new RClient());
	}
	public void modifierClient(int elementSelectionne, String loginName, String password, String infoDuDude) {
		//lsClients.
		//Client clientTempo = new Client(loginName,password,infoDuDude);
		//lsClients.ajouterClient(clientTempo);
	}
	
	/**
	 * Cette méthode sert à retirer un Client dans le catalogue.
	 * @param index
	 */
	public void retirerClient(int index) {
		unResto.retirerItem(index);
	}
	
	public void rafraichierVue(){
		letatFen.rafraichirVue();
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
	public Restaurant getResto(){
		return this.unResto ;
	}

	


	
}

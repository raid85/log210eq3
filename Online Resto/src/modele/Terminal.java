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
	private ListeUsagers lsUsagers;
	private ListeLivreur lsLivreurs;
	private EtatFenetre letatFen;
	private int indexUser;
	
	
	//Section pour initier les variables des restaurants pour tests
	private Restaurant unResto ;
	private Livreur unLivreur ;
	
	//Section pour initier les variables des usagers pour tests
	private Usager livreurTest = new Usager("livreur","1234","Tres bo", new Livreur());
	private Usager gerantTest = new Usager("gerant","1234","pas bo", new Gerant());
	private Usager adminTest = new Usager("admin","1234","laid", new Admin());
	private Usager clientTest = new Usager("client","1234","laid", new RClient());
	private Usager listeUsager[] = {livreurTest,gerantTest,adminTest,clientTest};
	private Usager lUsager;
	
	
	//Consctructeur et ce qui attrait a la gestion des obersvateurs
    Terminal() {}
	
	public void addRestoObserver(Observer observateur){
		lsRestos = new ListeRestaurants(observateur);
	}
	public void addLivreurObserver(Observer observateur){
		lsLivreurs = new ListeLivreur(observateur);
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
	
	public void ajouterItem(Double par1, String par2) {
		ItemMenu item = new ItemMenu(par1,par2);
		unResto.ajouterItem(item);
	}
	public void retirerItem(int index) {
		unResto.retirerItem(index);
	}
	public void modifierItem(int index, Double par1, String par2) {
		ItemMenu item = new ItemMenu(par1,par2);
		lsRestos.modifierRestaurant(index,unResto);
		System.out.println("terminal modifier restaurant"+unResto.getAdresse()+this.toString());
	}
	
	public void ajouterRestaurant(String Nom,String adresse, String numeroTel,String zoneCouverture,String heureOuverture) {
		this.unResto = new Restaurant(Nom,adresse,numeroTel,zoneCouverture,heureOuverture);
		lsRestos.ajouterRestaurant(unResto);
	}
	public void modifierRestaurant(int index, String Nom,String adresse, String numeroTel,String zoneCouverture,String heureOuverture) {
		this.unResto = new Restaurant(Nom,adresse,numeroTel,zoneCouverture,heureOuverture);
		lsRestos.modifierRestaurant(index,unResto);
		
	}
	public void retirerRestaurant(int index) {
		lsRestos.retirerRestaurant(index);
	}
	
	public void ajouterLivreur(String Nom,String adresse, String numeroTel,String zoneCouverture,String dispo) {
		this.unLivreur = new Livreur(Nom,adresse,numeroTel,zoneCouverture,dispo);
		//System.out.println("Livreur ajoute  :"+unLivreur.getNom());
		lsLivreurs.ajouterLivreur(unLivreur);
	}
	public void modifierLivreur(int index, String Nom,String adresse, String numeroTel,String zoneCouverture,String dispo) {
		this.unLivreur = new Livreur(Nom,adresse,numeroTel,zoneCouverture,dispo);
		lsLivreurs.modifierLivreur(index, unLivreur);
		//System.out.println("terminal modifier Livreur"+unLivreur.getNom()+this.toString());
	}
	public void retirerLivreur(int index) {
		lsLivreurs.retirerLivreur(index);
	}
	
	public void ajouterClient(String loginName, String password, String infoDuDude) {
		//Client clientTempo = new Client(loginName,password,infoDuDude);
		//lsClients.ajouterClient(clientTempo);
		Usager tempo = new Usager(loginName,password,infoDuDude,new RClient());
		listeUsager[listeUsager.length-1]= tempo;
		
		lUsager = tempo;
	}
	public Usager getlUsager() {
		return lUsager;
	}

	public void modifierClient(String loginName, String password, String infoDuDude) {
		lUsager = new Usager(loginName,password,infoDuDude,new RClient());
		lsUsagers.modifierUsager(indexUser, lUsager);
	}
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
					indexUser = compteur;
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

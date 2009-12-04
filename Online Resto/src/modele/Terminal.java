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
	


	public void setlUsager(Usager lUsager) {
		this.lUsager = lUsager;
	}

	//Creation de linstance
	private static Terminal instance = new Terminal();
	
	/**
	 * Le catalogue est la classe int�ressante de l'exemple. La vue veut
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
	/*
	private Usager livreurTest = new Usager("livreur","1234","Tres bo", new Livreur());
	private Usager gerantTest = new Usager("gerant","1234","pas bo", new Gerant());
	private Usager adminTest = new Usager("admin","1234","laid", new Admin());
	private Usager clientTest = new Usager("client","1234","laid", new RClient());
	private Usager listeUsager[] = {livreurTest,gerantTest,adminTest,clientTest};
	*/
	private Usager lUsager;
	
	
	//Consctructeur et ce qui attrait a la gestion des obersvateurs
    Terminal() {
    	lsRestos = new ListeRestaurants();
    	lsLivreurs = new ListeLivreur();
    	lUsager = new Usager();
    	letatFen = new EtatFenetre();
    	lsUsagers = new ListeUsagers();
    }
	
	public void addRestoObserver(Observer observateur){
		lsRestos.ajouterObserver(observateur);
		
	}
	public void addLivreurObserver(Observer observateur){
		lsLivreurs.ajouterObserver(observateur);
		
	}
	public void addUsagerObserver(Observer observateur){
		lUsager.ajouterObserver(observateur);
		
	}
	public void addMenuObserver(Observer observateur){
		lsRestos.ajouterObserver(observateur);
		
		
	}
	public void addFenetreObserver(Observer observateur){
		letatFen.ajouterObserver(observateur);
		
	}
	
	

	public void ajouterItem(int indexR, Double par1, String par2) {
		ItemMenu item = new ItemMenu(par1,par2);
		
		lsRestos.ajouterItemMenu(indexR, item);
	}
	public void retirerItem(int indexR, int indexIM) {
		lsRestos.retirerItemMenu(indexR, indexIM);
	}
	public void modifierItem(int indexR, int indexIM, Double par1, String par2) {
		ItemMenu item = new ItemMenu(par1,par2);
		lsRestos.modifierItemMenu(indexR, indexIM, item);
		
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
	
	public void ajouterLivreur(String nom,String adresse, String numeroTel,String zoneCouverture,String dispo) {
		this.unLivreur = new Livreur(nom,adresse,numeroTel,zoneCouverture,dispo);
		//System.out.println("Livreur ajoute  :"+unLivreur.getNom());
		lsLivreurs.ajouterLivreur(unLivreur);
		ajouterUsager(nom,"1234",adresse, new Livreur());
	}
	public void modifierLivreur(int index, String nom,String adresse, String numeroTel,String zoneCouverture,String dispo) {
		this.unLivreur = new Livreur(nom,adresse,numeroTel,zoneCouverture,dispo);
		lsLivreurs.modifierLivreur(index, unLivreur);
		modifierUsager(index,nom, "1234",adresse, new Livreur());
		//System.out.println("terminal modifier Livreur"+unLivreur.getNom()+this.toString());
	}
	public void retirerLivreur(int index) {
		lsLivreurs.retirerLivreur(index);
	}
	public void ajouterUsager(String loginName, String password, String infoDuDude, Role droits){
		lsUsagers.ajouterUsager(new Usager(loginName, password, infoDuDude, droits));
	}
	public void modifierUsager(int index, String loginName, String password, String infoDuDude, Role droits ){
		lsUsagers.modifierUsager(index, new Usager(loginName, password, infoDuDude, droits));
	}
	public void retirerUsager(int index){
		lsUsagers.retirerUsager(index);
	}
	
	public void ajouterClient(String loginName, String password, String infoDuDude) {
		//Client clientTempo = new Client(loginName,password,infoDuDude);
		//lsClients.ajouterClient(clientTempo);
		Usager tempo = new Usager(loginName,password,infoDuDude,new RClient());
		JOptionPane.showMessageDialog(null,loginName+password+infoDuDude);
		lsUsagers.ajouterUsager(tempo);
		indexUser=lsUsagers.getHauteur();
		lUsager.setUsager(loginName,password,infoDuDude,new RClient());
		
		
	}
	public Usager getlUsager() {
		return lUsager;
	}

	public void modifierClient(String loginName, String password, String infoDuDude) {
		lUsager.setUsager(loginName,password,infoDuDude,new RClient());
		lsUsagers.modifierUsager(indexUser, lUsager);
		
	}
	public void retirerClient() {
		lsUsagers.retirerUsager(indexUser);
		deconnexion();
	}
	
	public void rafraichierVue(){
		letatFen.rafraichirVue();
	}
	
	public void authentifier() {
		Usager tempo= lsUsagers.authentifier();
		Role rTempo = tempo.getDroits();
		lUsager.setUsager(tempo.getLoginName(), tempo.getPassword(), tempo.getInfoDuDude(),rTempo);
		/*int sizeTab = 3;
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
		}*/
	
	}
	
	public void deconnexion(){
		
	lUsager.setDroits(new Null());
			
	}

	public static Terminal getInstance(){
		return instance;
	}
	
	public Restaurant getResto(int index){
		return lsRestos.getResto(index);
	}

	public void updateVueMenu() {
		//lsRestos
		
	}

	public void retirerMenu(int elementSelectionne) {
	lsRestos.retirerMenu(elementSelectionne);
		
	}

	


	


	
}

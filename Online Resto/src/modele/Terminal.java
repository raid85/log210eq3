package modele;

/**
 * Cette classe est utilisée lors de l'instanciation du Terminal. Elle ne sert
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

	/**
	 * Le catalogue est la classe intéressante de l'exemple. La vue veut
	 * observer ce qui se passe avec le catalogue.
	 */
	private Menu catalogue;
	
	//Section pour initier les variables des usagers
	private Usager livreurTest = new Usager("livreur","1234","Tres bo", new Livreur());
	private Usager gerantTest = new Usager("gerant","1234","pas bo", new Gerant());
	private Usager adminTest = new Usager("admin","1234","laid", new Admin());
	private Usager listeUsager[] = {livreurTest,gerantTest,adminTest};
	private Usager lUsager;
	
	/**
	 * Constructeur avec paramètre.
	 * Lors de l'instanciation du Terminal, le Terminal instancie un Catalogue.
	 * @param observateur
	 */
	public Terminal(Observer observateur) {
		
		catalogue = new Menu(observateur);
	}
	
	
	/**
	 * Cette méthode sert à ajouter une String dans le catalogue.
	 * @param string
	 */
	public void ajouterItem(Double par1, String par2) {
		ItemMenu item = new ItemMenu(par1,par2);
		catalogue.ajouterItem(item);
	}
	
	/**
	 * Cette méthode sert à retirer une String dans le catalogue.
	 * @param index
	 */
	public void retirerItem(int index) {
		catalogue.retirerItem(index);
	}


	public void authentifier() {
		int sizeTab = 3;
		boolean nomTrouver = false;
		boolean connected=false;
		String ligneEntrer,verif1="master",verif2="chix",tempo[];
		
		while(!connected){
			ligneEntrer = JOptionPane.showInputDialog("Entrez Votre nom d'utilisateur suivi du mot de passe\nNomUsager:MotDePasse  ");
			tempo = ligneEntrer.split(":");
			
		int compteur = 0;
		
		while(nomTrouver=false || compteur != 3-1){
			if(listeUsager[compteur].getLoginName().equals(tempo[0]) ){
				if(listeUsager[compteur].getPassword().equals(tempo[1])){
					nomTrouver=true;
					JOptionPane.showMessageDialog(null,"C chill");
				}
				else
					JOptionPane.showMessageDialog(null,"Mauvais mot de passe");
				
			}
		}
		}
	
		
		
	}
		
	public void deconnection(){
		
	lUsager = null;
	
		
	}


	
}

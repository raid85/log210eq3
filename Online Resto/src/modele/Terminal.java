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
	public void ajouterItem(ItemMenu item) {
		catalogue.ajouterItem(item);
	}
	
	/**
	 * Cette méthode sert à retirer une String dans le catalogue.
	 * @param index
	 */
	public void retirerItem(int index) {
		catalogue.retirerItem(index);
	}
}

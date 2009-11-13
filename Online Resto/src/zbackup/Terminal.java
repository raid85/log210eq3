package modele;

/**
 * Cette classe est utilisée lors de l'instanciation du Terminal. Elle ne sert
 * plus par la suite.
 */
import java.util.Observer;

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
	private Catalogue catalogue;
	
	/**
	 * Constructeur avec paramètre.
	 * Lors de l'instanciation du Terminal, le Terminal instancie un Catalogue.
	 * @param observateur
	 */
	public Terminal(Observer observateur) {
		catalogue = new Catalogue(observateur);
	}
	
	/**
	 * Cette méthode sert à ajouter une String dans le catalogue.
	 * @param string
	 */
	public void ajouterString(String string) {
		catalogue.ajouterString(string);
	}
	
	/**
	 * Cette méthode sert à retirer une String dans le catalogue.
	 * @param index
	 */
	public void retirerString(int index) {
		catalogue.retirerString(index);
	}
}

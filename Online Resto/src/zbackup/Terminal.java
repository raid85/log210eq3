package modele;

/**
 * Cette classe est utilis�e lors de l'instanciation du Terminal. Elle ne sert
 * plus par la suite.
 */
import java.util.Observer;

/**
 * Le Terminal est le contr�leur GRASP de l'application. Il re�oit les messages
 * du contr�leur et les achemine vers le Catalogue.
 * @author Fran�ois Caron
 *
 */
public class Terminal {

	/**
	 * Le catalogue est la classe int�ressante de l'exemple. La vue veut
	 * observer ce qui se passe avec le catalogue.
	 */
	private Catalogue catalogue;
	
	/**
	 * Constructeur avec param�tre.
	 * Lors de l'instanciation du Terminal, le Terminal instancie un Catalogue.
	 * @param observateur
	 */
	public Terminal(Observer observateur) {
		catalogue = new Catalogue(observateur);
	}
	
	/**
	 * Cette m�thode sert � ajouter une String dans le catalogue.
	 * @param string
	 */
	public void ajouterString(String string) {
		catalogue.ajouterString(string);
	}
	
	/**
	 * Cette m�thode sert � retirer une String dans le catalogue.
	 * @param index
	 */
	public void retirerString(int index) {
		catalogue.retirerString(index);
	}
}

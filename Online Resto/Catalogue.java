

/**
 * Ces classes sont utilis�es pour permettre l'utilisation d'une collection.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Ces classes sont utilis�es pour le patron MVC.
 */
import java.util.Observable;
import java.util.Observer;

/**
 * Le Catalogue est le point de mire de la Vue.
 * @author Fran�ois Caron
 *
 */
public class Catalogue extends Observable {

	/**
	 * La collection qui permet de stocker les strings.
	 */
	private List<String> listeStrings;
	
	/**
	 * Constructeur avec param�tre.
	 * Lors de l'instanciation du Catalogue, l'observateur re�u est ajout� � la
	 * liste des ses observateurs.
	 * @param observateur
	 */
	public Catalogue(Observer observateur) {
		/*
		 * L'attribut de la classe ignore le type exact de List.
		 * Dans le cas pr�sent, une ArrayList a �t� utilis�. Un autre type de
		 * List aurait fait l'affaire.
		 */
		listeStrings = new ArrayList<String>();
		
		/*
		 * L'observateur re�u en param�tre est ajout� aux observateurs du
		 * Catalogue.
		 */
		addObserver(observateur);
	}
	
	/**
	 * Cette m�thode sert � ajouter une string au Catalogue.
	 * Lors de l'ajout d'une string, les observateurs sont avis�s de la 
	 * modification.
	 * @param string
	 */
	public void ajouterString(String string) {
		listeStrings.add(string);
		
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(listeStrings.toArray());
	}
	
	/**
	 * Cette m�thode sert � retirer une string du Catalogue.
	 * Lors du retrait d'une string, les observateurs sont avis�s de la
	 * modification.
	 * @param index
	 */
	public void retirerString(int index) {
		listeStrings.remove(index);
		
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(listeStrings.toArray());
	}
	
}

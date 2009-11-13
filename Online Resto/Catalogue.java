

/**
 * Ces classes sont utilisées pour permettre l'utilisation d'une collection.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Ces classes sont utilisées pour le patron MVC.
 */
import java.util.Observable;
import java.util.Observer;

/**
 * Le Catalogue est le point de mire de la Vue.
 * @author François Caron
 *
 */
public class Catalogue extends Observable {

	/**
	 * La collection qui permet de stocker les strings.
	 */
	private List<String> listeStrings;
	
	/**
	 * Constructeur avec paramètre.
	 * Lors de l'instanciation du Catalogue, l'observateur reçu est ajouté à la
	 * liste des ses observateurs.
	 * @param observateur
	 */
	public Catalogue(Observer observateur) {
		/*
		 * L'attribut de la classe ignore le type exact de List.
		 * Dans le cas présent, une ArrayList a été utilisé. Un autre type de
		 * List aurait fait l'affaire.
		 */
		listeStrings = new ArrayList<String>();
		
		/*
		 * L'observateur reçu en paramètre est ajouté aux observateurs du
		 * Catalogue.
		 */
		addObserver(observateur);
	}
	
	/**
	 * Cette méthode sert à ajouter une string au Catalogue.
	 * Lors de l'ajout d'une string, les observateurs sont avisés de la 
	 * modification.
	 * @param string
	 */
	public void ajouterString(String string) {
		listeStrings.add(string);
		
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(listeStrings.toArray());
	}
	
	/**
	 * Cette méthode sert à retirer une string du Catalogue.
	 * Lors du retrait d'une string, les observateurs sont avisés de la
	 * modification.
	 * @param index
	 */
	public void retirerString(int index) {
		listeStrings.remove(index);
		
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(listeStrings.toArray());
	}
	
}

package modele;

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

import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Le Catalogue est le point de mire de la Vue.
 * @author François Caron
 *
 */
public class ListeRestaurants extends Observable {

	/**
	 * La collection qui permet de stocker les strings.
	 */
	private List<Restaurant> m;
	
	/**
	 * Constructeur avec paramètre.
	 * Lors de l'instanciation du Catalogue, l'observateur reçu est ajouté à la
	 * liste des ses observateurs.
	 * @param observateur
	 */
	public ListeRestaurants() {
		/*
		 * L'attribut de la classe ignore le type exact de List.
		 * Dans le cas présent, une ArrayList a été utilisé. Un autre type de
		 * List aurait fait l'affaire.
		 */
		m = new ArrayList<Restaurant>();
		
		/*
		 * L'observateur reçu en paramètre est ajouté aux observateurs du
		 * Catalogue.
		 */
		
	}
	
	/**
	 * Cette méthode sert à ajouter une string au Catalogue.
	 * Lors de l'ajout d'une string, les observateurs sont avisés de la 
	 * modification.
	 * @param string
	 */
	public void ajouterRestaurant(Restaurant resto) {
		m.add(resto);
		
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(m.toArray());
	}
	
	/**
	 * Cette méthode sert à retirer une string du Catalogue.
	 * Lors du retrait d'une string, les observateurs sont avisés de la
	 * modification.
	 * @param index
	 */
	public void retirerRestaurant(int index) {
		m.remove(index);
		
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(m.toArray());
	}
	public void modifierRestaurant(int index, Restaurant resto) {
		m.remove(index);
		m.add(index, resto);
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(m.toArray());
	}
	public void ajouterItemMenu(int indexR, ItemMenu item){
		Restaurant tempo = m.get(indexR);
		tempo.ajouterItem(item);
		modifierRestaurant(indexR,tempo);
		
		setChanged();
		notifyObservers(m.toArray());		
	}
	public void modifierItemMenu(int indexR, int indexIM, ItemMenu item){
		Restaurant tempo = m.get(indexR);
		tempo.modifierItem(indexIM, item);
		modifierRestaurant(indexR,tempo);
		
		setChanged();
		notifyObservers(m.toArray());			
	}
	public void retirerItemMenu(int indexR, int indexIM){
		Restaurant tempo = m.get(indexR);
		tempo.retirerItem(indexIM);
		modifierRestaurant(indexR,tempo);
		
		setChanged();
		notifyObservers(m.toArray());			
	}
	
	public Restaurant getResto(int index){
		return m.get(index);
	}
	
	public void ajouterObserver(Observer observateur) {
		
		addObserver(observateur);
		

		setChanged();
		notifyObservers(m.toArray());
	}

	public void retirerMenu(int elementSelectionne) {
		
		Restaurant tempo;
		tempo = m.get(elementSelectionne);
		tempo.retirerMenu();
		m.remove(elementSelectionne);
		m.add(elementSelectionne, tempo);
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(m.toArray());
		
	}


	
}

package modele;

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
public class ListeLivreur extends Observable {

	/**
	 * La collection qui permet de stocker les strings.
	 */
	private List<Livreur> l;
	
	/**
	 * Constructeur avec param�tre.
	 * Lors de l'instanciation du Catalogue, l'observateur re�u est ajout� � la
	 * liste des ses observateurs.
	 * @param observateur
	 */
	public ListeLivreur() {
		/*
		 * L'attribut de la classe ignore le type exact de List.
		 * Dans le cas pr�sent, une ArrayList a �t� utilis�. Un autre type de
		 * List aurait fait l'affaire.
		 */
		l = new ArrayList<Livreur>();
		
		/*
		 * L'observateur re�u en param�tre est ajout� aux observateurs du
		 * Catalogue.
		 */
		
	}
	
	/**
	 * Cette m�thode sert � ajouter une string au Catalogue.
	 * Lors de l'ajout d'une string, les observateurs sont avis�s de la 
	 * modification.
	 * @param string
	 */
	public void ajouterLivreur(Livreur livreur) {
		//System.out.println("Livreur ajoute :"+livreur.toString()+" "+livreur.getClass());
		l.add(livreur);
		
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(l.toArray());
	}
	
	/**
	 * Cette m�thode sert � retirer une string du Catalogue.
	 * Lors du retrait d'une string, les observateurs sont avis�s de la
	 * modification.
	 * @param index
	 */
	public void retirerLivreur(int index) {
		//System.out.println("Livreur enleve : "+l.get(index).getNom());
		l.remove(index);
		
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(l.toArray());
	}
	public void modifierLivreur(int index, Livreur livreur) {
		l.remove(index);
		l.add(index, livreur);
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(l.toArray());
	}
	
	public Livreur getLivreur (int index){
		return l.get(index);
	}
	public void ajouterObserver(Observer observateur) {
		addObserver(observateur);
		setChanged();
		notifyObservers(l.toArray());
	}

	
}
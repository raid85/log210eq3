package modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class EtatFenetre extends Observable {

	public EtatFenetre() {
				
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
	public void rafraichirVue() {
			
		/*
		 * Il est important d'indiquer que la classe observée a changé AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(null);
	}
	
	public void ajouterObserver(Observer observateur) {
		addObserver(observateur);
		notifyObservers(null);
	}
	
}


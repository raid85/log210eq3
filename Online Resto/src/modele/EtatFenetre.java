package modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class EtatFenetre extends Observable {

	public EtatFenetre() {
				
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
	public void rafraichirVue() {
			
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
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


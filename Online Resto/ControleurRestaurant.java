package controleur;

/**
 * Ces classes permettent au ControleurVue d'agir comme ActionListener,
 * DocumentListener et ListSelectionListener.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import modele.*;

/**
 * 
 * @author François Caron
 *
 */
public class ControleurRestaurant implements ActionListener {

	/**
	 * Cet attribut sert à stocker le texte.
	 */
	private String texte[];

	/**
	 * Cet attribut sert à stocker l'index de l'élément sélectionné dans une
	 * liste.
	 */
	private int elementSelectionne;

	/**
	 * Le Terminal est la classe du modèle avec laquelle le contrôleur
	 * communique.
	 */
	private Terminal instance;

	//usager qui utilise le systeme
	Usager unUsager;	

	/**
	 * Constructeur avec paramètre.
	 * Lors de l'instanciation du contrôleur, un observateur (la vue) est passé
	 * en paramètre de façon à ce que le contrôleur puisse ajouter l'obervateur
	 * dans le modèle.
	 * 
	 * @param observateur
	 */
	public ControleurRestaurant(Observer observateur) {

		instance=Terminal.getInstance();
		instance.addRestoObserver(observateur);
		//texte = null;
		elementSelectionne = -1;

	}

	public void setTexte(int position,String texte){
		this.texte[position]=texte ;

	}




	public void actionPerformed(ActionEvent arg0) {
		/*
		 * Lorsque le bouton de la vue est appuyé, cette méthode est invoquée.
		 * Pour s'assurer que la méthode traite la bonne action, il faut
		 * vérifier la commande associée à l'action (la commande a été définie
		 * au préalable).
		 */
		String action = arg0.getActionCommand();

		if(action.equalsIgnoreCase("AJOUTER")) {
			//instance.ajouterRestaurant(adresse, numeroTel, numRestaurant);

		} 

		else if(action.equalsIgnoreCase("ENLEVER")) {
			if(elementSelectionne != -1) {
				instance.retirerRestaurant(elementSelectionne);
				/*
				 * Lorsque l'élément sélectionné a été retiré, il remettre la
				 * valeur à -1
				 */
				elementSelectionne = -1;
			}
		}

	}	

}

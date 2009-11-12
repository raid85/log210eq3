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
 * @author Fran�ois Caron
 *
 */
public class ControleurRestaurant implements ActionListener {

	/**
	 * Cet attribut sert � stocker le texte.
	 */
	private String texte[];

	/**
	 * Cet attribut sert � stocker l'index de l'�l�ment s�lectionn� dans une
	 * liste.
	 */
	private int elementSelectionne;

	/**
	 * Le Terminal est la classe du mod�le avec laquelle le contr�leur
	 * communique.
	 */
	private Terminal instance;

	//usager qui utilise le systeme
	Usager unUsager;	

	/**
	 * Constructeur avec param�tre.
	 * Lors de l'instanciation du contr�leur, un observateur (la vue) est pass�
	 * en param�tre de fa�on � ce que le contr�leur puisse ajouter l'obervateur
	 * dans le mod�le.
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
		 * Lorsque le bouton de la vue est appuy�, cette m�thode est invoqu�e.
		 * Pour s'assurer que la m�thode traite la bonne action, il faut
		 * v�rifier la commande associ�e � l'action (la commande a �t� d�finie
		 * au pr�alable).
		 */
		String action = arg0.getActionCommand();

		if(action.equalsIgnoreCase("AJOUTER")) {
			//instance.ajouterRestaurant(adresse, numeroTel, numRestaurant);

		} 

		else if(action.equalsIgnoreCase("ENLEVER")) {
			if(elementSelectionne != -1) {
				instance.retirerRestaurant(elementSelectionne);
				/*
				 * Lorsque l'�l�ment s�lectionn� a �t� retir�, il remettre la
				 * valeur � -1
				 */
				elementSelectionne = -1;
			}
		}

	}	

}

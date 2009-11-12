package controleur;

/**
 * Ces classes permettent au ControleurVue d'agir comme ActionListener,
 * DocumentListener et ListSelectionListener.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import vue.VueRestaurant;

import modele.*;

/**
 * 
 * @author Fran�ois Caron
 *
 */
public class ControleurRestaurant implements ActionListener {

	//... The Controller needs to interact with both the Model and View.
	private VueRestaurant vue ;
	private Terminal instance;

	/**
	 * Cet attribut sert � stocker le texte.
	 */
	private String texte;

	/**
	 * Cet attribut sert � stocker l'index de l'�l�ment s�lectionn� dans une
	 * liste.
	 */
	private int elementSelectionne;

	/**
	 * Le Terminal est la classe du mod�le avec laquelle le contr�leur
	 * communique.
	 */


	//usager qui utilise le systeme
	Usager unUsager;


	/**
	 * Constructeur avec param�tre.
	 * Lors de l'instanciation du contr�leur, un observateur (la vue) est pass�
	 * en param�tre de fa�on � ce que le contr�leur puisse ajouter l'obervateur
	 * dans le mod�le. De plus le controlleur doit connaitre la vue 
	 * 
	 * @param observateur 
	 */
	public ControleurRestaurant(Observer observateur) {
		
		instance=Terminal.getInstance();
		instance.addRestoObserver(observateur);	
		this.vue = (VueRestaurant) observateur;

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
			
			vue.grabText();
			instance.ajouterRestaurant(vue.getAdresse(),vue.getTelephone(),vue.getZoneLivraison(),vue.getHeureOuverture(),vue.getHeureFermeture(),vue.getNum());


		} 
		else if(action.equalsIgnoreCase("RETIRER")) {	
			instance.retirerRestaurant(vue.getNum());

		}

	}




}

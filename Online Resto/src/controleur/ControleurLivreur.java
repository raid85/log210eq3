package controleur;

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

import vue.VueLivreur;
import vue.VueRestaurant;

import modele.*;


public class ControleurLivreur implements ActionListener, ListSelectionListener{



	//... The Controller needs to interact with both the Model and View.
	private VueLivreur vue ;
	private Terminal instance;
	private String texte;
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
	public ControleurLivreur(Observer observateur) {

		instance=Terminal.getInstance();
		instance.addLivreurObserver(observateur);	
		this.vue = (VueLivreur) observateur;

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

			instance.ajouterLivreur(vue.getNom(),vue.getAdresse(),vue.getTelephone(),vue.getZoneCouverture(),vue.getDispo());			


		} 
		else if(action.equalsIgnoreCase("ENLEVER")) {	

			if(elementSelectionne != -1) {
				instance.retirerLivreur(elementSelectionne);
				/*
				 * Lorsque l'�l�ment s�lectionn� a �t� retir�, il remettre la
				 * valeur � -1
				 */
				elementSelectionne = -1;
			}
		} 

		else if(action.equalsIgnoreCase("MODIFIER")) {	

			instance.modifierLivreur(elementSelectionne, vue.getNom(),vue.getAdresse(),vue.getTelephone(),vue.getZoneCouverture(),vue.getDispo());

		}
		else {
			System.err.println("L'action '" + action + "' est inconnue...");
		}

	}

	//@Override
	public void changedUpdate(DocumentEvent arg0) {
		/*
		 * Cette m�thode sert � copier le texte dans la bo�te de texte de la vue.
		 * 
		 * La m�thode "changedUpdate" n'est pas appel�e directement lorsqu'un
		 * caract�re est ajout� ou retir� de la bo�te de texte. Ce sont plut�t
		 * les m�thodes insertUpdate et removeUpdate qui sont invoqu�es.
		 * Cependant, les deux m�thodes appellent la m�thode changedUpdate, car
		 * le m�me traitement est effectu� dans les deux cas.
		 */
		Document document = arg0.getDocument();
		try {
			texte = document.getText(0, document.getLength());
		} catch (BadLocationException e) {
			texte = "";
		}
	}

	//@Override
	public void valueChanged(ListSelectionEvent arg0) {
		/*
		 * Lorsque l'utilisateur s�lectionne un �l�ment dans la liste, le
		 * contr�leur note l'index de l'item s�lectionn�.
		 */
		elementSelectionne = arg0.getFirstIndex();
	}









}

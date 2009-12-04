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
	 * Le Terminal est la classe du modèle avec laquelle le contrôleur
	 * communique.
	 */


	//usager qui utilise le systeme
	Usager unUsager;


	/**
	 * Constructeur avec paramètre.
	 * Lors de l'instanciation du contrôleur, un observateur (la vue) est passé
	 * en paramètre de façon à ce que le contrôleur puisse ajouter l'obervateur
	 * dans le modèle. De plus le controlleur doit connaitre la vue 
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
		 * Lorsque le bouton de la vue est appuyé, cette méthode est invoquée.
		 * Pour s'assurer que la méthode traite la bonne action, il faut
		 * vérifier la commande associée à l'action (la commande a été définie
		 * au préalable).
		 */
		String action = arg0.getActionCommand();
		if(action.equalsIgnoreCase("AJOUTER")) {            

			instance.ajouterLivreur(vue.getNom(),vue.getAdresse(),vue.getTelephone(),vue.getZoneCouverture(),vue.getDispo());			


		} 
		else if(action.equalsIgnoreCase("ENLEVER")) {	

			if(elementSelectionne != -1) {
				instance.retirerLivreur(elementSelectionne);
				/*
				 * Lorsque l'élément sélectionné a été retiré, il remettre la
				 * valeur à -1
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
		 * Cette méthode sert à copier le texte dans la boîte de texte de la vue.
		 * 
		 * La méthode "changedUpdate" n'est pas appelée directement lorsqu'un
		 * caractère est ajouté ou retiré de la boîte de texte. Ce sont plutôt
		 * les méthodes insertUpdate et removeUpdate qui sont invoquées.
		 * Cependant, les deux méthodes appellent la méthode changedUpdate, car
		 * le même traitement est effectué dans les deux cas.
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
		 * Lorsque l'utilisateur sélectionne un élément dans la liste, le
		 * contrôleur note l'index de l'item sélectionné.
		 */
		elementSelectionne = arg0.getFirstIndex();
	}









}

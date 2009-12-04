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

import vue.VueMenu;
import vue.VueRestaurant;

import modele.*;

/**
 * 
 * @author François Caron
 *
 */
public class ControleurMenu implements ActionListener, ListSelectionListener {
	
	/**
	 * Cet attribut sert à stocker le texte.
	 */
	private String texte;
	
	/**
	 * Cet attribut sert à stocker l'index de l'élément sélectionné dans une
	 * liste.
	 */
	private int elementSelectionne;
	
	private VueMenu vue ;
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
	public ControleurMenu(Observer observateur) {
		
		
		instance=Terminal.getInstance();
		instance.addMenuObserver(observateur);
		this.vue = (VueMenu) observateur;
		texte = "";
		elementSelectionne = -1;
	     	
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
			//if(vue.getNom().equals("") || vue.getAdresse().equals("") ){
			Double tempo = Double.parseDouble(vue.getTextPrixItem());
			instance.ajouterItem(elementSelectionne, tempo, vue.getTextItemDeMenu());
			// vue.doList(instance.getResto());
			//} 

		} 
		else if(action.equalsIgnoreCase("ENLEVER")) {	
			//instance.retirerRestaurant(vue.getNum());
			if(elementSelectionne != -1) {
				instance.retirerItem(elementSelectionne, vue.getSelectionMenu());
				/*
				 * Lorsque l'élément sélectionné a été retiré, il remettre la
				 * valeur à -1
				 */
				elementSelectionne = -1;
			}
			else {
				JOptionPane.showMessageDialog(null,"La liste est vide");
			}
		} 

		else if(action.equalsIgnoreCase("MODIFIER")) {	
			
			Double tempo = Double.parseDouble(vue.getTextPrixItem());
			instance.modifierItem(elementSelectionne, vue.getSelectionMenu(), tempo, vue.getTextItemDeMenu());
		}
		else {
			System.err.println("L'action '" + action + "' est inconnue...");
		}
		
	}

	



	
	public void valueChanged(ListSelectionEvent arg0) {
		/*
		 * Lorsque l'utilisateur sélectionne un élément dans la liste, le
		 * contrôleur note l'index de l'item sélectionné.
		 */
		elementSelectionne = arg0.getFirstIndex();
	}

}

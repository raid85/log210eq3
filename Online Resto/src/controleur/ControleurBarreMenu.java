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

import vue.BarreMenu;
import vue.Fenetre;
import vue.VueRestaurant;

import modele.*;

/**
 * 
 * @author François Caron
 *
 */
public class ControleurBarreMenu implements ActionListener, DocumentListener, ListSelectionListener {
	
	/**
	 * Cet attribut sert à stocker le texte.
	 */
	private String texte;
	
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
	private BarreMenu laVue;
	
	
	
	/**
	 * Constructeur avec paramètre.
	 * Lors de l'instanciation du contrôleur, un observateur (la vue) est passé
	 * en paramètre de façon à ce que le contrôleur puisse ajouter l'obervateur
	 * dans le modèle.
	 * 
	 * @param observateur
	 */
	public ControleurBarreMenu(Observer observateur) {
		instance=Terminal.getInstance();
		
		instance.addUsagerObserver(observateur);
	
		this.laVue = (BarreMenu) observateur;
		
	}


	public void actionPerformed(ActionEvent arg0) {
		/*
		 * Lorsque le bouton de la vue est appuyé, cette méthode est invoquée.
		 * Pour s'assurer que la méthode traite la bonne action, il faut
		 * vérifier la commande associée à l'action (la commande a été définie
		 * au préalable).
		 */
		String action = arg0.getActionCommand();
		
		if(action.equalsIgnoreCase("CONNEXION")) {
		
			
			instance.authentifier();
		
			
			
		}
		
		else if(action.equalsIgnoreCase("DECONNEXION")) {
			instance.deconnexion();
			laVue.nouvelleVueDefaut();
			instance.rafraichierVue();
			
		}
		
		else if(action.equalsIgnoreCase("QUITTER")) {
			System.exit(0);			
		}
		
		else if(action.equalsIgnoreCase("ADDMENU")) {
			laVue.nouvelleVueMenu();
			instance.rafraichierVue();
		}
		
		else if(action.equalsIgnoreCase("MODMENU")) {
			laVue.nouvelleVueMenu();
			instance.rafraichierVue();
			
		}
		else if(action.equalsIgnoreCase("SUPMENU")) {
			
		}
		else if(action.equalsIgnoreCase("ADDRESTO")) {
			laVue.nouvelleVueRestaurant();
			instance.rafraichierVue();
		}
		
		else if(action.equalsIgnoreCase("MODRESTO")) {
			laVue.nouvelleVueRestaurant();
			instance.rafraichierVue();
		}
		else if(action.equalsIgnoreCase("SUPRESTO")) {
			
		}	
		
		else {
			System.err.println("L'action '" + action + "' est inconnue...");
		}
	}

	
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

	
	public void insertUpdate(DocumentEvent arg0) {
		changedUpdate(arg0);
	}

	
	public void removeUpdate(DocumentEvent arg0) {
		changedUpdate(arg0);
	}

	
	public void valueChanged(ListSelectionEvent arg0) {
		/*
		 * Lorsque l'utilisateur sélectionne un élément dans la liste, le
		 * contrôleur note l'index de l'item sélectionné.
		 */
		elementSelectionne = arg0.getFirstIndex();
	}

}

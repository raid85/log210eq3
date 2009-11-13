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
 * @author Fran�ois Caron
 *
 */
public class ControleurBarreMenu implements ActionListener, DocumentListener, ListSelectionListener {
	
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
	private Terminal instance;
	
	//usager qui utilise le systeme
	Usager unUsager;
	private BarreMenu laVue;
	
	
	
	/**
	 * Constructeur avec param�tre.
	 * Lors de l'instanciation du contr�leur, un observateur (la vue) est pass�
	 * en param�tre de fa�on � ce que le contr�leur puisse ajouter l'obervateur
	 * dans le mod�le.
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
		 * Lorsque le bouton de la vue est appuy�, cette m�thode est invoqu�e.
		 * Pour s'assurer que la m�thode traite la bonne action, il faut
		 * v�rifier la commande associ�e � l'action (la commande a �t� d�finie
		 * au pr�alable).
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

	
	public void insertUpdate(DocumentEvent arg0) {
		changedUpdate(arg0);
	}

	
	public void removeUpdate(DocumentEvent arg0) {
		changedUpdate(arg0);
	}

	
	public void valueChanged(ListSelectionEvent arg0) {
		/*
		 * Lorsque l'utilisateur s�lectionne un �l�ment dans la liste, le
		 * contr�leur note l'index de l'item s�lectionn�.
		 */
		elementSelectionne = arg0.getFirstIndex();
	}

}

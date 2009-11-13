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
public class ControleurVue implements ActionListener, DocumentListener, ListSelectionListener {
	
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
	public ControleurVue(Observer observateur) {
		
		instance=Terminal.getInstance();
		instance.addFenetreObserver(observateur);

	     	
	}
	
	


	public void actionPerformed(ActionEvent arg0) {
	
		
	}

	
	public void changedUpdate(DocumentEvent arg0) {
	
	}

	
	public void insertUpdate(DocumentEvent arg0) {
		changedUpdate(arg0);
	}

	
	public void removeUpdate(DocumentEvent arg0) {
		changedUpdate(arg0);
	}

	
	public void valueChanged(ListSelectionEvent arg0) {
	
	}

}

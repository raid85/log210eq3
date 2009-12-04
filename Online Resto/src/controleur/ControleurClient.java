package controleur;
import vue.*;
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

import vue.VueRestaurant;

import modele.*;

/**
 * 
 * @author François Caron
 *
 */
public class ControleurClient implements ActionListener {
	
	/**
	 * Cet attribut sert à stocker le texte.
	 */
	private String texte;
	
	/**
	 * Cet attribut sert à stocker l'index de l'élément sélectionné dans une
	 * liste.
	 */
	
	/**
	 * Le Terminal est la classe du modèle avec laquelle le contrôleur
	 * communique.
	 */
	private Terminal instance;
		
	//usager qui utilise le systeme
	Usager unUsager;
	
	//instance de la vue
	private VueClient vue ;
	
	/**
	 * Constructeur avec paramètre.
	 * Lors de l'instanciation du contrôleur, un observateur (la vue) est passé
	 * en paramètre de façon à ce que le contrôleur puisse ajouter l'obervateur
	 * dans le modèle.
	 * 
	 * @param observateur
	 */
	public ControleurClient(Observer observateur) {
		
		instance=Terminal.getInstance();
		instance.addUsagerObserver(observateur);

		 
		this.vue = (VueClient) observateur;
	     	
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
			String tempo = vue.getTextAdresse()+":" +vue.getTextCourriel();
			instance.ajouterClient(vue.getName(),vue.getTextMotDePasse(),tempo);
			
			
		} 
		else if(action.equalsIgnoreCase("MODIFIER")) {
				instance.modifierClient(vue.getName(),vue.getTextMotDePasse(),vue.getTextAdresse()+":" +vue.getTextCourriel());
			
		}
		else if(action.equalsIgnoreCase("RETIRER")) {
			JOptionPane.showMessageDialog(null,"retirer clien");
			instance.modifierClient(vue.getName(),vue.getTextMotDePasse(),vue.getTextAdresse()+":" +vue.getTextCourriel());
			int choix = JOptionPane.showConfirmDialog(null, null, "Voulez-vous supprimer votre conte", 1);
			
			instance.retirerClient();
			instance.deconnexion();
		}
		else {
			System.err.println("L'action '" + action + "' est inconnue...");
		}
		
	}

	

	


}

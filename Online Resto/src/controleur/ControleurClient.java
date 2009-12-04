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
 * @author Fran�ois Caron
 *
 */
public class ControleurClient implements ActionListener {
	
	/**
	 * Cet attribut sert � stocker le texte.
	 */
	private String texte;
	
	/**
	 * Cet attribut sert � stocker l'index de l'�l�ment s�lectionn� dans une
	 * liste.
	 */
	
	/**
	 * Le Terminal est la classe du mod�le avec laquelle le contr�leur
	 * communique.
	 */
	private Terminal instance;
		
	//usager qui utilise le systeme
	Usager unUsager;
	
	//instance de la vue
	private VueClient vue ;
	
	/**
	 * Constructeur avec param�tre.
	 * Lors de l'instanciation du contr�leur, un observateur (la vue) est pass�
	 * en param�tre de fa�on � ce que le contr�leur puisse ajouter l'obervateur
	 * dans le mod�le.
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
		 * Lorsque le bouton de la vue est appuy�, cette m�thode est invoqu�e.
		 * Pour s'assurer que la m�thode traite la bonne action, il faut
		 * v�rifier la commande associ�e � l'action (la commande a �t� d�finie
		 * au pr�alable).
		 */
		String action = arg0.getActionCommand();
		if(action.equalsIgnoreCase("AJOUTER")) {
			String tempo = vue.getTextAdresse()+":" +vue.getTextCourriel();
			instance.ajouterClient(vue.getTextNom(),vue.getTextMotDePasse(),tempo);
			
			
		} 
		else if(action.equalsIgnoreCase("MODIFIER")) {
			String tempo  = "" + vue.getTextAdresse()+":" +vue.getTextCourriel();
				instance.modifierClient(vue.getName(),vue.getTextMotDePasse(),tempo);
			
		}
		else if(action.equalsIgnoreCase("RETIRER")) {
			int choix = 5;
			try{
			 choix = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer votre conte", "Attention", 0);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			if(choix ==0){
			//instance.modifierClient(vue.getName(),vue.getTextMotDePasse(),vue.getTextAdresse()+":" +vue.getTextCourriel());
			
			instance.retirerClient();
			instance.deconnexion();
			}
		}
		else {
			System.err.println("L'action '" + action + "' est inconnue...");
		}
		
	}

	

	


}

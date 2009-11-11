package zbackup;
import java.awt.GridBagConstraints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

//CEST NORMAL QUE CA MARCHE PAS STE MARDE LA 

public class JListVue  {
	

	liste = new JListVue();
	/*
	 * On ajouter un ListSelectionListener � la liste pour �couter
	 * l'�v�nement o� un �l�ment est s�lectionn� dans la liste. De plus, on
	 * indique explicitement qu'un seul �l�ment peut �tre s�lectionn� � la
	 * fois.
	 */
	liste.addListSelectionListener(controleur);
	liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	/*
	 * On cr�e un JScrollPane dans lequel on stocke la liste. De cette
	 * fa�on, la gestion des curseurs est prise en charge automatiquement.
	 * 
	 * �a ne sert � rien de conserveur le JScrollPane ici, car on
	 * s'int�resse au contenu de la liste. Le JScrollPane agit comme un
	 * d�corateur pour la liste.
	 */
	JScrollPane curseur = new JScrollPane(liste);
	getContentPane().add(curseur, contraintes);
	
	/*
	 * Les boutons sont les derniers �l�ments de la fen�tre.
	 */
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.gridx = 0;
	contraintes.gridy = 3;
	contraintes.gridwidth = 1;
	/*
	 * L'attribut weigthx est important, car il permet d'avoir des boutons
	 * de la m�me largeur. Sans cet attribut, les boutons ne seront pas de
	 * la m�me largeur.
	 */
	contraintes.weightx = 0.5;
	boutonAjouter = new JButton("Ajouter");
	/*
	 * Le contr�leur impl�mente �galement l'interface ActionListener. Cet
	 * interface est utilis� pour r�cup�rer le message "buttonPressed" d'un
	 * JButton. Pour bien identifier l'action, la m�thode setActionCommand
	 * est utilis�e.
	 */
	boutonAjouter.addActionListener(controleur);
	boutonAjouter.setActionCommand("AJOUTER");
	getContentPane().add(boutonAjouter, contraintes);
	
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.gridx = 1;
	contraintes.gridy = 3;
	contraintes.gridwidth = 1;
	contraintes.weightx = 0.5;
	boutonRetirer = new JButton("Retirer");
	/*
	 * Le contr�leur impl�mente �galement l'interface ActionListener. Cet
	 * interface est utilis� pour r�cup�rer le message "buttonPressed" d'un
	 * JButton. Pour bien identifier l'action, la m�thode setActionCommand
	 * est utilis�e.
	 */
	boutonRetirer.addActionListener(controleur);
	boutonRetirer.setActionCommand("RETIRER");
	getContentPane().add(boutonRetirer, contraintes);

}

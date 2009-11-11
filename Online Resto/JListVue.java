package zbackup;
import java.awt.GridBagConstraints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

//CEST NORMAL QUE CA MARCHE PAS STE MARDE LA 

public class JListVue  {
	

	liste = new JListVue();
	/*
	 * On ajouter un ListSelectionListener à la liste pour écouter
	 * l'événement où un élément est sélectionné dans la liste. De plus, on
	 * indique explicitement qu'un seul élément peut être sélectionné à la
	 * fois.
	 */
	liste.addListSelectionListener(controleur);
	liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	/*
	 * On crée un JScrollPane dans lequel on stocke la liste. De cette
	 * façon, la gestion des curseurs est prise en charge automatiquement.
	 * 
	 * Ça ne sert à rien de conserveur le JScrollPane ici, car on
	 * s'intéresse au contenu de la liste. Le JScrollPane agit comme un
	 * décorateur pour la liste.
	 */
	JScrollPane curseur = new JScrollPane(liste);
	getContentPane().add(curseur, contraintes);
	
	/*
	 * Les boutons sont les derniers éléments de la fenêtre.
	 */
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.gridx = 0;
	contraintes.gridy = 3;
	contraintes.gridwidth = 1;
	/*
	 * L'attribut weigthx est important, car il permet d'avoir des boutons
	 * de la même largeur. Sans cet attribut, les boutons ne seront pas de
	 * la même largeur.
	 */
	contraintes.weightx = 0.5;
	boutonAjouter = new JButton("Ajouter");
	/*
	 * Le contrôleur implémente également l'interface ActionListener. Cet
	 * interface est utilisé pour récupérer le message "buttonPressed" d'un
	 * JButton. Pour bien identifier l'action, la méthode setActionCommand
	 * est utilisée.
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
	 * Le contrôleur implémente également l'interface ActionListener. Cet
	 * interface est utilisé pour récupérer le message "buttonPressed" d'un
	 * JButton. Pour bien identifier l'action, la méthode setActionCommand
	 * est utilisée.
	 */
	boutonRetirer.addActionListener(controleur);
	boutonRetirer.setActionCommand("RETIRER");
	getContentPane().add(boutonRetirer, contraintes);

}

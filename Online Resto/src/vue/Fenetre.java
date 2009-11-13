package vue;

/**
 * Les classes suivantes sont utilisées pour éviter de gérer la mise en page
 * des éléments dans la fenêtre. La classe GridBagLayout hérite de
 * LayoutManager.
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.text.Document;
import javax.swing.*;

import controleur.ControleurVue;

/**
 * La classe Vue est la vue du design MVC.
 * 
 * La fenêtre présente une liste, une boîte de texte et un bouton. Il est
 * possible d'ajouter des mots dans une liste. Pour ajouter un mot, il suffit
 * d'entrer le mot dans la boîte de texte et d'appuyer sur le bouton pour
 * ajouter le texte dans la liste. Lors de l'ajout, la boîte de texte se
 * videra.
 * 
 * @author François Caron
 *
 */
public class Fenetre extends JFrame implements Observer {

	/**
	 * Ce numéro est généré par Eclipse, car la classe Vue hérite de JFrame
	 */
	private static final long serialVersionUID = 391679701235987820L;
	
	/**
	 * Le contrôleur de la vue.
	 * Il écoute pour les actions telles que peser sur un bouton et modifier le texte dans une zone.
	 */
	private ControleurVue controleur;
	
	/**
	 * Les éléments dans le Jframe
	 */
	private JButton boutonAjouter;
	private JButton boutonRetirer;
	private JList liste;
	private JTextField boiteTexte;
	private BarreMenu barreMenu;
    private boolean answer = false;
	private JPanel panneauCentral;
	
    
	/**
	 * Constructeur sans paramètre
	 */
	public Fenetre() {
		/*
		 * Définit le titre de la fenêtre.
		 * La méthode "setTitle(...)" sert également à définir le titre de la fenêtre.
		 */
		super("Restauration en ligne");
		
		/*
		 * Indique que la fermeture de la fenêtre termine l'exécution de l'application.
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Instanciation du contrôleur.
		 * On passe la classe en tant qu'observateur.
		 */
		controleur = new ControleurVue((Observer)this);
		
		
		/*
		 * Ceci crée un gestionnaire de mise en page.
		 * La classe GridBagConstraints permet de spécifier l'emplacement et autre...
		 * Pour ajouter des éléments à la fenêtre, il faut passer par le "Content Pane".
		 */

		LayoutManager gestionnaireComposants = new GridBagLayout();
		GridBagConstraints contraintes = new GridBagConstraints();
		getContentPane().setLayout(gestionnaireComposants);
		
		
		//Ajout de la barre de menu
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 2;
				
		 //Création de la barre de menu
        barreMenu = new BarreMenu();

   		getContentPane().add(barreMenu, contraintes);
		
   		//panneauCentral;
   		
   		
		
		/*
		 * La liste doit être le premier élément de la fenêtre et elle doit occuper toute la largeur.
		 */
		
   		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 2;
		
		
		//La liste etait inserer ici on va la changer pour un Panel
		
   		
   		panneauCentral = new DefaultVue();
		//panneauCentral = new VueRestaurant();
		
   		getContentPane().add(panneauCentral,contraintes);
   		
		/*
		 * La zone de texte est le second élément de la fenêtre.
		 */
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		contraintes.gridwidth = 2;
		boiteTexte = new JTextField();
		/*
		 * Le contrôleur implémente l'interface DocumentListener. On utilise
		 * cet interface pour écouter l'ajout et le retrait de caractères dans
		 * la zone de texte.
		 * 
		 * Il faut donc récupérer le "Document" associé à au JTextField.
		 */
		Document document = boiteTexte.getDocument();
		document.addDocumentListener(controleur);
		getContentPane().add(boiteTexte, contraintes);
		
	
		
		/*
		 * Cette méthode règle automatiquement les dimensions de la fenêtre en
		 * fonction des composants ajoutés à la fenêtre.
		 */
		pack();
		
		/*
		 * Forcer l'affichage de la fenêtre.
		 */
		setVisible(true);
	}
	

	//@Override
	public void update(Observable arg0, Object arg1) {
		GridBagConstraints contraintes = new GridBagConstraints();
		
		getContentPane().remove(panneauCentral);
		/*
		 * La liste doit être le premier élément de la fenêtre et elle doit occuper toute la largeur.
		 */
		
   		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 2;
		
		
		panneauCentral = barreMenu.getPanneauTempo();
		//panneauCentral=new VueRestaurant();
		//JOptionPane.showMessageDialog(null,panneauCentral);
		//repaint();
		
		getContentPane().add(panneauCentral,contraintes);
		//getContentPane().add(panneauCentral,contraintes);
		//setVisible(true);
		pack();
	}
	
	/**
	 * Point d'entrée de l'application.
	 */
	public static void main(String args[]) {	
		
			new Fenetre();		
		
		
	}
	
	
}

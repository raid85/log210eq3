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
public class Vue extends JFrame implements Observer {

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
	private MenuVue barreMenu;
    private JMenu menuF, menuG, resto, menus, submenu;
    private JMenuItem itemC, itemDC, itemQ, itemAM, itemMM, itemSM;
    private boolean answer = false;
	
    
	/**
	 * Constructeur sans paramètre
	 */
	public Vue() {
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
        barreMenu = new MenuVue();

        //Construire le menu Fichier
        menuF = new JMenu("Fichier");
             
        barreMenu.add(menuF);

        //Création des items de menus
        
        itemC = new JMenuItem("Connexion");        
        menuF.add(itemC);
		itemC.addActionListener(controleur);
		itemC.setActionCommand("CONNEXION"); 
        itemC.setEnabled(false);
		
        itemDC = new JMenuItem("Deconnexion");        
        menuF.add(itemDC);
		itemDC.addActionListener(controleur);
		itemDC.setActionCommand("DECONNEXION"); 
        itemDC.setEnabled(false);        
        
		itemQ = new JMenuItem("Quitter");        
        menuF.add(itemQ);
        itemQ.addActionListener(controleur);
        itemQ.setActionCommand("QUITTER");

        //Construire le menu Gestion
        menuG = new JMenu("Gestion");
        
        barreMenu.add(menuG);
        
        menus = new JMenu("Menus");
        menuG.add(menus);
        itemAM = new JMenuItem("Créer un Menu");    
        itemAM.addActionListener(controleur);
        itemAM.setActionCommand("ADDMENU");
				
        menus.add(itemAM);
        itemMM = new JMenuItem("Modifier un Menu");        
        itemMM.addActionListener(controleur);
		itemMM.setActionCommand("MODMENU");

        menus.add(itemMM);
        itemSM = new JMenuItem("Supprimer un Menu");        
        itemSM.addActionListener(controleur);
        itemSM.setActionCommand("SUPMENU");
        
        menus.add(itemSM);
		
       resto = new JMenu("Restaurants");  
        menuG.add(resto);
        
        itemC.setEnabled(true);
        menus.setEnabled(false);
        itemSM.setEnabled(false);
        resto.setEnabled(false);
 
/*        
        menuItem = new JMenuItem("Ajouter un restaurant");        
        menuItem.addActionListener(controleur);
		menuItem.setActionCommand("ADDRESTO");
        resto.add(menuItem);
        
        menuItem = new JMenuItem("Modifier un restaurant");        
		menuItem.addActionListener(controleur);
		menuItem.setActionCommand("MODRESTO");
        resto.add(menuItem);
        
        menuItem = new JMenuItem("Supprimer un restaurant");        
		menuItem.addActionListener(controleur);
		menuItem.setActionCommand("SUPRESTO");
        resto.add(menuItem);		
*/
		
		getContentPane().add(barreMenu, contraintes);
		
		
		
		/*
		 * La liste doit être le premier élément de la fenêtre et elle doit occuper toute la largeur.
		 */
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 2;
		liste = new JList();
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
	

	@Override
	public void update(Observable arg0, Object arg1) {
		/*
		 * Une JList doit être populée à l'aide d'un tableau fixe d'objets.
		 */
		liste.setListData((Object[])arg1);
		
		/*
		 * Lorsque le texte a été ajouté de la liste, il faut vider la boîte de texte.
		 */
		boiteTexte.setText("");
	}
	
	/**
	 * Point d'entrée de l'application.
	 */
	public static void main(String args[]) {
	
		
			new Vue();
		

		
		
		
	}

}

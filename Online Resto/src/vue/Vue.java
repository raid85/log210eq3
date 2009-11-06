package vue;

/**
 * Les classes suivantes sont utilis�es pour �viter de g�rer la mise en page
 * des �l�ments dans la fen�tre. La classe GridBagLayout h�rite de
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
 * La fen�tre pr�sente une liste, une bo�te de texte et un bouton. Il est
 * possible d'ajouter des mots dans une liste. Pour ajouter un mot, il suffit
 * d'entrer le mot dans la bo�te de texte et d'appuyer sur le bouton pour
 * ajouter le texte dans la liste. Lors de l'ajout, la bo�te de texte se
 * videra.
 * 
 * @author Fran�ois Caron
 *
 */
public class Vue extends JFrame implements Observer {

	/**
	 * Ce num�ro est g�n�r� par Eclipse, car la classe Vue h�rite de JFrame
	 */
	private static final long serialVersionUID = 391679701235987820L;
	
	/**
	 * Le contr�leur de la vue.
	 * Il �coute pour les actions telles que peser sur un bouton et modifier le texte dans une zone.
	 */
	private ControleurVue controleur;
	
	/**
	 * Les �l�ments dans le Jframe
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
	 * Constructeur sans param�tre
	 */
	public Vue() {
		/*
		 * D�finit le titre de la fen�tre.
		 * La m�thode "setTitle(...)" sert �galement � d�finir le titre de la fen�tre.
		 */
		super("Restauration en ligne");
		
		/*
		 * Indique que la fermeture de la fen�tre termine l'ex�cution de l'application.
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Instanciation du contr�leur.
		 * On passe la classe en tant qu'observateur.
		 */
		controleur = new ControleurVue((Observer)this);
		
		/*
		 * Ceci cr�e un gestionnaire de mise en page.
		 * La classe GridBagConstraints permet de sp�cifier l'emplacement et autre...
		 * Pour ajouter des �l�ments � la fen�tre, il faut passer par le "Content Pane".
		 */

		LayoutManager gestionnaireComposants = new GridBagLayout();
		GridBagConstraints contraintes = new GridBagConstraints();
		getContentPane().setLayout(gestionnaireComposants);
		
		
		//Ajout de la barre de menu
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 2;
				
		 //Cr�ation de la barre de menu
        barreMenu = new MenuVue();

        //Construire le menu Fichier
        menuF = new JMenu("Fichier");
             
        barreMenu.add(menuF);

        //Cr�ation des items de menus
        
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
        itemAM = new JMenuItem("Cr�er un Menu");    
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
		 * La liste doit �tre le premier �l�ment de la fen�tre et elle doit occuper toute la largeur.
		 */
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 2;
		liste = new JList();
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
		 * La zone de texte est le second �l�ment de la fen�tre.
		 */
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		contraintes.gridwidth = 2;
		boiteTexte = new JTextField();
		/*
		 * Le contr�leur impl�mente l'interface DocumentListener. On utilise
		 * cet interface pour �couter l'ajout et le retrait de caract�res dans
		 * la zone de texte.
		 * 
		 * Il faut donc r�cup�rer le "Document" associ� � au JTextField.
		 */
		Document document = boiteTexte.getDocument();
		document.addDocumentListener(controleur);
		getContentPane().add(boiteTexte, contraintes);
		
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
		
		/*
		 * Cette m�thode r�gle automatiquement les dimensions de la fen�tre en
		 * fonction des composants ajout�s � la fen�tre.
		 */
		pack();
		
		/*
		 * Forcer l'affichage de la fen�tre.
		 */
		setVisible(true);
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		/*
		 * Une JList doit �tre popul�e � l'aide d'un tableau fixe d'objets.
		 */
		liste.setListData((Object[])arg1);
		
		/*
		 * Lorsque le texte a �t� ajout� de la liste, il faut vider la bo�te de texte.
		 */
		boiteTexte.setText("");
	}
	
	/**
	 * Point d'entr�e de l'application.
	 */
	public static void main(String args[]) {
	
		
			new Vue();
		

		
		
		
	}

}

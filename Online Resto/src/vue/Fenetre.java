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
import javax.swing.*;

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
public class Fenetre extends JFrame implements Observer {

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
	private BarreMenu barreMenu;
    private boolean answer = false;
	private JPanel panneauCentral;
	
    
	/**
	 * Constructeur sans param�tre
	 */
	public Fenetre() {
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
        barreMenu = new BarreMenu();

   		getContentPane().add(barreMenu, contraintes);
		
   		//panneauCentral;
   		
   		
		
		/*
		 * La liste doit �tre le premier �l�ment de la fen�tre et elle doit occuper toute la largeur.
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
		 * Cette m�thode r�gle automatiquement les dimensions de la fen�tre en
		 * fonction des composants ajout�s � la fen�tre.
		 */
		pack();
		
		/*
		 * Forcer l'affichage de la fen�tre.
		 */
		setVisible(true);
	}
	

	//@Override
	public void update(Observable arg0, Object arg1) {
		GridBagConstraints contraintes = new GridBagConstraints();
		
		getContentPane().remove(panneauCentral);
		/*
		 * La liste doit �tre le premier �l�ment de la fen�tre et elle doit occuper toute la largeur.
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
	 * Point d'entr�e de l'application.
	 */
	public static void main(String args[]) {	
		
			new Fenetre();		
		
		
	}
	
	
}

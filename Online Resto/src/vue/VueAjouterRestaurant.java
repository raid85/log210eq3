package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueAjouterRestaurant extends JFrame {
		
	public VueAjouterRestaurant() {		
		
		this.setTitle("Ajouter nouveau restaurant");
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setContentPane(new VueRestaurant());		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public class VueRestaurant extends JPanel {	
		public VueRestaurant() {
			/**
			 * panneau Pour le titre de la fenetre.
			 */
			JPanel pane1 = new JPanel(new BorderLayout());			
			pane1.setBackground(Color.gray);
						
			/**
			 * panneau Pour regrouper les labels des zones de texte.
			 */
			JPanel pane2 = new JPanel(new GridLayout(6,1,5,10));			
			pane2.setBackground(Color.yellow);
			
			/**
			 * panneau Pour regrouper les zones de textes.
			 */
			JPanel pane3 = new JPanel(new GridLayout(6,1,5,5));
			pane3.setPreferredSize(new Dimension(200,100));
			
			/**
			 * panneau Pour regrouper les labels et leurs zones de texte.
			 */
			JPanel pane4 = new JPanel(new GridLayout(1,2));		
			
			/**
			 * panneau Pour regrouper le titre, les labels et leurs zones de texte 
			 */
			JPanel pane5 = new JPanel(new GridLayout(3,1));						
			this.setBackground(Color.white);
			
			/**
			 * 
			 */
			JPanel pane6 = new JPanel(new GridLayout(3,1));	
			
			/**
			 * Le bouton "Ajouter"
			 */
			JButton boutonAjouter = new JButton("Ajouter");			
			boutonAjouter.setBackground(Color.GREEN);
			
			/**
			 * Les zones de texte
			 */
			JTextField textNom = new JTextField(),
					   textAdresse = new JTextField(),
					   textTelephone = new JTextField(),
					   textZoneLivraison = new JTextField(),
					   textHeureOuverture = new JTextField(),
					   textHeureFermeture = new JTextField();
			
			/**
			 * le titre.
			 */
			JLabel labelTitre = new JLabel();			
			
			/**
			 * les labels des zones de texte
			 */
			JLabel labelNom = new JLabel(), 
				   labelAdresse = new JLabel(),
				   labelTelephone = new JLabel(),
				   labelZoneLivraison = new JLabel(),
			   	   labelHeureOuverture = new JLabel(),
			   	   labelHeureFermeture = new JLabel();
			 
			/**
			 * On definit le titre.
			 */
			labelTitre.setText("                             AJOUTER UN NOUVEAU RESTAURANT");
			
			/**
			 * On definit les labels.
			 */
			labelNom.setText(" Nom");		
			labelAdresse.setText(" Adresse");		
			labelTelephone.setText(" Téléphone");		
			labelZoneLivraison.setText(" Zônes de livraison");
			labelHeureOuverture.setText(" Heure d'ouverture");
		   	labelHeureFermeture.setText(" Heure de fermeture");
			
			/**
			 * ON ajoute le titre à son panneau.
			 */
			pane1.add(labelTitre, BorderLayout.CENTER);	
			
			/**
			 * ON ajoute les labels à leur panneau.
			 */
			pane2.add(labelNom);					
			pane2.add(labelAdresse);					
			pane2.add(labelTelephone);					
			pane2.add(labelZoneLivraison);
			pane2.add(labelHeureOuverture);					
			pane2.add(labelHeureFermeture);
			
			/**
			 * ON ajoute les zones de texte à leur panneau.
			 */
			pane3.add(textNom);		
			pane3.add(textAdresse);					
			pane3.add(textTelephone);		
			pane3.add(textZoneLivraison);
			pane3.add(textHeureOuverture);		
			pane3.add(textHeureFermeture);
								
			/**
			 * On met met ensemble les panneaux des labels et des zones de texte.
			 */
			pane4.add(pane2);
			pane4.add(pane3);
			
			/**
			 * 
			 */			
			pane6.add(new JPanel());
			pane6.add(boutonAjouter);
			
			/**
			 * On met ajoute le panneau du titre au panneau des labels et zones de texte.
			 */
			pane5.add(pane1);
			pane5.add(pane4);
			pane5.add(pane6);
			
			this.add(pane5,BorderLayout.EAST);
		}		
	}	
	
	public static void main(String[] args) {
		VueAjouterRestaurant vue = new	VueAjouterRestaurant();	
	}
}

package vue;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;

import controleur.* ;

class VueRestaurant extends JPanel implements Observer
{  
	ControleurVue controleur;

	JButton ajouter=new JButton("AJOUTER");	
	JButton enlever=new JButton("ENLEVER");	
	JButton annuler=new JButton("ANNULER"); 


	TextArea texte=new TextArea();

	Label labelNom = new Label("Nom"), 
	labelAdresse = new Label("Adresse"),
	labelTelephone = new Label("Téléphone"),
	labelZoneLivraison = new Label("Zones de livraison"),
	labelHeureOuverture = new Label("Heure d'ouverture"),
	labelHeureFermeture = new Label("Heure de fermeture"),
	labelRien = new Label("");

	TextField textNom = new TextField(),
	textAdresse = new TextField(),
	textTelephone = new TextField(),
	textZoneLivraison = new TextField(),
	textHeureOuverture = new TextField(),
	textHeureFermeture = new TextField();	


	


	public TextArea getTexte() {
		return texte;
	}


	public TextField getTextNom() {
		return textNom;
	}


	public TextField getTextAdresse() {
		return textAdresse;
	}


	public TextField getTextTelephone() {
		return textTelephone;
	}


	public TextField getTextZoneLivraison() {
		return textZoneLivraison;
	}


	public TextField getTextHeureOuverture() {
		return textHeureOuverture;
	}


	public TextField getTextHeureFermeture() {
		return textHeureFermeture;
	}




	VueRestaurant()
	{
		controleur = new ControleurVue((Observer)this);
		// this.setTitle("FENÊTRE RESTAURANT");
		GridBagLayout repartiteur=new GridBagLayout(); 
		
		ajouter.addActionListener(controleur);
		enlever.addActionListener(controleur);
		


		setLayout(repartiteur); 
		this.setBackground(Color.LIGHT_GRAY);

		UtilitaireRepartition.ajouter(this,labelNom,0,1,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelAdresse,0,2,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelTelephone,0,3,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelZoneLivraison,0,4,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelHeureOuverture,0,5,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelHeureFermeture,0,6,2,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelRien,0,7,2,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textNom,2,1,3,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.NORTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textAdresse,2,2,3,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textTelephone,2,3,3,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textZoneLivraison,2,4,3,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textHeureOuverture,2,5,3,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textHeureFermeture,2,6,3,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,2,2,0,0);

		UtilitaireRepartition.ajouter(this,ajouter,5,1,1,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,2,10,2,2,0,0);
		UtilitaireRepartition.ajouter(this,enlever,5,3,1,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,2,10,2,2,0,0);
		UtilitaireRepartition.ajouter(this,annuler,5,5,1,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,2,10,2,2,0,0);    

		UtilitaireRepartition.ajouter(this,texte,0,8,5,2,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,1,1,1,1,0,0);
	} 
	//@Override
	public void update(Observable arg0, Object arg1) {

	}
	public void actionPerformed(ActionEvent e)
	{
		//quand on a cliqué sur le bouton ici
		System.out.println("Ici !");
	}
}



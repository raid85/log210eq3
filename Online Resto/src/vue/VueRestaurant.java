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
import javax.swing.text.Document;

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

	JLabel labelNom = new JLabel("Nom"), 
	labelAdresse = new JLabel("Adresse"),
	labelTelephone = new JLabel("Téléphone"),
	labelZoneLivraison = new JLabel("Zones de livraison"),
	labelHeureOuverture = new JLabel("Heure d'ouverture"),
	labelHeureFermeture = new JLabel("Heure de fermeture"),
	labelRien = new JLabel("");

	JTextField textNom = new JTextField(),
	textAdresse = new JTextField(),
	textTelephone = new JTextField(),
	textZoneLivraison = new JTextField(),
	textHeureOuverture = new JTextField(),
	textHeureFermeture = new JTextField();	

     JTextField info;
	

	VueRestaurant()
	{
		controleur = new ControleurVue((Observer)this);
		// this.setTitle("FENÊTRE RESTAURANT");
		GridBagLayout repartiteur=new GridBagLayout(); 
		
		ajouter.addActionListener(controleur);
		enlever.addActionListener(controleur);
		
		
		JList texto;
		

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
		
		info = new JTextField(textNom+";"+textAdresse
				+";"+textTelephone+";"+textZoneLivraison+";"+
   	 textHeureOuverture+";"+
   	 textHeureFermeture + ";");
	
	
	/*
	 * Le contrôleur implémente l'interface DocumentListener. On utilise
	 * cet interface pour écouter l'ajout et le retrait de caractères dans
	 * la zone de texte.
	 * 
	 * Il faut donc récupérer le "Document" associé à au JTextField.
	 */
	Document document = info.getDocument();
	document.addDocumentListener(controleur);
	//getContentPane().add(boiteTexte, contraintes);
	//a dessendre en bas
	

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



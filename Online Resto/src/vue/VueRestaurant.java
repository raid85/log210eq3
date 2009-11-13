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

public class VueRestaurant extends JPanel implements Observer
{  
	private ControleurRestaurant controleur;
	
	private String nomResto ;
	private String adresse ;
	private String telephone ;
	private String zoneLivraison ;
	private String heureOuverture;
	private String heureFermeture ;

	JButton ajouter=new JButton("AJOUTER");	
	JButton enlever=new JButton("ENLEVER");	
	JButton modifier=new JButton("MODIFIER"); 

	
	JLabel labelNom = new JLabel("Nom"),	
	labelAdresse = new JLabel("Adresse"),
	labelTelephone = new JLabel("Téléphone"),
	labelZoneLivraison = new JLabel("Zones de livraison"),
	labelHeureOuverture = new JLabel("Heure d'ouverture"),
	labelHeureFermeture = new JLabel("Heure de fermeture"),
	labelRien = new JLabel("");
	
	JScrollPane panlist ;
	JList liste = new JList ();

	JTextField textNom = new JTextField(),	
	textAdresse = new JTextField(),
	textTelephone = new JTextField(),
	textZoneLivraison = new JTextField(),
	textHeureOuverture = new JTextField(),
	textHeureFermeture = new JTextField();	

	VueRestaurant()
	{
		controleur = new ControleurRestaurant((Observer)this);	
		GridBagLayout repartiteur=new GridBagLayout(); 

		//ajout du controleur comme écouter des actions des boutons enlever et ajouter

		ajouter.addActionListener(controleur);
		enlever.addActionListener(controleur);
		
		liste.addListSelectionListener(controleur);
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
		panlist =  new JScrollPane(liste);
		
		Document document = textNom.getDocument();
		document.
		document.addDocumentListener(controleur);
		getContentPane().add(boiteTexte, contraintes);

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
		UtilitaireRepartition.ajouter(this,modifier,5,5,1,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,2,10,2,2,0,0);    

		UtilitaireRepartition.ajouter(this,panlist,0,8,5,2,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,1,1,1,1,0,0);



	} 
	

	/**Méthode qui sert a récupérer le texte sous for de string des JTextField
	 * 
	 */
	public void grabText (){

		this.nomResto = textNom.getText();
		this.adresse=textAdresse.getText();
		this.telephone = textTelephone.getText();
		this.zoneLivraison=textZoneLivraison.getText();
		this.heureOuverture=textHeureOuverture.getText();
		this.heureFermeture=textHeureFermeture.getText();

	}
	/**Groupe d'accesseurs qui fournissent les infos saisies par la vue sous forme de String
	 * 
	 * @return String
	 */
	public String getNom (){
		return this.nomResto;
	}
	public String getAdresse (){
		return this.adresse ;
	}
	public String getTelephone (){
		return this.telephone;
	}
	public String getZoneLivraison (){
		return this.zoneLivraison;
	}
	public String getHeureOuverture (){
		return this.heureOuverture;
	}
	public String getHeureFermeture (){
		return this.heureFermeture;
	}

	public void update(Observable arg0, Object arg1) {
		liste.setListData((Object[])arg1);

	}

}



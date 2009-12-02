package vue;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import modele.Usager;

import controleur.ControleurClient;
import controleur.ControleurRestaurant;
import controleur.ControleurVue;

public class VueClient extends JPanel implements Observer
{  
	
	ControleurClient controleur;
	
	boolean modifier;
	  JButton ajouter=new JButton(" Ajouter ");
	  JButton modifier2=new JButton("modifier");
	  JButton annuler=new JButton("annuler ");
	  JList list = new JList();
	  
	  JTextArea texte=new JTextArea();
	  
	  JLabel labelNom = new JLabel("Nom"), 
	  		 labelAdresse = new JLabel("Adresse"),
	  		 labelMotDePasse = new JLabel("Mot de passe  "),
	  		 labelCourriel = new JLabel("Courriel"),	  		 
	  		 labelTitre = new JLabel("                      ESPACE CLIENT                        "),
	  		 labelRien = new JLabel(" "),
	  		 labelRien2 = new JLabel(" ");
	  
	  JTextField textNom = new JTextField(),
	  			textAdresse = new JTextField(),
	  			textMotDePasse = new JTextField(),
	  			textCourriel = new JTextField();
	  GridBagLayout repartiteur;
	
	VueClient()
  {
	modifier = false;
	controleur = new ControleurClient((Observer)this);
	 
	repartiteur=new GridBagLayout(); 	
	 
	//ajout du controleur comme écouter des actions des boutons enlever et ajouter

	ajouter.addActionListener(controleur);
	ajouter.setActionCommand("AJOUTER");	
	 
	createGUI();

  }
	
	
	public void createGUI(){
		setLayout(repartiteur); 
		this.setBackground(Color.LIGHT_GRAY);
		labelTitre.setPreferredSize(new Dimension(250,20)); 
		UtilitaireRepartition.ajouter(this,labelTitre,1,0,5,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.NORTH,
	            0,0,2,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelRien2,0,1,5,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,2,2,2,2,0,0);
		 UtilitaireRepartition.ajouter(this,labelNom,0,2,1,1,GridBagConstraints.HORIZONTAL,
		            GridBagConstraints.SOUTH,
		            0,0,2,2,2,2,0,0);
	    UtilitaireRepartition.ajouter(this,labelAdresse,0,3,1,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,2,2,2,2,0,0);     
	    UtilitaireRepartition.ajouter(this,labelMotDePasse,0,4,1,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,2,2,2,2,0,0);
	    UtilitaireRepartition.ajouter(this,labelCourriel,0,5,1,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,2,2,2,2,0,0);
	  
	    UtilitaireRepartition.ajouter(this,labelRien,0,6,3,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,2,2,2,2,0,0);
	    
	 
	    UtilitaireRepartition.ajouter(this,textNom,2,2,4,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.NORTH,
	            0,0,15,2,2,2,0,0);
	    UtilitaireRepartition.ajouter(this,textAdresse,2,3,4,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,15,2,2,2,0,0);
	    UtilitaireRepartition.ajouter(this,textMotDePasse,2,4,4,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,15,2,2,2,0,0);
	    UtilitaireRepartition.ajouter(this,textCourriel,2,5,4,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,15,2,2,2,0,0);
	   
	    
	    UtilitaireRepartition.ajouter(this,ajouter,6,2,1,1,GridBagConstraints.NONE,
	            GridBagConstraints.SOUTH,
	            0,0,2,10,2,2,0,0);
	    UtilitaireRepartition.ajouter(this,modifier2,6,3,1,1,GridBagConstraints.NONE,
	            GridBagConstraints.SOUTH,
	            0,0,2,10,2,2,0,0);
	    UtilitaireRepartition.ajouter(this,annuler,6,4,1,1,GridBagConstraints.NONE,
	            GridBagConstraints.SOUTH,
	            0,0,2,10,2,2,0,0); 
	    
	   list.setPreferredSize(new Dimension(250,180));   
	    UtilitaireRepartition.ajouter(this,list,0,7,7,1,GridBagConstraints.NONE,
	            GridBagConstraints.SOUTH,
	            0,0,1,1,10,1,0,0);
	}

	public String getTextNom() {
		return textNom.getText();
	}

	public String getTextAdresse() {
		return textAdresse.getText();
	}

	public String getTextMotDePasse() {
		return textMotDePasse.getText();
	}

	public String getTextCourriel() {
		return textCourriel.getText();
	}

	//@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(modifier){
			Usager unUser = (Usager) arg0;
			remplirTableau(unUser);
		}
		
	
		
	} 
	
	public void remplirTableau(Usager unUser){
	textNom.setText(unUser.getLoginName());
	textAdresse.setText(unUser.getInfoDuDude());
	textMotDePasse.setText(unUser.getPassword());
	textCourriel.setText(unUser.getInfoDuDude());
	}
}



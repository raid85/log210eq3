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

import controleur.ControleurClient;
import controleur.ControleurVue;

class VueClient extends JPanel implements Observer
{  
	  ControleurClient controleurClient;
	
	  JButton ajouter=new JButton(" Ajouter ");
	  JButton modifier=new JButton("modifier");
	  JButton annuler=new JButton("annuler "); 
	  
	  JTextArea texte=new JTextArea();
	  
	  JLabel labelNom = new JLabel("Nom"), 
	  		 labelAdresse = new JLabel("Adresse"),
	  		 labelMotDePasse = new JLabel("Mot de passe"),
	  		 labelCourriel = new JLabel("Courriel"),	  		 
	  		 labelTitre = new JLabel("                                     ESPACE CLIENT "),
	  		 labelRien = new JLabel("");
	  
	  JTextField textNom = new JTextField(),
	  			textAdresse = new JTextField(),
	  			textMotDePasse = new JTextField(),
	  			textCourriel = new JTextField();
	  			
	
	
	public JButton getAjouter() {
		return ajouter;
	}

	public JButton getModifier() {
		return modifier;
	}

	public JButton getAnnuler() {
		return annuler;
	}


	public JTextArea getTexte() {
		return texte;
	}


	public JTextField getTextNom() {
		return textNom;
	}


	public JTextField getTextAdresse() {
		return textAdresse;
	}
	
	
	VueClient()
  {
	 controleurClient = new ControleurClient((Observer)this);
	 
	 GridBagLayout repartiteur=new GridBagLayout(); 
	  

	setLayout(repartiteur); 
	this.setBackground(Color.LIGHT_GRAY);
	
	
	UtilitaireRepartition.ajouter(this,labelTitre,1,0,3,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
	UtilitaireRepartition.ajouter(this,labelNom,0,1,1,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
    UtilitaireRepartition.ajouter(this,labelAdresse,0,2,1,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
    UtilitaireRepartition.ajouter(this,labelMotDePasse,0,3,1,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
    UtilitaireRepartition.ajouter(this,labelCourriel,0,4,1,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
  
    UtilitaireRepartition.ajouter(this,labelRien,0,5,2,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
    
 
    UtilitaireRepartition.ajouter(this,textNom,2,1,3,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.NORTH,
            0,0,2,2,2,2,0,0);
    UtilitaireRepartition.ajouter(this,textAdresse,2,2,3,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
    UtilitaireRepartition.ajouter(this,textMotDePasse,2,3,3,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
    UtilitaireRepartition.ajouter(this,textCourriel,2,4,3,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
   
    
    UtilitaireRepartition.ajouter(this,ajouter,5,1,1,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);
    UtilitaireRepartition.ajouter(this,modifier,5,2,1,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);
    UtilitaireRepartition.ajouter(this,annuler,5,3,1,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);    
  
    UtilitaireRepartition.ajouter(this,texte,0,6,5,2,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,1,1,1,1,0,0);
  }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	} 
}



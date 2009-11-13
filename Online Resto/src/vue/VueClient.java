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

import controleur.ControleurClient;
import controleur.ControleurVue;

class VueClient extends Panel implements Observer
{  
	  ControleurClient controleurClient;
	
	  Button ajouter=new Button(" Ajouter ");
	  Button modifier=new Button("modifier");
	  Button annuler=new Button("annuler "); 
	  
	  TextArea texte=new TextArea();
	  
	  Label labelNom = new Label("Nom"), 
	  		 labelAdresse = new Label("Adresse"),
	  		 labelMotDePasse = new Label("Mot de passe"),
	  		 labelCourriel = new Label("Courriel"),	  		 
	  		 labelTitre = new Label("                                     ESPACE CLIENT "),
	  		 labelRien = new Label("");
	  
	  TextField textNom = new TextField(),
	  			textAdresse = new TextField(),
	  			textMotDePasse = new TextField(),
	  			textCourriel = new TextField();
	  			
	
	
	public Button getAjouter() {
		return ajouter;
	}

	public Button getModifier() {
		return modifier;
	}

	public Button getAnnuler() {
		return annuler;
	}


	public TextArea getTexte() {
		return texte;
	}


	public TextField getTextNom() {
		return textNom;
	}


	public TextField getTextAdresse() {
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



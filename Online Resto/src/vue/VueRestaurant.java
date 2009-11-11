package vue;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

class VueRestaurant extends Frame
{  
	VueRestaurant()
  {
	  this.setTitle("FEN�TRE RESTAURANT");
	  
	  GridBagLayout repartiteur=new GridBagLayout();
	  
	  Button ajouter=new Button("Ajouter");
	  Button modifier=new Button("modifier");
	  Button annuler=new Button("annuler"); 

	  TextArea texte=new TextArea();
	  
	  Label labelNom = new Label("Nom"), 
	  		 labelAdresse = new Label("Adresse"),
	  		 labelTelephone = new Label("T�l�phone"),
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
	  
	  TextField text=new TextField(); 
	  
	  this.addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(java.awt.event.WindowEvent evt) {
	               hide();
	        } 
	} );

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
    UtilitaireRepartition.ajouter(this,modifier,5,3,1,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);
    UtilitaireRepartition.ajouter(this,annuler,5,5,1,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);    
  
    UtilitaireRepartition.ajouter(this,texte,0,8,5,2,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,1,1,1,1,0,0);
  }  
 

  public static void main(String[] argv)
  {
    VueRestaurant fenetre = new VueRestaurant();

    fenetre.setSize(600, 500);
    fenetre.setVisible(true);
  }
}



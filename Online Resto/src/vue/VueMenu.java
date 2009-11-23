package vue;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import controleur.ControleurClient;
import controleur.ControleurMenu;
import controleur.ControleurVue;

class VueMenu extends JPanel implements Observer
{  
	  ControleurMenu controleurMenu;
	
	  JButton boutonAjouter=new JButton(" Ajouter ");
	  JButton boutonModifier=new JButton("Modifier");
	  JButton boutonAnnuler=new JButton("Annuler "); 	  
	  
	  JLabel labelItemMenu = new JLabel("Item du menu"), 
	  		 labelPrixItem = new JLabel("Prix"),	  		 		 
	  		 labelTitre = new JLabel("                                           ESPACE MENU"),	  		 
	  		 labelListeRestaurants = new JLabel("        Liste des restaurants"), 
	  		 labelListeMenus = new JLabel("Liste des menus");
	  
	  JList listRestaurants = new JList();
	  JList listMenus = new JList();
	  
	  JTextField textItemMenu = new JTextField(),
	  			 textPrixItem = new JTextField();
	
	
	VueMenu()
  {
	 controleurMenu = new ControleurMenu((Observer)this);
	 
	 GridBagLayout repartiteur=new GridBagLayout(); 
	  

	setLayout(repartiteur); 
	this.setBackground(Color.LIGHT_GRAY);
	
	
	labelTitre.setPreferredSize(new Dimension(400,20));
	UtilitaireRepartition.ajouter(this,labelTitre,0,0,5,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,20,2,20,2,0,0);	
	
	labelItemMenu.setPreferredSize(new Dimension(160,20));
	UtilitaireRepartition.ajouter(this,labelItemMenu,0,2,2,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);
	textItemMenu.setPreferredSize(new Dimension(160,20));
	UtilitaireRepartition.ajouter(this,textItemMenu,0,3,2,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);
	labelPrixItem.setPreferredSize(new Dimension(160,20));
	UtilitaireRepartition.ajouter(this,labelPrixItem,0,4,2,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0); 
	textPrixItem.setPreferredSize(new Dimension(160,20));
	UtilitaireRepartition.ajouter(this,textPrixItem,0,5,2,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);
    UtilitaireRepartition.ajouter(this,labelListeMenus,0,6,2,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,10,10,2,2,0,0);
    listMenus.setPreferredSize(new Dimension(160,170));
    UtilitaireRepartition.ajouter(this,listMenus,0,7,3,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,1,1,20,1,0,0);	
	
    UtilitaireRepartition.ajouter(this,boutonAjouter,3,2,1,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,90,1,1,0,0);
    UtilitaireRepartition.ajouter(this,boutonModifier,3,3,1,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,10,90,1,1,0,0);
    UtilitaireRepartition.ajouter(this,boutonAnnuler,3,4,1,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,10,90,1,1,0,0);
    labelListeRestaurants.setPreferredSize(new Dimension(240,20));
	UtilitaireRepartition.ajouter(this,labelListeRestaurants,2,6,3,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
	listRestaurants.setPreferredSize(new Dimension(240,170));
	UtilitaireRepartition.ajouter(this,listRestaurants,2,7,3,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,1,10,20,10,0,0);	
	    
  }

	//@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	} 
}



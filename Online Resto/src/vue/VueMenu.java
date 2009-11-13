package vue;

import java.awt.Button;
import java.awt.Color;
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
	
	  JButton ajouter=new JButton(" Ajouter ");
	  JButton modifier=new JButton("modifier");
	  JButton annuler=new JButton("annuler "); 	  
	  
	  JLabel labelItemMenu = new JLabel("Item de menu"), 
	  		 labelPrixItem = new JLabel("Prix"),	  		 		 
	  		 labelTitre = new JLabel("                                     ESPACE MENU "),
	  		 labelRien = new JLabel(" "),
	  		 labelListeRestaurants = new JLabel("Liste des restaurants"), 
	  		 labelListeMenus = new JLabel("Liste des menus");
	  
	  JList listeRestaurants = new JList();
	  JList listeMenus = new JList();
	  
	  JTextField itemMenu = new JTextField("                      "),
	  			 prixItem = new JTextField("           ");
	  			
	
	
	public JButton getAjouter() {
		return ajouter;
	}

	public JButton getModifier() {
		return modifier;
	}

	public JButton getAnnuler() {
		return annuler;
	}		
	
	
	VueMenu()
  {
	 controleurMenu = new ControleurMenu((Observer)this);
	 
	 GridBagLayout repartiteur=new GridBagLayout(); 
	  

	setLayout(repartiteur); 
	this.setBackground(Color.LIGHT_GRAY);
	
	
	UtilitaireRepartition.ajouter(this,labelTitre,0,0,3,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
	UtilitaireRepartition.ajouter(this,labelRien,0,1,3,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
	UtilitaireRepartition.ajouter(this,labelListeRestaurants,0,2,3,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,2,2,2,2,0,0);
	UtilitaireRepartition.ajouter(this,listeRestaurants,0,3,2,2,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,1,1,1,1,0,0);
	
    UtilitaireRepartition.ajouter(this,labelItemMenu,3,2,2,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);
    UtilitaireRepartition.ajouter(this,itemMenu,3,3,2,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);
    UtilitaireRepartition.ajouter(this,labelPrixItem,3,4,2,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0); 
    UtilitaireRepartition.ajouter(this,prixItem,3,5,2,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);
    UtilitaireRepartition.ajouter(this,labelListeMenus,3,6,3,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,2,2,0,0);
    UtilitaireRepartition.ajouter(this,listeMenus,3,7,3,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,1,1,1,1,0,0);
  }

	//@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	} 
}



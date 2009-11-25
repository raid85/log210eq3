package vue;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import controleur.ControleurClient;
public class VueMenu extends JPanel implements Observer
{  
	
	ControleurClient controleur;
	
	  JButton ajouter=new JButton("AJOUTER MENU");
	  JButton modifier=new JButton("  RETIRER MENU");
	  JButton annuler=new JButton("MODIFIER MENU");
	  JButton ajouterItem =new JButton("Ajouter item");
	  JButton retirerItem =new JButton("Retirer item");
	  JList listeRestaurants = new JList();	
	  JList menu = new JList();
	  JLabel labelTitre = new JLabel("          CHOISISSEZ UN RESTAURANT"),	  		 
	  		 labelItemDeMenu = new JLabel("Item de menu"),
	  		 labelPrixItem = new JLabel("Prix item"),
	  		 labelMenu = new JLabel("                          MENU");
	  JTextField textItemDeMenu = new JTextField(),
	  			 textPrixItem = new JTextField();
VueMenu()
  {
	
	 GridBagLayout repartiteur=new GridBagLayout(); 	
	 
	ajouter.addActionListener(controleur);
	ajouter.setActionCommand("AJOUTER");		 
	setLayout(repartiteur); 
	this.setBackground(Color.LIGHT_GRAY);
	labelTitre.setPreferredSize(new Dimension(430,20)); 
	UtilitaireRepartition.ajouter(this,labelTitre,1,0,8,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.NORTH,
            0,0,15,2,15,2,0,0);   
    
    UtilitaireRepartition.ajouter(this,ajouter,7,1,2,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,10,2,0,0);
    UtilitaireRepartition.ajouter(this,modifier,7,2,2,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,10,2,0,0);
    UtilitaireRepartition.ajouter(this,annuler,7,3,2,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,2,10,10,2,0,0); 
    UtilitaireRepartition.ajouter(this,labelItemDeMenu,7,4,1,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.NORTH,
            0,0,3,2,3,2,0,0); 
    UtilitaireRepartition.ajouter(this,textItemDeMenu,8,4,1,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.NORTH,
            0,0,3,2,3,2,0,0); 
    UtilitaireRepartition.ajouter(this,labelPrixItem,7,5,1,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.NORTH,
            0,0,3,2,3,2,0,0); 
    UtilitaireRepartition.ajouter(this,textPrixItem,8,5,1,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.NORTH,
            0,0,3,2,3,2,0,0); 
    UtilitaireRepartition.ajouter(this,ajouterItem,7,6,1,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,1,2,10,2,0,0); 
    UtilitaireRepartition.ajouter(this,retirerItem,8,6,1,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,1,2,10,2,0,0); 
    
    UtilitaireRepartition.ajouter(this,labelMenu,7,7,2,1,GridBagConstraints.HORIZONTAL,
            GridBagConstraints.SOUTH,
            0,0,3,2,3,2,0,0);
    
     menu.setPreferredSize(new Dimension(200,115));   
    UtilitaireRepartition.ajouter(this,menu,7,8,2,1,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,1,1,10,2,0,0);
    
   listeRestaurants.setPreferredSize(new Dimension(220,340));   
    UtilitaireRepartition.ajouter(this,listeRestaurants,0,1,5,10,GridBagConstraints.NONE,
            GridBagConstraints.SOUTH,
            0,0,1,5,10,2,0,0);   
  }

	public void retirerModifier() {
		 labelItemDeMenu.setVisible(false);
	   textItemDeMenu.setVisible(false);
	   labelPrixItem.setVisible(false);
	   textPrixItem.setVisible(false);
	   ajouterItem.setVisible(false);
	   menu.setPreferredSize(new Dimension(180,210));
	}

	//@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	} 
}



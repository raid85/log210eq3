package vue;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import controleur.ControleurMenu;
public class VueMenu extends JPanel implements Observer
{  
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	//private Menu model;
	  ControleurMenu controleur;	
	  public void setTextItemDeMenu(JTextField textItemDeMenu) {
		this.textItemDeMenu = textItemDeMenu;
	}

	JButton ajouterMenu=new JButton("AJOUTER MENU");
	  JButton retirerMenu=new JButton("  RETIRER MENU");
	  JButton modifierMenu=new JButton("MODIFIER MENU");
	  JButton ajouterItem =new JButton("Ajouter item");
	  JButton retirerItem =new JButton("Retirer item");
	  
	  JList listeRestaurants = new JList();	
	  JList menu = new JList();
	  
	  JLabel labelTitre = new JLabel("          CHOISISSEZ UN RESTAURANT"),	  		 
	  		 labelItemDeMenu = new JLabel("Item de menu"),
	  		 labelPrixItem = new JLabel("Prix item"),
	  		 labelMenu = new JLabel("                          MENU");
	  
	  JTextField textItemDeMenu = new JTextField();
	  JTextField textPrixItem = new JTextField();
	  
	  public JTextField getTextItemDeMenu() {
		return textItemDeMenu;
	  }

	  public JTextField getTextPrixItem() {
		return textPrixItem;
	  }	
	
	public VueMenu() {
		ajouterMenu.addActionListener(controleur);
		ajouterMenu.setActionCommand("ajouterMenu");
		
		retirerMenu.addActionListener(controleur);
		retirerMenu.setActionCommand("retirerMenu");
		
		modifierMenu.addActionListener(controleur);
		modifierMenu.setActionCommand("modifierMenu");
		
		ajouterItem.addActionListener(controleur);
		ajouterItem.setActionCommand("ajouterItem");
		
		retirerItem.addActionListener(controleur);
		retirerItem.setActionCommand("retirerItem");

		GridBagLayout repartiteur = new GridBagLayout(); 	
		setLayout(repartiteur); 
		this.setBackground(Color.LIGHT_GRAY);	
		UtilitaireRepartition.ajouter(this,labelTitre,1,0,6,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.NORTH,
	            0,0,15,2,15,2,0,0);   
	    
	    UtilitaireRepartition.ajouter(this,ajouterMenu,7,0,2,1,GridBagConstraints.NONE,
	            GridBagConstraints.SOUTH,
	            0,0,2,10,10,2,0,0);
	    UtilitaireRepartition.ajouter(this,retirerMenu,7,1,2,1,GridBagConstraints.NONE,
	            GridBagConstraints.SOUTH,
	            0,0,2,10,10,2,0,0);
	    UtilitaireRepartition.ajouter(this,modifierMenu,7,2,2,1,GridBagConstraints.NONE,
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
	    
	     menu.setPreferredSize(new Dimension(200,155));   
	    UtilitaireRepartition.ajouter(this,menu,7,8,2,1,GridBagConstraints.NONE,
	            GridBagConstraints.SOUTH,
	            0,0,1,1,10,2,0,0);
	    
	   listeRestaurants.setPreferredSize(new Dimension(215,340));   
	    UtilitaireRepartition.ajouter(this,listeRestaurants,0,1,5,10,GridBagConstraints.NONE,
	            GridBagConstraints.SOUTH,
	            0,0,1,5,10,2,0,0); 
	    //desactiverSaisieItem();
  }

	public void desactiverSaisieItem() {
	   labelItemDeMenu.setEnabled(false);
	   textItemDeMenu.setEnabled(false);
	   labelPrixItem.setEnabled(false);
	   textPrixItem.setEnabled(false);
	   ajouterItem.setEnabled(false);
	   menu.setPreferredSize(new Dimension(180,210));
	}

	//@Override
	public void update(Observable o, Object arg) {
		
	}
}



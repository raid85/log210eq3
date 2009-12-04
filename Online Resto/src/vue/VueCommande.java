package vue;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import controleur.ControleurMenu;
import controleur.ControleurRestaurant;
import controleur.ControlleurCommande;
public class VueCommande extends JPanel implements Observer
{  
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	//private Menu model;
	  private ControlleurCommande controleur;	
	

	



	 

	  
	  private JScrollPane panlist ;
	  JList listeRestaurants = new JList();;
	  JList menu = new JList();
	    
	  
	  JLabel labelTitre = new JLabel("          CHOISISSEZ UN RESTAURANT"),	  		 
	  		 labelItemDeMenu = new JLabel("Item de menu"),
	  		 labelPrixItem = new JLabel("Prix item"),
	  		 labelMenu = new JLabel("                          MENU");
	  
	  GridBagLayout repartiteur;
	  
	  
	  public JList getMenu() {
			return menu;
		}
	 
	  public int getSelectionMenu(){
		  return menu.getSelectedIndex();
	  }
	
	public VueCommande() {
		controleur = new ControlleurCommande((Observer)this);
		
		
		
		panlist = new JScrollPane(listeRestaurants);
		
		
		/*
		retirerItem.addActionListener(controleur);
		retirerItem.setActionCommand("RETIRERMENU");
	*/
		listeRestaurants.addListSelectionListener(controleur);

		repartiteur = new GridBagLayout(); 	
		
		creerGUI();
		
		
	    //desactiverSaisieItem();
  }
	

	public JList getListeRestaurants() {
		return listeRestaurants;
	}

	private void creerGUI() {
		setLayout(repartiteur); 
		this.setBackground(Color.LIGHT_GRAY);	
		UtilitaireRepartition.ajouter(this,labelTitre,1,0,6,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.NORTH,
	            0,0,15,2,15,2,0,0);   
	    
	   
	   /* UtilitaireRepartition.ajouter(this,modifierMenu,7,2,2,1,GridBagConstraints.NONE,
	            GridBagConstraints.SOUTH,
	            0,0,2,10,10,2,0,0); 
	            */
	    UtilitaireRepartition.ajouter(this,labelItemDeMenu,7,4,1,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.NORTH,
	            0,0,3,2,3,2,0,0); 
	   /* UtilitaireRepartition.ajouter(this,textItemDeMenu,8,4,1,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.NORTH,
	            0,0,3,2,3,2,0,0); 
	            */
	    UtilitaireRepartition.ajouter(this,labelPrixItem,7,5,1,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.NORTH,
	            0,0,3,2,3,2,0,0); 
	    
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
	}

	public void desactiverSaisieItem() {
	   labelItemDeMenu.setEnabled(false);
	  
	   labelPrixItem.setEnabled(false);
	  
	   menu.setPreferredSize(new Dimension(180,210));
	}

	//@Override
	public void update(Observable arg0, Object arg1) {
		//JOptionPane.showMessageDialog(null,"UPDATE VUEMENU" + listeRestaurants.getHeight());
		/*
		JList tempo = new JList();
		tempo.setListData((Object[])arg1);
		JOptionPane.showMessageDialog(null,tempo);
		*/
		listeRestaurants.setListData((Object[])arg1);
		
		
		
		
	}
}



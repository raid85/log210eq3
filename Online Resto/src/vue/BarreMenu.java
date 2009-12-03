package vue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import modele.Null;
import modele.Role;

import controleur.ControleurBarreMenu;
import controleur.ControleurVue;

public class BarreMenu extends JMenuBar implements Observer{

    private JMenu menuF, menuG, menuC;
    
    private JMenuItem itemC, itemDC, itemQ, itemMenu, itemResto, itemAC, itemMC, itemSC, itemLivraison;
    private Role droits;
    private JPanel panneauTempo;
	/**
	 * Le contrôleur de la vue.
	 * Il écoute pour les actions telles que peser sur un bouton et modifier le texte dans une zone.
	 */
	private ControleurBarreMenu controleur;
    
	public BarreMenu(){
		
		droits=new Null();
		
		/*
		 * Instanciation du contrôleur.
		 * On passe la classe en tant qu'observateur.
		 */
		controleur = new ControleurBarreMenu((Observer)this);
		
		//Construire le menu Fichier
        menuF = new JMenu("Fichier");
             
        this.add(menuF);

        //Création des items de menus
        
        itemC = new JMenuItem("Connexion");        
        menuF.add(itemC);
		itemC.addActionListener(controleur);
		itemC.setActionCommand("CONNEXION"); 
        
		
        itemDC = new JMenuItem("Deconnexion");        
        menuF.add(itemDC);
		itemDC.addActionListener(controleur);
		itemDC.setActionCommand("DECONNEXION"); 


      //  menuF = new JMenu("Client");  
      //  menuF.add(menuF);
        itemAC = new JMenuItem("Creer compte client");        
        itemAC.addActionListener(controleur);
		itemAC.setActionCommand("ADDCLIENT");
        menuF.add(itemAC);
		
        
		itemQ = new JMenuItem("Quitter");        
        menuF.add(itemQ);
        itemQ.addActionListener(controleur);
        itemQ.setActionCommand("QUITTER");

        
        
      
      //Construire le menu Client
        menuC = new JMenu("Client");
        this.add(menuC);
        
        itemMC = new JMenuItem("Modifier compte");        
        itemMC.addActionListener(controleur);
        itemMC.setActionCommand("MODCLIENT");
        menuC.add(itemMC);

        itemSC = new JMenuItem("Supprimer compte");        
        itemSC.addActionListener(controleur);
        itemSC.setActionCommand("SUPPCLIENT");
        menuC.add(itemSC);
        
      //Construire le menu Gestion
        menuG = new JMenu("Gestion");
        this.add(menuG);
        
   
        itemMenu = new JMenuItem("Menu");    
        itemMenu.addActionListener(controleur);
        itemMenu.setActionCommand("ADDMENU");
			
        menuG.add(itemMenu);
        
		
        
        itemResto = new JMenuItem("Restaurant");        
        itemResto.addActionListener(controleur);
		itemResto.setActionCommand("ADDRESTO");
        menuG.add(itemResto);
        
        itemLivraison = new JMenuItem("Livraison");        
        itemLivraison.addActionListener(controleur);
		itemLivraison.setActionCommand("LIVRAISON");
        menuG.add(itemLivraison);
        
       
               
        
        
        
        
        
        // SWITCH QUI PERMET DE POUVOIR AVOIR ACCES A TOUT SANS SE LOGGUER (enlever avant production ;) )
        //verifDroits(droits);
       DroitsTempo();
	}
    
	private void DroitsTempo() {
		// TODO Auto-generated method stub
		 itemC.setEnabled(true);
    	 itemDC.setEnabled(true); 
    	 menuG.setEnabled(true);
    	 itemAC.setEnabled(true);
    	 itemC.setEnabled(true);
    	 	itemDC.setEnabled(true);
    	 	menuG.setEnabled(true);
    	 	
    	 	itemAC.setEnabled(true);
    	 	itemMC.setEnabled(true);
    	 	itemLivraison.setEnabled(true);
    	 	menuC.setVisible(true);
	}

	//@Override
	public void update(Observable arg0, Object arg1) {

		
		droits = (Role)arg1;
		verifDroits(droits);
		
		repaint(); 
		
	}
	
	public void verifDroits(Role droits){
		
		 if (droits.isNull()){
	        	
	        	 itemC.setEnabled(true);
	        	 itemDC.setEnabled(false); 
	        	 menuG.setVisible(false);
	        	 itemAC.setEnabled(true);
	        	 menuC.setVisible(false);
		      
	        }
		 
		 else if (droits.isClient()){
	        	
	        	itemC.setEnabled(false);
	       	 	itemDC.setEnabled(true); 
	       	 	menuG.setVisible(false);
	       	  	itemAC.setEnabled(false);
	       	 	itemMC.setEnabled(true);
	       	 	itemMenu.setVisible(false);
	       	 	itemResto.setVisible(false);
	       	 	menuC.setVisible(true);
	        }
	        else if (droits.isLivreur()){
	        	
	        	itemC.setEnabled(false);
	       	 	itemDC.setEnabled(true); 
	       	 	menuG.setVisible(true);
	       	 	itemAC.setEnabled(false);
	       	 	itemMC.setEnabled(false);
	       	 	itemMenu.setVisible(false);
	       	 	itemResto.setVisible(false);
	       	 	menuC.setVisible(false);
	        }
	        else if (droits.isGerant()){
	        	
	        	itemC.setEnabled(false);
	       	 	itemDC.setEnabled(true);
	       	 	menuG.setVisible(true);
	       	 	itemAC.setEnabled(false);
	       	 	itemMC.setEnabled(false);
	       		itemMenu.setVisible(true);
	       	 	itemResto.setVisible(true);
	       	 	menuC.setVisible(false);
	        }
	        else if (droits.isAdmin()){
	        	
	        	itemC.setEnabled(false);
	       	 	itemDC.setEnabled(true);
	       	 	menuG.setVisible(true);
	       	 	itemAC.setEnabled(false);
	       	 	itemMC.setEnabled(false);
	       	 	itemMenu.setVisible(true);
	       	 	itemResto.setVisible(true);
	       	 	menuC.setVisible(true);
	        }
	}
	
	public void nouvelleVueClient(){

		panneauTempo = new VueClient();
		
	}
	public void nouvelleVueMenu(){
		panneauTempo = new VueMenu();
	}
	public void nouvelleVueRestaurant(){
		panneauTempo = new VueRestaurant();
	}
	public void nouvelleVueDefaut(){
		panneauTempo = new DefaultVue();
	}

	public JPanel getPanneauTempo() {
		return panneauTempo;
	}

	
}

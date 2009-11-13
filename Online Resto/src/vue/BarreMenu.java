package vue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import modele.Null;
import modele.Role;

import controleur.ControleurBarreMenu;
import controleur.ControleurVue;

public class BarreMenu extends JMenuBar implements Observer{

    private JMenu menuF, menuG, resto, menus, submenu, menuC;
    
    private JMenuItem itemC, itemDC, itemQ, itemAM, itemMM, itemSM, itemAR, itemMR, itemSR, itemAC, itemMC, itemSC;
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

        
        
        //Construire le menu Gestion
        menuG = new JMenu("Gestion");
        this.add(menuG);
        
        
        itemMC = new JMenuItem("Modifier compte");        
        itemMC.addActionListener(controleur);
        itemMC.setActionCommand("MODCLIENT");
        menuG.add(itemMC);
        /*
        itemSC = new JMenuItem("Supprimer un client");        
        itemSC.addActionListener(controleur);
        itemSC.setActionCommand("SUPCLIENT");
        itemSC.setEnabled(false);
        menuC.add(itemSC);	        
        */
        
        
        
        
        menus = new JMenu("Menus");
        menuG.add(menus);
        itemAM = new JMenuItem("Créer un Menu");    
        itemAM.addActionListener(controleur);
        itemAM.setActionCommand("ADDMENU");
				
        menus.add(itemAM);
        itemMM = new JMenuItem("Modifier un Menu");        
        itemMM.addActionListener(controleur);
		itemMM.setActionCommand("MODMENU");

        menus.add(itemMM);
        itemSM = new JMenuItem("Supprimer un Menu");        
        itemSM.addActionListener(controleur);
        itemSM.setActionCommand("SUPMENU");
        itemSM.setEnabled(false);
        menus.add(itemSM);
		
        resto = new JMenu("Restaurants");  
        menuG.add(resto);
        itemAR = new JMenuItem("Ajouter un restaurant");        
        itemAR.addActionListener(controleur);
		itemAR.setActionCommand("ADDRESTO");
        resto.add(itemAR);
        
        itemMR = new JMenuItem("Modifier un restaurant");        
        itemMR.addActionListener(controleur);
        itemMR.setActionCommand("MODRESTO");
        resto.add(itemMR);
        
        itemSR = new JMenuItem("Supprimer un restaurant");        
        itemSR.addActionListener(controleur);
        itemSR.setActionCommand("SUPRESTO");
        itemSR.setEnabled(false);
        resto.add(itemSR);		
               
        
        
        
        
        
        
        verifDroits(droits);
   
	}
    
	@Override
	public void update(Observable arg0, Object arg1) {

		
		droits = (Role)arg1;
		verifDroits(droits);
		
		repaint(); 
		
	}
	
	public void verifDroits(Role droits){
		
		 if (droits.isNull()){
	        	
	        	 itemC.setEnabled(true);
	        	 itemDC.setEnabled(false); 
	        	 menuG.setEnabled(false);
	        	 
	        }
	        else if (droits.isLivreur()){
	        	
	        	itemC.setEnabled(false);
	       	 	itemDC.setEnabled(true); 
	       	 	menuG.setEnabled(false);
	       	 	
	        }
	        else if (droits.isGerant()){
	        	
	        	itemC.setEnabled(false);
	       	 	itemDC.setEnabled(true);
	       	 	menuG.setEnabled(true);
	       	 	
	        }
	        else if (droits.isAdmin()){
	        	
	        	itemC.setEnabled(false);
	       	 	itemDC.setEnabled(true);
	       	 	menuG.setEnabled(true);
	       	 	
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

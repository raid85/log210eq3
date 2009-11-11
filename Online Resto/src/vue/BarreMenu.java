package vue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import controleur.ControleurMenuVue;
import controleur.ControleurVue;

public class BarreMenu extends JMenuBar implements Observer{

    private JMenu menuF, menuG, resto, menus, submenu;
    private JMenuItem itemC, itemDC, itemQ, itemAM, itemMM, itemSM;
    
	/**
	 * Le contrôleur de la vue.
	 * Il écoute pour les actions telles que peser sur un bouton et modifier le texte dans une zone.
	 */
	private ControleurMenuVue controleur;
    
	public BarreMenu(){
		
		/*
		 * Instanciation du contrôleur.
		 * On passe la classe en tant qu'observateur.
		 */
		controleur = new ControleurMenuVue((Observer)this);
		
		//Construire le menu Fichier
        menuF = new JMenu("Fichier");
             
        this.add(menuF);

        //Création des items de menus
        
        itemC = new JMenuItem("Connexion");        
        menuF.add(itemC);
		itemC.addActionListener(controleur);
		itemC.setActionCommand("CONNEXION"); 
        itemC.setEnabled(false);
		
        itemDC = new JMenuItem("Deconnexion");        
        menuF.add(itemDC);
		itemDC.addActionListener(controleur);
		itemDC.setActionCommand("DECONNEXION"); 
        itemDC.setEnabled(false);        
        
		itemQ = new JMenuItem("Quitter");        
        menuF.add(itemQ);
        itemQ.addActionListener(controleur);
        itemQ.setActionCommand("QUITTER");

        //Construire le menu Gestion
        menuG = new JMenu("Gestion");
        
        this.add(menuG);
        
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
        
        menus.add(itemSM);
		
       resto = new JMenu("Restaurants");  
        menuG.add(resto);
        
        itemC.setEnabled(true);
        menus.setEnabled(false);
        itemSM.setEnabled(false);
        resto.setEnabled(false);
 
/*        
        menuItem = new JMenuItem("Ajouter un restaurant");        
        menuItem.addActionListener(controleur);
		menuItem.setActionCommand("ADDRESTO");
        resto.add(menuItem);
        
        menuItem = new JMenuItem("Modifier un restaurant");        
		menuItem.addActionListener(controleur);
		menuItem.setActionCommand("MODRESTO");
        resto.add(menuItem);
        
        menuItem = new JMenuItem("Supprimer un restaurant");        
		menuItem.addActionListener(controleur);
		menuItem.setActionCommand("SUPRESTO");
        resto.add(menuItem);		
*/
	}
    
    @Override
	public void update(Observable arg0, Object arg1) {

	}
    
	
}

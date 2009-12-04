package vue;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import controleur.ControleurConsulterCommande;
import controleur.ControleurMenu;
public class VueConsulterCommande extends JPanel implements Observer
{  

	
	ControleurConsulterCommande controleur;	
	

	JButton terminer=new JButton("Terminer");
	JList listeRestaurants;
	JList menu ;
	JList commandes ;

	JLabel labelTitre = new JLabel("          Consultation des commandes");	  

	GridBagLayout repartiteur;


	public int getSelectionMenu(){
		return menu.getSelectedIndex();
	}

	public VueConsulterCommande() {
		
		menu = new JList();
		listeRestaurants = new JList();
		commandes = new JList();

		repartiteur = new GridBagLayout(); 	

		creerGUI();


		
	}


	private void creerGUI() {
		setLayout(repartiteur); 
		this.setBackground(Color.LIGHT_GRAY);	
		UtilitaireRepartition.ajouter(this,labelTitre,1,0,6,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);   
		
		commandes.setPreferredSize(new Dimension(200,155));   
		UtilitaireRepartition.ajouter(this,menu,7,8,2,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,1,10,10,2,0,0);

		

		menu.setPreferredSize(new Dimension(200,155));   
		UtilitaireRepartition.ajouter(this,menu,7,8,2,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,1,1,10,2,0,0);

		listeRestaurants.setPreferredSize(new Dimension(215,340));   
		UtilitaireRepartition.ajouter(this,listeRestaurants,0,1,5,10,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,1,5,10,2,0,0); 
	}

	

	//@Override
	public void update(Observable arg0, Object arg1) {
		listeRestaurants.setListData((Object[])arg1);


	}
}



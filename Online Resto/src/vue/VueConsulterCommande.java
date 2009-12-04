package vue;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import modele.Terminal;

import controleur.ControleurConsulterCommande;
import controleur.ControleurMenu;
public class VueConsulterCommande extends JPanel implements Observer
{  

	
	ControleurConsulterCommande controleur;
	JButton consulter=new JButton("Consulter");
	JList listeRestaurants;	
	JList listeCommandes ;
	JList infoCommande ;

	JLabel labelTitre = new JLabel("          Consultation des commandes");	  
	JLabel labelRestaurant = new JLabel("Restaurants");
	JLabel labelCommandes = new JLabel("Commandes");
	JLabel labelInfoCommande = new JLabel("Détails de la commande");
	

	GridBagLayout repartiteur;


	public int getSelectionResto(){
		return listeRestaurants.getSelectedIndex();
	}
	public int getSelectionCommande(){
		return listeCommandes.getSelectedIndex();
	}
	public JList getCommandes(){
		return this.listeCommandes ;
	}
	public JList getInfoCommandes (){
		return this.infoCommande;
	}
	

	public VueConsulterCommande() {
		
		infoCommande= new JList();
		listeRestaurants = new JList();
		listeCommandes = new JList();
		
		listeRestaurants.addListSelectionListener(controleur);
		consulter.addActionListener(controleur);
		//listeCommandes.addListSelectionListener(controleur);
		
		repartiteur = new GridBagLayout(); 	

		creerGUI();


		
	}
	
	


	private void creerGUI() {
		
		setLayout(repartiteur); 
		
		this.setBackground(Color.LIGHT_GRAY);	
		
		UtilitaireRepartition.ajouter(this,labelTitre,1,0,6,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);   
		
		UtilitaireRepartition.ajouter(this,labelCommandes,7,5,2,1,GridBagConstraints.NONE,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);
		
		
		UtilitaireRepartition.ajouter(this,consulter,7,0,2,1,GridBagConstraints.NONE,
	            GridBagConstraints.SOUTH,
	            0,0,2,10,10,2,0,0);
		
		listeCommandes.setPreferredSize(new Dimension(200,155));   
		UtilitaireRepartition.ajouter(this,listeCommandes,7,8,2,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,1,10,10,2,0,0);
		

		infoCommande.setPreferredSize(new Dimension(200,155));   
		UtilitaireRepartition.ajouter(this,infoCommande,7,10,2,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,1,10,10,2,0,0);
		UtilitaireRepartition.ajouter(this,labelInfoCommande,7,9,2,1,GridBagConstraints.NONE,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);

		listeRestaurants.setPreferredSize(new Dimension(215,340));   
		UtilitaireRepartition.ajouter(this,listeRestaurants,0,1,5,10,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,1,5,5,2,0,0); 
		UtilitaireRepartition.ajouter(this,labelRestaurant,0,1,5,10,GridBagConstraints.NONE,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);
	}

	

	//@Override
	public void update(Observable arg0, Object arg1) {
		listeRestaurants.setListData((Object[])arg1);


	}
}



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
import controleur.ControleurRestaurant;
public class VueConsulterCommande extends JPanel implements Observer
{  

	
	ControleurConsulterCommande controleur;
	
	private JButton consulter=new JButton("Consulter");
	private JButton accepter = new JButton("Accepter");
	private JButton complet = new JButton("Prête");
	
	
	private JList listeRestaurants= new JList();	
	private JList listeCommandes = new JList();
	private JList infoCommande = new JList();
	
	private JScrollPane panResto ;
	private JScrollPane panCommandes ;
	private JScrollPane panInfo ;

	private JLabel labelTitre = new JLabel("Consultation des commandes");	  
	private JLabel labelRestaurant = new JLabel("Restaurants");
	private JLabel labelCommandes = new JLabel("Commandes");
	private JLabel labelInfoCommande = new JLabel("Détails de la commande");
	

	GridBagLayout repartiteur;


	public VueConsulterCommande() {		
		
		controleur = new ControleurConsulterCommande((Observer)this);		
		
		listeRestaurants.addListSelectionListener(controleur);
		consulter.addActionListener(controleur);
		accepter.addActionListener(controleur);
		complet.addActionListener(controleur);
		
		
		repartiteur = new GridBagLayout(); 	
		
		panResto = new JScrollPane(listeRestaurants);
		panCommandes= new JScrollPane(listeCommandes);
		panInfo = new JScrollPane(infoCommande);
	
		creerGUI();
	
	
		
	}
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
	

	private void creerGUI() {
		
		setLayout(repartiteur); 
		
		this.setBackground(Color.LIGHT_GRAY);	
		
		UtilitaireRepartition.ajouter(this,labelTitre,3,0,6,1,GridBagConstraints.VERTICAL,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);   
		
		UtilitaireRepartition.ajouter(this,labelCommandes,7,2,2,1,GridBagConstraints.NONE,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);
		UtilitaireRepartition.ajouter(this,complet,8,11,1,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,2,1,1,1,0,0);
		
		
		UtilitaireRepartition.ajouter(this,consulter,6,11,1,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,2,1,1,1,0,0);
		UtilitaireRepartition.ajouter(this,accepter,7,11,1,1,GridBagConstraints.HORIZONTAL,
	            GridBagConstraints.SOUTH,
	            0,0,2,1,1,1,0,0);
		
		
		
		
		listeCommandes.setPreferredSize(new Dimension(200,155));   
		UtilitaireRepartition.ajouter(this,panCommandes,7,3,2,1,GridBagConstraints.VERTICAL,
				GridBagConstraints.SOUTH,
				0,0,1,10,10,2,0,0);
		

		infoCommande.setPreferredSize(new Dimension(200,155));   
		UtilitaireRepartition.ajouter(this,panInfo,7,10,2,1,GridBagConstraints.VERTICAL,
				GridBagConstraints.SOUTH,
				0,0,1,10,10,2,0,0);
		UtilitaireRepartition.ajouter(this,labelInfoCommande,7,9,2,1,GridBagConstraints.NONE,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);

		listeRestaurants.setPreferredSize(new Dimension(215,340));   
		UtilitaireRepartition.ajouter(this,panResto,0,3,5,10,GridBagConstraints.VERTICAL,
				GridBagConstraints.SOUTH,
				0,0,1,10,10,2,0,0); 
		UtilitaireRepartition.ajouter(this,labelRestaurant,0,2,5,1,GridBagConstraints.NONE,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);
	}

	

	//@Override
	public void update(Observable arg0, Object arg1) {
		
		listeRestaurants.setListData((Object[])arg1);
		

	}
}



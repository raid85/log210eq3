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
import controleur.ControleurLivraison;
import controleur.ControleurMenu;
import controleur.ControleurRestaurant;
public class VueLivraison extends JPanel implements Observer
{  


	ControleurLivraison controleur;

	private JButton consulter=new JButton("Consulter");
	private JButton accepter = new JButton("Accepter");
	private JButton complet = new JButton("Livrée");


	private JList listeLivreurs= new JList();	
	private JList listeLivraison = new JList();
	private JList infoLivraison = new JList();

	private JScrollPane panResto ;
	private JScrollPane panCommandes ;
	private JScrollPane panInfo ;

	private JLabel labelTitre = new JLabel("Consultation des Livraisons");	  
	private JLabel labelRestaurant = new JLabel("Livreurs");
	private JLabel labelCommandes = new JLabel("Livraison");
	private JLabel labelInfoCommande = new JLabel("Détails de la livraion");


	GridBagLayout repartiteur;


	public VueLivraison() {		

		controleur = new ControleurLivraison((Observer)this);		

		listeLivreurs.addListSelectionListener(controleur);
		consulter.addActionListener(controleur);
		accepter.addActionListener(controleur);
		complet.addActionListener(controleur);


		repartiteur = new GridBagLayout(); 	

		panResto = new JScrollPane(listeLivreurs);
		panCommandes= new JScrollPane(listeLivraison);
		panInfo = new JScrollPane(infoLivraison);

		creerGUI();



	}
	public int getSelectionLivreur(){
		return listeLivreurs.getSelectedIndex();
	}
	public int getSelectionLivraison(){
		return listeLivraison.getSelectedIndex();
	}
	public JList getLivraisons(){
		return this.listeLivraison ;
	}
	public JList getInfoLivraison (){
		return this.infoLivraison;
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


		listeLivraison.setPreferredSize(new Dimension(200,155));   
		UtilitaireRepartition.ajouter(this,panCommandes,7,3,2,1,GridBagConstraints.VERTICAL,
				GridBagConstraints.SOUTH,
				0,0,1,10,10,2,0,0);


		infoLivraison.setPreferredSize(new Dimension(200,155));   
		UtilitaireRepartition.ajouter(this,panInfo,7,10,2,1,GridBagConstraints.VERTICAL,
				GridBagConstraints.SOUTH,
				0,0,1,10,10,2,0,0);
		UtilitaireRepartition.ajouter(this,labelInfoCommande,7,9,2,1,GridBagConstraints.NONE,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);

		listeLivreurs.setPreferredSize(new Dimension(215,340));   
		UtilitaireRepartition.ajouter(this,panResto,0,3,5,10,GridBagConstraints.VERTICAL,
				GridBagConstraints.SOUTH,
				0,0,1,10,10,2,0,0); 
		UtilitaireRepartition.ajouter(this,labelRestaurant,0,2,5,1,GridBagConstraints.NONE,
				GridBagConstraints.NORTH,
				0,0,15,2,15,2,0,0);
	}



	//@Override
	public void update(Observable arg0, Object arg1) {

		listeLivreurs.setListData((Object[])arg1);


	}
}



package vue;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.text.Document;

import controleur.* ;
import modele.*;

public class VueLivreur extends JPanel implements Observer

{  
	private ControleurLivreur controleur;

	JButton ajouter=new JButton("AJOUTER");	
	JButton enlever=new JButton("ENLEVER");	
	JButton modifier=new JButton("MODIFIER"); 

	JLabel labelNom = new JLabel("Nom"),	
	labelAdresse = new JLabel("Adresse"),
	labelTelephone = new JLabel("Téléphone"),
	labelZoneCouverture = new JLabel("Zone de couverture"),
	labelDisponibilite = new JLabel("Disponibilitées"),	
	labelTitre = new JLabel("                                                ESPACE LIVREUR");

	private JScrollPane panlist ;
	JList liste = new JList ();

	private JTextField nomsLiveurs;

	JTextField textNom = new JTextField(),	
	textAdresse = new JTextField(),
	textTelephone = new JTextField(),
	textZoneCouverture = new JTextField(),
	textDisponibilite = new JTextField();
	GridBagLayout repartiteur;


	JTextArea texte = new JTextArea();
	VueLivreur()
	{		
		controleur = new ControleurLivreur((Observer)this);	
		repartiteur = new GridBagLayout();		

		//ajout du controleur comme écouter des actions des boutons enlever et ajouter

		ajouter.addActionListener(controleur);
		enlever.addActionListener(controleur);
		modifier.addActionListener(controleur);
		liste.addListSelectionListener(controleur);


		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.setVisibleRowCount(10);
		panlist = new JScrollPane(liste);


		CreerGUI();



	} 


	public void CreerGUI() {
		setLayout(repartiteur); 
		this.setBackground(Color.LIGHT_GRAY);
		labelTitre.setPreferredSize(new Dimension(330,20));
		UtilitaireRepartition.ajouter(this,labelTitre,0,1,6,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,2,2,30,2,0,0);
		UtilitaireRepartition.ajouter(this,labelNom,0,2,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelAdresse,0,3,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelTelephone,0,4,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelZoneCouverture,0,5,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelDisponibilite,0,6,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);		
		textNom.setPreferredSize(new Dimension(200,20));
		UtilitaireRepartition.ajouter(this,textNom,2,2,4,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.NORTH,
				0,0,10,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textAdresse,2,3,4,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textTelephone,2,4,4,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textZoneCouverture,2,5,4,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textDisponibilite,2,6,4,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);

		UtilitaireRepartition.ajouter(this,ajouter,6,2,1,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,1,10,1,1,0,0);
		UtilitaireRepartition.ajouter(this,enlever,6,3,1,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,2,10,2,2,0,0);
		UtilitaireRepartition.ajouter(this,modifier,6,4,1,1,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,2,10,2,2,0,0);    

		UtilitaireRepartition.ajouter(this,panlist,0,8,0,0,GridBagConstraints.NONE,
				GridBagConstraints.SOUTH,
				0,0,15,1,15,1,0,0);

	}




	/**Groupe d'accesseurs qui fournissent les infos saisies par la vue sous forme de String
	 * 
	 * @return String
	 */
	public String getNom (){
		return textNom.getText();
	}
	public String getAdresse (){
		return textAdresse.getText();
	}
	public String getTelephone (){
		return textTelephone.getText();
	}
	public String getZoneCouverture (){
		return textZoneCouverture.getText();
	}
	public String getDispo (){
		return textDisponibilite.getText();
	}


	public String toString(){
		String tempo = textNom.getText();
		return tempo;
	}	




	//@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		liste.setListData((Object[])arg1);
		textNom.setText("");
		textAdresse.setText("");
		textTelephone.setText("");
		textZoneCouverture.setText("");
		textDisponibilite.setText("");


	}


}



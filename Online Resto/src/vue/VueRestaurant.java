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


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;



import controleur.* ;
import modele.*;

public class VueRestaurant extends JPanel implements Observer, ListSelectionListener

{  
	private ControleurRestaurant controleur;

	private String nomResto ;
	private String adresse ;
	private String telephone ;
	private String zoneLivraison ;
	private String heureOuverture;	

	JButton ajouter=new JButton("AJOUTER");	
	JButton enlever=new JButton("ENLEVER");	
	JButton modifier=new JButton("MODIFIER"); 

	JLabel labelNom = new JLabel("Nom"),	
	labelAdresse = new JLabel("Adresse"),
	labelTelephone = new JLabel("Téléphone"),
	labelZoneLivraison = new JLabel("Zones de livraison"),
	labelHeureOuverture = new JLabel("Heure d'ouverture"),	
	labelTitre = new JLabel("                                                ESPACE RESTAURANT");
	

	private JScrollPane panlist ;
	JList liste = new JList ();
	private DefaultListModel listModel;
	private JTextField nomsRestos;

	JTextField textNom = new JTextField(),	
	textAdresse = new JTextField(),
	textTelephone = new JTextField(),
	textZoneLivraison = new JTextField(),
	textHeureOuverture = new JTextField();
	

	JTextArea texte = new JTextArea();
	VueRestaurant()
	{		
		controleur = new ControleurRestaurant((Observer)this);	
		GridBagLayout repartiteur=new GridBagLayout();		
		
		//ajout du controleur comme écouter des actions des boutons enlever et ajouter

		ajouter.addActionListener(controleur);
		enlever.addActionListener(controleur);	
		
		enlever.addActionListener(new FireListener());
		HireListener hireListener = new HireListener(ajouter);
		//ajouter.setActionCommand(hireString);
		ajouter.addActionListener(hireListener);


		listModel = new DefaultListModel();
		liste = new JList(listModel);
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.setSelectedIndex(1);
		liste.addListSelectionListener(this);
		liste.setVisibleRowCount(10);
		panlist = new JScrollPane(liste);

		nomsRestos = new JTextField(1);
		nomsRestos.addActionListener(hireListener);
		nomsRestos.getDocument().addDocumentListener(hireListener);
		


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
		UtilitaireRepartition.ajouter(this,labelZoneLivraison,0,5,1,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,labelHeureOuverture,0,6,1,1,GridBagConstraints.HORIZONTAL,
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
		UtilitaireRepartition.ajouter(this,textZoneLivraison,2,5,4,1,GridBagConstraints.HORIZONTAL,
				GridBagConstraints.SOUTH,
				0,0,10,2,2,2,0,0);
		UtilitaireRepartition.ajouter(this,textHeureOuverture,2,6,4,1,GridBagConstraints.HORIZONTAL,
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


	/**Méthode qui sert a récupérer le texte sous for de string des JTextField
	 * 
	 */
	public void grabText (){

		this.nomResto = textNom.getText();
		this.adresse=textAdresse.getText();
		this.telephone = textTelephone.getText();
		this.zoneLivraison=textZoneLivraison.getText();
		this.heureOuverture=textHeureOuverture.getText();	

		/*Document documentNom = textNom.getDocument();
		Document documentAdresse = textAdresse.getDocument();
		Document documentTel =textTelephone.getDocument();
		Document documentZL =textZoneLivraison.getDocument();
		Document documentHO = textHeureOuverture.getDocument();
		Document documentHF = textHeureFermeture.getDocument();

		documentNom.addDocumentListener(controleur);
		documentAdresse.addDocumentListener(controleur);
		documentTel.addDocumentListener(controleur);
		documentZL.addDocumentListener(controleur);
		documentHO.addDocumentListener(controleur);
		documentHF.addDocumentListener(controleur);*/




	}
	public void doList(Restaurant r){
		listModel.addElement(r);
	}

	/**Groupe d'accesseurs qui fournissent les infos saisies par la vue sous forme de String
	 * 
	 * @return String
	 */
	public String getNom (){
		return this.nomResto;
	}
	public String getAdresse (){
		return this.adresse ;
	}
	public String getTelephone (){
		return this.telephone;
	}
	public String getZoneLivraison (){
		return this.zoneLivraison;
	}
	public String getHeureOuverture (){
		return this.heureOuverture;
	}

	
	public String toString(){
		String tempo = textNom.getText();
		return tempo;
	}



	class FireListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//This method can be called only if
			//there's a valid selection
			//so go ahead and remove whatever's selected.
			int index = liste.getSelectedIndex();
			listModel.remove(index);

			int size = listModel.getSize();

			if (size == 0) { //Nobody's left, disable firing.
				ajouter.setEnabled(false);

			} else { //Select an index.
				if (index == listModel.getSize()) {
					//removed item in last position
					index--;
				}

				liste.setSelectedIndex(index);
				liste.ensureIndexIsVisible(index);
			}
		}
	}

	//This listener is shared by the text field and the hire button.
	class HireListener implements ActionListener, DocumentListener {
		private boolean alreadyEnabled = false;
		private JButton button;

		public HireListener(JButton button) {
			this.button = button;
		}

		//Required by ActionListener.
		public void actionPerformed(ActionEvent e) {
			String name = nomsRestos.getText();

			//User didn't type in a unique name...
			if (name.equals("") || alreadyInList(name)) {
				Toolkit.getDefaultToolkit().beep();
				nomsRestos.requestFocusInWindow();
				nomsRestos.selectAll();
				return;
			}

			int index = liste.getSelectedIndex(); //get selected index
			if (index == -1) { //no selection, so insert at beginning
				index = 0;
			} else {           //add after the selected item
				index++;
			}

			listModel.insertElementAt(nomsRestos.getText(), index);
			//If we just wanted to add to the end, we'd do this:
			//listModel.addElement(employeeName.getText());

			//Reset the text field.
			nomsRestos.requestFocusInWindow();
			nomsRestos.setText("");

			//Select the new item and make it visible.
			liste.setSelectedIndex(index);
			liste.ensureIndexIsVisible(index);
		}

		//This method tests for string equality. You could certainly
		//get more sophisticated about the algorithm.  For example,
		//you might want to ignore white space and capitalization.
		protected boolean alreadyInList(String name) {
			return listModel.contains(name);
		}

		//Required by DocumentListener.
		public void insertUpdate(DocumentEvent e) {
			enableButton();
		}
		//Required by DocumentListener.
		public void removeUpdate(DocumentEvent e) {
			handleEmptyTextField(e);
		}

		//Required by DocumentListener.
		public void changedUpdate(DocumentEvent e) {
			if (!handleEmptyTextField(e)) {
				enableButton();
			}
		}

		private void enableButton() {
			if (!alreadyEnabled) {
				button.setEnabled(true);
			}
		}

		private boolean handleEmptyTextField(DocumentEvent e) {
			if (e.getDocument().getLength() <= 0) {
				button.setEnabled(false);
				alreadyEnabled = false;
				return true;
			}
			return false;
		}
	}

	//This method is required by ListSelectionListener.
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

			if (liste.getSelectedIndex() == -1) {
				//No selection, disable fire button.
				enlever.setEnabled(false);

			} else {
				//Selection, enable the fire button.
				enlever.setEnabled(true);
			}
		}
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


}



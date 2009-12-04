package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.Terminal;
import vue.*;

public class ControleurLivraison implements ListSelectionListener,ActionListener {

	private VueLivraison vue ;
	private Terminal instance;	
	private int esLivreurs;
	private int esLivraison ;

	public ControleurLivraison(Observer observateur) {

		instance=Terminal.getInstance();
		instance.addLivreursObserver(observateur);	
		this.vue = (VueLivraison) observateur;

		esLivreurs = -1;
	}

	//@Override
	public void valueChanged(ListSelectionEvent e) {

		esLivreurs = e.getFirstIndex();
		vue.getLivraisons().setListData(instance.getLivreur(esLivreurs).getLivraisons());


	}

	//@Override
	public void actionPerformed(ActionEvent arg0) {
		String action = arg0.getActionCommand();
		if(action.equalsIgnoreCase("Consulter")&& !vue.getLivraisons().isSelectionEmpty()) {
			vue.getInfoLivraison().setListData(instance.getLivreur(esLivreurs).getLivraison(vue.getLivraisons().getSelectedIndex()).toArray());
		} 
		else if(action.equalsIgnoreCase("Accepter") && !vue.getLivraisons().isSelectionEmpty()){

			esLivraison = vue.getLivraisons().getSelectedIndex();
			if(!instance.getLivreur(esLivreurs).getLivraison(esLivraison).isAccepted()){

				if(JOptionPane.showConfirmDialog(null, "D�sirez vous vraiment livrer la commande  ?","Confirmation", 0)==0){
					instance.getLivreur(esLivreurs).getLivraison(esLivraison).setAccepted(true);
					//System.out.println("..."+instance.getResto(esRestos).getCommande(esCommande).toString());
					//System.out.println("..."+instance.getResto(esRestos).getCommande(esCommande).isAccepter());            		 
				}
			} 
			else JOptionPane.showMessageDialog(null, "La commande s�lection�e � d�ja �t� accept�e");


		}
		else if(action.equalsIgnoreCase("Livr�e") && !vue.getLivraisons().isSelectionEmpty()){
			
			esLivraison = vue.getLivraisons().getSelectedIndex();
			if(!instance.getLivreur(esLivreurs).getLivraison(esLivraison).isDelivered()){

				if(JOptionPane.showConfirmDialog(null, "Confirmez vous que la commande est pr�te ?","Confirmation", 0)==0){
					instance.getLivreur(esLivreurs).getLivraison(esLivraison).setDelivered(true);
					//System.out.println("..."+instance.getResto(esRestos).getCommande(esCommande).toString());
					//System.out.println("complete ??"+instance.getResto(esRestos).getCommande(esCommande).isCompleter());            		 
				}
			} 
			else JOptionPane.showMessageDialog(null, "La commande s�lection�e � d�ja �t� livr�e");

		}
		


	}

}

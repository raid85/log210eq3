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

public class ControleurConsulterCommande implements ListSelectionListener,ActionListener {

	private VueConsulterCommande vue ;
	private Terminal instance;
	private String texte;
	private int esRestos;
	private int esCommande ;

	public ControleurConsulterCommande(Observer observateur) {

		instance=Terminal.getInstance();
		instance.addRestoObserver(observateur);	
		this.vue = (VueConsulterCommande) observateur;

		esRestos = -1;
	}

	//@Override
	public void valueChanged(ListSelectionEvent e) {

		esRestos = e.getFirstIndex();
		vue.getCommandes().setListData(instance.getResto(esRestos).getCommandes());


	}

	//@Override
	public void actionPerformed(ActionEvent arg0) {
		String action = arg0.getActionCommand();
		if(action.equalsIgnoreCase("Consulter")&& !vue.getCommandes().isSelectionEmpty()) {
			vue.getInfoCommandes().setListData(instance.getResto(esRestos).getCommande(vue.getCommandes().getSelectedIndex()).getPlats().toArray());


		} 
		else if(action.equalsIgnoreCase("Accepter") && !vue.getCommandes().isSelectionEmpty()){
			esCommande = vue.getCommandes().getSelectedIndex();
			if(!instance.getResto(esRestos).getCommande(esCommande).isAccepter()){

				if(JOptionPane.showConfirmDialog(null, "Confirmez vous l'acceptation de la commande ?","Confirmation", 0)==0){
					instance.getResto(esRestos).getCommande(esCommande).setAccepter(true);
					System.out.println("..."+instance.getResto(esRestos).getCommande(esCommande).toString());
					System.out.println("..."+instance.getResto(esRestos).getCommande(esCommande).isAccepter());            		 
				}
			} 
			else JOptionPane.showMessageDialog(null, "La commande sélectionée à déja été acceptée par un restaurant");

		}


	}

}

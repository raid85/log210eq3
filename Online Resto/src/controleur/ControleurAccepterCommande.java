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

public class ControleurAccepterCommande implements ListSelectionListener,ActionListener {

	private VueAccepterCommande vue ;
	private Terminal instance;	
	private int esRestos;
	

	public ControleurAccepterCommande(Observer observateur) {

		instance=Terminal.getInstance();
		instance.addRestoObserver(observateur);	
		this.vue = (VueAccepterCommande) observateur;
		
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
		else if(action.equalsIgnoreCase("accepter")){
			
		}
		
		
	}

}

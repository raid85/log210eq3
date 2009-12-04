package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

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
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		esRestos = e.getFirstIndex();		
		//esCommande = this.vue.getSelectionCommande();
		vue.getCommandes().setListData(instance.getResto(esRestos).getCommandes());
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String action = arg0.getActionCommand();
		if(action.equalsIgnoreCase("Consulter")) {
			vue.getInfoCommandes().setListData((Object[]) instance.getResto(esRestos).getCommande(vue.getCommandes().getSelectedIndex()));
			

		} 
		
		
	}

}

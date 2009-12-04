package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.Terminal;
import vue.*;

public class ControleurConsulterCommande implements ListSelectionListener {

	private VueConsulterCommande vue ;
	private Terminal instance;
	private String texte;
	private int esRestos;
	private int esCommande ;

	public ControleurConsulterCommande(Observer observateur) {

		instance=Terminal.getInstance();
		instance.addCCommandeObserver(observateur);	
		this.vue = (VueConsulterCommande) observateur;
		
		esRestos = -1;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		esRestos = e.getFirstIndex();
		
		
	}

}

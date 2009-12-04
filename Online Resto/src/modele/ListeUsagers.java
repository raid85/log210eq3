package modele;

/**
 * Ces classes sont utilis�es pour permettre l'utilisation d'une collection.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 * Ces classes sont utilis�es pour le patron MVC.
 */
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import modele.Usager;
import java.util.Iterator;
/**
 * Le Catalogue est le point de mire de la Vue.
 * @author Fran�ois Caron
 *
 */
public class ListeUsagers extends Observable {

	/**
	 * La collection qui permet de stocker les strings.
	 */
	private List<Usager> m;
	private int indexUser;	
	private Usager usagerReturn;
	/**
	 * Constructeur avec param�tre.
	 * Lors de l'instanciation du Catalogue, l'observateur re�u est ajout� � la
	 * liste des ses observateurs.
	 * @param observateur
	 */
	public ListeUsagers() {
		/*
		 * L'attribut de la classe ignore le type exact de List.
		 * Dans le cas pr�sent, une ArrayList a �t� utilis�. Un autre type de
		 * List aurait fait l'affaire.
		 */
		m = new ArrayList<Usager>();
		
		/*
		 * L'observateur re�u en param�tre est ajout� aux observateurs du
		 * Catalogue.
		 */
		ajouterUsager(new Usager("livreur","1234","Tres bo", new Livreur()));
		ajouterUsager(new Usager("gerant","1234","pas bo", new Gerant()));
		ajouterUsager(new Usager("admin","1234","laid", new Admin()));
		ajouterUsager(new Usager("client","1234","laid", new RClient()));
		
	}
	
	/**
	 * Cette m�thode sert � ajouter une string au Catalogue.
	 * Lors de l'ajout d'une string, les observateurs sont avis�s de la 
	 * modification.
	 * @param string
	 */
	public void ajouterUsager(Usager unUser) {
		m.add(unUser);
		
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(m.toArray());
	}
	
	/**
	 * Cette m�thode sert � retirer une string du Catalogue.
	 * Lors du retrait d'une string, les observateurs sont avis�s de la
	 * modification.
	 * @param index
	 */
	public void retirerUsager(int index) {
		m.remove(index);
		
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(m.toArray());
	}
	public Usager getUsager(int index){
		Usager tempo;
		tempo = m.get(index);
		return tempo;
		
	}
	public void modifierUsager(int index, Usager lUsager) {
		m.remove(index);
		m.add(index, lUsager);
		/*
		 * Il est important d'indiquer que la classe observ�e a chang� AVANT
		 * d'aviser les observateurs. 
		 */
		setChanged();
		notifyObservers(m.toArray());
	}
	
	public int getHauteur(){
	int tempo;
	tempo=1;
	return tempo;
}
	public void ajouterObserver(Observer observateur) {
		addObserver(observateur);
		setChanged();
		notifyObservers(m.toArray());
	}
	public Usager authentifier() {
		Iterator<Usager> it = m.iterator();
		int sizeTab = 3;
		boolean connected=false;
		boolean mauvaisPW=false;
		boolean question;
		String ligneEntrer,verif1="master",verif2="chix",tempo[];
		Usager loginUser;
		
		
		
		while(!connected){
			
			ligneEntrer = JOptionPane.showInputDialog("Entrez Votre nom d'utilisateur suivi du mot de passe\nNomUsager:MotDePasse  ");
			tempo = ligneEntrer.split(":");
			
			
		int compteur = 0;
		
		while(!connected && !mauvaisPW && it.hasNext()){
				Usager tempUser = it.next();
						
			if(tempUser.getLoginName().equals(tempo[0]) ){
				
				if(tempUser.getPassword().equals(tempo[1])){
					connected=true;
					Usager lUsager  = new Usager();
					lUsager.setLoginName(tempUser.getLoginName());
					lUsager.setPassword(tempUser.getPassword());
					lUsager.setInfoDuDude(tempUser.getInfoDuDude());
					lUsager.setDroits(tempUser.getDroits());
					indexUser = compteur;
					usagerReturn = lUsager;
				}
				else{
					JOptionPane.showMessageDialog(null,"Mauvais mot de passe");
					mauvaisPW=true;
				}
			}
			else{
			
				compteur++;
				
				}
			}
		if(!connected){
			usagerReturn = null;
			connected=true;
		}
		}
		return usagerReturn;
	
	}
}
	

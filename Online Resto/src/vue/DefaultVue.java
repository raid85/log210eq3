package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**Cette classe repr�sente la vue par d�faut qui est affich�e
 * lorsqu'aucune autre vue n'est active
 * @author ah45290
 *
 */
public class DefaultVue extends JPanel implements Observer{
	
	
	public DefaultVue() {
		
		JPanel pane1 = new JPanel(new BorderLayout());
		pane1.setPreferredSize(new Dimension(430,400));
		pane1.setBackground(Color.white);
		this.add(pane1);
		
		GridBagConstraints contraintes = new GridBagConstraints();
		
		/*
		 * La liste doit �tre le premier �l�ment de la fen�tre et elle doit occuper toute la largeur.
		 */
		
   		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 2;
		JTextArea bienvenue = new JTextArea("Bienvenue, si vous etes un nouveau client,\n" +
				"veuillez cr�er un nouveau compte dans le menu Fichier.");
		pane1.add(bienvenue);
	}

	
	
	
    //@Override
	public void update(Observable arg0, Object arg1) {

	}
}

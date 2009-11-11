package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**Cette classe représente la vue par défaut qui est affichée
 * lorsqu'aucune autre vue n'est active
 * @author ah45290
 *
 */
public class DefaultVue extends JPanel implements Observer{
	
	
	public DefaultVue() {
		
		JPanel pane1 = new JPanel(new BorderLayout());
		pane1.setPreferredSize(new Dimension(400,400));
		pane1.setBackground(Color.white);
		this.add(pane1);	
	}

	
	
	
    @Override
	public void update(Observable arg0, Object arg1) {

	}
}

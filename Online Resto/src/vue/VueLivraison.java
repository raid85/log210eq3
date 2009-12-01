package vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.ListModel;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class VueLivraison extends javax.swing.JPanel {

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new VueLivraison());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public VueLivraison() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
setPreferredSize(new Dimension(400, 300));
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
			thisLayout.rowHeights = new int[] {75, 91, 49, 39, 7};
			thisLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			thisLayout.columnWidths = new int[] {7, 7, 7, 7};
			this.setLayout(thisLayout);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

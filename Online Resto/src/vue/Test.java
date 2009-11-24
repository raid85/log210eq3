package vue;

import javax.swing.JFrame;

public class Test extends JFrame {
	
	public Test() {
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		this.setLocationRelativeTo(null);
		this.setContentPane(new VueRestaurant());
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test();
	}
}

package vue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

/* MenuSelectionManagerDemo.java requires images/middle.gif. */

/*
 * This class is just like MenuDemo, except every second (thanks
 * to a Timer) the selected path of the menu is printed in the text area.
 */
public class AppView implements ActionListener, ItemListener {
    JTextArea output;
    JScrollPane scrollPane;
    String newline = "\n";
    public final static int ONE_SECOND = 1000;

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, resto,menus,submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Création de la barre de menu
        menuBar = new JMenuBar();

        //Construire le menu principal
        menu = new JMenu("Menu Principal");
             
        menuBar.add(menu);

        //Création des items de menus
        
        ImageIcon icon = createImageIcon("/MenuIcon.gif");
        ImageIcon icon1 = createImageIcon("/RestoIcon.png");
        ImageIcon icon2 = createImageIcon("/icon003.jpg");
        
        resto = new JMenu("Restaurants");  
        menu.add(resto);
        menuItem = new JMenuItem("Ajouter un restaurant", icon);        
        menuItem.addActionListener(this);
        resto.add(menuItem);
        menuItem = new JMenuItem("Modifier un restaurant", icon1);        
        menuItem.addActionListener(this);
        resto.add(menuItem);
        menuItem = new JMenuItem("Supprimer un restaurant", icon2);        
        menuItem.addActionListener(this);
        resto.add(menuItem);
        
        menus = new JMenu("Menus");
        menu.add(menus);
        menuItem = new JMenuItem("Créer un Menu", icon);        
        menuItem.addActionListener(this);
        menus.add(menuItem);
        menuItem = new JMenuItem("Modifier un Menu", icon1);        
        menuItem.addActionListener(this);
        menus.add(menuItem);
        menuItem = new JMenuItem("Supprimer un Menu", icon2);        
        menuItem.addActionListener(this);
        menus.add(menuItem);

        return menuBar;
    }

    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = "Action event detected."
                   + newline
                   + "    Event source: " + source.getText()
                   + " (an instance of " + getClassName(source) + ")";
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
    }

    public void itemStateChanged(ItemEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        String s = "Item event detected."
                   + newline
                   + "    Event source: " + source.getText()
                   + " (an instance of " + getClassName(source) + ")"
                   + newline
                   + "    New state: "
                   + ((e.getStateChange() == ItemEvent.SELECTED) ?
                     "selected":"unselected");
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
    }

    // Returns just the class name -- no package info.
    protected String getClassName(Object o) {
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        return classString.substring(dotIndex+1);
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = AppView.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Gestion Restaurant 3000 ®");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        AppView demo = new AppView();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());

        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

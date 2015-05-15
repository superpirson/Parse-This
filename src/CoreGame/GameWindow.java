/**
 * 
 */
package CoreGame;

import java.awt.Container;

import javax.swing.*;

/**
 * @author alex
 *
 */
public class GameWindow extends JFrame {
	JPanel pane = new JPanel();
	
	  JButton pressme = new JButton("Press Me");
	  GameWindow(){
	    super("JPrompt Demo"); 
	    setBounds(100,100,300,200);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container con = this.getContentPane(); // inherit main frame
	    con.add(pane);    // JPanel containers default to FlowLayout
	    pressme.setMnemonic('P'); // associate hotkey to button
	    pane.add(pressme); pressme.requestFocus();
	    setVisible(true); // make frame visible
}
}

package CoreGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;

import GameData.State;
import GameData.Transition;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWindow {
	private State currentState; 
	private JFrame frame;
	private JTextPane textPane;
	private JComboBox<Transition> comboBox;
	private JButton btnGo;

	public GameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.getContentPane().setLayout(null);
		 
		  textPane = new JTextPane();
		  textPane.setBounds(12, 12, 426, 211);
		  frame.getContentPane().add(textPane);
		 
		  comboBox = new JComboBox<Transition>();
		  comboBox.setBounds(12, 235, 362, 24);
		  frame.getContentPane().add(comboBox);
		 
		 btnGo = new JButton("GO!");
		 btnGo.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		transition((Transition)comboBox.getSelectedItem());
		 	}
		 });
		 btnGo.setBounds(378, 235, 60, 25);
		 frame.getContentPane().add(btnGo);
		frame.setVisible(true);
	}

	public void goToState(State state){
		currentState = state;
		this.guiUpdate();
	}
	public void transition(Transition trans){
		currentState = trans.getState();
		this.guiUpdate();
	}
	private void guiUpdate(){
		textPane.setText(currentState.getText());
		frame.setTitle(currentState.getTitleText());
		comboBox.removeAllItems();
		for (Transition trans : currentState.getTransition()){
		comboBox.addItem(trans);
		}
	}
	
	
}

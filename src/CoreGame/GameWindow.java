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

public class GameWindow {
	private State currentState; 
	private JFrame frame;
	private JTextPane textPane;
	private JComboBox<Transition> comboBox;

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
		
		 textPane = new JTextPane();
		frame.getContentPane().add(textPane, BorderLayout.CENTER);
		
		 comboBox = new JComboBox<Transition>();
		frame.getContentPane().add(comboBox, BorderLayout.SOUTH);
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

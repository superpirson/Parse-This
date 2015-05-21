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
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.SpringLayout;

public class GameWindow {
	private State currentState; 
	private JFrame frame;
	private JTextPane textPane;
	ConcurrentHashMap<String,Transition> hashMap = new ConcurrentHashMap<String, Transition>();
	private JComboBox<String> comboBox;
	private JButton btnGo;

	public GameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 687, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  SpringLayout springLayout = new SpringLayout();
		  frame.getContentPane().setLayout(springLayout);
		 
		  textPane = new JTextPane();
		  springLayout.putConstraint(SpringLayout.NORTH, textPane, 12, SpringLayout.NORTH, frame.getContentPane());
		  springLayout.putConstraint(SpringLayout.WEST, textPane, 12, SpringLayout.WEST, frame.getContentPane());
		  frame.getContentPane().add(textPane);
		 
		  comboBox = new JComboBox<String>();
		  comboBox.setEditable(true);
		  springLayout.putConstraint(SpringLayout.SOUTH, textPane, -6, SpringLayout.NORTH, comboBox);
		  springLayout.putConstraint(SpringLayout.WEST, comboBox, 10, SpringLayout.WEST, frame.getContentPane());
		  springLayout.putConstraint(SpringLayout.SOUTH, comboBox, -10, SpringLayout.SOUTH, frame.getContentPane());
		  frame.getContentPane().add(comboBox);
		 
		 btnGo = new JButton("GO!");
		 springLayout.putConstraint(SpringLayout.NORTH, btnGo, 6, SpringLayout.SOUTH, textPane);
		 springLayout.putConstraint(SpringLayout.EAST, textPane, 0, SpringLayout.EAST, btnGo);
		 springLayout.putConstraint(SpringLayout.EAST, comboBox, -6, SpringLayout.WEST, btnGo);
		 springLayout.putConstraint(SpringLayout.EAST, btnGo, -10, SpringLayout.EAST, frame.getContentPane());
		 btnGo.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		Transition trans = hashMap.get(comboBox.getSelectedItem());
		 		if (trans != null) {
		 		transition(trans);
		 		}
		 		else {
		 			textPane.setText(textPane.getText() + "\n		I'm afrade I can't do that.");
		 			
		 		}
		 		}
		 });
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
		hashMap.clear();
		textPane.setText(currentState.getText());
		frame.setTitle(currentState.getTitleText());
		comboBox.removeAllItems();
		for (Transition trans : currentState.getTransition()){
			for (String key : trans.getKeyword()) {
			comboBox.addItem(key);
			hashMap.put(key, trans);
			}
		}
	}
}

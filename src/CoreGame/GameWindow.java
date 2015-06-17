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

import GameData.Actable;
import GameData.Action;
import GameData.LoadedAction;
import GameData.LoadedState;
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
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.python.core.PyException;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import javax.swing.SpringLayout;

public class GameWindow {
	private LoadedState currentState; 
	public JFrame frame;
	private JTextPane textPane;
	ConcurrentHashMap<String,List<Action>> hashMap = new ConcurrentHashMap<String, List<Action>>();
	private JComboBox<String> comboBox;
	private JButton btnGo;
	public PythonInterpreter pyInterpreter = null;
	
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
		 		if (comboBox.getSelectedItem() == null) {
		 			System.err.println("ERR! Combobox has no selected targit!");
		 			return;
		 		}
		 		for (Action action : hashMap.get(comboBox.getSelectedItem())){
		 		if (action != null) {
		 		((Actable)action).run();
		 		}
		 	} 
		 	}});
		 frame.getContentPane().add(btnGo);
		frame.setVisible(true);
	}

	public void goToState(LoadedState state){
		currentState = state;
		this.guiUpdate();
	}

	private void guiUpdate(){
		hashMap.clear();
		comboBox.removeAllItems();
		textPane.setText(currentState.getText());
		frame.setTitle(currentState.getTitleText());
		currentState.run();
	}
	public void addChoice(String text, List<Action> list, Boolean isHidden ) {
		System.err.println("regetering choice " + text);
		hashMap.put(text, list);
		if (!isHidden) {
			this.comboBox.addItem(text);
		}
		
	}
}

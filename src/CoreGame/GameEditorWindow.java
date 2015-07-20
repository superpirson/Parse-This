package CoreGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
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
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class GameEditorWindow extends GameWindow {
	private LoadedState currentState; 
	public JFrame frame;
	private JTextPane textPane;
	ConcurrentHashMap<String,List<Action>> hashMap = new ConcurrentHashMap<String, List<Action>>();
	DefaultListModel<String> listModel = new DefaultListModel<String>();

	private JButton btnGo;
	public PythonInterpreter pyInterpreter = null;
	private JTree dataTree;
	
	public GameEditorWindow() {
		initialize();
		return;
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
		  springLayout.putConstraint(SpringLayout.NORTH, textPane, 10, SpringLayout.NORTH, frame.getContentPane());
		  frame.getContentPane().add(textPane);
		 
		 
		 btnGo = new JButton("GO!");
		 springLayout.putConstraint(SpringLayout.EAST, textPane, 0, SpringLayout.EAST, btnGo);
		 springLayout.putConstraint(SpringLayout.SOUTH, btnGo, -10, SpringLayout.SOUTH, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, btnGo, -10, SpringLayout.EAST, frame.getContentPane());
		 /*
		 btnGo.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
		 		if (list.getSelectedValue() == null) {
		 			System.err.println("ERR! Combobox has no selected targit!");
		 			return;
		 		}
		 		for (Action action : hashMap.get(list.getSelectedValue())){
		 		if (action != null) {
		 		((Actable)action).run();
		 		}
		 	} 
		 	}});
		 /*/
		 frame.getContentPane().add(btnGo);
		 
		 JButton btnAdd = new JButton("Add");
		 springLayout.putConstraint(SpringLayout.SOUTH, textPane, -6, SpringLayout.NORTH, btnAdd);
		 springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 193, SpringLayout.NORTH, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.WEST, btnAdd, 600, SpringLayout.WEST, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, btnAdd, -12, SpringLayout.EAST, frame.getContentPane());
		 frame.getContentPane().add(btnAdd);
		/*
		 btnAdd.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		if (list.getSelectedValue() == null) {
			 			System.err.println("ERR! Combobox has no selected targit!");
			 			return;
			 		} 
			 	
			 	}
			 	});
		/*/ 
		 JButton btnDelete = new JButton("Delete");
		 springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 6, SpringLayout.SOUTH, btnAdd);
		 springLayout.putConstraint(SpringLayout.WEST, btnDelete, 591, SpringLayout.WEST, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, btnDelete, -12, SpringLayout.EAST, frame.getContentPane());
		 frame.getContentPane().add(btnDelete);
		 
		 dataTree = new JTree();
		 dataTree.setModel(new DefaultTreeModel(
		 	new DefaultMutableTreeNode("Game States") {
		 		{
		 			
		 			for (State state : Game.currentGame.mainGameData.getState()){
		 				LoadedState lstate = (LoadedState)state;
		 				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(lstate.getNAME());
		 				newNode.setUserObject(lstate);
		 				
		 				add(newNode);
		 				
		 			}
		 					DefaultMutableTreeNode node_1;
		 				node_1 = new DefaultMutableTreeNode("sports");
		 				node_1.add(new DefaultMutableTreeNode("basketball"));
		 				node_1.add(new DefaultMutableTreeNode("soccer"));
		 				node_1.add(new DefaultMutableTreeNode("football"));
		 				node_1.add(new DefaultMutableTreeNode("hockey"));
		 			add(node_1);
		 			node_1 = new DefaultMutableTreeNode("food");
		 				node_1.add(new DefaultMutableTreeNode("hot dogs"));
		 				node_1.add(new DefaultMutableTreeNode("pizza"));
		 				node_1.add(new DefaultMutableTreeNode("ravioli"));
		 				node_1.add(new DefaultMutableTreeNode("bananas"));
		 			add(node_1);
		 		}
		 	}
		 ));
		 springLayout.putConstraint(SpringLayout.WEST, textPane, 12, SpringLayout.EAST, dataTree);
		 springLayout.putConstraint(SpringLayout.NORTH, dataTree, 10, SpringLayout.NORTH, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.WEST, dataTree, 10, SpringLayout.WEST, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, dataTree, 0, SpringLayout.SOUTH, btnGo);
		 springLayout.putConstraint(SpringLayout.EAST, dataTree, 191, SpringLayout.WEST, frame.getContentPane());
		 frame.getContentPane().add(dataTree);
		 /*
		 btnDelete.addActionListener(new ActionListener() {
		
			 public void actionPerformed(ActionEvent arg0) {
			 		if (list.getSelectedValue() == null) {
			 			System.err.println("ERR! Combobox has no selected targit!");
			 			return;
			 		}
			 		for (Action action : hashMap.get(list.getSelectedValue())){
			 		if (action != null) {
			 		((Actable)action).run();
			 		}
			 	} 
			 	}});
		 /*/
		 
		 frame.setVisible(true);
		
	}

	public void goToState(LoadedState state){
    		currentState = state;
		this.guiUpdate();
	}

	private void guiUpdate(){
		hashMap.clear();
		listModel.clear();
		textPane.setText(currentState.getText());
		frame.setTitle(currentState.getTitleText());
		currentState.run();
	}
	public void addChoice(String text, List<Action> list, Boolean isHidden ) {
		System.err.println("regetering choice " + text);
		hashMap.put(text, list);
		if (!isHidden) {
			listModel.addElement(text);
		}else{
			listModel.addElement(text.concat(" (hidden)"));
		}
		
	}
}

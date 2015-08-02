package CoreGame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JTextPane;

import GameData.Action;
import GameData.GUIEditorObject;
import GameData.State;

import javax.swing.JButton;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.python.util.PythonInterpreter;

import javax.swing.SpringLayout;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

import java.awt.FlowLayout;
import java.awt.CardLayout;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;

public class GameEditorWindow extends GameWindow {
	private State currentState; 
	public JFrame frame;
	private JTextPane textPane;

	private JButton btnGo;
	public PythonInterpreter pyInterpreter = null;
	private JTree dataTree;
	private JPanel editorPannel;
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
		  springLayout.putConstraint(SpringLayout.SOUTH, textPane, -301, SpringLayout.SOUTH, frame.getContentPane());
		  springLayout.putConstraint(SpringLayout.EAST, textPane, -10, SpringLayout.EAST, frame.getContentPane());
		  frame.getContentPane().add(textPane);
		 
		 
		 btnGo = new JButton("GO!");
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
		 springLayout.putConstraint(SpringLayout.WEST, btnAdd, 10, SpringLayout.WEST, frame.getContentPane());
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
		 springLayout.putConstraint(SpringLayout.NORTH, btnDelete, 0, SpringLayout.NORTH, btnGo);
		 springLayout.putConstraint(SpringLayout.WEST, btnDelete, 6, SpringLayout.EAST, btnAdd);
		 springLayout.putConstraint(SpringLayout.EAST, btnDelete, -485, SpringLayout.EAST, frame.getContentPane());
		 frame.getContentPane().add(btnDelete);
		 
		 dataTree = new JTree();
		 dataTree.addTreeSelectionListener(new TreeSelectionListener() {
		 	public void valueChanged(TreeSelectionEvent e) {
		 		DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
		 		if (node.getUserObject() instanceof GUIEditorObject){
		 			GUIEditorObject editable = (GUIEditorObject) node.getUserObject();
		 		editorPannel.removeAll();
		 		editable.addEditorPannel(editorPannel);
		 		editorPannel.validate();
		 		System.err.println("we are editing " + editable.getClass().getName());
		 		}
		 		else{
		 		//	System.err.println("we are looking at a " + node.getUserObject().getClass().getName());
		 		
		 		}
		 	}
		 });
		 JScrollPane treeView = new JScrollPane(dataTree);
		 springLayout.putConstraint(SpringLayout.NORTH, btnAdd, 7, SpringLayout.SOUTH, treeView);
		 springLayout.putConstraint(SpringLayout.EAST, btnAdd, -179, SpringLayout.EAST, treeView);
		 springLayout.putConstraint(SpringLayout.WEST, textPane, 6, SpringLayout.EAST, treeView);
		 springLayout.putConstraint(SpringLayout.NORTH, treeView, 0, SpringLayout.NORTH, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.WEST, treeView, 0, SpringLayout.WEST, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, treeView, 291, SpringLayout.WEST, frame.getContentPane());
		
		 
		 
		 
		 
		 

		 springLayout.putConstraint(SpringLayout.NORTH, dataTree, 10, SpringLayout.NORTH, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.WEST, dataTree, 10, SpringLayout.WEST, frame.getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, dataTree, 0, SpringLayout.SOUTH, btnGo);
		 springLayout.putConstraint(SpringLayout.EAST, dataTree, 191, SpringLayout.WEST, frame.getContentPane());
		 this.refreshTreeView(); // populate the tree
		 frame.getContentPane().add(treeView);
		 
		 JPanel panel = new JPanel();
		 editorPannel = panel;
		 springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, textPane);
		 springLayout.putConstraint(SpringLayout.WEST, panel, 6, SpringLayout.EAST, treeView);
		 springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, treeView);
		 springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, textPane);
		 frame.getContentPane().add(panel);
		 panel.setLayout(new BorderLayout(0, 0));
		 
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
		 //*/
		 
		 frame.setVisible(true);
		
	}
	public void refreshTreeView(){
		 dataTree.setModel(new DefaultTreeModel(
				 	new DefaultMutableTreeNode("Game States") {
				 		{	
				 			for (State state : Game.currentGame.mainGameData.getState()){
				 				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(state);
				 				for (Action action : state.getTransitionOrIfTrueOrPythonScript()){
				 					newNode.add(action.getNode());
				 				}	
				 				add(newNode);
				 			}
				 		}
				 	}
				 ));
	}
	
}

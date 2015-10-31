package coreGame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.python.util.PythonInterpreter;

import gameData.Action;
import gameData.GameObject;
import gameData.State;

import javax.swing.SpringLayout;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.CardLayout;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class GameEditorWindow extends GameWindow {
	private State currentState;
	public JFrame frame;
	private JTextPane textPane;
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
		JScrollPane treeView = new JScrollPane();
		springLayout.putConstraint(SpringLayout.SOUTH, treeView, 0,
				SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, treeView, 0,
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, treeView, 0,
				SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, treeView, 291,
				SpringLayout.WEST, frame.getContentPane());

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 167,
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 297,
				SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0,
				SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10,
				SpringLayout.EAST, frame.getContentPane());
		editorPannel = panel;
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		dataTree = new JTree();
		treeView.setViewportView(dataTree);
		dataTree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
						.getPath().getLastPathComponent();

				saveTextBoxContents();
				
				if (node.getUserObject() instanceof GameObject) {
					GameObject editable = (GameObject) node.getUserObject();
					editorPannel.removeAll();
					editable.addEditorPannel(editorPannel);
					editorPannel.revalidate();
					editorPannel.repaint();
					System.err.println("we are editing "
							+ editable.getClass().getName());
				} else {
					// System.err.println("we are looking at a " +
					// node.getUserObject().getClass().getName());

				}
			}
		});

		this.refreshTreeView(); // populate the tree
		frame.getContentPane().add(treeView);

		dataTree.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger())
					doPop(e);
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger())
					doPop(e);
			}

			private void doPop(MouseEvent e) {
				TreePopupMenu menu = new TreePopupMenu();
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		});

		springLayout.putConstraint(SpringLayout.NORTH, dataTree, 10,
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, dataTree, 10,
				SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, dataTree, 191,
				SpringLayout.WEST, frame.getContentPane());

		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 0,
				SpringLayout.NORTH, treeView);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 6,
				SpringLayout.EAST, treeView);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -20,
				SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 10,
				SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(scrollPane);

		textPane = new JTextPane();
		textPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				saveTextBoxContents();
			}
		});

		scrollPane.setViewportView(textPane);
		springLayout.putConstraint(SpringLayout.NORTH, textPane, -15,
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textPane, 6,
				SpringLayout.EAST, treeView);
		springLayout.putConstraint(SpringLayout.SOUTH, textPane, -25,
				SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, textPane, -10,
				SpringLayout.EAST, frame.getContentPane());

		/*
		 * btnDelete.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent arg0) { if
		 * (list.getSelectedValue() == null) {
		 * System.err.println("ERR! Combobox has no selected targit!"); return;
		 * } for (Action action : hashMap.get(list.getSelectedValue())){ if
		 * (action != null) { ((Actable)action).run(); } } }}); //
		 */

		frame.setVisible(true);

	}

	private void saveTextBoxContents() {
		if (dataTree.getSelectionPath() == null) {
			return;
		}
		State targetState = (State) ((DefaultMutableTreeNode) dataTree
				.getSelectionPath().getPathComponent(1)).getUserObject();

		if (targetState != null) {
			targetState.setText(textPane.getText());
		}

	}

	public void refreshTreeView() {
		dataTree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(
				"Game States") {
			{
				for (State state : Game.currentGame.mainGameData.getState()) {
					DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(
							state);
					for (GameObject object : state.getChildren()) {
						newNode.add(object.getNode());
					}
					add(newNode);
				}
			}
		}));
	}
}

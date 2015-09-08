package gameData;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import coreGame.Game;

public class GameObject {
	public void addEditorPannel(JPanel panel) {
		System.err.println("called unimplemented addEditorPanel methoid!");
		return;
	}

	public MutableTreeNode getNode() {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(this);
		
		return node;
	}
}

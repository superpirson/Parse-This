//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.28 at 02:23:11 PM CDT 
//


package gameObjects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;

import coreGame.Game;
import gameData.ActionData;

import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Action extends GameObject{

	protected  ActionData actionData;
	private JTextField textField;
    
	public ActionData getActionData(){
		return actionData;	
	}
	
	public Action(ActionData data){
	this.actionData = data;
	}
	//Default consturctor. 
	public Action(){
	}
	
    public void run() {
    if(actionData.getRef() != null) {
    	System.err.println("ERROR! action " + actionData.getNAME() + " used unimplemente ref feature");
    }else {
    	System.err.println("ERROR! action " + actionData.getNAME()+ " exicuted unimplemented run method");
    }
    }

    
    
	/**
	 * @wbp.parser.entryPoint
	 */
	public void addEditorPannel(JPanel panel) {
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		Vector<String> keySet = new Vector<String>();
		for (String s : Game.currentGame.actions.keySet()){
		keySet.add(s);
		}
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel lblActionRef = new JLabel("NAME:");
		lblActionRef.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(lblActionRef);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				rename(textField.getText());
			}
		});
		panel_2.add(textField);
		//textField.setColumns(10);
	}
	public void rename(String newName){
		Game.currentGame.renameAction(actionData.getNAME(), newName);
		actionData.setNAME(newName);
	}
}
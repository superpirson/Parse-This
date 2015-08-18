//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.28 at 02:23:11 PM CDT 
//


package gameObjects;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import gameData.ActionData;
import gameData.PythonScriptData;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JEditorPane;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class PythonScript
    extends Action
{
    
	
	public PythonScriptData getActionData(){
		return (PythonScriptData) actionData;	
	}
	
	public PythonScript(PythonScriptData data){
	this.actionData = data;
	data.setLinkedGameObject(this);
	}
    @Override
	public String toString() {
    	if(this.getActionData().getNAME() == null){
    		return "Script: " + this.getActionData().getPy();
    	}
		return "Script: " + this.getActionData().getNAME();
	}
    public DefaultMutableTreeNode getNode(){
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(this);
	return node;
	}

    public void run() {
    	coreGame.Game.currentGame.pythonController.exec(this.getActionData().getPy());
    }
    /**
     * @wbp.parser.entryPoint
     */
    @Override
    public void addEditorPannel(JPanel panel) {
		JLabel lblNewLabel = new JLabel("Python Script:");
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.addInputMethodListener(new InputMethodListener() {
			public void inputMethodTextChanged(InputMethodEvent event) {
			
			}

			@Override
			public void caretPositionChanged(InputMethodEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(editorPane, BorderLayout.CENTER);
		super.addEditorPannel(panel);
	}
    
}

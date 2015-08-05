//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.28 at 02:23:11 PM CDT 
//


package GameData;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;
import CoreGame.Game;

public class Choice
    extends Action
{

    @Override
	public ChoiceData getActionData(){
		return (ChoiceData) actionData;	
	}
	
    @Override
	public String toString() {
    	if(this.getActionData().getNAME() == null){
    		return "Choice: " + this.getActionData().getKeyword().get(0);
    	}
		return "Choice: " + this.getActionData().getNAME();
	}

    public DefaultMutableTreeNode getNode(){
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(this);
		for (Action action : this.getActionData().getTransitionOrPythonScriptOrChoice()){
			node.add(action.getNode());
		}
	return node;
	}

    
    
    public void run() {
        if(this.getRef() != null) {
        	( this.getRef()).run();	
        }
    	
    	for(String s :this.getActionData().getKeyword() ) {
    	Game.currentGame.gameWindow.addChoice(s,this.getActionData().getTransitionOrPythonScriptOrChoice(), this.getActionData().isHidden() );
        
    	}
        }
    @Override
    public void addEditorPannel(JPanel panel) {
		JTextPane txtpnLolWoot = new JTextPane();
		txtpnLolWoot.setText("LOL! WOOT!!!");
		panel.add(txtpnLolWoot);
		super.addEditorPannel(panel);
	}


}

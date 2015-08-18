
package gameObjects;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;

import coreGame.Game;
import gameData.ActionData;
import gameData.IfTrueData;

public class IfTrue extends Action{
	
	   @Override
		public IfTrueData getActionData(){
			return (IfTrueData) actionData;	
			
		}
	   
	   public IfTrue(IfTrueData data){
			this.actionData = data;
			data.setLinkedGameObject(this);
	   }
	   
	@Override
	public String toString() {
    	if(this.getActionData().getNAME() == null){
    		return "IF: " + this.getActionData().getPy();
    	}
		return "IF: " + this.getActionData().getNAME();
	}
   
    public DefaultMutableTreeNode getNode(){
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(this);
		for (ActionData actionData : this.getActionData().getTransitionOrPythonScriptOrChoice()){
			node.add(actionData.getLinkedGameObject().getNode());
		}
	return node;
	}
    
	public void run() {
		if( Game.currentGame.pythonController.eval(this.getActionData().getPy()).__nonzero__()){
		for (ActionData actionData : this.getActionData().getTransitionOrPythonScriptOrChoice()) {
			actionData.getLinkedGameObject().run();
	}
		}}
	   @Override
	public void addEditorPannel(JPanel panel) {
		JTextPane txtpnLolWoot = new JTextPane();
		txtpnLolWoot.setText("LOL! WOOT!!!");
		panel.add(txtpnLolWoot);
		super.addEditorPannel(panel);
	}
}

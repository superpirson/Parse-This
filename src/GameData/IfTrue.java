
package GameData;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;

import CoreGame.Game;

public class IfTrue extends Action{
	
	   @Override
		public IfTrueData getActionData(){
			return (IfTrueData) actionData;	
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
		for (Action action : this.getActionData().getTransitionOrPythonScriptOrChoice()){
			node.add(action.getNode());
		}
	return node;
	}
    
	public void run() {
		if( Game.currentGame.pythonController.eval(this.getActionData().getPy()).__nonzero__()){
		for (Action act : this.getActionData().getTransitionOrPythonScriptOrChoice()) {
			act.run();
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

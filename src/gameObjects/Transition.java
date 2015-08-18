
package gameObjects;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import coreGame.Game;
import gameData.TransitionData;

public class Transition
    extends Action
{
    
	  @Override
			public TransitionData getActionData(){
				return (TransitionData) actionData;	
			}
	 
	  Transition(TransitionData data){
		  this.actionData = data;
		  data.setLinkedGameObject(this);
	  }
	  
	@Override
	public String toString() {
    	if(this.getActionData().getNAME() == null){
    		return "Transition to: " + this.getActionData().getState().toString();
    	}
		return "Transition: " + this.getActionData().getNAME();
	}
    public DefaultMutableTreeNode getNode(){
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(this);
	return node;
	}
    
    public void run() {
        
        Game.currentGame.gameWindow.goToState( this.getActionData().getState().getLinkedGameObject());
    }
    @Override
    public void addEditorPannel(JPanel panel) {
		JTextPane txtpnLolWoot = new JTextPane();
		txtpnLolWoot.setText("LOL! WOOT!!!");
		panel.add(txtpnLolWoot);
		super.addEditorPannel(panel);
	}
}

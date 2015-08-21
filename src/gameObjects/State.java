
package gameObjects;

import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import coreGame.Game;
import gameData.ActionData;
import gameData.IfTrueData;
import gameData.StateData;

public class State extends GameObject {
	protected StateData stateData;
	private JTextField textField;
	
	
	 public State(StateData data){
			this.stateData = data;
			data.setLinkedGameObject(this);
	   
	 }
		public StateData getStateData(){
			return (StateData) stateData;	
			
		}
		
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
			textField.setColumns(20);
			textField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					rename(textField.getText());
				}
			});
			panel_2.add(textField);
			//textField.setColumns(10);
		}
		
	protected void rename(String text) {
			// TODO Auto-generated method stub
			
		}
	@Override
		public String toString() {
	    	if(this.stateData.getNAME() == null && this.stateData.getTitleText()!= null){
	    		return this.stateData.getTitleText();
	    	}
			return  this.stateData.getNAME();
	 }

	public void runActions() {
		for (ActionData actionData :  this.getStateData().getTransitionOrIfTrueOrPythonScript()) {
			actionData.getLinkedGameObject().run();	
		}
	}
    
}

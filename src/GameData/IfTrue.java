
package GameData;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;

import CoreGame.Game;

public class IfTrue extends Action{
	
    @Override
	public String toString() {
    	if(this.getNAME() == null){
    		return "IF: " + this.getPy();
    	}
		return "IF: " + this.getNAME();
	}
   
    public DefaultMutableTreeNode getNode(){
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(this);
		for (Action action : this.getTransitionOrPythonScriptOrChoice()){
			node.add(action.getNode());
		}
	return node;
	}
    
    @XmlElements({
        @XmlElement(name = "transition", type = Transition.class),
        @XmlElement(name = "pythonScript", type = PythonScript.class),
        @XmlElement(name = "choice", type = Choice.class),
        @XmlElement(name = "ifTrue", type = IfTrue.class),
        @XmlElement(name = "action", type = Action.class)
    })
    protected List<Action> transitionOrPythonScriptOrChoice;
    @XmlAttribute(name = "py")
    protected String py;

    /**
     * Gets the value of the transitionOrPythonScriptOrChoice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transitionOrPythonScriptOrChoice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransitionOrPythonScriptOrChoice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transition }
     * {@link PythonScript }
     * {@link Choice }
     * {@link IfTrue }
     * {@link Action }
     * 
     * 
     */
    public List<Action> getTransitionOrPythonScriptOrChoice() {
        if (transitionOrPythonScriptOrChoice == null) {
            transitionOrPythonScriptOrChoice = new ArrayList<Action>();
        }
        return this.transitionOrPythonScriptOrChoice;
    }

    /**
     * Gets the value of the py property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPy() {
        return py;
    }

    /**
     * Sets the value of the py property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPy(String value) {
        this.py = value;
    }
	public void run() {
		if( Game.currentGame.pythonController.eval(this.getPy()).__nonzero__()){
		for (Action act : this.transitionOrPythonScriptOrChoice) {
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

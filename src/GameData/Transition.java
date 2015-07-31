//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.28 at 02:23:11 PM CDT 
//


package GameData;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import CoreGame.Game;


/**
 * <p>Java class for Transition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transition">
 *   &lt;complexContent>
 *     &lt;extension base="{}Action">
 *       &lt;sequence>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transition", propOrder = {
    "state"
})
public class Transition
    extends Action
{
    @Override
	public String toString() {
    	if(this.getNAME() == null){
    		return "Transition to: " + this.getState().toString();
    	}
		return "Transition: " + this.getNAME();
	}
    public DefaultMutableTreeNode getNode(){
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(this);
	return node;
	}
    
    @XmlElement(required = true, type = Object.class)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected State state;

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public State getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setState(State value) {
        this.state = value;
    }
   
    public void run() {
        
        Game.currentGame.gameWindow.goToState( this.getState());
    }
    @Override
    public void addEditorPannel(JPanel panel) {
		JTextPane txtpnLolWoot = new JTextPane();
		txtpnLolWoot.setText("LOL! WOOT!!!");
		panel.add(txtpnLolWoot);
		super.addEditorPannel(panel);
	}
}

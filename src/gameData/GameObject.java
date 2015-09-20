package gameData;

import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import coreGame.Game;

public class GameObject {


	  @XmlTransient private JTextField textField;
  
	
	public MutableTreeNode getNode() {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(this);
		
		return node;
	}
	
public void addEditorPannel(final JPanel panel) {
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		Vector<String> keySet = new Vector<String>();
		for (String s : Game.currentGame.gameObjects.keySet()){
		keySet.add(s);
		}
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel lblGameObjectRef = new JLabel("NAME:");
		lblGameObjectRef.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(lblGameObjectRef);
		
		textField = new JTextField();
		textField.setColumns(20);
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText() == null || textField.getText().isEmpty()){
					return;
			}
				if (!rename(textField.getText())) {
					JOptionPane.showMessageDialog(panel, "Name allready taken.");
					textField.setText(getNAME());
				}
			}
		});
		panel_2.add(textField);
		//textField.setColumns(10);
	}
	public boolean rename(String newName){
		if (!Game.currentGame.renameGameObject(this.getNAME(), newName)){
			System.err.println("ERROR: tried to rename " + this.getNAME() + " TO: " + newName + " and found it taken!");
			return false;
		}
		this.setNAME(newName);
		return true;
	}


	
    @XmlElements({
        @XmlElement(name = "transition", type = Transition.class),
        @XmlElement(name = "pythonScript", type = PythonScript.class),
        @XmlElement(name = "choice", type = Choice.class),
        @XmlElement(name = "ifTrue", type = IfTrue.class),
        @XmlElement(name = "action")
    })
    protected List<GameObject> children;
    @XmlAttribute(name = "NAME")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String name;    

    /**
     * Gets the value of the children property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the children property.
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
     * {@link GameObject }
     * 
     * 
     */
    public List<GameObject> getChildren() {
        if (children == null) {
            children = new ArrayList<GameObject>();
        }
        return this.children;
    }
    

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME(String value) {
        this.name = value;
}
}
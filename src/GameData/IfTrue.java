//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.28 at 02:23:11 PM CDT 
//


package GameData;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IfTrue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfTrue">
 *   &lt;complexContent>
 *     &lt;extension base="{}Action">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="transition" type="{}Transition"/>
 *           &lt;element name="pythonScript" type="{}PythonScript"/>
 *           &lt;element name="choice" type="{}Choice"/>
 *           &lt;element name="ifTrue" type="{}IfTrue"/>
 *           &lt;element name="action" type="{}Action"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="py" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfTrue", propOrder = {
    "transitionOrPythonScriptOrChoice"
})
public class IfTrue
    extends LoadedAction
{

    @XmlElements({
        @XmlElement(name = "transition", type = LoadedTransition.class),
        @XmlElement(name = "pythonScript", type = LoadedPythonScript.class),
        @XmlElement(name = "choice", type = LoadedChoice.class),
        @XmlElement(name = "ifTrue", type = LoadedIfTrue.class),
        @XmlElement(name = "action", type = LoadedAction.class)
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

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.02 at 02:07:03 PM CDT 
//


package GameData;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChoiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChoiceData">
 *   &lt;complexContent>
 *     &lt;extension base="{}ActionData">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="transition" type="{}TransitionData"/>
 *           &lt;element name="pythonScript" type="{}PythonScriptData"/>
 *           &lt;element name="choice" type="{}ChoiceData"/>
 *           &lt;element name="ifTrue" type="{}IfTrueData"/>
 *           &lt;element name="action" type="{}ActionData"/>
 *         &lt;/choice>
 *         &lt;element name="hidden" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChoiceData", propOrder = {
    "transitionOrPythonScriptOrChoice",
    "hidden",
    "keyword"
})
public class ChoiceData
    extends ActionData
{

    @XmlElements({
        @XmlElement(name = "transition", type = TransitionData.class),
        @XmlElement(name = "pythonScript", type = PythonScriptData.class),
        @XmlElement(name = "choice", type = ChoiceData.class),
        @XmlElement(name = "ifTrue", type = IfTrueData.class),
        @XmlElement(name = "action")
    })
    protected List<ActionData> transitionOrPythonScriptOrChoice;
    protected boolean hidden;
    @XmlElement(required = true)
    protected List<String> keyword;

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
     * {@link TransitionData }
     * {@link PythonScriptData }
     * {@link ChoiceData }
     * {@link IfTrueData }
     * {@link ActionData }
     * 
     * 
     */
    public List<ActionData> getTransitionOrPythonScriptOrChoice() {
        if (transitionOrPythonScriptOrChoice == null) {
            transitionOrPythonScriptOrChoice = new ArrayList<ActionData>();
        }
        return this.transitionOrPythonScriptOrChoice;
    }

    /**
     * Gets the value of the hidden property.
     * 
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Sets the value of the hidden property.
     * 
     */
    public void setHidden(boolean value) {
        this.hidden = value;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getKeyword() {
        if (keyword == null) {
            keyword = new ArrayList<String>();
        }
        return this.keyword;
    }

}

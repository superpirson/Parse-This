//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.25 at 02:30:40 PM EDT 
//


package gameData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PythonScriptData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PythonScriptData">
 *   &lt;complexContent>
 *     &lt;extension base="{}ActionData">
 *       &lt;attribute name="py" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PythonScriptData")
public class PythonScriptData
    extends ActionData
{

    @XmlAttribute(name = "py")
    protected String py;

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

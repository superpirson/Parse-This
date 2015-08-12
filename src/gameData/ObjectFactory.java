//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.11 at 11:03:44 PM EDT 
//


package GameData;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the GameData package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MainGameData_QNAME = new QName("", "mainGameData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: GameData
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MainGameData }
     * 
     */
    public MainGameData createMainGameData() {
        return new MainGameData();
    }

    /**
     * Create an instance of {@link IfTrueData }
     * 
     */
    public IfTrueData createIfTrueData() {
        return new IfTrueData();
    }

    /**
     * Create an instance of {@link ActionData }
     * 
     */
    public ActionData createActionData() {
        return new ActionData();
    }

    /**
     * Create an instance of {@link StateData }
     * 
     */
    public StateData createStateData() {
        return new StateData();
    }

    /**
     * Create an instance of {@link PythonScriptData }
     * 
     */
    public PythonScriptData createPythonScriptData() {
        return new PythonScriptData();
    }

    /**
     * Create an instance of {@link TransitionData }
     * 
     */
    public TransitionData createTransitionData() {
        return new TransitionData();
    }

    /**
     * Create an instance of {@link ChoiceData }
     * 
     */
    public ChoiceData createChoiceData() {
        return new ChoiceData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MainGameData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mainGameData")
    public JAXBElement<MainGameData> createMainGameData(MainGameData value) {
        return new JAXBElement<MainGameData>(_MainGameData_QNAME, MainGameData.class, null, value);
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.17 at 06:49:22 PM CDT 
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
     * Create an instance of {@link GameData }
     * 
     */
    public GameData createGameData() {
        return new GameData();
    }

    /**
     * Create an instance of {@link State }
     * 
     */
    public State createState() {
        return new State();
    }

    /**
     * Create an instance of {@link Transition }
     * 
     */
    public Transition createTransition() {
        return new Transition();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GameData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mainGameData")
    public JAXBElement<GameData> createMainGameData(GameData value) {
        return new JAXBElement<GameData>(_MainGameData_QNAME, GameData.class, null, value);
    }

}

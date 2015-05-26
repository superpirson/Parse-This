
package GameData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


public class LoadedAction extends Action implements Actable {
    
    public void init() {
	if(this.getRef() != null) {
	((LoadedAction) this.getRef()).init();	
	}else {
    	System.err.println("ERROR! action " + this.name + "has no refrence and is base action with no init function");
    }
	}
    public void run() {
    if(this.getRef() != null) {
    	((LoadedAction) this.getRef()).run();	
    }else {
    	System.err.println("ERROR! action " + this.name + " exicuted inimplemented run method");
    }
    }
    

}

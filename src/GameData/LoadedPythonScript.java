

package GameData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

public class LoadedPythonScript extends PythonScript implements Actable{
    public void run() {
    if(this.getRef() != null) {
    	((LoadedAction) this.getRef()).run();	
    }else {
    	System.err.println("ERROR! action " + this.name + " exicuted unimplemented run method");
    }
    }
    
}

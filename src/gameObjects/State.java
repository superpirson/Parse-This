
package gameObjects;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import gameData.StateData;

public class State extends GUIEditorObject {
	protected StateData stateData;
	
	
	@Override
		public String toString() {
	    	if(this.stateData.getNAME() == null && this.stateData.getTitleText()!= null){
	    		return this.stateData.getTitleText();
	    	}
			return  this.stateData.getNAME();
	 }

	public void runActions() {
		for (Action thing : this.getTransitionOrIfTrueOrPythonScript()) {
			Action act = thing;
			act.run();
			
		}
	}
    
}

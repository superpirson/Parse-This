

package GameData;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import CoreGame.Game;

public class LoadedTransition extends Transition implements Actable{
    public void init() { 	
    	if(this.getRef() != null) {
    	((LoadedAction) this.getRef()).init();	
    }
	}
    public void run() {
        if(this.getRef() != null) {
        	((LoadedAction) this.getRef()).run();	
        }
        
        
        Game.currentGame.gameWindow.goToState((LoadedState) this.getState());
    }
    
}

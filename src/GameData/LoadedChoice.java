

package GameData;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import CoreGame.Game;

public class LoadedChoice extends Choice implements Actable{
    public void init() {
	if(this.getRef() != null) {
	((LoadedAction) this.getRef()).init();	
	}
	
	
	//first set up our child actables
    for (Action act: this.transitionOrScriptOrChoice) {
    ((LoadedAction)act).init();
    }
	
	for(String s :this.getKeyword() ) {
	Game.currentGame.gameWindow.addChoice(s,this, this.isHidden() );
    
	
	}
	}
    public void run() {
    if(this.getRef() != null) {
    	((LoadedAction) this.getRef()).run();	
    }
    for (Action act: this.transitionOrScriptOrChoice) {
    ((LoadedAction)act).run();
    }
    }
    

}

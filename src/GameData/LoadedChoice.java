

package GameData;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import CoreGame.Game;

public class LoadedChoice extends Choice implements Actable{
    public void run() {
    if(this.getRef() != null) {
    	((LoadedAction) this.getRef()).run();	
    }
	
	for(String s :this.getKeyword() ) {
	Game.currentGame.gameWindow.addChoice(s,this.getTransitionOrScriptOrChoice(), this.isHidden() );
    
	
	}
    for (Action act: this.transitionOrScriptOrChoice) {
    ((LoadedAction)act).run();
    }
    }
    

}

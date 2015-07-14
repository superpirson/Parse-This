package GameData;

import org.python.util.jython;

import CoreGame.Game;

public class LoadedIfTrue extends IfTrue implements Actable {
	
	
	boolean initalResult = false; // used to assure consistancy across the init and run funcitons

	public void run() {
		if (this.getRef() != null) {
			((LoadedAction) this.getRef()).run();
		}
		if( Game.currentGame.pythonController.eval(this.getPy()).__nonzero__()){
		for (Action act : this.transitionOrPythonScriptOrChoice) {
			((LoadedAction) act).run();
	}
		}}

}

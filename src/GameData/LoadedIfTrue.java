package GameData;

import org.python.util.jython;

import CoreGame.Game;

public class LoadedIfTrue extends IfTrue implements Actable {
	
	
	boolean initalResult = false; // used to assure consistancy across the init and run funcitons
	
	
	public void init() {
		if (this.getRef() != null) {
			((LoadedAction) this.getRef()).init();
		}
		initalResult=Game.currentGame.pyInterpreter.eval(this.getPy()).__nonzero__();
		if (initalResult) {
			// first set up our child actables
			for (Action act : this.transitionOrScriptOrChoice) {
				((LoadedAction) act).init();
			}
		}
	}

	public void run() {
		if (this.getRef() != null) {
			((LoadedAction) this.getRef()).run();
		}
		if (initalResult != Game.currentGame.pyInterpreter.eval(this.getPy()).__nonzero__()) {
			System.err.println("ERROR, LOADEDCHOICE " + this.toString() + " found that it's condition \"" + this.getPy() + "\" changed between init and run calls. Going with the init value");
		}
		if (initalResult) {
		for (Action act : this.transitionOrScriptOrChoice) {
			((LoadedAction) act).run();
		}
	}
		}

}

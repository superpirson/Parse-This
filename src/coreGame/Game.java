package coreGame;

import static java.lang.System.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.TreeMap;

import org.python.core.PyException;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import gameData.*;
import gameObjects.Action;
import gameObjects.State;

import javax.swing.JFileChooser;
import javax.xml.bind.*;


public class Game {
	public TreeMap<String, Action> actions =  new TreeMap<String, Action>();
	public GameWindow gameWindow;
	public static Game currentGame;
	 public PythonController pythonController = new PythonController();
	 MainGameData mainGameData = null;
	final JFileChooser fileChooser = new JFileChooser() {
		  @Override
		  public void rescanCurrentDirectory() {
		    // do nothing
		  }
		};
	 
	 /**
	 * @param args
	 */
	public static void main(String[] args) {
		currentGame = new Game();
		currentGame.loadGame();
		out.println("XML loaded, constructing game window");
		if (args.length != 0 && args[0].compareToIgnoreCase("-edit") == 0 ){
			currentGame.gameWindow = new GameEditorWindow();	
			}else{
			currentGame.gameWindow = new GameWindow();
			}
			out.println("Game window constructed. ");
			currentGame.gameWindow.goToState(currentGame.mainGameData.getStartingState().getLinkedGameObject());
			
	}
	public void loadGame( ) {
	
		File selectedFile = null;
	
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		
		    selectedFile = fileChooser.getSelectedFile();
		     
		}
	
     JAXBContext jc;
	try {
		jc = JAXBContext.newInstance( "gameData" );
    	       Unmarshaller u = jc.createUnmarshaller();
    	       JAXBElement<?> element = (JAXBElement<?>) u.unmarshal (selectedFile);
    	       mainGameData = (MainGameData) (JAXBIntrospector.getValue(element));
    	       out.println("Main Game Data loaded: \n" + mainGameData);
	} catch (JAXBException e) {
		e.printStackTrace();
		
	}
	

	for (String s : mainGameData.getPy()){
		if (s != null) {
			
		this.pythonController.exec(s);
		}
		}
	}
	public  List<StateData> getAllStates(){
		return this.mainGameData.getState();
	}
	public boolean regesterAction(String name, Action action) {
		if (!actions.containsKey(name)){
		actions.put(name, action);
		return true;
		}
		System.out.println("tried to add action named " + name + " but found it was allready taken in the names list");
		return false;
		
	}
	public boolean unregesterAction(String name){
		if (! this.actions.containsKey(name)){
			return false;
		}
		this.actions.remove(name);
		return true;
	}
	public boolean renameAction(String oldName, String newName){
		Action action = this.actions.get(oldName);
		this.unregesterAction(oldName);
		if (this.regesterAction(newName, action)){
			return true;
		}
		this.regesterAction(oldName, action);
		return false;
	}
}

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
import javax.swing.JFileChooser;
import javax.xml.bind.*;


public class Game {
	public TreeMap<String, GameObject> gameObjects =  new TreeMap<String, GameObject>();
	public GameWindow gameWindow;
	public static Game currentGame;
	 public PythonController pythonController = new PythonController();
	 MainGame mainGameData = null;
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
			currentGame.gameWindow.goToState(currentGame.mainGameData.getStartingState());
			
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
    	       mainGameData = (MainGame) u.unmarshal (selectedFile);
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
	public  List<State> getAllStates(){
		return this.mainGameData.getState();
	}
	public boolean regesterGameObject(String name, GameObject gameObject) {
		if (!gameObjects.containsKey(name)){
		gameObjects.put(name, gameObject);
		return true;
		}
		System.out.println("tried to add action named " + name + " but found it was allready taken in the names list");
		return false;
		
	}
	public boolean unregesterGameObject(String name){
		if (! this.gameObjects.containsKey(name)){
			return false;
		}
		this.gameObjects.remove(name);
		return true;
	}
	public boolean renameGameObject(String oldName, String newName){
		GameObject gameObject = this.gameObjects.get(oldName);
		this.unregesterGameObject(oldName);
		if (this.regesterGameObject(newName, gameObject)){
			return true;
		}
		this.regesterGameObject(oldName, gameObject);
		return false;
	}
}

package CoreGame;

import static java.lang.System.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.python.core.PyException;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import javax.swing.JFileChooser;
import javax.xml.bind.*;

import GameData.*;


public class Game {
	public GameWindow gameWindow;
	public static Game currentGame;
	 // Create an instance of the PythonInterpreter
	public PythonInterpreter pyInterpreter = new PythonInterpreter();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		currentGame = new Game();
		currentGame.loadGame();	
	}
	public void loadGame() {
		gameWindow = new GameWindow(pyInterpreter);
		out.println("Game window constructed. Setting up XML");
		File selectedFile = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    selectedFile = fileChooser.getSelectedFile();
		     
		}
	 MainGameData mainGameData = null;
     JAXBContext jc;
	try {
		jc = JAXBContext.newInstance( "GameData" );
    	       Unmarshaller u = jc.createUnmarshaller();
    	       JAXBElement element = (JAXBElement) u.unmarshal (selectedFile);
    	       mainGameData = (MainGameData) (JAXBIntrospector.getValue(element));
    	       out.println("Main Game Data loaded: \n" + mainGameData);
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	

	for (String s : mainGameData.getPython()){
		if (s != null) {
		pyInterpreter.eval(s);
		}
		}
	
	gameWindow.goToState((LoadedState) mainGameData.getStartingState());
	}
	
}

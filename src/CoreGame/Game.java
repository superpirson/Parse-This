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
	
	 // Create an instance of the PythonInterpreter
	public PythonInterpreter pyInterpreter = new PythonInterpreter();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.loadGame();	
	}
	public void loadGame() {
		GameWindow gameWindow = new GameWindow(pyInterpreter);
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
    	       mainGameData = (MainGameData)JAXBIntrospector.getValue(u.unmarshal(selectedFile));
    	       out.println("Main Game Data loaded: \n" + mainGameData);
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	

	for (String s : mainGameData.getPy()){
		pyInterpreter.eval(s);
	}
	
	gameWindow.goToState(mainGameData.getStartingState());
	}
	
}

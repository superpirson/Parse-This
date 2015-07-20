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
			currentGame.gameWindow.goToState((LoadedState)currentGame.mainGameData.getStartingState());
			
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
		jc = JAXBContext.newInstance( "GameData" );
    	       Unmarshaller u = jc.createUnmarshaller();
    	       JAXBElement element = (JAXBElement) u.unmarshal (selectedFile);
    	       mainGameData = (MainGameData) (JAXBIntrospector.getValue(element));
    	       out.println("Main Game Data loaded: \n" + mainGameData);
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	

	for (String s : mainGameData.getPy()){
		if (s != null) {
			
		this.pythonController.exec(s);
		}
		}
	}
	
}

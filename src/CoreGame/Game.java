package CoreGame;

import static java.lang.System.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.xml.bind.*;

import GameData.GameData;


public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GameWindow gameWindow = new GameWindow();
		out.println("Game window constructed. Setting up XML");
		File selectedFile = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    selectedFile = fileChooser.getSelectedFile();
		       out.println("we selected:  " + selectedFile);
		}
	 GameData mainGameData = null;
     JAXBContext jc;
	try {
		jc = JAXBContext.newInstance( "GameData" );
    	       Unmarshaller u = jc.createUnmarshaller();
    	       mainGameData = (GameData)JAXBIntrospector.getValue(u.unmarshal(selectedFile));
    	       out.println(mainGameData);
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

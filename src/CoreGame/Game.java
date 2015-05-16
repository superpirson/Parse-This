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
		    
		}
		  InputStream mainFile;
		  GameData mainGameData = null;
		    try {
		    	mainFile = new FileInputStream(selectedFile);
		    	
		    	mainFile.close(); 
		    } catch (FileNotFoundException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	}
	
	public <T> T unmarshal( Class<T> docClass, InputStream inputStream )
		    throws JAXBException {
		    String packageName = docClass.getPackage().getName();
		    JAXBContext jc = JAXBContext.newInstance( packageName );
		    Unmarshaller u = jc.createUnmarshaller();
		    JAXBElement<T> doc = (JAXBElement<T>)u.unmarshal( inputStream );
		    return doc.getValue();
		}
}

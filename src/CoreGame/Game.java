package CoreGame;

import static java.lang.System.out;

import java.io.InputStream;

import javax.xml.bind.*;


public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GameWindow gameWindow = new GameWindow();
		out.println("Game window constructed. Setting up XML");
		
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

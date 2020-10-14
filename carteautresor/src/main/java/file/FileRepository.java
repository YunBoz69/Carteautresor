package file;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileRepository {
	
	 protected Stream<String> filePathToStream(String filePath){
	    	Stream<String> stream = null;
	    	
	    	try {
				stream = Files.lines(Paths.get(filePath));
				return stream;
			} catch (IOException e) {
				//On continue pour verifier si le fichier est dans les resources
			}
	    	try {
				return Files.lines(Paths.get(ClassLoader.getSystemResource(filePath).toURI()));
			} catch (IOException | URISyntaxException e) {
				System.err.println("Erreur lors de la recuperation du fichier "+filePath + " : " +e.getMessage());
			}
	    	return null;
	    }
}

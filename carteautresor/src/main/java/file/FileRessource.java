package file;

import facade.Ressource;

public class FileRessource extends Ressource {
	private String fileName;

	
	public FileRessource(String fileName) {
		this.fileName = fileName;
	}

	
	
	public String getFileName() {
		return fileName;
	}

	
}

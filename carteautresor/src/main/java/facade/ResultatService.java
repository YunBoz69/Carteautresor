package facade;

import model.Partie;

public interface ResultatService {
	
	/**
	 * enregistre les resultats d'une partie
	 * @param carte
	 */
	public void saveResultat(Partie carte);
}

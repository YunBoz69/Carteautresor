package facade;

import model.Carte;
import exception.InitialisationException;

public interface CarteRepository {
	/**
	 * Initialise une carte apartir d'une ressource
	 * @param ressource
	 * @return
	 */
	public Carte get(Ressource ressource) throws InitialisationException;
}

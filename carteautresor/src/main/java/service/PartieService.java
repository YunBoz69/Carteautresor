package service;

import model.Aventurier;
import model.Carte;
import model.Partie;
import exception.InitialisationException;
import facade.CarteRepository;
import facade.Ressource;
import facade.ResultatService;

import java.util.HashMap;

public class PartieService {
	CarteRepository carteRepository;
	ResultatService resultatService;
	
	public PartieService(CarteRepository carteRepository,
                         ResultatService resultatService) {
		this.carteRepository = carteRepository;
		this.resultatService = resultatService;
	}
	
	public Partie creerPartie(Ressource ressourceCarte) throws InitialisationException {
		Carte carte = carteRepository.get(ressourceCarte);
		HashMap<String, Aventurier> aventuriers = carte.getAventurier();

		return new Partie(aventuriers, carte);
	}
	
	public void resultatPartie(Partie partie){
		resultatService.saveResultat(partie);
	}
}

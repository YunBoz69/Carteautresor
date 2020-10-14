package main;
import file.FileCarteRepository;
import file.FileRessource;
import file.FileResultatService;
import model.Partie;
import exception.InitialisationException;
import facade.CarteRepository;
import facade.Ressource;
import facade.ResultatService;
import service.PartieService;

import java.util.Scanner;

public class CarteTresors {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir le fichier d'entrée: ");
		String carteFileName = sc.nextLine();
		sc.close();

		Ressource fileRessourceCarte = new FileRessource(carteFileName);
		CarteRepository carteRepository = new FileCarteRepository();
		ResultatService resultatService = new FileResultatService();

		PartieService partieService = new PartieService(carteRepository, resultatService);
		try {
			Partie partie = partieService.creerPartie(fileRessourceCarte);
			partie.run();
			partieService.resultatPartie(partie);

		} catch (InitialisationException e) {
			System.err.println("Erreur d'initialisation");
		}

	}

}

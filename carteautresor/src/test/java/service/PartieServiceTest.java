package service;

import file.TestCarteRepository;
import file.TestRessource;
import file.TestResultatService;
import model.Montagne;
import model.Partie;
import model.Position;
import model.Tresor;
import exception.InitialisationException;
import exception.OutOfLimitsException;
import org.junit.Test;
import test.AbstractTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class PartieServiceTest extends AbstractTest {

    @Test
    public void createPartieTest() throws InitialisationException, OutOfLimitsException {

        TestRessource ressourceCarte = new TestRessource();

        TestCarteRepository carteRepository = new TestCarteRepository();
        TestResultatService resultatService = new TestResultatService();

        PartieService partieService = new PartieService(carteRepository,resultatService);

        Partie partie = partieService.creerPartie(ressourceCarte);

        assertNotNull(partie.getAventuriers().get("Yunus"));
        assertNotNull(partie.getAventuriers().get("CarbonIT"));

        assertTrue(partie.getCarte().getCase(new Position(5,3)) instanceof Montagne);
        assertTrue(partie.getCarte().getCase(new Position(4,2)) instanceof Tresor);
        assertTrue(partie.getCarte().getCase(new Position(1,4)) instanceof Tresor);
    }

}

package model;


import exception.OutOfLimitsException;
import org.junit.Test;
import test.AbstractTest;
import util.Util;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartieTest extends AbstractTest {

	@Test
	public void runTest() throws OutOfLimitsException {
		Aventurier aventurier = getAventurier();
		Carte carte = getCarteSimple();
		List<Aventurier> aventuriers = new ArrayList<Aventurier>();
		aventuriers.add(aventurier);
				
		Partie partie = new Partie(Util.listAventurierToMapAventurier(aventuriers), carte);
		
		partie.run();
		
		Tresor tresor = ((Tresor) partie.getCarte().getCase(new Position(4, 2)));
		Aventurier Yunus = partie.getAventuriers().get("Yunus");
	
		assertEquals("Le tresor n'a pas ete ramasse", 0, tresor.getNbTresor());
		assertEquals("Le nombre de tresor de Yunus n'est correcte", 2, Yunus.getNbTresor());
	}
}

package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TresorTest {
	
	@Test
	public void ramasseTest(){
		Tresor tresor = new Tresor(new Position(1, 2), 3);
		int nbTresor = tresor.ramasse();

		assertEquals(3, nbTresor);
		assertEquals(0, tresor.getNbTresor());
	}
}

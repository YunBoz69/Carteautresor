package model;

import exception.OutOfLimitsException;
import exception.UnauthorizedActionException;
import org.junit.Before;
import org.junit.Test;
import test.AbstractTest;

import static org.junit.Assert.*;

/**
 * Created by Travail on 15/09/2016.
 */
public class CarteTest extends AbstractTest {
    private Carte carte;
    
    @Before
    public void setUp(){
        carte = getCarteSimple();
    }
    
    @Test
    public void getCaseTest() throws OutOfLimitsException {
        Position positionMontagne = new Position(5,3);
        Position positionTresor1 = new Position(4,2);
        Position positionTresor2 = new Position(1,4);

        assertTrue(carte.getCase(positionMontagne) instanceof Montagne);
        assertTrue(carte.getCase(positionTresor1) instanceof Tresor);
        assertTrue(carte.getCase(positionTresor2) instanceof Tresor);
    }

    @Test
    public void getCasePlainTest() throws OutOfLimitsException {
        Position positionPlaine = new Position(1,1);

        assertNull(carte.getCase(positionPlaine));
    }

    @Test(expected = OutOfLimitsException.class)
    public void getCaseOutOfLimitsInX1Test() throws OutOfLimitsException {
        Position positionPlaine = new Position(7,1);

        carte.getCase(positionPlaine);
    }

    @Test(expected = OutOfLimitsException.class)
    public void getCaseOutOfLimitsInY1Test() throws OutOfLimitsException {
    	Position positionPlaine = new Position(1,6);

        carte.getCase(positionPlaine);
    }

    @Test(expected = OutOfLimitsException.class)
    public void getCaseOutOfLimitsInX2Test() throws OutOfLimitsException {

        Position positionPlaine = new Position(0,1);

        carte.getCase(positionPlaine);
    }

    @Test(expected = OutOfLimitsException.class)
    public void getCaseOutOfLimitsInY2Test() throws OutOfLimitsException {

        Position positionPlaine = new Position(1,0);

        carte.getCase(positionPlaine);
    }

    @Test
    public void ramasseTest() throws OutOfLimitsException, UnauthorizedActionException {
        Position positionTresor1 = new Position(4,2);
        Position positionTresor2 = new Position(1,4);

        assertEquals(1, carte.ramasse(positionTresor1));
        assertEquals(3, carte.ramasse(positionTresor2));
    }

    @Test(expected = UnauthorizedActionException.class)
    public void ramasseMontagneTest() throws OutOfLimitsException, UnauthorizedActionException {
        Position positionMontagne = new Position(5,3);

        carte.ramasse(positionMontagne);
    }

    @Test(expected = UnauthorizedActionException.class)
    public void ramassePlaineTest() throws OutOfLimitsException, UnauthorizedActionException {
        Position positionPlain = new Position(1,1);

        carte.ramasse(positionPlain);
    }

}

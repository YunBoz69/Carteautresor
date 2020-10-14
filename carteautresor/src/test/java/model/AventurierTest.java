package model;

import org.junit.Before;
import org.junit.Test;
import test.AbstractTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AventurierTest extends AbstractTest{
	private Aventurier a;
	@Before
    public void setUp(){
		List<Action> listAction = new ArrayList<>();
		a = new Aventurier("Yunus", new Position(1,1), Orientation.EST, listAction );
    }
	@Test
	public void rotationGaucheTest(){
		a.perform(Action.GAUCHE, null);
		assertEquals(Orientation.NORD, a.getOrientation());
		a.perform(Action.GAUCHE, null);
		assertEquals(Orientation.OUEST, a.getOrientation());
		a.perform(Action.GAUCHE, null);
		assertEquals(Orientation.SUD, a.getOrientation());
		a.perform(Action.GAUCHE, null);
		assertEquals(Orientation.EST, a.getOrientation());
	}
	
	@Test
	public void rotationDroiteTest(){
		a.perform(Action.DROITE, null);
		assertEquals(Orientation.SUD, a.getOrientation());
		a.perform(Action.DROITE, null);
		assertEquals(Orientation.OUEST, a.getOrientation());
		a.perform(Action.DROITE, null);
		assertEquals(Orientation.NORD, a.getOrientation());
		a.perform(Action.DROITE, null);
		assertEquals(Orientation.EST, a.getOrientation());
	}
	
	@Test
	public void avanceESTTest(){
		Aventurier aventurier = new Aventurier("Yunus",new Position(1,1), Orientation.EST, null);
		aventurier.perform(Action.AVANCE, null);
		assertEquals(new Position(2, 1), aventurier.getPosition());
	}
	
	@Test
	public void avanceOUESTTest(){
		Aventurier aventurier = new Aventurier("Yunus",new Position(1,1), Orientation.OUEST, null);
		aventurier.perform(Action.AVANCE, null);
		assertEquals(new Position(0, 1), aventurier.getPosition());
	}
	
	@Test
	public void avanceNORDTest(){
		Aventurier aventurier = new Aventurier("Yunus",new Position(1,1), Orientation.NORD, null);
		aventurier.perform(Action.AVANCE, null);
		assertEquals(new Position(1, 0), aventurier.getPosition());
	}
	
	@Test
	public void avanceSUDTest(){
		Aventurier aventurier = new Aventurier("Yunus",new Position(1,1), Orientation.SUD, null);
		aventurier.perform(Action.AVANCE, null);
		assertEquals(new Position(1, 2), aventurier.getPosition());
	}
	
}

package model;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PositionTest {
	
	@Test
	public void positionEqual(){
		Position p1 = new Position(1, 1);
		Position p2 = new Position(2, 1);
		Position p3 = new Position(1, 1);
		
		
		assertNotEquals(p1, p2);
		assertEquals(p1, p3);
	}
	
	@Test
	public void positionMapTest(){
		HashMap<Position, String> map = new HashMap<Position, String>();
		
		Position p1 = new Position(1, 1);
		Position p2 = new Position(2, 1);
		map.put(p1, "p1");
		map.put(p2, "p2");
		
		Position p3 = new Position(1, 1);
		
		
		assertEquals("p1", map.get(p1));
		assertEquals("p2", map.get(p2));
		assertEquals("p1", map.get(p3));
		
		Position p4 = new Position(4, 4);
		String actual = map.get(p4);
		assertNull(actual);
		
	}
}

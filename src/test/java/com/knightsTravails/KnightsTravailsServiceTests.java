package com.knightsTravails;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.knightsTravails.service.KnightsTravailsService;

@SpringBootTest
class KnightsTravailsServiceTests {
	
	@Autowired
	private KnightsTravailsService knightsTravailsService;

	@Test
	void testStringToCoordinatesConversion() {
		assertArrayEquals(knightsTravailsService.stringToCoord("A1"),new int[]{0,0});
		assertArrayEquals(knightsTravailsService.stringToCoord("B2"),new int[]{1,1});
		assertArrayEquals(knightsTravailsService.stringToCoord("C3"),new int[]{2,2});
		assertArrayEquals(knightsTravailsService.stringToCoord("D4"),new int[]{3,3});
		assertArrayEquals(knightsTravailsService.stringToCoord("E5"),new int[]{4,4});
		assertArrayEquals(knightsTravailsService.stringToCoord("F6"),new int[]{5,5});
		assertArrayEquals(knightsTravailsService.stringToCoord("G7"),new int[]{6,6});
		assertArrayEquals(knightsTravailsService.stringToCoord("H8"),new int[]{7,7});
	}
	
	@Test
	void testCoordinatesListToStringConversion() {
		assertEquals(knightsTravailsService.coordToString("21 40 61 73 65 77"), "C2 E1 G2 H4 G6 H8");
	}
	
	@Test
	void testFindShortestPath() {
		assertEquals(knightsTravailsService.findShortestPath("A1", "H8"),"C2 E1 G2 H4 G6 H8");
	}

}

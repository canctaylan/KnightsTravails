package com.knightsTravails;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.knightsTravails.service.KnightsTravailsService;
import com.knightsTravails.util.KnightsTravailsUtil;

@SpringBootTest
class KnightsTravailsUtilTests {

	@Test
	void testStringToCoordinatesConversion() {
		assertArrayEquals(KnightsTravailsUtil.stringToCoord("A1"),new int[]{0,0});
		assertArrayEquals(KnightsTravailsUtil.stringToCoord("B2"),new int[]{1,1});
		assertArrayEquals(KnightsTravailsUtil.stringToCoord("C3"),new int[]{2,2});
		assertArrayEquals(KnightsTravailsUtil.stringToCoord("D4"),new int[]{3,3});
		assertArrayEquals(KnightsTravailsUtil.stringToCoord("E5"),new int[]{4,4});
		assertArrayEquals(KnightsTravailsUtil.stringToCoord("F6"),new int[]{5,5});
		assertArrayEquals(KnightsTravailsUtil.stringToCoord("G7"),new int[]{6,6});
		assertArrayEquals(KnightsTravailsUtil.stringToCoord("H8"),new int[]{7,7});
	}
	
	@Test
	void testCoordinatesListToStringConversion() {
		assertEquals(KnightsTravailsUtil.coordToString("21 40 61 73 65 77"), "C2 E1 G2 H4 G6 H8");
	}
}

package com.knightsTravails;

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
	void testFindShortestPath() {
		assertEquals(knightsTravailsService.findShortestPath("A1", "H8"),"C2 E1 G2 H4 G6 H8");
	}

}

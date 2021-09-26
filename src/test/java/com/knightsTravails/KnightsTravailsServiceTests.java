package com.knightsTravails;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.knightsTravails.service.KnightsTravailsService;

class KnightsTravailsServiceTests {
	
	@Autowired
	private KnightsTravailsService knightsTravailsService;

	@Test
	void test() {
		knightsTravailsService.stringToCoord(null);
	}

}

package com.knightsTravails;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.knightsTravails.controller.KnightsTravailsController;

@SpringBootTest
class KnightsTravailsApplicationTests {
	
	@Autowired
	private KnightsTravailsController knightsTravailsController;

	@Test
	void contextLoads() {
		assertThat(knightsTravailsController).isNotNull();
	}
	
	

}

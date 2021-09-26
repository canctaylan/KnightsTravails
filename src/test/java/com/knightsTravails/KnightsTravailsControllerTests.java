package com.knightsTravails;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.knightsTravails.service.KnightsTravailsService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class KnightsTravailsControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private KnightsTravailsService knightsTravailsService;

	@Test
	void testControllerReturnsOkStatus() throws Exception {
		mockMvc.perform(get("/knightsTravails/api?start=A3&end=H4")).andExpect(status().isOk());
	}

	@Test
	public void testServiceIsCalledSuccessfully() throws Exception {
		when(knightsTravailsService.findShortestPath("A1", "B1")).thenReturn("C2 A3 B1");
		MvcResult result = this.mockMvc.perform(get("/knightsTravails/api?start=A1&end=B1")).andDo(print())
				.andExpect(status().isOk()).andReturn();
		assertEquals(result.getResponse().getContentAsString(), "C2 A3 B1");
	}

	@Test
	public void testStartInputIsNull() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/knightsTravails/api?start=&end=B1")).andDo(print())
				.andExpect(status().isOk()).andReturn();
		assertEquals(result.getResponse().getContentAsString(), "Null input parameter(s)");
	}

	@Test
	public void testEndInputIsNull() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/knightsTravails/api?start=A1&end=")).andDo(print())
				.andExpect(status().isOk()).andReturn();
		assertEquals(result.getResponse().getContentAsString(), "Null input parameter(s)");
	}

	@Test
	public void testBothInputsAreNull() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/knightsTravails/api?start=&end=")).andDo(print())
				.andExpect(status().isOk()).andReturn();
		assertEquals(result.getResponse().getContentAsString(), "Null input parameter(s)");
	}

	@Test
	public void testBothInputsWithWrongFormat() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/knightsTravails/api?start=a9&end=B2")).andDo(print())
				.andExpect(status().isOk()).andReturn();
		assertEquals(result.getResponse().getContentAsString(),
				"Invalid input parameter formats. Please enter inputs with a capital letter and a number. Ex: C3");
	}
	
	@Test
	public void testStartAndEndParametersAreSame() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/knightsTravails/api?start=B2&end=B2")).andDo(print())
				.andExpect(status().isOk()).andReturn();
		assertEquals(result.getResponse().getContentAsString(),
				"Start and locations are the same. Please enter different locations");
	}

}

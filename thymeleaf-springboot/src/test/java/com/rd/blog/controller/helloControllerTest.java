package com.rd.blog.controller;

import org.assertj.core.error.ShouldBeAfterOrEqualsTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class helloControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void contextLoads() {
		try {
			MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();
			String contentAsString = mvcResult.getResponse().getContentAsString();
			System.out.println(contentAsString.equals("helloword"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

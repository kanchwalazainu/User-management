package com.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)

public class UserControllerTest {
	
	
	    private MockMvc mockMvc;
	    @Autowired
	    WebApplicationContext context;
	    @Before
	    public void setup() {
	    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	    }
		@Test
		public void retrievetest_ok() throws Exception {
			 mockMvc.perform(get("/api/users/1" )).andDo(print())
		                .andExpect(status().isOk())
		                .andExpect(MockMvcResultMatchers.jsonPath("$.userid").value(1))
		                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Shabbir"))
		                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Bagasrawala"))
		                .andExpect(MockMvcResultMatchers.jsonPath("$.emailId").value("murtaza_bagasrawala@rediffmail.com"))
		                .andExpect(MockMvcResultMatchers.jsonPath("$.deletedFlag").value(false));
			 
			
		}
		
		@Test
		public void retrievealltest_ok() throws Exception {
			
			 mockMvc.perform(get("/api/users" )).andDo(print())
		                .andExpect(status().isOk());
			
		               
		               
			 
		
		}
}


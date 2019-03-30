package com.qa.tests.integration;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.netflix.discovery.EurekaClient;
import com.qa.account.AccountApplication;
import com.qa.account.entities.Account;
import com.qa.account.entities.Constants;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = AccountApplication.class)
public class IntegrationTest {

	@Autowired
	private WebApplicationContext wac;
	
	@Mock
	private RestTemplateBuilder rest;
	@Mock
	private EurekaClient client;

	private List<Account> MOCK_LIST;
	private MockMvc mockMvc;
	@Before
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void givenWac_whenServletContext_thenItProvidesGreetController() {
	    ServletContext servletContext = wac.getServletContext();
	     
	    Assert.assertNotNull(servletContext);
	    Assert.assertTrue(servletContext instanceof MockServletContext);
	    Assert.assertNotNull(wac.getBean("accountController"));

}
	@Test
	public void checkEncrypt() throws Exception {
	    this.mockMvc.perform(put("/encrypt").contentType("application/x-www-form-urlencoded")
	      .content("Hi")).andDo(print()).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}
	@Test
	public void checkLogin() throws Exception {
		Mockito.when(rest.build().exchange(client.getNextServerFromEureka(Constants.GATEWAY, false).getHomePageUrl()+Constants.GET_ACCOUNTS_PATH, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Account>>(){}).getBody()).thenReturn(MOCK_LIST);
	    this.mockMvc.perform(put("/login").contentType("application/x-www-form-urlencoded")
	      .content("Hi")).andDo(print()).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}
}

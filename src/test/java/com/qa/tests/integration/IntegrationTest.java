package com.qa.tests.integration;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.http.MediaType;
import com.google.gson.Gson;
import com.netflix.discovery.EurekaClient;
import com.qa.account.AccountApplication;
import com.qa.account.controller.AccountController;
import com.qa.account.entities.Account;
import com.qa.account.entities.Login;
import com.qa.account.service.AccountServiceImpl;

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
	@Mock
	private AccountServiceImpl srvc;
	@Mock
	private AccountController control;

	private List<Account> MOCK_LIST;
	private Account MOCK_ACCOUNT;
	private Login MOCK_LOGIN;
	private MockMvc mockMvc;
	private String MOCK_EMAIL = "gary@gary.gary";
	private String MOCK_PASSWORD = "Password1";
	
	@Before
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    MOCK_ACCOUNT = new Account();
	    MOCK_LOGIN = new Login();
	    MOCK_LIST = new ArrayList();
	    MOCK_LIST.add(MOCK_ACCOUNT);
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
		Mockito.when(srvc.login(MOCK_LOGIN, MOCK_LIST)).thenReturn(MOCK_ACCOUNT);
		Mockito.when(control.getAllAccounts()).thenReturn(MOCK_LIST);
		Gson gson = new Gson();
	    String json = gson.toJson(MOCK_LOGIN);

	    this.mockMvc.perform(put("/login").content(json).contentType(MediaType.APPLICATION_JSON))
	    		.andDo(print()).andExpect(status().isOk());
	}
}

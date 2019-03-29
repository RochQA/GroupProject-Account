package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.account.AccountApplication;
import com.qa.account.controller.AccountController;
import com.qa.account.entities.CreateAccount;
import com.qa.account.entities.Login;
import com.qa.account.service.AccountServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AccountApplication.class)
public class ControllerTests {
	
	@InjectMocks
	AccountController control;
	
	@Mock
	AccountServiceImpl scv;

	private String MOCK_STRING = "TEST";
	private CreateAccount MOCK_ACCOUNT = new CreateAccount(); 
	private CreateAccount MOCK_ACCOUNT2= new CreateAccount();
	private Login MOCK_LOGIN= new Login();
	private Long MOCK_LONG = 1L;
	
//	@Test
//	public void createAccountTest() {
//		Mockito.when(scv.createAccount(MOCK_ACCOUNT)).thenReturn(MOCK_ACCOUNT);
//		assertEquals(MOCK_ACCOUNT, control.createAccount(MOCK_ACCOUNT));
//	}
//	@Test
//	public void getAccountTest() {
//		Mockito.when(scv.getAccount(MOCK_LONG)).thenReturn(MOCK_ACCOUNT);
//		assertEquals(MOCK_ACCOUNT, control.getAccount(MOCK_LONG));
//	}
//	@Test
//	public void getAllAccountsTest() {
//		List<CreateAccount> accounts = new ArrayList<>();
//		accounts.add(MOCK_ACCOUNT);
//		accounts.add(MOCK_ACCOUNT2);
//		Mockito.when(scv.getAllAccounts()).thenReturn(accounts);
//		assertEquals(accounts, control.getAllAccounts());
//	}
//	
//	@Test
//	public void deleteAccountTest() {
//		Mockito.when(scv.deleteAccount(MOCK_LONG)).thenReturn(MOCK_STRING);
//		assertEquals(MOCK_STRING, control.deleteAccount(MOCK_LONG));
//	}
//	@Test
//	public void updateAccountTest() {
//		Mockito.when(scv.updateAccount(MOCK_ACCOUNT)).thenReturn(MOCK_ACCOUNT);
//		assertEquals(MOCK_ACCOUNT, control.updateAccount(MOCK_ACCOUNT));		
//	}
//	@Test
//	public void loginTest() {
//		Mockito.when(scv.login(MOCK_LOGIN)).thenReturn(MOCK_ACCOUNT);
//		assertEquals(MOCK_ACCOUNT, control.login(MOCK_LOGIN));		
//	}
}

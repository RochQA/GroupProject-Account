package com.qa.tests.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.account.AccountApplication;
import com.qa.account.entities.Account;
import com.qa.account.entities.Constants;
import com.qa.account.entities.CreateAccount;
import com.qa.account.entities.Login;
import com.qa.account.service.AccountServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AccountApplication.class)
public class ServiceTests {
	
	@InjectMocks
	AccountServiceImpl srvc;
	
	
	
	private String MOCK_STRING = "TEST";
	private String MOCK_STRING2 = "roch@roch.roch";
	private CreateAccount MOCK_ACCOUNT = new CreateAccount(); 
	private CreateAccount MOCK_ACCOUNT2= new CreateAccount();
	private Long MOCK_LONG = 1L;
	private Long MOCK_LONG2 = 2L;
	private Login MOCK_LOGIN= new Login();
	private List<CreateAccount> MOCK_ACCOUNTS;
	private String MOCK_PASS = "Testpassnumber1";
	private String MOCK_EMAIL2 = "dan@dan.dan";
	private String MOCK_INVALID_EMAIL = "wery.”16\\ sdry”@dt.cwrm";
	private String MOCK_INVALID_PASS = "passwd";
	private Account acc1;
	private Account acc2;
	List<Account> accounts;
	Login login;

	@Before
	public void setup() {
		MOCK_ACCOUNT2= new CreateAccount();
		MOCK_ACCOUNT= new CreateAccount(); 
		MOCK_ACCOUNT.setId(MOCK_LONG);
		MOCK_ACCOUNT2.setId(MOCK_LONG2);
		MOCK_ACCOUNT.setEmail(MOCK_STRING);
		MOCK_ACCOUNT.setPassword(srvc.encryptPassword(MOCK_STRING));
		MOCK_ACCOUNT2.setEmail(MOCK_STRING2);
		MOCK_ACCOUNT2.setPassword(MOCK_PASS);
		MOCK_ACCOUNT2.setConfirmPassword(MOCK_PASS);
		MOCK_LOGIN.setEmail(MOCK_STRING);
		MOCK_LOGIN.setPassword(MOCK_STRING);
		MOCK_ACCOUNTS = new ArrayList<CreateAccount>();
		MOCK_ACCOUNTS.add(MOCK_ACCOUNT);
		MOCK_ACCOUNTS.add(MOCK_ACCOUNT2);
		
		Account acc1 = new Account();
		acc1.setId(1L);
		acc1.setEmail(MOCK_STRING2);
		acc1.setPassword(MOCK_PASS);
		acc1.setTrainerId(1L);
		acc1.setAccountType("Trainer");
		
		Account acc2 = new Account();
		acc2.setId(2L);
		acc2.setEmail(MOCK_EMAIL2);
		acc2.setPassword(MOCK_PASS);
		acc2.setTrainerId(2L);
		acc2.setAccountType("Trainer");
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(acc1);
		accounts.add(acc2);
		
		Login login = new Login();
		login.setEmail(MOCK_STRING2);
		login.setPassword(MOCK_PASS);
	}
	
	@Test
	public void loginValidTest() {
		assertEquals(acc1, srvc.login(login, accounts));
	}
	
	
	@Test
	public void isEmailValidTest() {
		assertEquals(true,srvc.isEmailValid(MOCK_STRING2));
	}
	
	@Test
	public void isEmailValidTest2() {
		assertEquals(false,srvc.isEmailValid(MOCK_INVALID_EMAIL));
	}
	
	@Test
	public void isPasswordValidTest() {
		assertEquals(true,srvc.isPasswordValid(MOCK_PASS));
	}
	
	@Test
	public void isPasswordValidTest2() {
		assertEquals(false,srvc.isPasswordValid(MOCK_INVALID_PASS));
	}
	
	@Test
	public void checkCreateAccountTestValid() {
		assertEquals(Constants.VALID_MESSAGE, srvc.checkCreateAccount(MOCK_ACCOUNT2));
	}
	
	@Test
	public void checkCreateAccountTestInvalidEmail() {
		MOCK_ACCOUNT2.setEmail(MOCK_INVALID_EMAIL);
		assertEquals(Constants.INVALID_EMAIL_MESSAGE, srvc.checkCreateAccount(MOCK_ACCOUNT2));
	}
	
	@Test
	public void checkCreateAccountTestInvalidPass() {
		MOCK_ACCOUNT2.setPassword(MOCK_INVALID_PASS);
		assertEquals(Constants.INVALID_PASSWORD_MESSAGE, srvc.checkCreateAccount(MOCK_ACCOUNT2));
	}
	
	@Test
	public void checkCreateAccountTestInvalidConfirmPass() {
		MOCK_ACCOUNT2.setConfirmPassword(MOCK_INVALID_PASS);
		assertEquals(Constants.PASSWORDS_DONT_MATCH_MESSAGE, srvc.checkCreateAccount(MOCK_ACCOUNT2));
	}
	
	
	
	
//	@Test
//	public void createTest() {
//		Mockito.when(repo.save(Mockito.any())).thenReturn(MOCK_ACCOUNT2);
//		assertEquals("createAccount not functioning",srvc.createAccount(MOCK_ACCOUNT), null);
//		System.out.println(MOCK_ACCOUNT2.getPassword()+ MOCK_ACCOUNT2.getEmail());
//		assertEquals("createAccount not functioning",srvc.createAccount(MOCK_ACCOUNT2), MOCK_ACCOUNT2);
//		
//	}
//	@Test
//	public void getTests() {
//		Mockito.when(repo.findAll()).thenReturn(MOCK_ACCOUNTS);
//		assertEquals("getAllAccounts not functioning", srvc.getAllAccounts(), MOCK_ACCOUNTS);
//		assertEquals("getAccount not functioning",srvc.getAccount(MOCK_LONG), MOCK_ACCOUNT);
//	}
//	@Test
//	public void updateTest() {
//		Mockito.when(repo.findAll()).thenReturn(MOCK_ACCOUNTS);
//		assertEquals("updateAccount not functioning", srvc.updateAccount(MOCK_ACCOUNT).getId(), MOCK_ACCOUNT.getId());
//	}
//
//	@Test
//	public void deleteByIdAccountTest() {
//		assertEquals("deleteAccount not functioning", "Account deleted", srvc.deleteAccount(MOCK_LONG));
//	}
//	@Test
//	public void loginTest() {
//		Mockito.when(repo.findAll()).thenReturn(MOCK_ACCOUNTS);
//		assertEquals("updateAccount not functioning", srvc.login(MOCK_LOGIN).getId(), MOCK_ACCOUNT.getId());
//	}

}

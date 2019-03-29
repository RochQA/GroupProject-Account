package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.account.AccountApplication;
import com.qa.account.entities.CreateAccount;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AccountApplication.class)
public class AccountTests {
	
	private CreateAccount account;
	
	private Long MOCK_ID = 1L;
	private String MOCK_STRING = "Test";
	
	@Before
	public void setup() {
		account = new CreateAccount();
	}
	@Test
	public void accountIdTest() {
		account.setId(MOCK_ID);
		assertEquals(MOCK_ID, account.getId());
	}
	@Test
	public void accountEmailTest() {
		account.setEmail(MOCK_STRING);
		assertEquals(MOCK_STRING, account.getEmail());
	}
	@Test
	public void accountPasswordTest() {
		account.setPassword(MOCK_STRING);
		assertEquals(MOCK_STRING, account.getPassword());
	}
//	@Test
//	public void accountTrainerIdTest() {
//		account.setTrainerId(MOCK_ID);
//		assertEquals(MOCK_ID, account.getTrainerId());
//	}
//	@Test
//	public void accountAccountTypeTest() {
//		account.setAccountType(MOCK_STRING);
//		assertEquals(MOCK_STRING, account.getAccountType());
//	}

}

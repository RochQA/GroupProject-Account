package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.account.AccountApplication;



@RunWith(SpringRunner.class)
@SpringBootTest(classes=AccountApplication.class)
public class AccountApplicationTests {
	
	@InjectMocks
	AccountApplication app;
	
	
	SuiteTest test;
	

	@Test
	public void suiteTest() {
		test = new SuiteTest();
		assertThat(test).isNotNull();
	}
	
	@Test
	public void appTests() {
		assertThat(app).isNotNull();
		String[] args = new String[] {"random"};
		app.main(args);
	}

}

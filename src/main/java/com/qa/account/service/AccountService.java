package com.qa.account.service;

import java.util.List;

import com.qa.account.entities.Account;
import com.qa.account.entities.CreateAccount;
import com.qa.account.entities.Login;

public interface AccountService {
	
	public String checkCreateAccount(CreateAccount account);

	public String checkDuplicates(CreateAccount account, List<Account> accounts);

	public String encryptPassword(String password);

	public Account login(Login login, List<Account> allAccounts);
	


}

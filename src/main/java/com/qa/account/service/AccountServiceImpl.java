package com.qa.account.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

import com.qa.account.entities.Account;
import com.qa.account.entities.Constants;
import com.qa.account.entities.CreateAccount;
import com.qa.account.entities.Login;
import com.qa.account.entities.UpdateAccount;

@Service
public class AccountServiceImpl implements AccountService{

    private Pattern emailPattern = Pattern
            .compile(Constants.EMAIL_CHARS);
	
    
	@Override
	public String checkValid(CreateAccount account) {
		String password = account.getPassword();
		if (!isEmailValid(account.getEmail().toLowerCase())) {
			account.setPassword(encryptPassword(account.getPassword()));			
			return Constants.INVALID_EMAIL_MESSAGE;
		}else if(!isPasswordValid(password)) {
			return Constants.INVALID_PASSWORD_MESSAGE;
		}else if(!password.equals(account.getConfirmPassword())) {
			return Constants.PASSWORDS_DONT_MATCH_MESSAGE;
		}else return Constants.VALID_MESSAGE;		
	}
	@Override
	public Account login(Login login, List<Account> allAccounts) {
		Account loginAccount =  new Account();
		loginAccount = allAccounts.stream()
				.filter(account -> login.getEmail().equals(account.getEmail())&&encryptPassword(login.getPassword()).equals(account.getPassword()))
				.findAny()
				.orElse(new Account());
		return loginAccount;
	}	
	@Override
	public String encryptPassword(String password) {
        byte[] securePassword = hash(password.toCharArray(), Constants.SALT.getBytes());
        return Base64.getEncoder().encodeToString(securePassword);
    }	
		
	@Override
	public String checkDuplicates(CreateAccount accountC, List<Account> accounts) {
		Account matchingAccs = new Account();
		matchingAccs = accounts.stream()
				.filter(account -> accountC.getEmail().equals(account.getEmail()))
				.findFirst()
				.orElse(new Account());
		if (matchingAccs.getEmail() != null) {
			return Constants.ACCOUNT_EXISTS_MESSAGE;
		}else return Constants.VALID_MESSAGE;
	}
	
	public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, Constants.ITERATIONS, Constants.KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(Constants.INSTANCE_STRING);
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError(Constants.PASSWORD_HASH_ERROR+ e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }	
	public Boolean isEmailValid(String email) {
		return emailPattern.matcher(email.toLowerCase()).matches();
	}
	public Boolean isPasswordValid(String password) {
		return  (!password.equals(password.toLowerCase()) && !password.equals(password.toUpperCase()) 
				&& password.length() >= Constants.PASSLENGTH && password.matches(Constants.PASSCHARS));
	}
	public String checkUpdateAccount(UpdateAccount account, Account oldAccount, List<Account> accounts) {
		if(encryptPassword(account.getOldPassword()).equals(oldAccount.getPassword())) {
			String checkValid = checkValid(account);
			if(checkValid.equals(Constants.VALID_MESSAGE)) {
				Account matchingAccs = accounts.stream()
						.filter(acc -> oldAccount.getId().equals(acc.getId()))
						.findFirst()
						.orElse(new Account());
				accounts.remove(matchingAccs);
				return checkDuplicates(account, accounts);				
			}return checkValid;
		}return Constants.INVALID_OLD_PASSWORD_MESSAGE;
	}
	public String checkAccount(CreateAccount account, List<Account> allAccounts) {
		String validRes = checkValid(account);
		if( validRes.equals(Constants.VALID_MESSAGE)) {
			String dupeRes = checkDuplicates(account, allAccounts);
			return dupeRes;
		}else return validRes;
	}

}
	
	
	



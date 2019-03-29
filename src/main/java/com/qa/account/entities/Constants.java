package com.qa.account.entities;

public class Constants {
	public static final int ITERATIONS = 10000;
	public static final int KEY_LENGTH = 256;
    public static final String SALT = "EqdmPh53c9x33EygXpTpcoJvc4VXLK";
	public static final String EMAIL_CHARS = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$";
	public static final String ACCOUNT_DELETED_MESSAGE = "Account deleted";
	public static final String INSTANCE_STRING = "PBKDF2WithHmacSHA1";
	public static final String PASSWORD_HASH_ERROR = "Error while hashing a password: ";
	public static final String PASSCHARS = "[A-Za-z0-9 ]*";
	public static final String GATEWAY = "GATEWAY";
	public static final String GET_ACCOUNTS_PATH = "getAllAccounts";
	public static final String INVALID_EMAIL_MESSAGE = "Invalid Email!";
	public static final String INVALID_PASSWORD_MESSAGE = "Invalid Password!";
	public static final String PASSWORDS_DONT_MATCH_MESSAGE = "Passwords Do Not Match!";
	public static final String VALID_MESSAGE = "Valid";
	public static final String NOT_VALID_MESSAGE = "Not Valid";
	public static final String ACCOUNT_EXISTS_MESSAGE = "Account already exists";


}

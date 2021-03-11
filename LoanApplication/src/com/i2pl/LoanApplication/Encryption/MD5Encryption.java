package com.i2pl.LoanApplication.Encryption;


import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Fetches the encryption requests from different servlet and java files, encrypts the password,
 * and passes it to the same.
 */

public class MD5Encryption {
	
	/**
     * Recieves the password , encrypts it and send it back to the servlet or 
     * java file from where it was called.
     *
     *
     * @param input the password value which is given by the user.
     *
     * @return a String consisting of the encrypted value of the given password
     * 
     * @exception Exception any excpetions that may occur.
     *
     */
	
	public String getEncryption(String input) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while(hashtext.length() < 32){
					hashtext = "0" + hashtext;
				}
				return hashtext;
					
			} catch (Exception e) {
			}
			return input;
	}
}

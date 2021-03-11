package com.i2pl.LoanApplication.Constants;

/**
 * To store the static final variables common to many servlets and java file.
 */

public class Constant {
	
	/**
	 *The credentials for connecting to the live database.
	 */
	
	final public static String DB_URL = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12373181";
	final public static String DB_NAME = "sql12373181";
	final public static String DB_PASSWORD = "DiGxfM3cAQ";
	final public static String DB_DRIVER = "com.mysql.jdbc.Driver";
	
	/**
	 * The Admin's prepopulated login credentials.
	 */
	
	final public static String ADMIN_ID= "admin";
	final public static String ADMIN_PASSWORD="0192023a7bbd73250516f069df18b500";
	
	/**
	 * The credentials of the Email Id via which the 
	 * OTP is to be sent for password recovery.
	 */
	
	final public static String EMAIL_FROM="recoveryp335@gmail.com";
	final public static String EMAIL_SUBJECT="Password Recovery";
	final public static String EMAIL_MAIN_BODY="Your OTP for password recovery is: ";
	final public static String EMAIL_PASSWORD="335_recover";
	
}

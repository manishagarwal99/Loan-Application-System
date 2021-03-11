package com.i2pl.LoanApplication.CreateFieldOfficials;

/**
 * A class to store the Field Official's credentials as it's object.
 */

public class Accounts {
	private String FIELD_OFFICIAL_NAME, FIELD_OFFICIAL_EMAIL, FIELD_OFFICIAL_UNAME, FIELD_OFFICIAL_PASSWORD ;
	
	/**
     * Constructor of the class.
     * Encapsulates the Field Official's credentials.
     *
     * @param FIELD_OFFICIAL_NAME the name of Field Official.
     * @param FIELD_OFFICIAL_EMAIL the email id of Field Official.
     * @param FIELD_OFFICIAL_UNAME the user name of Field Official, used to login.
     * @param FIELD_OFFICIAL_PASSWORD the Password of Field Official, used to login.
     * 
     */
	
	public Accounts(String FIELD_OFFICIAL_NAME,String FIELD_OFFICIAL_EMAIL,String FIELD_OFFICIAL_UNAME,String FIELD_OFFICIAL_PASSWORD) {
		super();
		this. FIELD_OFFICIAL_NAME= FIELD_OFFICIAL_NAME;
		this. FIELD_OFFICIAL_EMAIL= FIELD_OFFICIAL_EMAIL;
		this. FIELD_OFFICIAL_UNAME=FIELD_OFFICIAL_UNAME;
		this. FIELD_OFFICIAL_PASSWORD = FIELD_OFFICIAL_PASSWORD;
	}
	
	/**
	 *Returns the Field Official's name. 
	 *@return Field Official's name.
	 */
	
	public String getName() {
		return FIELD_OFFICIAL_NAME;
	}
	
	/**
	 *Returns the Field Official's email. 
	 *@return Field Official's email.
	 */
	
	public String getEmail() {
		return FIELD_OFFICIAL_EMAIL;
	}
	
	/**
	 *Returns the Field Official's user name. 
	 *@return Field Official's user name.
	 */
	
	public String getuname() {
		return FIELD_OFFICIAL_UNAME;
	}
	
	/**
	 *Returns the Field Official's password. 
	 *@return Field Official's password.
	 */
	
	public String getPassword() {
		return FIELD_OFFICIAL_PASSWORD ;
	}
}

package com.i2pl.LoanApplication.FillApplication;

/**
 * A class to store the Loan application details as it's object.
 */

public class Applicant 
{
	private String APPLICANT_NAME, APPLICANT_ADDRESS, APPLICANT_PAN, APPLICANT_AADHAR,APPLICANT_DATE,APPLICANT_PHNO;
	private int APPLICANT_LOAN_REQ;
	private int lr = 80;
	private int ur = 120;
	
	/**
     * Constructor of the class.
     * Encapsulates the Loan application details.
     *
     * @param APPLICANT_DATE date of application.
     * @param APPLICANT_NAME name of the applicant.
     * @param APPLICANT_ADDRESS address of the applicant.
     * @param APPLICANT_PHNO phone number of the applicant.
     * @param APPLICANT_PAN pan number of the applicant.
     * @param APPLICANT_AADHAR aadhar number of the applicant.
     * @param APPLICANT_LOAN_REQ loan requirement of the applicant.
     * 
     */
	
	public Applicant(String APPLICANT_DATE,String APPLICANT_NAME, String APPLICANT_ADDRESS, String APPLICANT_PHNO, String APPLICANT_PAN, String APPLICANT_AADHAR, int APPLICANT_LOAN_REQ) {
		super();
		this.APPLICANT_DATE=APPLICANT_DATE;
		this.APPLICANT_NAME = APPLICANT_NAME;
		this.APPLICANT_ADDRESS = APPLICANT_ADDRESS;
		this.APPLICANT_PHNO = APPLICANT_PHNO;
		this.APPLICANT_PAN = APPLICANT_PAN;
		this.APPLICANT_AADHAR = APPLICANT_AADHAR;
		this.APPLICANT_LOAN_REQ = APPLICANT_LOAN_REQ;
		
	}
	
	/**
	 *Returns the Applicant's name. 
	 *@return Applicant's name.
	 */
	
	public String getName() {
		return APPLICANT_NAME;
	}
	
	/**
	 *Returns the Applicant's address. 
	 *@return Applicant's address.
	 */
	
	public String getAddress() {
		return APPLICANT_ADDRESS;
	}
	
	/**
	 *Returns the Applicant's phone number. 
	 *@return Applicant's phone number.
	 */
	
	public String getPhone() {
		return APPLICANT_PHNO;
	}
	
	/**
	 *Returns the Applicant's pan number. 
	 *@return Applicant's pan number.
	 */
	
	public String getPan() {
		return APPLICANT_PAN;
	}
	
	/**
	 *Returns the Applicant's aadhar number. 
	 *@return Applicant's aadhar number.
	 */
	
	public String getAadhar() {
		return APPLICANT_AADHAR;
	}
	
	/**
	 *Returns the Applicant's loan requirement. 
	 *@return Applicant's loan requirement.
	 */
	
	public int getLoan() {
		return APPLICANT_LOAN_REQ;
	}
	
	/**
	 *Randomly generates the loan eligibile for the applicant i.e 
	 *80% to 120% of the loan requirement. 
	 *@return loan eligible for the applicant .
	 */
	
	public int getEligibile() {
		double share = (Math.random() * (ur - lr + 1) + lr)/100.0;
		int APPLICANT_LOAN_Eligibile=(int)(share*APPLICANT_LOAN_REQ);
		return APPLICANT_LOAN_Eligibile;
	}
	
	/**
	 *Returns the application's month. 
	 *@return application's month.
	 */
	
	public String getMonth()
	{
		int m=Integer.parseInt(APPLICANT_DATE.substring(5,7));
		switch(m)
		{
		case 1: return "January";
		case 2: return "February";
		case 3: return "March";
		case 4: return "April";
		case 5: return "May";
		case 6: return "June";
		case 7: return "July";
		case 8: return "August";
		case 9: return "September";
		case 10: return "October";
		case 11: return "November";
		default:
			return "December";
		}
	}
	
	/**
	 *Returns the application's date. 
	 *@return application's date.
	 */
	
	public String getDate()
	{
		return APPLICANT_DATE;
	}
}


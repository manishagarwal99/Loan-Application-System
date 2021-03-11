package com.i2pl.LoanApplication.CheckReport;
import java.sql.*;
import java.text.SimpleDateFormat;

import com.i2pl.LoanApplication.Constants.Constant;

/**
 * Fetches the loan application details from the database
 * and passes it to the servlet <code>ShowTable</code>.
 */

public class StoreData {

	private String APPLICANT_NAME = "";
	private String APPLICANT_ADDRESS = "";
	private String APPLICANT_PAN = "";
	private String APPLICANT_AADHAR = "";
	private Date APPLICANT_DATE;
	private String result = "";
	private String APPLICANT_PHNO="";
	private int APPLICANT_LOAN_REQ, APPLICANT_LOAN_EL, total;

	/**
     * Called by the server
     * to allow fetch and store date wise loan application details
     * and send it to the servlet<code>ShowTable</code>.
     *
     *
     * @param date1 a date given by the user for which we have to show the details.
     *
     * @param type the type(valid/invalid) of loan application details the client wants to view.
     *
     * @return a String array consisting of details of the resultant table and the total loan values.
     * 
     * @exception SQLException  if the request for the connection to database could not be handled.
     *
     */
	
	public String[] data1(String date1, String type) {SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Class.forName(Constant.DB_DRIVER);
			Connection con = DriverManager.getConnection(Constant.DB_URL,Constant.DB_NAME,Constant.DB_PASSWORD);


			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + type + " where Date = '" + date1 + "'");

			while (rs.next()) {
				
				APPLICANT_NAME = rs.getString(1);
				APPLICANT_ADDRESS = rs.getString(2);
				APPLICANT_PHNO = rs.getString(3);
				APPLICANT_PAN = rs.getString(4);
				APPLICANT_AADHAR = rs.getString(5);
				APPLICANT_LOAN_REQ = rs.getInt(6);
				APPLICANT_LOAN_EL = rs.getInt(7);
				APPLICANT_DATE = rs.getDate(9);
				result += String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%d</td><td>%d</td><td>%s</td></tr>", APPLICANT_NAME, APPLICANT_ADDRESS, APPLICANT_PHNO, APPLICANT_PAN, APPLICANT_AADHAR,
						APPLICANT_LOAN_REQ, APPLICANT_LOAN_EL, formatter.format(APPLICANT_DATE)) + "\r\n";
				
				total += APPLICANT_LOAN_REQ;

			}
		} catch (Exception e) {
			System.out.println("SQL exception occured" + e);
		}
		String result2 = "The total Loan Requirement of Date " + date1 + " is : " + total;
		String result_data[]= {result,result2};
		return result_data;

	}

	/**
     * Called by the server
     * to allow fetch and store month wise loan application details
     * and send it to the servlet<code>ShowTable</code>.
     *
     *
     * @param month a month given by the user for which we have to show the details.
     *
     * @param type the type(valid/invalid) of loan application details the client wants to view.
     *
     * @return a String array consisting of details of the resultant table and the total loan values.
     *
     * @exception SQLException  if the request for the connection to database could not be handled.
     *
     */
	
	public String[] data2(String month, String type) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Class.forName(Constant.DB_DRIVER);
			Connection con = DriverManager.getConnection(Constant.DB_URL,Constant.DB_NAME,Constant.DB_PASSWORD);


			Statement stmt = con.createStatement();
			month = month+"-01";
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + type + " where YEAR(Date) = YEAR('" + month + "') AND MONTH(Date) = MONTH('"+ month + "')"); // change
			
			while (rs.next()) {

				APPLICANT_NAME = rs.getString(1);
				APPLICANT_ADDRESS = rs.getString(2);
				APPLICANT_PHNO = rs.getString(3);
				APPLICANT_PAN = rs.getString(4);
				APPLICANT_AADHAR = rs.getString(5);
				APPLICANT_LOAN_REQ = rs.getInt(6);
				APPLICANT_LOAN_EL = rs.getInt(7);
				APPLICANT_DATE = rs.getDate(9);
				result += String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%d</td><td>%d</td><td>%s</td></tr>", APPLICANT_NAME, APPLICANT_ADDRESS, APPLICANT_PHNO, APPLICANT_PAN, APPLICANT_AADHAR,
						APPLICANT_LOAN_REQ, APPLICANT_LOAN_EL, formatter.format(APPLICANT_DATE)) + "\r\n";
				total += APPLICANT_LOAN_REQ;

			}
		} catch (Exception e) {
			System.out.println("SQL exception occured" + e);
		}

		String result2 = "The total Loan Requirement of month " + month + " is : " + total;
		String result_data[]= {result,result2};
		return result_data;

	}

	/**
     * Called by the server
     * to allow fetch and store date range wise loan application details
     * and send it to the servlet<code>ShowTable</code>.
     *
     *
     * @param date1 a start date given by the user for which we have to show the details.
     * 
     * @param date2 an end date given by the user for which we have to show the details.
     *
     * @param type the type(valid/invalid) of loan application details the client wants to view.
     *
     * @return a String array consisting of details of the resultant table and the total loan values.
     * 
     * @exception SQLException  if the request for the connection to database could not be handled.
     *
     */
	
	public String[] data3(String date1, String date2, String type) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Class.forName(Constant.DB_DRIVER);
			Connection con = DriverManager.getConnection(Constant.DB_URL,Constant.DB_NAME,Constant.DB_PASSWORD);


			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM " + type + " where Date >= '" + date1 + "' and Date <= '" + date2 + "'");

			while (rs.next()) {

				APPLICANT_NAME = rs.getString(1);
				APPLICANT_ADDRESS = rs.getString(2);
				APPLICANT_PHNO = rs.getString(3);
				APPLICANT_PAN = rs.getString(4);
				APPLICANT_AADHAR = rs.getString(5);
				APPLICANT_LOAN_REQ = rs.getInt(6);
				APPLICANT_LOAN_EL = rs.getInt(7);
				APPLICANT_DATE = rs.getDate(9);
				result += String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%d</td><td>%d</td><td>%s</td></tr>", APPLICANT_NAME, APPLICANT_ADDRESS, APPLICANT_PHNO, APPLICANT_PAN, APPLICANT_AADHAR,
						APPLICANT_LOAN_REQ, APPLICANT_LOAN_EL, formatter.format(APPLICANT_DATE)) + "\r\n";
				total += APPLICANT_LOAN_REQ;

			}
		} catch (Exception e) {
			System.out.println("SQL exception occured" + e);
		}
		String result2 = "The total Loan Requirement between dates " + date1 + " and " + date2 + " is : " + total;
		String result_data[]= {result,result2};
		return result_data;
	}
}
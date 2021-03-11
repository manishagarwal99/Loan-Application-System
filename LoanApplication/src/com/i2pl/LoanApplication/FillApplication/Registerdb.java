package com.i2pl.LoanApplication.FillApplication;
import java.sql.*;

import com.i2pl.LoanApplication.Constants.Constant;

/**
 * Forms connection and stores the Loan application details to the live database.
 */

public class Registerdb {
	
	/**
     * To set the driver for database connection.
     *
     *
     * @param DB_DRIVER Driver details.
     * 
     * @return Nothing.
     * 
     * @exception ClassNotFoundException when the requested class is not found.
     *
     */
	
	public void loadDriver(String DB_DRIVER) {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}
	
	/**
     * To connect to the database.
     * 
     * @return Connection object.
     * 
     * @exception SQLException if the request for the connection to database could not be handled.
     */

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(Constant.DB_URL, Constant.DB_NAME,Constant.DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}
	
	/**
     * To insert the Loan application details into the live database .
     *
     * @param applicant an Applicant class object containing the application details.
     * 
     * @return a string value to notify if the insertion was successful or not.
     * 
     * @exception SQLException if the request for the connection to database could not be handled.
     *
     */

	public String insert(Applicant applicant) {
		loadDriver(Constant.DB_DRIVER);
		Connection con = getConnection();
		String name=applicant.getName();
		String address=applicant.getAddress();
		String Phone=applicant.getPhone();
		String pan=applicant.getPan();
		String aadhar=applicant.getAadhar();
		int loan=applicant.getLoan();
		int eligible=applicant.getEligibile();
		String month=applicant.getMonth();
		Date date=Date.valueOf(applicant.getDate());
		String result = "";
		try {
			PreparedStatement ps;
			if(loan<=eligible)
			{
				result="Valid loan request.";
				ps = con.prepareStatement("insert into sql12373181.valid values ('"+name +"','" +address +"'," +Phone +",'" +pan +"','" +aadhar +"'," +loan +"," +eligible +",'" +month +"','" +date+"')");
			}
			else
			{
				result="Invalid loan request.";
				ps = con.prepareStatement("insert into sql12373181.invalid values ('"+name +"','" +address +"'," +Phone +",'" +pan +"','" +aadhar +"'," +loan +"," +eligible +",'" +month +"','" +date+"')");
			}
				ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			result = "Data entry failed!";
		}

		return result;

	}

}

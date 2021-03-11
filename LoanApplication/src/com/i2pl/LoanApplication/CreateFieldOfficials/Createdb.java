package com.i2pl.LoanApplication.CreateFieldOfficials;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.i2pl.LoanApplication.Constants.Constant;

/**
 * Forms connection and stores the Field Official's credentials to the live database.
 */

public class Createdb {

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
			con = DriverManager.getConnection(Constant.DB_URL,Constant.DB_NAME,Constant.DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;

	}

	/**
     * To insert the Field Official's credentials into the live database .
     *
     * @param account an Account class object containing the credentials.
     * 
     * @return a string value to notify if the insertion was successfull or not.
     * 
     * @exception SQLException if the request for the connection to database could not be handled.
     *
     */
	
	public String insert(Accounts account) {
		loadDriver(Constant.DB_DRIVER);
		Connection con = getConnection();
		String name=account.getName();
		String email=account.getEmail();
		String uname=account.getuname();
		String password=account.getPassword();
		String result = "Account created.";
		try {
				PreparedStatement ps = con.prepareStatement("insert into sql12373181.field_officials values (?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2, email);
				ps.setString(3,uname);
				ps.setString(4, password);
				ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			result = "Error in creating account.";
		}
		return result;

	}

}

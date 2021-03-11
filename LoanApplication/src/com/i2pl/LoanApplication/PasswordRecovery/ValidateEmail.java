package com.i2pl.LoanApplication.PasswordRecovery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.i2pl.LoanApplication.Constants.Constant;

/**
 * A class to Validate emails, passwords and usernames accordingly with the requests.
 */

public class ValidateEmail {
	
	/**
	 * Validates the existence of the given email id and username in the database.
	 *
	 * @param uname user name of the client. 
	 *
	 * @param to email id of the client.
	 *
	 * @return {@code true} if and only if the password matches and email exists.
	 * 
	 * @exception SQLException  if the request for connection to database is not handled.
	 * 
	 * @exception ClassNotFoundException if the requested class is not found.
	 *
	 */
	public boolean Password(String uname,String to)throws SQLException
	{
		String check = "";
		Connection con = null;
		String sql = "select Email from sql12373181.field_officials where User_name='"+uname+"'";
		try {
			Class.forName(Constant.DB_DRIVER);
			con = DriverManager.getConnection(Constant.DB_URL, Constant.DB_NAME, Constant.DB_PASSWORD);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		Statement st = null;
		try {
			st = con.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			st.executeQuery(sql);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = st.getResultSet();
		if (rs.next()) {
			check = rs.getString(1);
		}
		st.close();
		if (check.equals(to)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 *
	 * @param pass new password accepted from the user.
	 *
	 * @param password confirm password to be same with the new password
	 *
	 * @return {@code true} if and only if both the parameters matches.
	 * 
	 * @exception SQLException  if the request for connection to database is not handled.
	 * 
	 * @exception ClassNotFoundException if the requested class is not found.
	 *
	 */
	
	public boolean validate(String pass,String password) {
		if (!password.equals(pass)) {
			return false;
			
		} else {
			Connection con = null;
			String email = forgotpassword.to;
			String sql = "update sql12373181.field_officials set Password='"+pass+"' where Email='"+email+"'";
			try {
				Class.forName(Constant.DB_DRIVER);
				con = DriverManager.getConnection(Constant.DB_URL,Constant.DB_NAME,Constant.DB_PASSWORD);
			} catch (ClassNotFoundException e) {
				System.out.println(e);//e.printStackTrace();e.printStackTrace();
			} catch (SQLException e) {
				System.out.println(e);//e.printStackTrace();e.printStackTrace();
			}

			Statement st = null;
			try {
				st = con.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
	}
}


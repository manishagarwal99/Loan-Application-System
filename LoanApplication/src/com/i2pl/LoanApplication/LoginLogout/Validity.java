package com.i2pl.LoanApplication.LoginLogout;
import java.sql.*;

import com.i2pl.LoanApplication.Constants.Constant;

/**
 * Validates the login credentials of Field Offcials by looking it up on the database.
 */

public class Validity {
	
	/**
	 * Looks up on the database for a particular user name, fetches the passwords and 
	 * checks if the user given password matches to it or not.
	 * 
	 * @param uname username for login.
	 *
	 * @param pass password for login.
	 *
	 * @return {@code true} if password matches and {@code false} if does not. 
	 * 
	 * @exception SQLException  if the request for connection to database is not handled.
	 * 
	 * @exception ClassNotFoundException if the requested class is not found.
	 *
	 */
	
	public boolean Password(String uname,String pass)throws SQLException
	{
		String check = "";
		Connection con = null;
		String sql = "select Password from sql12373181.field_officials where User_name='"+uname+"'";
		try {
			Class.forName(Constant.DB_DRIVER);
			con = DriverManager.getConnection(Constant.DB_URL,Constant.DB_NAME,Constant.DB_PASSWORD);
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
		if (check.equals(pass)) {
			return true;
		} else {
			return false;
		}

	}
}

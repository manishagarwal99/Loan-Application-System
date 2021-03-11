package com.i2pl.LoanApplication.PasswordRecovery;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.i2pl.LoanApplication.Constants.Constant;

/**
 * Fetches the user request and Validates the email and user name to change the password.
 * 
 * When the client sends the request to this servlet, it calls the password function 
 * to validate it and redirects it to the OTP validation page.
 */

@WebServlet("/forgotpassword")
public class forgotpassword extends HttpServlet {
	
	/** use default serialVersionUID for interoperability */
	private static final long serialVersionUID = 1L;
	public static String to;
	
	/**
	 * Called by the server to allow a servlet to handle a POST request.
	 *
	 * The HTTP POST method allows the client to send data of unlimited length to
	 * the Web server a single time and is useful when posting information.

	 * Fetches the email and user name and initiates the searching of it in the database.
     * If validated it redirects the user to validate the OTP.
     * 
	 * @param request  an {@link HttpServletRequest} object that contains the
	 *                 request the client has made of the servlet
	 *
	 * @param response an {@link HttpServletResponse} object that contains the
	 *                 response the servlet sends to the client
	 *
	 * @return Nothing.
	 * 
	 * @exception IOException      if an input or output error is detected when the
	 *                             servlet handles the request
	 *
	 * @exception ServletException if the request for the POST could not be handled
	 *
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
    	ValidateEmail obj = new ValidateEmail();
        to = request.getParameter("user");
        HttpSession session = request.getSession(true);
    	int i = new Random().nextInt(900000) + 100000;
    	String otp =Integer.toString(i);
        session.setAttribute("otp", otp);
        session.setAttribute("name","password-changer");
        String uname = request.getParameter("uname");
        try {
			if(obj.Password(uname,to)==true) {
				
				MailSender.send(to,Constant.EMAIL_SUBJECT,Constant.EMAIL_MAIN_BODY+ i,Constant.EMAIL_FROM,Constant.EMAIL_PASSWORD);
				session.setAttribute("mailSent","Mail sent successfully.");
		        response.sendRedirect("otpValidate.jsp");
			}
			else {
				session.setAttribute("mailSent","User not found.");
		        response.sendRedirect("email.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        

	}
}


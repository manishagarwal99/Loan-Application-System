package com.i2pl.LoanApplication.PasswordRecovery;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.i2pl.LoanApplication.Encryption.MD5Encryption;

/**
 * Fetches the user request and Validates the password and confirm password to change the password.
 * 
 * When the client sends the request to this servlet, it calls the validate function 
 * to validate it and update the password in the data base.
 */

@WebServlet("/ConfirmMatch")
public class ConfirmMatch extends HttpServlet {
	
	/** use default serialVersionUID for interoperability */
	private static final long serialVersionUID = 1L;
	/**
     * Called by the server to
     * allow a servlet to handle a GET request.
     *
     * Fetches the email and user name and initiates the searching of it in the database.
     * If validated it redirects the user to change the password.
     *  
     * @param request   an {@link HttpServletRequest} object that
     *                  contains the request the client has made
     *                  of the servlet
     *
     * @param response  an {@link HttpServletResponse} object that
     *                  contains the response the servlet sends
     *                  to the client
     *
     * @exception IOException   if an input or output error is
     *                              detected when the servlet handles
     *                              the GET request
     *
     * @exception ServletException  if the request for the GET
     *                                  could not be handled
     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MD5Encryption encryption = new MD5Encryption();
		String pass = encryption.getEncryption(request.getParameter("pass"));
		String password = encryption.getEncryption(request.getParameter("password"));
		ValidateEmail obj = new ValidateEmail();
		boolean result = obj.validate(pass, password);
		if (result == false) {
		} else {
			response.sendRedirect("Validpassword.jsp");
		}
	}
	
	/**
	 * Called by the server to allow a servlet to handle a POST request.
	 *
	 * The HTTP POST method allows the client to send data of unlimited length to
	 * the Web server a single time and is useful when posting information.

	 * Calls doGet.
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		

	}
}

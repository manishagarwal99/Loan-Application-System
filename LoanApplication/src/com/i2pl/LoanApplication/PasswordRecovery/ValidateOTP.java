package com.i2pl.LoanApplication.PasswordRecovery;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Checks if the OTP entered by the user is valid or not and displays an error
 * message if the verification fails. If the verification is successful the user
 * is redirected to set the new password.
 */

@WebServlet("/ValidateOTP")
public class ValidateOTP extends HttpServlet {
	
	/** use default serialVersionUID for interoperability */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Called by the server to allow a servlet to handle a POST request.
	 *
	 * The HTTP POST method allows the client to send data of unlimited length to
	 * the Web server a single time and is useful when posting information.
	 * 
	 * Checks if the OTP entered by the user is valid or not. Displays an error
	 * message if the verification fails.
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		String otp_gen=(String)session.getAttribute("otp");
		String otp = request.getParameter("otp");
		if(otp_gen.equals(otp))
		{
		session.setAttribute("result1","not null");
		response.sendRedirect("passwordVal.jsp");
		}
		else
		{
			session.setAttribute("mailSent","Invalid OTP. Please try again.");
			response.sendRedirect("otpValidate.jsp");
		}
	}
}

package com.i2pl.LoanApplication.FillApplication;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Fetches the Loan application details and stores it to the live database.
 * 
 * When the client sends the request to this servlet, it initiates the submition procedure 
 * of the application details into the database.
 */

@WebServlet("/CollectData")
public class CollectData extends HttpServlet {
	
	/** use default serialVersionUID for interoperability */
	private static final long serialVersionUID = 1L;
    
	/**
     * Called by the server
     * to allow a servlet to handle a POST request.
     *
     * The HTTP POST method allows the client to send
     * data of unlimited length to the Web server a single time
     * and is useful when posting information.
     *
     * Fetches the Loan application details and initiates the storing procedure into the live database.
     *
     * @param request   an {@link HttpServletRequest} object that
     *                  contains the request the client has made
     *                  of the servlet
     *
     * @param response  an {@link HttpServletResponse} object that
     *                  contains the response the servlet sends
     *                  to the client
     *
     * @return Nothing.
     * 
     * @exception IOException   if an input or output error is
     *                              detected when the servlet handles
     *                              the request
     *
     * @exception ServletException  if the request for the POST
     *                                  could not be handled
     *
     */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date=request.getParameter("date");
		String name = request.getParameter("name");
		String address = request.getParameter("add");
		String number =request.getParameter("number");
		String pan = request.getParameter("pan");
		String aadhar = request.getParameter("aadhar");
		int loan = Integer.parseInt( request.getParameter("loan"));
		Applicant applicant = new Applicant(date,name,address,number,pan,aadhar,loan);
		Registerdb applications = new Registerdb();
		String result = applications.insert(applicant);
		HttpSession session = request.getSession(false);
		session.setAttribute("result",result);
		response.sendRedirect("Loan_applicant.jsp");
		
	}

}

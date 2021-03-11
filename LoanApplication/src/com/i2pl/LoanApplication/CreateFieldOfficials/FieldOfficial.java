package com.i2pl.LoanApplication.CreateFieldOfficials;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.i2pl.LoanApplication.Encryption.MD5Encryption;

/**
 * Fetches the Field Official credentials and stores it to the live database.
 * 
 * When the client sends the request to this servlet, it initiates the submition procedure 
 * of the credentials into the database.
 */

@WebServlet("/FieldOfficial")
public class FieldOfficial extends HttpServlet {
	
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
     * Fetches the Field Official credentials and initiates the storing procedure into the live database.
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
		response.setContentType("text/html; charset=ISO-8859-1");
		MD5Encryption encryption = new MD5Encryption();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String uname =request.getParameter("uname");
		String password = encryption.getEncryption(request.getParameter("password"));
        PrintWriter out = response.getWriter();
		try{
				Accounts account = new Accounts(name,email,uname,password);
				Createdb accountFieldOfficial = new Createdb();
				String result = accountFieldOfficial.insert(account);
				HttpSession session = request.getSession(false);
				session.setAttribute("result",result);
				response.sendRedirect("fieldofficial_form.jsp");
			
		}

		catch(Exception e){
			HttpSession session = request.getSession(false);
			session.setAttribute("result","Error in creating account.");
			response.sendRedirect("fieldofficial_form.jsp");
		}
		finally {
			out.close();
		}
	}

}

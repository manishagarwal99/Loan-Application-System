package com.i2pl.LoanApplication.LoginLogout;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.i2pl.LoanApplication.Constants.Constant;
import com.i2pl.LoanApplication.Encryption.MD5Encryption;

/**
 * Fetches the Login credentials of Admin and Field Officials and
 * validates it by looking up the database or prepolulated credentials
 * 
 * When the client sends the request to this servlet, it initiates the validation procedure, the redirects the user to the desired page.
 */

@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	
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
     * Fetches the login credentials. If validated ,redirects the user to desired page.
     * Otherwise shows an error message.
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Validity check=new Validity();
		MD5Encryption encryption = new MD5Encryption();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String name = request.getParameter("user");
            String password = encryption.getEncryption(request.getParameter("pass"));
            
            if(name.equals(Constant.ADMIN_ID) && password.equals(Constant.ADMIN_PASSWORD))
            {
            	HttpSession session = request.getSession(true);
	            session.setAttribute("name", name);
	            response.sendRedirect("Admin_main.jsp");
            }
            else
            {
            	HttpSession session = request.getSession(true);
            	try {
					if(check.Password(name, password))
					{
			            session.setAttribute("name", name);
			            response.sendRedirect("Loan_applicant.jsp");
					}
					else
					{
						 session.setAttribute("result","Could not login. Please try again.");
		                 RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		                 rd.include(request, response);
		                 session.invalidate();					}
					 
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        }
        finally {            
            out.close();
        }
        
    }
}
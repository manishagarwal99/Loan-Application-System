package com.i2pl.LoanApplication.LoginLogout;

/**
 * Invalidates the ongoing session when the user requests to logout.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
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
     * Invalidates the ongoing session and redirects the user to the Login page.
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
		 HttpSession session = request.getSession();
		 session.removeAttribute("name");
		 session.removeAttribute("flag");
         session.invalidate();
         response.sendRedirect("index.jsp");
	}

}

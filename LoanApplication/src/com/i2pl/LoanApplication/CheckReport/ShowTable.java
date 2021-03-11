
package com.i2pl.LoanApplication.CheckReport;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Fetches the user request and shows the required loan reports with JQuery Data Tables.
 * 
 * When the client sends the request to this servlet, it processes the button request and displays the report accordingly
 * on the same page. 
 */

@WebServlet("/ShowTable")
public class ShowTable extends HttpServlet {
	
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
     * Processes the button request ,fetches the loan reports and display it in the same page with Jquery data tables.
     *
     *
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

		String result1 = "";
		String result2="";
		String act_datewise="active";
		String act_month="";
		String act_daterange="";
		StoreData store = new StoreData();
		PrintWriter out = response.getWriter();

		if (request.getParameter("ibutton1") != null) {
			String date = request.getParameter("idate");
			String[] result = store.data1(date, "invalid");
			result1 = result[0];
			act_datewise="active";
			act_month="";
			act_daterange="";
			
			// out.print(result[0]);
		} else if (request.getParameter("ibutton2") != null) {
			String month = request.getParameter("imonth");
			String[] result = store.data2(month, "invalid");
			result1 = result[0];
			act_datewise="";
			act_month="active";
			act_daterange="";
			// out.print(result[0]);
		} else if (request.getParameter("ibutton3") != null) {
			String start = request.getParameter("istart");
			String end = request.getParameter("iend");
			String[] result = store.data3(start, end, "invalid");
			result1 = result[0];
			act_datewise="";
			act_month="";
			act_daterange="active";
			// out.print(result[0]);
		} else if (request.getParameter("vbutton1") != null) {
			String date = request.getParameter("vdate");
			String[] result = store.data1(date, "valid");
			result1 = result[0];
			act_datewise="active";
			act_month="";
			act_daterange="";
			// out.print(result[0]);
		} else if (request.getParameter("vbutton2") != null) {
			String month = request.getParameter("vmonth");
			String[] result = store.data2(month, "valid");
			result1 = result[0];
			act_datewise="";
			act_month="active";
			act_daterange="";
			// out.print(result[0]);
		} else if (request.getParameter("vbutton3") != null) {
			String start = request.getParameter("vstart");
			String end = request.getParameter("vend");
			String[] result = store.data3(start, end, "valid");
			result1 = result[0];
			act_datewise="";
			act_month="";
			act_daterange="active";
			// out.print(result[0]);
		} else if (request.getParameter("abutton1") != null) {
			String date = request.getParameter("adate");
			String[] result = store.data1(date, "valid");
			result2 = result[1];
			act_datewise="active";
			act_month="";
			act_daterange="";
			//out.print(result[1]);
		} else if (request.getParameter("abutton2") != null) {
			String month = request.getParameter("amonth");
			String[] result = store.data2(month, "valid");
			result2 = result[1];
			act_datewise="";
			act_month="active";
			act_daterange="";
			//out.print(result[1]);
		} else if (request.getParameter("abutton3") != null) {
			String start = request.getParameter("astart");
			String end = request.getParameter("aend");
			String[] result = store.data3(start, end, "valid");
			result2 = result[1];
			act_datewise="";
			act_month="";
			act_daterange="active";
			//out.print(result[1]);
		}
		HttpSession session = request.getSession(false);
		session.setAttribute("act_datewise",act_datewise);
		session.setAttribute("act_month",act_month);
		session.setAttribute("act_daterange",act_daterange);
		if(result1.equals("") && result2.equals(""))
		{
			if((request.getParameter("ibutton1") != null)||(request.getParameter("ibutton2") != null)||(request.getParameter("ibutton3") != null))
			{
				RequestDispatcher rs = request.getRequestDispatcher("/invalid.jsp");
				rs.include(request,response);
			}
			else if((request.getParameter("vbutton1") != null)||(request.getParameter("vbutton2") != null)||(request.getParameter("vbutton3") != null))
			{
				RequestDispatcher rs = request.getRequestDispatcher("/valid.jsp");
				rs.include(request,response);
			}
			else if((request.getParameter("abutton1") != null)||(request.getParameter("abutton2") != null)||(request.getParameter("abutton3") != null))
			{
				RequestDispatcher rs = request.getRequestDispatcher("/main.jsp");
				rs.include(request,response);
			}
			out.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "	<style type=\"text/css\">\r\n"
					+ "		#main-header{\r\n"
					+ "			text-align:center;\r\n"
					+ "			color:black;\r\n"
					+ "			padding:10px;\r\n"
					+ "		}\r\n"
					+ "\r\n"
					+ "	</style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<header id=\"main-header\">\r\n"
					+ "		<h2>"+"No data found!"+"</h2>\r\n"
					+ "	</header>"
					+ "</body>\r\n"
					+ "</html>");
			session.setAttribute("act_datewise","");
			session.setAttribute("act_month","");
			session.setAttribute("act_daterange","");
		}
		else if(result1 != "") {
			if((request.getParameter("ibutton1") != null)||(request.getParameter("ibutton2") != null)||(request.getParameter("ibutton3") != null))
			{
				RequestDispatcher rs = request.getRequestDispatcher("/invalid.jsp");
				rs.include(request,response);
			}
			else if((request.getParameter("vbutton1") != null)||(request.getParameter("vbutton2") != null)||(request.getParameter("vbutton3") != null))
			{
				RequestDispatcher rs = request.getRequestDispatcher("/valid.jsp");
				rs.include(request,response);
			}
		out.print("<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <!-- Required meta tags -->\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n"
				+ "\r\n"
				+ "    <!-- Bootstrap CSS -->\r\n"
				+ "    <link rel=\"stylesheet\"\r\n"
				+ "    href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\r\n"
				+ "    integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\"\r\n"
				+ "    crossorigin=\"anonymous\">\r\n"
				+ "    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css\"/>\r\n"
				+ "\r\n"
				+ "    <title>Check Report Table</title>\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				+ "    <p><br/></p>\r\n"
				+ "    <div class=\"container table-responsive\">\r\n"
				+ "    <table class=\"table table-stripped table-bordered table-hover\" id=\"mydata\">\r\n"
				+ "          <thead>\r\n"
				+ "             <tr>\r\n"
				+ "                 <th>Name</th>\r\n"
				+ "                 <th>Address</th>\r\n"
				+ "                 <th>Phone No.</th>\r\n"
				+ "                 <th>Pan No.</th>\r\n"
				+ "                 <th>Aadhar No.</th>\r\n"
				+ "                 <th>Loan Required</th>\r\n"
				+ "                 <th>Loan Eligible</th>\r\n"
				+ "                 <th>Date</th>\r\n"
				+ "              </tr>\r\n"
				+ "          </thead>\r\n"
				+ "          <tbody>\r\n"
				+               result1
				+ "          </tbody>\r\n"
				+ "     </table>\r\n"
				+ "   </div>\r\n"
				+ "\r\n"
				+ "    <!-- Optional JavaScript -->\r\n"
				+ "    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n"
				+ "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\r\n"
				+ "        integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\r\n"
				+ "        crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script\r\n"
				+ "        src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"\r\n"
				+ "        integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\"\r\n"
				+ "        crossorigin=\"anonymous\"></script>\r\n"
				+ "    \r\n"
				+ "    <script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.js\"></script>\r\n"
				+ "    <script>\r\n"
				+ "      $('#mydata').DataTable();\r\n"
				+ "    </script>\r\n"
				+"     <footer style=\"padding:20px;\"><br></footer>"
				+ "  </body>\r\n"
				+ "</html>");

		session.setAttribute("act_datewise","");
		session.setAttribute("act_month","");
		session.setAttribute("act_daterange","");
		}
		else{
			if((request.getParameter("abutton1") != null)||(request.getParameter("abutton2") != null)||(request.getParameter("abutton3") != null))
			{
				RequestDispatcher rs = request.getRequestDispatcher("/main.jsp");
				rs.include(request,response);
			}
			out.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "	<style type=\"text/css\">\r\n"
					+ "		#main-header{\r\n"
					+ "			text-align:center;\r\n"
					+ "			color:black;\r\n"
					+ "			padding:10px;\r\n"
					+ "		}\r\n"
					+ "\r\n"
					+ "	</style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<header id=\"main-header\">\r\n"
					+ "		<h2>"+result2+"</h2>\r\n"
					+ "	</header>"
					+ "</body>\r\n"
					+ "</html>");	

			session.setAttribute("act_datewise","");
			session.setAttribute("act_month","");
			session.setAttribute("act_daterange","");
		}
	}
}

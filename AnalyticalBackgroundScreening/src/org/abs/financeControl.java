package org.abs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class financeControl
 */
//@WebServlet("/financeControl")
public class financeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public financeControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setContentType is very important without it chrome will display html tags in browser and html wont apply
				response.setContentType("text/html");
				PrintWriter write = response.getWriter();
						
						//Grab values from the inventory form and store in variables
						
						//passing parameters to a servlett
						//int productId = 24;
						String TotalIncome = "test";
						request.setAttribute("TotalIncome",TotalIncome);
						response.sendRedirect("/AnalyticalBackgroundScreening/finance.html");
	}

}

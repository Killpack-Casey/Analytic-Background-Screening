package org.abs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteInventory
 */
//The @WebServlet must be removed when using web.xml servlet mapping
//@WebServlet("/deleteInventory")
public class deleteInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Grab id user specified for row deletion and pass it to deleteDb method in updateDb class
		try{		
		int deleteRow = Integer.parseInt(request.getParameter("delete"));
		updateDb.deleteDb(deleteRow);
		//If the user does not input anything or inputs invalid characters the program redirects to inventory page
		}catch(Exception ex){
				RequestDispatcher view = request.getRequestDispatcher("/InventoryView");
				view.forward(request, response);
		}
	}

}

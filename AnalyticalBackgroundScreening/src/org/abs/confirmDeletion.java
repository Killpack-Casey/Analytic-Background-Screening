package org.abs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class confirmDeletion
 */
//@WebServlet("/confirmDeletion")
public class confirmDeletion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Calls method from updateDb to delete all information in the inventory table
		updateDb.deleteEntire();
		
		//Redirect after deletion to the inventory view page
		RequestDispatcher view = request.getRequestDispatcher("/InventoryView");
		view.forward(request, response);
	}
}

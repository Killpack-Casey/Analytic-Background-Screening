package org.abs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InventoryView
 */
/*
 * This servlet queries entire database and displays it to the user. The user also has the option to delete information
 * from the database
 */
//Do not need @WebServlet if specified in the web.xml
//@WebServlet("/InventoryView")
public class InventoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setContentType is very important without it chrome will display html tags in browser and html wont apply
		response.setContentType("text/html");
		PrintWriter write = response.getWriter();
		
		//Print HTML elements to the page
		write.println("<link rel=stylesheet type=text/css href=style.css>");
		write.println("<ul>");
		write.println("<li><a href=\"Home.html\">Home</a></li>");
		write.println("<li><a href=\"inventoryForm.html\">Submit Inventory</a></li>");
		//write.println("<li><a href=\"finance.html\">Go to budget</a></li>");
		//write.println("<li><a href=\"customers.html\">Customers</a></li>");
		write.println("<li><a href=\"InventoryView\">Go to Inventory</a></li>");
		write.println("</ul>");
		write.println("<p>----------------------------------------------------------------------------------------------------</p>");
		
		write.println("<form method=\"post\" action=\"deleteInventory\">");
		write.println("Specify Product ID For Deletion: <input name=\"delete\">");
		write.println("<input type=\"submit\">");
		write.println("</form>");
		
		write.println("<form method=\"post\" action=\"deleteAllInventory\">");
		write.println("Delete Entire Inventory Database: <input type=\"submit\">");
		write.println("</form>");
		
		write.println("<p>----------------------------------------------------------------------------------------------------</p>");
		
		
		//Creates the graphical table of information for the user
		write.println("<table style=width:100%>");
		write.println("<tr>");
		write.println("<th>Product Id</th>");
		write.println("<th>Sku</th>");
		write.println("<th>Product Name</th> ");
		write.println("<th>Price</th>");
		write.println("<th>Product Amount</th>");
		write.println("<th>Date Checked In</th>");
		write.println("<th>Location</th>");
		write.println("<th>Shipping</th>");
		write.println("</tr>");
		
		
		//Queries database from a method in the updateDb class
		updateDb.queryDb();
		
		//create list to hold inventory objects, representing our rows
		List <inventory> item;
		item = updateDb.items;
		
		//Loop through all inventory objects and print out contents to the graphical table displayed to the user
		for (inventory result : item){
			System.out.println("Object: " + result);
			write.println("<tr>");
			write.println("<td>" + result.productId + "</td>");
			write.println("<td>" + result.sku + "</td>");
			write.println("<td>" + result.productName + "</td>");
			write.println("<td>" + result.price + "</td>");
			write.println("<td>" + result.amount + "</td>");
			write.println("<td>" + result.dateIn + "</td>");
			write.println("<td>" + result.locationIn + "</td>");
			write.println("<td>" + result.shipping + "</td>");
			
			write.println("</tr>");
			
			}
		write.println("</table>");
	
	
	
	
	}

}

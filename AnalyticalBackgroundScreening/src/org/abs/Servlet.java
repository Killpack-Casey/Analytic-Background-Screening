package org.abs;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.hibernate.sql.Select;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class servlet
 */
//Do not need @WebServlet if specified in the web.xml
//@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//setContentType is very important without it chrome will display html tags in browser and html wont apply
		response.setContentType("text/html");
		PrintWriter write = response.getWriter();
				
				//Grab values from the inventory form and store in variables
				try{
				//passing parameters to a servlett
				//int productId = 24;
				String sku = request.getParameter("sku");
				String productName = request.getParameter("productName");
				double price = Double.parseDouble(request.getParameter("price"));
				int amount = Integer.parseInt(request.getParameter("amount"));
				String dateIn = request.getParameter("dateIn");
				String locationIn = request.getParameter("locationIn");
				String shipping = request.getParameter("shipping");
				
				//pass variables from user input to updateDb to save to the database
				try{
				//Add values to database
				updateDb.database(/*productId,*/ sku, productName, price, amount, dateIn, locationIn, shipping);
				} catch(Exception ex){
					//catch error when saving to database and display error page
					write.println("<h1>Database not updated.</h1>");
					write.println(ex.getMessage());
				}
				}
				catch(Exception e){
				//display error page if something goes wrong getting user input
				write.println("<h1>Error!</h1>");
				write.println("<p>Please fill out all fields in the form.</p>");
				write.println("<a href=\"inventoryForm.html\">Go Back To Inventory Form</a>");
				//write.println(e.getMessage());
				
				//breaks out of program
				return;
				}
				
				//print out results verification
				write.println("<link rel=stylesheet type=text/css href=style.css>");
				write.println("<h2>Product Successfully Added to Inventory!!!</h2>");
				write.println("<p>----------------------------------------------------------------------------------------------------</p>");
				
				//form to allow user to delete specific items from the inventory table
				write.println("<form method=\"post\" action=\"deleteInventory\">");
				write.println("Specify Product ID For Deletion: <input name=\"delete\">");
				write.println("<input type=\"submit\">");
				write.println("</form>");
				
				//Construct graphical table to be shown to user
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
				
				//query the database
				updateDb.queryDb();
				
				//store results in a list
				List <inventory> item;
				item = updateDb.items;
				
				//print out graphical table rows
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
				write.println("<a href=\"inventoryForm.html\">Submit More Inventory</a>");
	
	}

}

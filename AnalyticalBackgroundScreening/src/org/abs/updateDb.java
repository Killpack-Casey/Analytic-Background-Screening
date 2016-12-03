package org.abs;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.Statement;

public class updateDb {
	
	//Results of query stored in this list of objects
	public static List<inventory> items;
	
//------------------------------------------Query entire inventory table-------------------------------------------------//
	
	public static void queryDb(){
	//create sessionFactory
    SessionFactory sessionFactory = 
    		new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(inventory.class).buildSessionFactory();
    
    //Open new session of the sessionFactory object
    Session session = sessionFactory.getCurrentSession();
  	session = sessionFactory.getCurrentSession();
	session.beginTransaction();
	
	//Happy Path: query the customers, query all object in database from the CustomerDetails table
	items = session.createQuery("from inventory").list();
			
	//Happy Path: display all customer objects
	System.out.println("--------------------------------------------------------------------------------------------------");
	System.out.println("Printing out query contents....");
	for (inventory result : items){
	//System.out.println("Object: " + result);
	}
	
}
	
	//------------------------------------------Delete from inventory table-------------------------------------------------//
	
		//Pass in product id of the row being deleted
		public static void deleteDb(int deleteId){
		//create sessionFactory
	    SessionFactory sessionFactory = 
	    		new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(inventory.class).buildSessionFactory();
	    
	    //Open new session of the sessionFactory object
	    Session session = sessionFactory.getCurrentSession();
	  	session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//Delete from the inventory table where the product id is what the user specified
		session.createQuery("delete from inventory where product_id= " + deleteId).executeUpdate();
		
		//Commit deletion
		session.getTransaction().commit();
		
	}
		
		//------------------------------------------Delete entire inventory table-------------------------------------------------//
		
			//Pass in product id of the row being deleted
			public static void deleteEntire(){
			//create sessionFactory
		    SessionFactory sessionFactory = 
		    		new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(inventory.class).buildSessionFactory();
		    
		    //Open new session of the sessionFactory object
		    Session session = sessionFactory.getCurrentSession();
		  	session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//Delete from the inventory table where the product id is what the user specified
			session.createQuery("delete from inventory").executeUpdate();
			
			//Commit deletion
			session.getTransaction().commit();
			
		}

	
	//------------------------------------------Set up database to use-------------------------------------------------//
	 //------------------------------------------And add to database-------------------------------------------------//
		
	public static void database(/*int productId,*/ String sku, String productName, double price, int amount, String dateIn,
			String locationIn, String shippingMethod){
	
			//Connect to database
			//dbConnect.connectDatabase();
	    
	    //create sessionFactory
	    SessionFactory sessionFactory = 
	    		new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(inventory.class).buildSessionFactory();
	    
	    //Open new session of the sessionFactory object
	    Session session = sessionFactory.getCurrentSession();
	  	session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	    
		//create object from InventoryDb class and set its attributes
	    inventory inventory = new inventory();
	    //inventory.setId(productId);
	    inventory.setSku(sku);
	    inventory.setProductName(productName);
	    inventory.setPrice(price);
	    inventory.setAmount(amount);
	    inventory.setDateIn(dateIn);
	    inventory.setLocationIn(locationIn);
	    inventory.setShipping(shippingMethod);
		
		//Save the inventory object to database
		session.save(inventory);
		
		//Need to commit and close transaction
		session.getTransaction().commit();
		
		
		
			}
}

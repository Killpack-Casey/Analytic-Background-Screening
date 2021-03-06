package org.abs;

/*
 * inventory class to create inventory java objects to be used in the databasse
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class inventory {
	
	//@Id tells the procuctId will be the Primary key of the object
	//I want this to be self generating
		@Id
		@Column(name = "product_id")
		public int productId;
		
		@Column(name="sku")
		public String sku;
		
		@Column(name="product_name")
		public String productName;
		
		@Column(name="price")
		public double price;
		
		@Column(name="amount")
		public int amount;
		
		@Column(name="date_in")
		public String dateIn;
		
		@Column(name="location_in")
		public String locationIn;
		
		@Column(name="shipping_method")
		public String shipping;
		
		
		public int getId(){
			return productId;
		}
		
		public void setId(int productId){
			this.productId = productId;
		}
		
		public String getSku(){
			return sku;
		}
		
		public void setSku(String sku){
			this.sku = sku;
		}	
			
		public String getProductName(){
				return productName;
		}
			
		public void setProductName(String productName){
				this.productName = productName;		
		}
		
		public double getPrice(){
			return price;
		}
		
		public void setPrice(double price){
			this.price = price;		
		}
		
		public int getAmount(){
			return amount;
		}
		
		public void setAmount(int amount){
			this.amount = amount;		
		}
		
		public String getDateIn(){
			return dateIn;
		}
		
		public void setDateIn(String dateIn){
			this.dateIn = dateIn;		
		}
		
		public String getLocationIn(){
			return locationIn;
		}
		
		public void setLocationIn(String locationIn){
			this.locationIn = locationIn;		
		}
		
		public String getShipping(){
			return shipping;
		}
		
		public void setShipping(String shipping){
			this.shipping = shipping;		
		}

		@Override
		public String toString() {
			return "Inventory [productId=" + productId + ", sku="
					+ sku + ", productName=" + productName + ", price="
					+ price + ", amount=" + amount + ", dateIn=" + dateIn
					 + ", locationIn=" + locationIn+ ", shipping=" + shipping + "]";
		}
		
	}

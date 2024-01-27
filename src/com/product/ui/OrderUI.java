package com.product.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.product.Service.CustomerServiceImpl;
import com.product.Service.OrderServiceImpl;
import com.product.entity.Cart;
import com.product.entity.Customer;
import com.product.entity.Order;

public class OrderUI {
	private String orderId;
	private LocalDate orderDate;
	private String dropLocation;
	private LocalDateTime expectedDelivery;
	private String customerid;
	private Double billingAmount;
	private String status;
	
	boolean flag;

	Order o=null;
	OrderServiceImpl oimpl=new OrderServiceImpl();
	List<Order>olist=null;
	
	

	public void orderMenu(String customerid, List<Cart> clist) {
		
		Customer cust =new CustomerServiceImpl().getCustomerById(customerid);
		System.out.print("  *****   *****    *****   *    *   *****   *   *      *****   *****   *    *   *****   *****\r\n"
				+ "");
		System.out.print("    *     *   *    *       * *  *   *   *    * *         *       *     **  **   *       *\r\n"
				+ "");

		System.out.print("    *     *****    *****   *  * *   *   *     *          *       *     *  * *   *****   *****\r\n"
				+ "");

		System.out.print("    *     *  *     *       *   **   *   *     *          *       *     *    *   *           *\r\n"
				+ "");

		System.out.print("    *     *    *   *****   *    *   *****     *          *     *****   *    *   *****   *****   \r\n"
				+ "");
		

		System.out.println("\n Welcome to the Order Page "+cust.getcustomername()+" !!!");
	
		int option ;
		Scanner sc=new Scanner(System.in);
		String ans;

		  Double grandTotal=0.0;
			for( Cart cart:clist)
					
					{
						System.out.println("Cart id: "+cart.getCartId());
						System.out.println("Item added: "+cart.getW().getwatchName());
						System.out.println("Price: "+cart.getPrice());
						System.out.println("quantity: "+cart.getQuantity());
						System.out.println("subtotal: "+cart.getSubtotal());
						
						grandTotal+=cart.getSubtotal();
						System.out.println("__________________________________");
					}
					System.out.println("Grand total="+grandTotal);
			   
		
	while(true) {
		System.out.println("\nEnter 1----> Place Order ");
		System.out.println("Enter 2----> Cancel my Order");
		System.out.println(" Enter 3----> Show my Order history ");
		System.out.println(" Enter 4-----> show order by id ");
		System.out.println("Enter 5------>Go to main menu");
		System.out.println("_________________________________________________________________");

		option=sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		case 1:
			int min = 500;  
			int max = 400; 				
			int b = (int)(Math.random()*(max-min+1)+min);

			orderId="OR"+b;
			
			orderDate=LocalDate.now();
			
			System.out.println("\nDo you want to deliver at the below given address ???");
			System.out.println(cust.getcustomer_address());
			System.out.println("\nAnswer in yes or no");
			
			ans=sc.nextLine();
			if(ans.equalsIgnoreCase("yes")) {
				
				dropLocation=cust.getcustomer_address();
			}
			
			else if(ans.equalsIgnoreCase("no")) {
				System.out.println("Enter your dropLocation :--");
			dropLocation=sc.nextLine();
			}
			else 
			
				System.out.println("\nPlease answer in yes or no only !!! Going back to main menu");
			
			expectedDelivery=LocalDateTime.now().plusHours(1);
			
			billingAmount=grandTotal;
			status="\nProcessing...";
			
			o=new Order(orderId, orderDate, dropLocation, expectedDelivery, customerid, billingAmount, status);
			
			Order order=oimpl.placeOrder(o);
			if(order!=null) {
				System.out.println("\nYour order has been placed .Details given below...");
			System.out.println("\nOrder number: "+order.getOrderId());
			System.out.println("Drop location :  "+order.getDropLocation());
			
			DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy HH:mm");
			LocalDateTime delivery =order.getExpectedDelivery();
			
			System.out.println("Delivered by: "+delivery.format(pattern));
			System.out.println(" Billing amount :"+billingAmount);
			System.out.println("status"+order.getStatus());
			System.out.println("_________________________________________________________________");

			return;
			
			}
			else 
				System.out.println("Error while placing order ");
			break;
			
		case 2:
		System.out.println("\nEnter the order Id  to be cancelled");
		orderId=sc.nextLine();
		
	flag=oimpl.cancelOrder(orderId);
	
	if(flag) 
	System.out.println("\nYour order has been cancelled");
	
	else 
		System.out.println("Error while cancelling your order. try again later...");
		
			break;
		case 3:
			olist=oimpl.showMyOrderHistory(customerid);
			if(olist!=null && olist.isEmpty()!=true) {
				for(Order o1:olist) {
					System.out.println("\nYour order has been placed .Details given below...");
					System.out.println("Order number: "+o1.getOrderId());
					System.out.println("Drop location :  "+o1.getDropLocation());
					
					DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy HH:mm");
					LocalDateTime delivery =o1.getExpectedDelivery();
					
					System.out.println("Delivered by: "+delivery.format(pattern));
					System.out.println(" Billing amount :"+o1.getBillingAmount());
					System.out.println("status"+o1.getStatus());
					System.out.println("____________________________________________________");
					return;
				}
			}
			break;
		case 4:
			System.out.println("\nEnter the order id :");
		orderId=sc.nextLine();
		
		o=oimpl.showOrderById(orderId);
		if(o!=null) {
			
			System.out.println("Your order has been placed .Details given below...");
			System.out.println("Order number: "+o.getOrderId());
			System.out.println("Drop location :  "+o.getDropLocation());
			
			DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd-LLL-yyyy HH:mm");
			LocalDateTime delivery =o.getExpectedDelivery();
			
			System.out.println("Delivered by: "+delivery.format(pattern));
			System.out.println(" Billing amount :"+o.getBillingAmount());
			System.out.println("status"+o.getStatus());
			System.out.println("_________________________________________________________________");
		}
		else
			System.out.println("No order found with this id..");
			break;
		case 5:
			System.out.println("\n Going  back to the main menu...");
			break;
			
			default: System.out.println("Please enter the number as given in the menu..");
		             }
             	}
	
	}
}

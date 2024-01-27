package com.product.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.product.Service.CustomerServiceImpl;
import com.product.entity.Customer;


public class CustomerUI {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String customerid;
		 String customername ;
		 String customer_phone;
		 String customer_address; 
		 String custEmail;
		 String password;
		 Boolean flag;

		 Customer c =null;
		 CustomerServiceImpl cimpl =new CustomerServiceImpl();
			List<Customer> clist=null;
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
			
			System.out.println("**********Customer page************");
			while(true) {
				System.out.println("Enter 1--------> Register  Customer details");
				System.out.println("Enter 2--------> Update Customer details");
				System.out.println("Enter 3--------> Delete Customer details");
				System.out.println("Enter 4--------> Show Customer details");
				System.out.println("Enter 5--------> Show customer details using CustomerId");

				Integer option=sc.nextInt();
				sc.nextLine();
				
				switch(option) {
				
				case 1:
					
				
				System.out.println("\nEnter the details as given below  :-");
				
				System.out.println("Enter email id: ");
				String custEmail1=sc.nextLine();
				String letter=custEmail1.substring(1, 3);
				
				Integer i=custEmail1.length();
				customerid="C"+letter+i;

				System.out.println("Enter your name  ");
				customername=sc.nextLine();
				
				System.out.println("Enter your phone number ");
				customer_phone=sc.next();
				sc.nextLine();
				
				
				System.out.println("Enter your  Residential address");
				customer_address=sc.nextLine();
				
				
				
				
				System.out.println("Enter your email address ");
				custEmail=sc.nextLine();
				
				
				System.out.println("please enter your password  the watch--");
				password=sc.nextLine();
				

              c=new Customer(customerid,customername,customer_phone,customer_address,
		      custEmail,password);
				
				flag=cimpl.addCustomer(c);
				
				if(flag)
					System.out.println("customer  details are added to database....");
				else
					System.out.println("Error while adding customer details...");
				

				break;

				
	
				
			case 2:
				break;
				
			case 3:
				System.out.println("Enter the customerid you want to delete");
				customerid=sc.nextLine();
                c=cimpl.getCustomerById(customerid);
                if(c!=null) {
                	System.out.println("***Customer  Details***");
                	System.out.println(c);
                	
                	System.out.println("Are you sure you want to delete this Customer item??"
			                  +"\nAnswer in yes or no");
	
	String ans=sc.next();
	sc.nextLine();
	if(ans.equalsIgnoreCase("yes")) {
		flag=cimpl.deleteCustomer(c);
		
		if(flag) {
			System.out.println("Customer deleted successfully");
		}
			else
				System.out.println("error while deleting the Customer");
		
		}else if(ans.equalsIgnoreCase("no"))
			System.out.println("Please answer in yes and no only!! back to the main menu..");
		
	}
	else
		System.out.println(" No Customer item with this id is found !!!");
				break;
				
			case 4:
				clist=cimpl.showAllCustomer();
				if(clist!=null && clist.isEmpty()!=true) {
					Iterator<Customer> it=clist.iterator();
					
					while(it.hasNext()) {
						System.out.println(it.next());
						System.out.println("___________________________________________________");
					}
				}
				else
					System.out.println("No data available for customer details at this moment!!!");
											
							break;
							
							case 5:
								System.out.println("Enter the id of the Customer you want to show: ");
								customerid=sc.nextLine();

								c=cimpl.getCustomerById(customerid);

								if(c!=null) {
									System.out.println(c);
									
								}
								break;
								
							default : System.out.println("Please enter only those numbers as mentioned in start");

								
			}	
				
			}
	



}
	
}

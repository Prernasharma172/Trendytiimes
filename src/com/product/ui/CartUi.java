package com.product.ui;

import java.util.List;
import java.util.Scanner;

import com.product.Service.*;
import com.product.entity.Cart;
import com.product.entity.Customer;
import com.product.entity.Watch;

public class CartUi {

	public static void main(String[] args) {
		  String cartId;
	      String watchId;
	      String customerid ;
		  Integer quantity;// the number of watch items added to cart.
		  double subtotal;// price* quantity
	      double  price;// watch price 
	      
		   Watch w;
		   Boolean flag;
		  String ans;
		  
		  int num=2;
		   int option;
		   
		  Scanner sc= new Scanner(System.in);
		  Cart c= null;
		  CartService wimpl=new CartServiceImpl();
		  List<Cart>wlist =null;
		  while (true) {
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
				System.out.println("                    \n||Login Details||");

			  System.out.print("\n\nEnter  your  userName i.e your id:");
			  String  username=sc.nextLine().trim();
			  System.out.print("Enter Password:");
			  String password=sc.nextLine();
			  String login =new LoginUI().login(username,password);
			  if (login==null)
				  System.out.println("username or password is  given  is wrong . please  login agian");
			  else if (login.equals("customer"))
				  /*
					 * Fetching the customer object from the database by using the
					 * showCustomerById/getDetailsById method of CustomerServiceImpl
					 */
	{
				  Customer cust = new CustomerServiceImpl().getCustomerById(username);
				  
				  
				  System.out.print("\nwelcome to our  website  "+cust.getcustomername()+" Hope you like our services and visit again");
			        System.out.println("\u263A");

				  boolean logout=false;
				  while(logout==false) {
					  
					   System.out.println("\nEnter  the number  as given  in option ...");
					   System.out.println("Enter  1--->  Add to cart");
					   System.out.println("Enter  2--->  Show my  cart");
					   System.out.println("Enter  3--->  update  quantity of  watch item ");
					   System.out.println("Enter  4--->  Delete watch  item  from cart");
					   System.out.println("Enter  5--->  Clear  my cart");
					   System.out.println("Enter  6---> See order menu");
					   System.out.println("Enter  7--->  Logout");
					   System.out.println("_______________________________________________________________________________________________________________________");
					   option=sc.nextInt();
					   sc.nextLine();
					   
					   
					   switch(option) {
					   case 1 :
						   
						  // System.out.println("Enter your  contact numer");
						 //   String  contact=sc.nextLine();
						/*  String  contact=cust.getContactNo().toString();
						   cartId="CA"+contact.substring(0,5)+num;
						   num+=2;*/
						   int min = 100;  
							int max = 400; 				
							int b = (int)(Math.random()*(max-min+1)+min);

	cartId="CA"+b;
						   
						   List<Watch> flist=new WatchServiceImpl().showAllwatch();
System.out.println("________________________________________________________________________________________");
						   System.out.println("\nwatch name and watch id show below");
						   for(Watch f1:flist) {
							   System.out.println(f1.getwatchName()+" : "+f1.getwatchId());
						   }
						   System.out.println("________________________________________________________________________________________");

						   System.out.println("\nEnter  the watch id");
						   watchId=sc.nextLine();
						   
						   
						   customerid=username;
						   flag=wimpl.checkwatchItem(customerid, watchId);
						   
						if(flag)
							System.out.println("Item was already present in your cart. "+"Quantity has been increased by 1..");
						else

						{
						   quantity=1;
						   price = new WatchServiceImpl().getWatchById(watchId).getPrice();
						   subtotal=quantity*price;
						   c=new Cart(cartId,watchId,customerid,quantity,subtotal,price);
						  flag = wimpl.addToCart(c);
						  if(flag)
							  System.out.println("watch items added to cart succesfully..!");
						  else 
							  System.out.println("error while added in watch items to cart..!");
						   
			
						   
						}  
						   break;
					   case 2 :
						   customerid = username;
						   wlist=wimpl.showMyCart(customerid);
						   
						   if(wlist!=null && wlist.isEmpty()!=true) {
							   
							   System.out.println("____Your Cart Details Are as Mentioned Below_____\r\n");
							   
							   Double grandTotal=0.0;
						for( Cart cart:wlist)
								
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
						   
								System.out.println("\nDo you want go to  order page? Answer in yes or no...");
								ans=sc.nextLine();
								
								if(ans.equalsIgnoreCase("yes")) {
									
									new OrderUI().orderMenu(customerid, wlist);	
									}
								else if(ans.equalsIgnoreCase("no"))
									System.out.println("Thank you for you input. Continue browsing....");
								else
									System.out.println("Please answer in yes or no only!!Going back to main menu");
						   }
						   else
							   System.out.println("Your cart is empty...please add to cart first....");
						   break;
						   
					   case 3 :
						   System.out.println("Enter the cart id:  ");
						cartId=sc.nextLine();
						
						c=wimpl.getCartById(cartId);
						if(c!=null) {
						System.out.println("Cart id: "+c.getCartId());
						System.out.println("Item added: "+c.getW().getwatchName());
						System.out.println("Price of single item: "+c.getPrice());
						System.out.println("quantity in cart: "+c.getQuantity());
						System.out.println("subtotal : "+c.getSubtotal());
						
						System.out.println("Enter new quantity: ");
						quantity=sc.nextInt();
						sc.nextLine();
						if(quantity>0) {
						flag=wimpl.updateQuantity(cartId, quantity);
						
						if(flag)
							System.out.println("Quantity updated successfully!!!");
						else
							System.out.println("error while changing quantity!!!");
						}
						else
							System.out.println("Please give a number greater than 0 for quantity");
						}
						   break;
						   
					   case 4 :
						   System.out.println("Enter the cartid of item to be deleted...");
						   cartId=sc.nextLine();
						   
						   System.out.println(" Are you sure you want to delete the item from the cart" + "\n ans in 'yes' or 'no' ");
						   ans=sc.nextLine();
						   
						   if(ans.equalsIgnoreCase("yes")) {
							   
							  flag=wimpl.deletewatchItemFromcart(cartId);
							  if(flag) 
								  System.out.println("Item deleted successfully ..");
							  else
								  System.out.println("Error while deleting the item from the cart");
							
						   }
						   
						   else if (ans.equalsIgnoreCase("no"))
							   System.out.println(" Thank you for your input ..please continue browsing..");
						   else
							   System.out.println("Answer in yes or no only . Going back to main menu..");
						   
						   
						   break;
						   
					   case 5 :
						   customerid=username;
						   System.out.println(" Are you sure you want to delete the cart" + "\n ans in 'yes' or 'no' ");
						   ans=sc.nextLine();
						   
						   if(ans.equalsIgnoreCase("yes")) {
							   
							  flag=wimpl.clearMyCart(customerid);
							  
							  if(flag) 
								  System.out.println("The cart is now empty..");
							  else
								  System.out.println("Error while clearing  the cart");
							
						   }
						   
						   else if (ans.equalsIgnoreCase("no"))
							   System.out.println(" Thank you for your input ..please continue browsing..");
						   else
							   System.out.println("Answer in yes or no only . Going back to main menu..");
						   						   break;
						   
					   case 6:
						   customerid=username;
						   wlist=wimpl.showMyCart(customerid);
						   new OrderUI().orderMenu(customerid, wlist);
						 
						   break;
					   case 7:
						   logout=true;
						   System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						   System.out.println("+        Thankyou for using our services..Visit again soon!!!     +");
						   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n");
						   

						   break;
					    
					   default : System.out.println("pls enter the  number as mention above");
					   				   			   
					   			  
					   					   }
					   
				  }
				  
			  }
			  else if (login.equals("admin")) {
				  System.out.println("you have  logged  in as admin\n ");
				
				  boolean logout=false;
				  while(logout==false) { 
					  System.out.println("Enter the number as given in options ..");
				  System.out.println("Enter 1----->show all cart items : ");
					System.out.println("Enter 2 ---> show cart by id: ");
					System.out.println("Enter 3 -----> logout ");
					
					option=sc.nextInt();
					sc.nextLine();
					 switch(option) {
					 case 1: 
						 wlist=wimpl.showAllCart();
						 if(wlist!=null && wlist.isEmpty()!=true) {
							 for( Cart cart:wlist)
									
								{
									System.out.println("Cart id: "+cart.getCartId());
									System.out.println("Customer id:"+cart.getcustomerid());
									System.out.println("Item added: "+cart.getW().getwatchName());
									System.out.println("Price: "+cart.getPrice());
									System.out.println("quantity: "+cart.getQuantity());
									System.out.println("subtotal: "+cart.getSubtotal());
								
								    System.out.println("____________________________________________________");
								}
							 
						 }
						 else
							 System.out.println("The cart is empty . no data is available at this moment!!!");
						
						 break;
						 
					 case 2: 
						 System.out.println("Enter the cart id:  ");
							cartId=sc.nextLine();
							
							c=wimpl.getCartById(cartId);
							if(c!=null) {
								System.out.println("Here are the details of the customer..");
							System.out.println("\nCart id: "+c.getCartId());
							System.out.println("Customer id:"+c.getcustomerid());
							System.out.println("Item added: "+c.getW().getwatchName());
							System.out.println("Price of single item: "+c.getPrice());
							System.out.println("quantity in cart: "+c.getQuantity());
							System.out.println("subtotal : "+c.getSubtotal());
							System.out.println();
							}
							else
								System.out.println("no cart with this id found ..");
						 break;
						 
					 case 3: 
						 logout=true;
						 System.out.println("Thank you for using our services . Visit again soon!!!");
						 break;
						 default : System.out.println(" please give inputs as the options given...");
						 
					 }//switch ends
					
				  }	// while ends
			  }//else if ends
			  
			  
		  }//outer while loop ends

	}//main method ends

}// class ends
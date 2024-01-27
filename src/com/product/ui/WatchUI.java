package com.product.ui;

import java.util.Iterator;

 // *****   *****    *****   *    *   *****   *   *      *****   *****   *    *   *****   *****
 //   *     *   *    *       * *  *   *   *    * *         *       *     **  **   *       *
 //   *     *****    *****   *  * *   *   *     *          *       *     *  * *   *****   *****
 //   *     *  *     *       *   **   *   *     *          *       *     *    *   *           *
 //   *     *    *   *****   *    *   *****     *          *     *****   *    *   *****   *****   
 
    
import java.util.List;
import java.util.Scanner;

import com.product.Service.WatchServiceImpl;
import com.product.entity.Watch;

public class WatchUI {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		String watchId;
		String watchName;
		String brand; 
		String category ; 
		Double price;
		Integer quantityInstock;
		 Boolean flag;
		
		Watch w=null;
		WatchServiceImpl wimpl=new WatchServiceImpl();
		List<Watch> wlist=null;
		System.out.println();
		

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

		while(true) {
			
			System.out.println("\nEnter the number as given in menu :-");
			System.out.println("Enter 1--------> Add watch item");
			System.out.println("Enter 2--------> Update watch item");
			System.out.println("Enter 3--------> Delete watch item");
			System.out.println("Enter 4--------> Show watch item");
			System.out.println("Enter 5--------> Search watch item on the basis of brand");
			System.out.println("Enter 6--------> Search watch item on the basis of category");
			
			Integer option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
			case 1:
				
				System.out.println("Enter email id: ");
				String email=sc.nextLine();
				String letter=email.substring(1, 3);
				
				Integer i=email.length();
				watchId="F"+letter+i;
				
				System.out.println("Enter the category of your desired watch\n");
				System.out.println("1:Analog Watches:  \r\n"
						+ "2: Digital Watches: \r\n"
						+ "3: Sports Watches: \r\n"
						+ "4:Luxury Watches: \r\n"
						+ "5:  Smartwatches ");
				System.out.println("________________________________________________________________________");
	Integer choice=sc.nextInt();
	sc.nextLine();
	
	switch(choice) {
	
	case 1: category="Analog Watches:";
	
	break;

	case 2: category="Digital Watches";
	
	break;
	
	case 3: category=" Sports Watches:";
	
	break;
	
	case 4: category="Luxury Watches:";
	break;
	
	case 5: category="Smartwatches:";
	
	
	System.out.println("________________________________________________________________________");

	break;
	
	default: System.out.println("Please enter only those numbers as given in"
	                                +"category menu");
				category="data unavailable";
	}
	
	System.out.println("Enter the category of your Brand watch\n");
	System.out.println("1.Apple\r\n"
			+ "2.Garmin\r\n"
			+ "3.Tag heuer\r\n"
			+ "4.Rolex \r\n"
			+ "5.Omega");
	System.out.println("________________________________________________________________________");
	Integer choice1=sc.nextInt();
	sc.nextLine();
switch(choice1) {
	
	case 1: brand="Apple :";
	System.out.println("Here's the collection of Apple");

	System.out.println("1. Apple Watch Series 9: \r\n"
			+ "2. Apple Watch Ultra 2: \r\n"
			+ "3. Apple Watch Series 3:.\r\n"
			+ "4. RApple Watch Series 6:\r\n"
			+ "5. Carbon Neutral \r\n"
			+ "");
	System.out.println("________________________________________________________________________");

	
	break;

	case 2: brand="Garmin ";
	System.out.println("Here's the collection of Garmin");
	System.out.println("1. Garmin Fenix 6: \r\n"
			+ "\r\n"
			+ "2. Garmin Forerunner 945: \r\n"
			+ "\r\n"
			+ "3. Garmin Vivoactive 4: \r\n"
			+ "\r\n"
			+ "4. Garmin Instinct: \r\n"
			+ "");
	System.out.println("________________________________________________________________________");

	break;
	
	case 3: brand=" TAG Heuer :";
	System.out.println("Here's the collection of TAG Heuer");

	System.out.println("1. TAG Heuer Carrera:\r\n "
			+ "2. TAG Heuer Aquaracer:\r\n"
			+ "3. TAG Heuer Monaco:\r\n "
		
			+ "4. TAG Heuer Formula 1: \r\n ");
	System.out.println("________________________________________________________________________");

	break;
	
	case 4: brand="Rolex :";
	System.out.println("Here's the collection of Rolex");

	System.out.println("1. Rolex Submariner: \r\n"
			+ "2. Rolex Daytona: \r\n"
			+ "3. Rolex Datejust:.\r\n"
			+ "4. Rolex GMT-Master II:\r\n"
			+ "5. Rolex Day-Date: \r\n"
			+ "");
	System.out.println("________________________________________________________________________");

	break;
	
	case 5: brand="Omega :";
	System.out.println("Here's the collection of Omega");

	System.out.println("1. Omega Seamaster:\\r\\n "
			
			+ "2. Omega Speedmaster:\\r\\n"
			+ "3. Omega Constellation: \\r\\n"
			+ "4. Omega De Ville:\\r\\n"
			+ "");
	System.out.println("________________________________________________________________________");

	
	System.out.println("________________________________________________________________________");

	break;
	
	default: System.out.println("Please enter only those numbers as given in"
	                                +"brand menu");
	brand="data unavailable";
	}
	
	System.out.println("Enter the watch name you want to buy of  the above brand");
	watchName=sc.nextLine();
	
	
				System.out.println("Enter price: ");
				price=sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Quantity in stock: ");
				quantityInstock=sc.nextInt();
				sc.nextLine();
				
				w=new Watch(watchId, watchName, brand, category, price, quantityInstock);
				
				flag=wimpl.addWatch(w);
				if(flag)
					System.out.println("watch details addes to database....");
				else
					System.out.println("Error while adding watch details...");
				
				break;
				
			
				
			case 2:
				
				System.out.println("Enter the id of the watch you want to update: ");
				watchId=sc.nextLine();
				
				w=wimpl.getWatchById(watchId);
				
				if(w!=null) {
					System.out.println(w);
					
					System.out.println("Are you sure you want to update this watch item??"
							                  +"\nAnswer in yes or no");
					
					String ans=sc.next();
					sc.nextLine();
					
					if(ans.equalsIgnoreCase("yes")) {
						
						System.out.println("What do you want to update?");
						System.out.println("Enter a----> update name \nEnter b----> update brand"
								   +"\nEnter c----> update category  \nEnter d----> update price \nEnter e----> update quantity");
						
						char choice2=sc.next().toLowerCase().charAt(0);
						sc.nextLine();
						
						switch(choice2) {
						
						case 'a':
							System.out.println("Enter name: ");
							watchName=sc.nextLine();
							w.setwatchName(watchName);
							
							flag=wimpl.updateWatch(w);
							if(flag)
								System.out.println("watch name updated successfully!!!");
							else
							System.out.println("Error while updating watch name!!!");
							break;
							
						case 'b':
							System.out.println("Enter the Brand of the watch...");
							brand=sc.nextLine();
							
							w.setbrand(brand);
							
							
							flag=wimpl.updateWatch(w);
							if(flag)
								System.out.println("watch Brand updated successfully!!!");
							else
								System.out.println("Error while updating watch brand!!!");
							
							break;
							
						case 'c':
							
							System.out.println("Enter category: \n1:Analog Watches:  \n2: Digital Watches:"
				                     +" \n3: Sports Watches: \n4:Luxury Watches: \n5:  Smartwatches ");
							choice=sc.nextInt();
							sc.nextLine();
							
														
				
								switch(choice) {
				
								case 1: category="Analog Watches:";
								break;
				
								case 2: category="Digital Watches";
								break;
								
								case 3: category="Sports Watches:";
								break;
								
								case 4: category="Luxury Watches:";
								break;
								
								case 5: category="Smartwatches:";
								break;
								
								default: System.out.println("Please enter only those numbers as given in"
								                                +"category menu");
											category="data unavailable";
								}
								w.setCategory(category);
								
								flag=wimpl.updateWatch(w);
								if(flag)
									System.out.println("watch name updated successfully!!!");
								else
									System.out.println("Error while updating watch category!!!");
								
							break;
							
						case 'd':
							
							System.out.println("Enter price: ");
							price=sc.nextDouble();
							sc.nextLine();
							
							w.setPrice(price);
							
							flag=wimpl.updateWatch(w);
							if(flag)
								System.out.println("watch name updated successfully!!!");
							else
								System.out.println("Error while updating watch price!!!");
							
							break;
							
						case 'e':
							
							System.out.println("Quantity in stock: ");
							quantityInstock=sc.nextInt();
							sc.nextLine();
							
							w.setQuantityInstock(quantityInstock);
							
							flag=wimpl.updateWatch(w);
							if(flag)
								System.out.println("watch name updated successfully!!!");
							else
								System.out.println("Error while updating watch quantity!!!");
							
							break;
							
							default:System.out.println("Please enter characters as mentioned above in update menu!!!");
								
						}
					}
					else if (ans.equalsIgnoreCase("no")) {}
					else
						System.out.println("Please answer in yes or no only. Going back to main menu");
					
				}
				else
					System.out.println("No watch item with this id found.\n Please check the id given...");
				
				
				
				break;
				
			case 3:
				
				System.out.println("Enter the watchId you want to delete");
				watchId=sc.nextLine();
                w=wimpl.getWatchById(watchId);
                if(w!=null) {
                	System.out.println("***watch Details***");
                	System.out.println(w);
                	
                	System.out.println("Are you sure you want to delete this watch item??"
			                  +"\nAnswer in yes or no");
	
	String ans=sc.next();
	sc.nextLine();
	if(ans.equalsIgnoreCase("yes")) {
		flag=wimpl.deleteWatch(w);
		
		if(flag) {
			System.out.println("watch deleted successfully");
		}
			else
				System.out.println("error while deleting the watch");
		
		}else if(ans.equalsIgnoreCase("no"))
			System.out.println("Please answer in yes and no only!! back to the main menu..");
		
	}
	else
		System.out.println(" No watch item with this id is found !!!");
                
				break;
				
			case 4:
				
				wlist=wimpl.showAllwatch();
				if(wlist!=null && wlist.isEmpty()!=true) {
					Iterator<Watch> it=wlist.iterator();
					
					while(it.hasNext()) {
						System.out.println(it.next());
						System.out.println("___________________________________________________");
					}
				}
				else
					System.out.println("No data available for watch details at this moment!!!");
				
				
				
				break;
				
			case 5:
				
				break;
				
			case 6:
				
				break;
			
				
			default: System.out.println("Please enter only those numbers as mentioned in start");
			
			break;
			
			}
			
		}

	}
}




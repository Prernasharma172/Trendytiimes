package com.product.ui;

import com.product.Service.LoginServiceImpl;

public class LoginUI {
 public String login(String username,String password) {
	 
	 boolean flag;
	 
	 LoginServiceImpl limpl= new LoginServiceImpl();
	 
	  if (limpl.customerLogin(username,password)) {
		  return "customer";
		  
		  
	  }
	  else if (limpl.adminLogin(username, password)) {
		  return "admin";
		  
	  }

	 return null;
	 
 }
}
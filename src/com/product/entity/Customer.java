package com.product.entity;

public class Customer {

	private String customerid;
	private String customername ;
	private String customer_phone;
	private String customer_address; 
	
	private String custEmail;
	private String password;
	
	
	
	public Customer() {
		super();
	}
	public Customer(String customerid, String customername , String customer_phone,String customer_address,  String custEmail, String password) {
		super();
		this.customerid=customerid;
		this.customername=customername;
		this.customer_phone=customer_phone;
		this.customer_address=customer_address;
		this.custEmail=custEmail;
		this.password=password;
	}
	public String getcustomerid() {
		return customerid;
	}
	
	public void setcustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getcustomername( ) {
		return customername;
	}
	
	public void setcustomername(String customername) {
		this.customername = customername;
	}
	public String getcustomer_phone( ) {
		return customer_phone;
	}
	
	public void setcustomer_phone(String  customer_phone) {
		this.customer_phone = customer_phone;
	}
	
	public String getcustomer_address( ) {
		return customer_address;
	}
	
	public void setcustomer_address(String customer_address) {
		this.customer_address= customer_address;
	}
	
	
	
	public String getpassword( ) {
		return password;
	}
	public void setpassword( String password) {
		this.password=password;
	}
	
	public String getcustEmail() {

		return custEmail;
	}
	public void setcustEmail(String custEmail) {
		this.custEmail=custEmail;
	}
	public String toString() {
		return "\n[customerid = "+customerid +  "\ncustomerName = " + customername + " \ncustomer_phone ="
	+customer_phone +	"\ncustomer_address = " +customer_address
	+ "\ncustEmail = " +custEmail + "\npassword = " +password;
		
	}
	



	
	
	

}

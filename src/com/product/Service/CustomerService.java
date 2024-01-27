package com.product.Service;

import java.util.List;

import com.product.entity.Customer;

public interface CustomerService {

	public boolean addCustomer(Customer c);
	public List<Customer> showAllCustomer();
	public Customer getCustomerById(String customerid);
     public boolean deleteCustomer(Customer c);
 	public boolean updateCustomer(Customer c);



}

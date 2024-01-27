package com.product.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.entity.Customer;
import com.product.utility.DBConnection;

public class CustomerServiceImpl implements CustomerService{
	
	Connection con=null;
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	


	@Override
	public boolean addCustomer(Customer c) {
try {
	con=DBConnection.makeConnection();
	sql="insert into customers values(?, ?, ?, ?, ?, ?)";
	ps=con.prepareStatement(sql);
	ps.setString(1, c.getcustomerid());
	ps.setString(2, c.getcustomername());
	ps.setString(3, c.getcustomer_phone());
	ps.setString(4, c.getcustomer_address());
	ps.setString(5, c.getcustEmail());
	ps.setString(6, c.getpassword());
	
	int i=ps.executeUpdate();
	if(i>0)
		return true;
}
	catch(Exception e) {
		
	}
finally {
	try {
		ps.close();
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
		return false;
	}



	@Override
	public List<Customer> showAllCustomer() {
		try{
			con=DBConnection.makeConnection();
			sql="select * from customers " ;
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			List<Customer> clist=new ArrayList<Customer>();
			while(rs.next()) {
				Customer c=new Customer();
				c.setcustomerid(rs.getString("customerid"));
				c.setcustomername(rs.getString("customername"));
				c.setcustomer_phone(rs.getString("customer_phone"));
				c.setcustomer_address(rs.getString("customer_address"));
				c.setcustEmail(rs.getString("custEmail"));
				c.setpassword(rs.getString("password"));

				clist.add(c);
				
				
			}
return clist;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}



	@Override
	public Customer getCustomerById(String customerid) {
		
		con=DBConnection.makeConnection();
		sql="select * from customers where customerid=?" ;
		
		
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, customerid);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				Customer c=new Customer();
				c.setcustomerid(rs.getString("customerid"));
				c.setcustomername(rs.getString("customername"));
				c.setcustomer_phone(rs.getString("customer_phone"));
				c.setcustomer_address(rs.getString("customer_address"));
				c.setcustEmail(rs.getString("custEmail"));
				c.setpassword(rs.getString("password"));

				return c;
			}
		
		

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}



	@Override
	public boolean deleteCustomer( Customer c) {

		con=DBConnection.makeConnection();
		sql="delete from customers  where customerid=?";
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, c.getcustomerid());
			
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return false;
	}



	@Override
	public boolean updateCustomer(Customer c) {
		con=DBConnection.makeConnection();
		sql="update customers set customername=?, customer_phone=?, customer_address=?, custEmail=?, password=? where customerid=?";
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(6, c.getcustomerid());
			ps.setString(1, c.getcustomername());
			ps.setString(2, c.getcustomer_phone());
			ps.setString(3, c.getcustomer_address());
			ps.setString(4, c.getcustEmail());
			ps.setString(5, c.getpassword());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
				return false;
	}

}

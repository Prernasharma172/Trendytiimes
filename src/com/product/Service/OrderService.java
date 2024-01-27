package com.product.Service;

import java.util.List;

import com.product.entity.Order;

public interface OrderService {

	public Order placeOrder(Order o);
	public boolean cancelOrder( String orderId);
	
	public List<Order> showMyOrderHistory(String customerid);
	public Order showOrderById (String orderId);
}

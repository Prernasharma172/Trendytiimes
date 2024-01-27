package com.product.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * we can have cartlist in this class so as to know what has to be delivered to each customer.
 * Mapping of List type collection with MySql is easy with Hibernate . since we have not completed Hibernate 
 * this part needs to be done later; after the said Hibernate portion is done
 */
	

public class Order {
	private String orderId;
	private LocalDate orderDate;
	private String dropLocation;
	private LocalDateTime expectedDelivery;
	private String customerid;
	private Double billingAmount;
	private String status;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, LocalDate orderDate, String dropLocation, LocalDateTime expectedDelivery,
			String customerid, Double billingAmount, String status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.dropLocation = dropLocation;
		this.expectedDelivery = expectedDelivery;
		this.customerid = customerid;
		this.billingAmount = billingAmount;
		this.status = status;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getDropLocation() {
		return dropLocation;
	}
	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}
	public LocalDateTime getExpectedDelivery() {
		return expectedDelivery;
	}
	public void setExpectedDelivery(LocalDateTime expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public Double getBillingAmount() {
		return billingAmount;
	}
	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", dropLocation=" + dropLocation
				+ ", expectedDelivery=" + expectedDelivery + ", customerid=" + customerid + ", billingAmount="
				+ billingAmount + ", status=" + status + "]";
	}
	
	

}

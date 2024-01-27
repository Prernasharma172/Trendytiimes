package com.product.entity;

public class Cart {

	private String cartId;
	private String watchId;
	private String customerid;
	private Integer quantity; //the number of watch item added to cart 
	private Double subtotal;//price * quantity
	private Double price;// price of watch item
	
	private Watch w;
	public Watch getW() {
		return w;
	}
	public void setW(Watch w) {
		this.w = w;
	}
	public Cart() {
		super();
	}
	public Cart(String cartId, String watchId, String customerid, Integer quantity, Double subtotal, Double price) {
		super();
		this.cartId = cartId;
		this.watchId = watchId;
		this.customerid = customerid;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.price = price;
	}
	
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getwatchId() {
		return watchId;
	}

	public void setwatchId(String watchId) {
		this.watchId = watchId;
	}

	public String getcustomerid() {
		return customerid;
	}

	public void setcustomerid(String customerid) {
		this.customerid = customerid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + "\nwatchId=" + watchId + "\n customerid=" + customerid + "\n quantity=" + quantity
				+ "\n subtotal=" + subtotal + "\n price=" + price + "]";
	}

	
}

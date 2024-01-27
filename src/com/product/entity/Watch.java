package com.product.entity;

public class Watch {

	private String watchId;
	private String watchName;
	private String brand; 
	private String category; 
	private Double price;
	private Integer quantityInstock;
	
	public Watch() {
		super();
	}
	public Watch(String watchId, String watchName, String brand, String category, Double price, Integer quantityInstock) {
		super();
		this.watchId = watchId;
		this.watchName = watchName;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.quantityInstock = quantityInstock;
	}
	
	public String getwatchId() {
		return watchId;
	}
	
	public void setwatchId(String watchId) {
		this.watchId = watchId;
	}
	
	public String getwatchName() {
		return watchName;
	}
	
	public void setwatchName(String watchName) {
		this.watchName = watchName;
	}
	
	public String getbrand() {
		return brand;
	}
	
	public void setbrand(String brand) {
		this.brand = brand;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getQuantityInstock() {
		return quantityInstock;
	}
	
	public void setQuantityInstock(Integer quantityInstock) {
		this.quantityInstock = quantityInstock;
	}
	
	@Override
	public String toString() {
		return "\n[watchId=" + watchId + "\nwatchName=" + watchName + "\nbrand=" + brand + "\ncategory=" + category
				+ "\nprice=" + price + "\nquantityInstock=" + quantityInstock + "]\n ";
	}
	
	
}

package com.scp.java.EcommerceProductOperations;

public class Products implements Cloneable{
	private String product_id;
	private String name;
	private int price;
	private String product_decsription;
	private String categorty;
	private int stock;
	public Products clone() throws CloneNotSupportedException{
		
		return (Products)super.clone();
	}
	
	public Products(String product_id, String name, int price, String product_decsription, String categorty,int stock) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.price = price;
		this.product_decsription = product_decsription;
		this.categorty = categorty;
		this.stock=stock;
	}
	
	@Override
	public String toString() {
		return "\n         product_id=" + product_id + ", name=" + name + ", price=" + price + ", product_decsription="
				+ product_decsription + ", categorty=" + categorty + ", stock=" + stock;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProduct_decsription() {
		return product_decsription;
	}
	public void setProduct_decsription(String product_decsription) {
		this.product_decsription = product_decsription;
	}
	public String getCategorty() {
		return categorty;
	}
	public void setCategorty(String categorty) {
		this.categorty = categorty;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	

}

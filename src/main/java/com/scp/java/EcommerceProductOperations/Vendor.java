package com.scp.java.EcommerceProductOperations;

import java.util.Arrays;
import java.util.*;

public class Vendor {
	private String vendor_id;
	private String vendor_name;
	private ArrayList<Products> products_list;
	private Account account_details;
	public Vendor(String vendor_id, String vendor_name,ArrayList<Products> products_list, Account account_details) {
		super();
		this.vendor_id = vendor_id;
		this.vendor_name = vendor_name;
		this.products_list = products_list;
		this.account_details = account_details;
	}
	
	@Override
	public String toString() {
		return "\n\nVendor Details\nvendor_id=" + vendor_id + "\nvendor_name=" + vendor_name + "\naccount_details=" + account_details+ "\nproducts="+ products_list
				;
	}

	public String getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public ArrayList<Products> getProducts_list() {
		return products_list;
	}
	public void setProducts_list(ArrayList<Products> products_list) {
		this.products_list = products_list;
	}
	public Account getAccount_details() {
		return account_details;
	}
	public void setAccount_details(Account account_details) {
		this.account_details = account_details;
	}
	

}

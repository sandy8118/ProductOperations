package com.scp.java.EcommerceProductOperations;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.*;
@Entity
@Table(name="Vendor")
public class Vendor {
	@Id
	private String vendor_id;
	private String vendor_name;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Products> products_list;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Account account_details;
	public Vendor(){
		
	}
	public Vendor(String vendor_id, String vendor_name,List<Products> products_list, Account account_details) {
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
	public List<Products> getProducts_list() {
		return products_list;
	}
	public void setProducts_list(List<Products> products_list) {
		this.products_list = products_list;
	}
	public Account getAccount_details() {
		return account_details;
	}
	public void setAccount_details(Account account_details) {
		this.account_details = account_details;
	}
	

}

package com.scp.java.EcommerceProductOperations;
import java.util.*;
import java.lang.*;
public interface Shopping_Services {
	public void purchase_items(Vendor vendor_id,Customer cust_id,ArrayList p_id,ArrayList<Products> pl)throws LowAccountBalanceException;
    public void return_item(Vendor vendor,Customer cust,ArrayList p_id,ArrayList<Products> pl)throws LowAccountBalanceException;
    public void add_products();
    public void bank_balance(Vendor vendor,Customer  cust,int total_Amount);
    
}	
	
class Service_Implemetation implements Shopping_Services{
	public void purchase_items(Vendor vendor,Customer cust,ArrayList p_id,ArrayList<Products> pl)throws LowAccountBalanceException{
		int total_Amount=0;
		for(Products p:pl) {
			for(Object id:p_id) {
				String product_id=(String)id;
				if(p.getProduct_id().equals(product_id)) {
					
				//	System.out.println(p.getPrice());
					total_Amount=total_Amount+p.getPrice();	
				}
			}
		}
//	 	System.out.println(total_Amount);
		int cust_Balance=cust.getAccount_details().getBalance();
		int vendor_Balance=vendor.getAccount_details().getBalance();
		if(total_Amount>=cust_Balance) {
			
			throw new LowAccountBalanceException("PlsMaintainYourAccountBalance..");
		}
		else {
			
			  bank_balance(vendor,cust,total_Amount);
		      updateStock(p_id,pl);
		          
		}	
		
	}
    public void return_item(Vendor vendor,Customer cust,ArrayList p_id,ArrayList<Products> pl)throws LowAccountBalanceException {
    	int total_Amount=0;
		for(Products p:pl) {
			for(Object id:p_id) {
				String product_id=(String)id;
				if(p.getProduct_id().equals(product_id)) {
					
				//	System.out.println(p.getPrice());
					total_Amount=total_Amount+p.getPrice();	
				}
			}
		}
		
		int cust_Balance=cust.getAccount_details().getBalance();
		int vendor_Balance=vendor.getAccount_details().getBalance();
	if(total_Amount>=vendor_Balance) {
			
			throw new LowAccountBalanceException("PlsMaintainYourAccountBalance..");
		}
		else {
			
			  bank_balance(vendor,cust,-total_Amount);
		      updateStock(p_id,pl);
		          
		}	
	
    	
    }
    public void add_products() {
    	
    }
    public void bank_balance(Vendor vendor,Customer  cust,int total_Amount){
    	int cust_Balance=cust.getAccount_details().getBalance();
		int vendor_Balance=vendor.getAccount_details().getBalance();
    	cust.getAccount_details().setBalance(cust_Balance-total_Amount,null);
		vendor.getAccount_details().setBalance(vendor_Balance+total_Amount,null);
		
	  //   System.out.println(cust.getAccount_details().getBalance());
	   //  System.out.println(vendor.getAccount_details().getBalance());
    	
    }
	public void updateStock(ArrayList p_id,ArrayList<Products> pl) {
		for(Products p:pl) {
			for(Object id:p_id) {
				String product_id=(String)id;
				
				if(p.getProduct_id().equals(product_id)) {
					int oldStock=p.getStock();
					p.setStock(oldStock-1);
				
				}
				
			}
		}
		
		
	}
	
}
 

class LowAccountBalanceException extends Exception{
	public LowAccountBalanceException(String msg) {
		super(msg);
	} 
		
		
	}
	

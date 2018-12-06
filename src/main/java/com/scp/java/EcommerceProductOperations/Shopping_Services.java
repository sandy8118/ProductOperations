package com.scp.java.EcommerceProductOperations;
import java.util.*;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.lang.*;
public interface Shopping_Services {
	public void purchase_items(String vendor_id,String cust_id,List products_id)throws LowAccountBalanceException;
    public void return_item(Vendor vendor,Customer cust,List p_id,List<Products> pl)throws LowAccountBalanceException;
    public void add_products();
    public void bank_balance(String vendor_id,String cust_id,int total_Amount,Session session);    
}	
class Service_Implemetation implements Shopping_Services{
	public void purchase_items(String vendor_id,String cust_id,List p_id)throws LowAccountBalanceException{
	    int total_Amount=0;
		Session session=com.scp.java.HibernateUtil.HibernateUtilMethods.getSessionFactory().openSession();
		Vendor dbVendor=(Vendor)session.get(Vendor.class,vendor_id);
		List<Products> products=dbVendor.getProducts_list();
		Iterator itr=products.iterator();
		Iterator product_id_itr=p_id.iterator();
		while(product_id_itr.hasNext()){
		while(itr.hasNext()){
			Products prod=(Products)itr.next();
			if(prod.getProduct_id().equals(product_id_itr.next())){
				if(prod.getStock()==0){
					System.out.println(prod.getName()+" not available");
				   return;
				}
				total_Amount=total_Amount+prod.getPrice();
			}
		}
		}
		
		
		Customer dbCustomer=session.get(Customer.class,cust_id);
		int cust_Balance=dbCustomer.getAccount_details().getBalance();
		int vendor_Balance=dbVendor.getAccount_details().getBalance();
		if(total_Amount>=cust_Balance) {
			throw new LowAccountBalanceException("PlsMaintainYourAccountBalance..");
		}
		else {
			  bank_balance(vendor_id,cust_id,-total_Amount,session);
		      updateStock(vendor_id,p_id,session);
		}	
				}
    public void return_item(Vendor vendor,Customer cust,List p_id,List<Products> pl)throws LowAccountBalanceException {
    }
    public void add_products() {	
    }
    public void bank_balance(String vendor_id,String cust_id,int total_Amount,Session session){
        Transaction tr=session.beginTransaction(); 
    	Vendor updateVendor=session.get(Vendor.class,vendor_id);
    	Customer updateCust=session.get(Customer.class,cust_id);
        int cust_bal_old=updateCust.getAccount_details().getBalance();    
        updateCust.getAccount_details().setBalance(cust_bal_old+total_Amount,null);
        session.saveOrUpdate(updateCust);
        int vendor_bal_old=updateVendor.getAccount_details().getBalance();
        updateVendor.getAccount_details().setBalance(vendor_bal_old-total_Amount,null);
        session.saveOrUpdate(updateVendor);
        session.saveOrUpdate(updateCust);
        session.flush();
        tr.commit();
        System.out.println("transaction successful..");
    }

	public void updateStock(String vendor_id,List<Products> product_Id_List,Session session) {
		Transaction tr=session.beginTransaction();
		Vendor dbVendor=session.get(Vendor.class,vendor_id);
		List<Products> product_list=dbVendor.getProducts_list();
		
		Iterator p_id_itr=product_Id_List.iterator();
		while(p_id_itr.hasNext()){
			
			
			
		}
		
		/*for(Products p:pl) {
			for(Object id:p_id) {
				String product_id=(String)id;
				if(p.getProduct_id().equals(product_id)) {
					int oldStock=p.getStock();
					p.setStock(oldStock-1);
					}
			}
		}*/

	}
}
class LowAccountBalanceException extends Exception{
	public LowAccountBalanceException(String msg) {
     super(msg);
	} 
	}
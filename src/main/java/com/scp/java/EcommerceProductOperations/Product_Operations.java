package com.scp.java.EcommerceProductOperations;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class Product_Operations {

	public static void main(String[] args)throws CloneNotSupportedException{
		Products type1=new Products("101b","Laptop",54000,"Brand-Dell corei7,Model-4245b, RAM-8gb,HDD-1tb","electronics",5);
		Products type2=new Products("101w","Laptop",52000,"Brand-Dell corei7,Model-4245w, RAM-8gb,HDD-1tb","electronics",10);
		List<Products> products1=new ArrayList();
		products1.add(type1);
		products1.add(type2);
		Products type3=new Products("201","AC",34000,"Godrej,capacity-1233,model-asadad","electronics",5);
		Products type4=new Products("401","Fridge",52000,"brand-Whirpool","electronics",15);
		List<Products> products2=new ArrayList();
		products2.add(type3);			
		products2.add(type4);
		Account a1=new Account("Flipcart","123456789",350000);
		Account a2=new Account("Amazon","987654321",280000);
		Account ca1=new Account("Sandy","564332456",150000);
		List<Account> BankCustomers=new ArrayList();
		BankCustomers.add(a1);
		BankCustomers.add(a2);
		BankCustomers.add(ca1);
	    Vendor v1=new Vendor("655","Flipcart",products1,a1);
	    Vendor v2=new Vendor("544","Amazon",products2,a2);
	    
	    
	    
	    
	    long amount=0;
	    for(Account ac:BankCustomers) {
	    	amount=amount+ac.getBalance();
	    }
	    System.out.println(amount);
	    Bank SBI=new Bank("SBI1234",amount,BankCustomers); 
	    Address ad1=new Address("pune",411045);
	    Customer c1=new Customer("101","Sandy",ad1,"9422811118",ca1);
	    Session session1=com.scp.java.HibernateUtil.HibernateUtilMethods.getSessionFactory().openSession();
	    Transaction tr=session1.beginTransaction();
	    session1.save(v1);
	    session1.save(v2);
	    session1.save(c1);
	    session1.save(SBI);
	    session1.flush();
	    tr.commit();
        
	    System.out.println("succesfful");	    
	    Shopping_Services  ss=new Service_Implemetation ();
	    List<String> selected_items=new ArrayList<String>();
	    selected_items.add("101b".toString());
	    selected_items.add("101w".toString());
   	   /* System.out.println(c1);
        System.out.println(v1);
        System.out.println(SBI.getBank_funds());
       */
	    try{
	    ss.purchase_items(v1,c1,selected_items,v1.getProducts_list());
        }
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
        System.out.println(c1);
        System.out.println(v1);
        System.out.println(SBI.getBank_funds());
        c1.getAccount_details().setBalance(410000,SBI);
        System.out.println(SBI.getBank_customers());
	    System.out.println(SBI.getBank_funds());
	    v1.getAccount_details().setBalance(250000,SBI);   
	    System.out.println(SBI.getBank_funds());
	    System.out.println(SBI.getBank_customers());
	}

}

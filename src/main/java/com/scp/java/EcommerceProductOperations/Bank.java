package com.scp.java.EcommerceProductOperations;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;

@Entity
@Table(name="Bank")
public class Bank {
	@Id
	private String ifsc_code;
	private long bank_funds;
	@OneToMany
	private List<Account> bank_customers;
	public Bank(String ifsc_code, long bank_funds, List<Account> bank_customers) {
		super();
		this.ifsc_code = ifsc_code;
		this.bank_funds = bank_funds;
		this.bank_customers = bank_customers;
	}
	@Override
	public String toString() {
		return "\nBank \n ifsc_code=" + ifsc_code + "\n, bank_funds=" + bank_funds + "\n, bank_customers=" + bank_customers
				;
	}
	public String getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}
	public long getBank_funds() {
		return bank_funds;
	}
	public void setBank_funds(long bank_funds) {
		this.bank_funds = bank_funds;
	}
	public List<Account> getBank_customers() {
		return bank_customers;
	}
	public void setBank_customers(List<Account> bank_customers) {
		this.bank_customers = bank_customers;
	}
	public void update_Bank_Funds(Bank b) {
		/*List<Account> BankCustomers=b.getBank_customers();
		 long amount=0;
		    for(Account ac:BankCustomers) {
		    	amount=amount+ac.getBalance();
		    }
		    b.setBank_funds(amount);
		*/  
		Session session=com.scp.java.HibernateUtil.HibernateUtilMethods.getSessionFactory().openSession();
	       Bank bb=session.get(Bank.class,b.getIfsc_code());
	       List<Account> BankCustomers=bb.getBank_customers();
	       Iterator bankItr=BankCustomers.iterator();
	}	

}

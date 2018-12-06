package com.scp.java.EcommerceProductOperations;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	private String customer_id;
	private String customer_name;
	private Address address;
	private String Mob_number;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Account account_details;
	public Customer(String customer_id, String customer_name, Address address, String mob_number,
			Account account_details) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.address = address;
	Mob_number = mob_number;
		this.account_details = account_details;
	}
	@Override
	public String toString() {
		return "\nCustomer Details\ncustomer_id="+ customer_id + "\ncustomer_name=" + customer_name +"\naddress=" + address
				+ "\nMob_number=" + Mob_number + "\naccount_details=" +account_details+"]";
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getMob_number() {
		return Mob_number;
	}
	public void setMob_number(String mob_number) {
		Mob_number = mob_number;
	}
	public Account getAccount_details() {
		return account_details;
	}
	public void setAccount_details(Account account_details) {
		this.account_details = account_details;
	}
	

}
class Address{
	private String city;
	private int pin;
	public Address(String city, int pin) {
		super();
		this.city = city;
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", pin=" + pin + "]";
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
class Account{
	private String ho_name;
	private String account_Number;
	private int balance;
	public Account(String ho_name, String account_Number, int balance) {
		super();
		this.ho_name = ho_name;
		this.account_Number = account_Number;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [ho_name=" + ho_name + ", account_Number=" + account_Number + ", balance=" + balance + "]";
	}
	public String getHo_name() {
		return ho_name;
	}
	public void setHo_name(String ho_name) {
		this.ho_name = ho_name;
	}
	public String getAccount_Number() {
		return account_Number;
	}
	public void setAccount_Number(String account_Number) {
		this.account_Number = account_Number;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance,Bank b) {
		this.balance = balance;
		if(b==null) {
			return;
		}
		b.update_Bank_Funds(b);
	}
	
	
}

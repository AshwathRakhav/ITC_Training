package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.Table;

@Entity
@Table(name="Customer_Details")
public class Customer {
@Id
@GeneratedValue
private Integer customerid;
private String name;
private String mobno;
private String email;
private String address;

public Integer getCustomerid() {
	return customerid;
}
public void setCustomerid(Integer customerid) {
	this.customerid = customerid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobno() {
	return mobno;
}
public void setMobno(String mobno) {
	this.mobno = mobno;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Customer(Integer customerid, String name, String mobno, String email, String address) {
	super();
	this.customerid = customerid;
	this.name = name;
	this.mobno = mobno;
	this.email = email;
	this.address = address;
}
public Customer() {
	super();
}
@Override
public String toString() {
	return "Customer [customerid=" + customerid + ", name=" + name + ", mobno=" + mobno + ", email=" + email
			+ ", address=" + address + "]";
}

}

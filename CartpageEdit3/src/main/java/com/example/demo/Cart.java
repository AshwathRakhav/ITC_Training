package com.example.demo;

 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 

@Entity
public class Cart {

 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cust_id;
    private Long prod_id;
    private String name;
    private double price;
    private String category;
    private Integer quantity;
    private double total;
    
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCust_id() {
		return cust_id;
	}


	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}


	public Long getProd_id() {
		return prod_id;
	}


	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	

	public Cart(Long cust_id, Long prod_id, Integer quantity) {
		super();
		this.cust_id = cust_id;
		this.prod_id = prod_id;
		this.quantity = quantity;
	}


	public Cart() {
		super();
	}
    
    
	
}

 
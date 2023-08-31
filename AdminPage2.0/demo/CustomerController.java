package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private IcustomerService service;
	
	//1. to save the data
	@PostMapping("/register")
	public ResponseEntity<String> saveCourse(@RequestBody Customer c)
	{
		Integer id=service.savecustomer(c);
		ResponseEntity<String> resp=new ResponseEntity<String>("Customer "+id+" Generated",HttpStatus.CREATED);
		return resp;
	}
	
	@GetMapping("/all")
	public List<Customer> getAllCourse()
	{
		List<Customer> allCourse=service.AllCustomers();
		return allCourse;
		}
}

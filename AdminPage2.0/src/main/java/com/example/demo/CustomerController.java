package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/admin/customer")
public class CustomerController {
	@Autowired
	private IcustomerService service;
	
	@GetMapping("/all")
	public List<Customer> getAllCourse()
	{
		List<Customer> allCourse=service.AllCustomers();
		return allCourse;
		}
}

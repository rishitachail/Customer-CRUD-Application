package com.customerManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.customerManagement.entity.Customer;
import com.customerManagement.service.CustomerService;


import java.util.*;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/add_customer")
	public String addCustomer() {
		return "addCustomer";
	}
	
	@GetMapping("/customer_list")
	public ModelAndView getAllCustomer() {
		List<Customer>list=service.getAllCustomer();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("customerList","customer",list);
	}
	
	@PostMapping("/save")
	public String addCustomer(@ModelAttribute Customer c) {
		service.save(c);
		return "redirect:/customer_list";
	}
	
	@RequestMapping("/editCustomer/{id}")
	public String editCustomer(@PathVariable("id") int id,Model model) {
		Customer c=service.getCustomerById(id);
		model.addAttribute("customer",c);
		return "editCustomer";
	}
	@RequestMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/customer_list";
	}
	
}

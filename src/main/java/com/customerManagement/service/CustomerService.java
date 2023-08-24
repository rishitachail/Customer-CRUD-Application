package com.customerManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerManagement.entity.Customer;
import com.customerManagement.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository cRepo;
	
	public void save(Customer c) {
		cRepo.save(c);
	}
	
	public List<Customer> getAllCustomer(){
		return cRepo.findAll();
	}
	
	public Customer getCustomerById(int id) {
		return cRepo.findById(id).get();
	}
	public void deleteById(int id) {
		cRepo.deleteById(id);
	}
}

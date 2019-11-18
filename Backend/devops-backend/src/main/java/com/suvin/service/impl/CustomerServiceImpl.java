package com.suvin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suvin.dao.CustomerDao;
import com.suvin.model.Customer;
import com.suvin.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}

}

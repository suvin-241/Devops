package com.suvin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.suvin.common.GenericDaoImpl;
import com.suvin.dao.CustomerDao;
import com.suvin.model.Customer;

@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao{
	
	public CustomerDaoImpl() {
        super(Customer.class);
    }

	@Override
	public List<Customer> getCustomers() {
		return this.findAllAsList();
	}

}

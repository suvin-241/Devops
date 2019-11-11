package com.suvin.dao;

import java.util.List;

import com.suvin.common.GenericDao;
import com.suvin.model.Customer;

public interface CustomerDao extends GenericDao<Customer>{
	
	List<Customer> getCustomers();

}

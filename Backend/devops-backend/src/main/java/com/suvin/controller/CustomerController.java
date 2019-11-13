package com.suvin.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suvin.common.DevopsUtil;
import com.suvin.model.Customer;
//import com.suvin.service.CustomerService;

@RestController
@RequestMapping(value = "/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

//	@Autowired
//	private CustomerService customerservice;

	@GetMapping(value = "test")
	public String test() {

		return "Hello World";

	}

	@GetMapping(value = "getcustomer")
	public ResponseEntity<Map<String, Object>> getCustomers() {
		HttpStatus responseStatus;

		Map<String, Object> responseMap = new HashMap<>();
		try {

			List<Customer> custList=new ArrayList<>();
			
			Customer cust1=new Customer();
			cust1.setCustomerid(BigInteger.valueOf(1000L));
			cust1.setEmail("suvin241");
			cust1.setFirstname("suvin");
			cust1.setLastname("suyambu");
			cust1.setMobileno("9840110411");
			
			custList.add(cust1);
			responseMap.put(DevopsUtil.DATA,custList );
			responseMap.put(DevopsUtil.SUCCESS, true);
			responseStatus = HttpStatus.OK;
		} catch (Exception e) {

			responseMap.put(DevopsUtil.DATA, null);
			responseMap.put(DevopsUtil.SUCCESS, false);
			responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(responseMap, responseStatus);
	}

}

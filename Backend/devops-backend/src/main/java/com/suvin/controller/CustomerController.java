package com.suvin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suvin.common.DevopsUtil;
import com.suvin.service.CustomerService;

@RestController
@RequestMapping(value = "/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private CustomerService customerservice;

	@GetMapping(value = "test")
	public String test() {

		return "Hello World";

	}

	@GetMapping(value = "getcustomer")
	public ResponseEntity<Map<String, Object>> getCustomers() {
		HttpStatus responseStatus;

		Map<String, Object> responseMap = new HashMap<>();
		try {

			responseMap.put(DevopsUtil.DATA, customerservice.getCustomers());
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

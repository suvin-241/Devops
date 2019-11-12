package com.suvin.model;

import java.io.Serializable;
import java.math.BigInteger;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigInteger customerid;

	private String title;

	private String firstname;

	private String lastname;

	private String email;

	public BigInteger getCustomerid() {
		return customerid;
	}

	public void setCustomerid(BigInteger customerid) {
		this.customerid = customerid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String mobileno;

}

package com.bilal.hundal1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(nullable = false)
	private String street;
	@Column(nullable = false)
	private String postCode;
	public Address() {
		
	}
	public Address(String street, String postCode) {
		this.street = street;
		this.postCode = postCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	

}

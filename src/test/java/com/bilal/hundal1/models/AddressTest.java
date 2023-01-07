/**
 * 
 */
package com.bilal.hundal1.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Bilal Saddique
 * @implNote Creational Test of Address Model Class
 */

class AddressTest {
	//Given Address
	Address address;
	@DisplayName("Initilizing Address Object ")
	@BeforeEach 
	void when() {
		//When
		this.address=new Address("12 ab","abc");
		
	}
	
	/**
	 * Test Constructor method for {@link com.bilal.hundal1.models.Address#Address(java.lang.String, java.lang.String)}.
	 */
	@DisplayName("Testing Address object creation")
	@Test
	void testAddressStringString() {
		//then
		assertNotNull(address);
		
	}
//Setter tests
	/**
	 * Test method for {@link com.bilal.hundal1.models.Address#setStreet(java.lang.String)}.
	 */
	@Test
	void testSetStreet() {
		//then
		 assertNotNull(this.address.getStreet());
	}
	/**
	 * Test method for {@link com.bilal.hundal1.models.Address#setPost_Code(java.lang.String)}.
	 */
	@Test
	void testSetPostCode() {
		//then
		assertNotNull(this.address.getPostCode());
	}
//getter tests
	/**
	 * Test method for {@link com.bilal.hundal1.models.Address#getStreet()}.
	 */
	@Test
	void testGetStreet() {
		//then
	  assertEquals(this.address.getStreet(), "12 ab");
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Address#getPost_Code()}.
	 */
	@Test
	void testGetPostCode() {
		//then
		assertThat(this.address.getPostCode());
	}

}

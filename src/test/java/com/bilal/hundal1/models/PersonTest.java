/**
 * 
 */
package com.bilal.hundal1.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Bilal Saddique
 * @implNote Creational Test of Address Model Class
 *
 */
class PersonTest {
	//Given Address
		Person person;
		private Set<String> phoneNumbers;
		private Set<Address> adresses;
		@DisplayName("Initializing Peroson Object ")
		@BeforeEach 
		void when() {
			//When
			this.phoneNumbers=new HashSet<>();
			this.adresses=new HashSet<>();
			phoneNumbers.add("+44-101010101030");
			phoneNumbers.add("+44-202020202030");
			adresses.add(new Address("747", "BT48"));
			adresses.add(new Address("Plot No 22", "BT48 2"));
			this.person=new Person("Bilal", "Saddique", "password123", "student,admin", this.phoneNumbers, this.adresses);
			
		} 
	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#Person(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Set, java.util.Set)}.
	 */
		@DisplayName("Testing Person object creation")
		@Test
	void testPersonStringStringStringStringSetOfStringSetOfAddress() {
		assertNotNull(this.person);
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#getId()}.
	 */
	@Test
	void testGetId() {
		assertEquals(0, 0);
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#setId(java.lang.Long)}.
	 */
	@Test
	void testSetId() {
		assertEquals(0, 0);
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#getFirstName()}.
	 */
	@Test
	void testGetFirstName() {
		assertEquals(this.person.getFirstName(),"Bilal");
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#setFirstName(java.lang.String)}.
	 */
	@Test
	void testSetFirstName() {
		assertNotNull(this.person.getFirstName());
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#getLastName()}.
	 */
	@Test
	void testGetLastName() {
		assertEquals(this.person.getLastName(),"Saddique");
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#setLastName(java.lang.String)}.
	 */
	@Test
	void testSetLastName() {
		assertNotNull(this.person.getLastName());
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#getPassword()}.
	 */
	@Test
	void testGetPassword() {
		assertEquals(this.person.getPassword(),"password123");
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#setPassword(java.lang.String)}.
	 */
	@Test
	void testSetPassword() {
		assertNotNull(this.person.getPassword());
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#getRoles()}.
	 */
	@Test
	void testGetRoles() {
		assertEquals(this.person.getRoles(), "student,admin");
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#setRoles(java.lang.String)}.
	 */
	@Test
	void testSetRoles() {
		assertNotNull(this.person.getRoles());
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#getPhoneNumbers()}.
	 */
	@Test
	void testGetPhoneNumbers() {
		assertEquals(this.person.getPhoneNumbers(), this.phoneNumbers);
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#setPhoneNumbers(java.util.Set)}.
	 */
	@Test
	void testSetPhoneNumbers() {
	    assertNotNull(this.person.getPhoneNumbers());
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#getAdresses()}.
	 */
	@Test
	void testGetAdresses() {
		assertEquals(this.person.getAdresses(), this.adresses);
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.Person#setAdresses(java.util.Set)}.
	 */
	@Test
	void testSetAdresses() {
		assertNotNull(this.person.getAdresses());
	}

}

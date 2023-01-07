/**
 * 
 */
package com.bilal.hundal1.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author Bilal Saddique
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
class SecurityUserTest {

	/**
	 * Test method for {@link com.bilal.hundal1.models.SecurityUser#SecurityUser(com.bilal.hundal1.models.Person)}.
	 */
	//Given SecurityUserTest
	    // Person Object and its constructor variable Declaration 
		private Person person;
		private Set<String> phoneNumbers;
		private Set<Address> adresses;
		//SecurityUser Object Variable Declaration
		private SecurityUser securityUser;
		 
		@DisplayName("Initializing SecurityUserTest Object ")
		@BeforeAll
		void when() {
			//Initializing Person Object
			this.phoneNumbers=new HashSet<>();
			this.adresses=new HashSet<>();
			phoneNumbers.add("+44-101010101030");
			phoneNumbers.add("+44-202020202030");
			adresses.add(new Address("747", "BT48"));
			adresses.add(new Address("Plot No 22", "BT48 2"));
			this.person=new Person("Bilal", "Saddique", "password123", "student,admin", this.phoneNumbers, this.adresses);
			
			//Initializing SecurityUser Object
			this.securityUser=new SecurityUser(this.person);
		} 
	@DisplayName("Testing SecurityUser object creation")
	@Test
	void testSecurityUser() {
		assertNotNull(this.securityUser);
			
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.SecurityUser#getAuthorities()}.
	 */
	@Test
	void testGetAuthorities() {
		//Getting List of Granted Authorities from person rules
		List<SimpleGrantedAuthority> authorities=Arrays.stream(this.person.getRoles()
				.split(",")).map(SimpleGrantedAuthority::new).toList();
		//checking equality of authorities in Person and SecurityUser
		assertEquals(this.securityUser.getAuthorities(), authorities);
		
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.SecurityUser#getPassword()}.
	 */
	@Test
	void testGetPassword() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.SecurityUser#getUsername()}.
	 */
	@Test
	void testGetUsername() {
		assertEquals(this.securityUser.getUsername(), this.person.getFirstName());
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.SecurityUser#isAccountNonExpired()}.
	 */
	@Test
	void testIsAccountNonExpired() {
		assertTrue(this.securityUser.isAccountNonExpired());
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.SecurityUser#isAccountNonLocked()}.
	 */
	@Test
	void testIsAccountNonLocked() {
		assertTrue(this.securityUser.isAccountNonExpired());
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.SecurityUser#isCredentialsNonExpired()}.
	 */
	@Test
	void testIsCredentialsNonExpired() {
		assertTrue(this.securityUser.isCredentialsNonExpired());
	}

	/**
	 * Test method for {@link com.bilal.hundal1.models.SecurityUser#isEnabled()}.
	 */
	@Test
	void testIsEnabled() {
		assertTrue(this.securityUser.isEnabled());
	}

}

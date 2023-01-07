/**
 * 
 */
package com.bilal.hundal1.services;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bilal.hundal1.models.Address;
import com.bilal.hundal1.models.Person;
import com.bilal.hundal1.repos.PersonRep;
/**
 * @author Bilal Saddique
 *
 */
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = JpaUserDetailsServiceTest.class)
class JpaUserDetailsServiceTest {
	// Person Object Declaration
	Person person;
	private Set<String> phoneNumbers;
	private Set<Address> adresses;
	@InjectMocks
	JpaUserDetailsService jpaUserDetailsService;
	@Mock
	PersonRep personRep;
	@Captor
	 ArgumentCaptor<String> stCap;
	
	//Method before all
	@BeforeEach
	 void beforeEach() {
		//Initializing Person Object
		this.phoneNumbers=new HashSet<>();
		this.adresses=new HashSet<>();
		phoneNumbers.add("+44-101010101030");
		phoneNumbers.add("+44-202020202030");
		adresses.add(new Address("747", "BT48"));
		adresses.add(new Address("Plot No 22", "BT48 2"));
		this.person=new Person("Bilal3", "Saddique3", "password123", "student,admin", this.phoneNumbers, this.adresses);
	}
	

	/**
	 * Test method for {@link com.bilal.hundal1.services.JpaUserDetailsService#JpaUserDetailsService(com.bilal.hundal1.repos.PersonRep)}.
	 */
	@Test
	void testJpaUserDetailsService() {
		// checking if jpaUserDetailsService initialized  
		//assertNotNull(jpaUserDetailsService);
	}

	/**
	 * Test method for {@link com.bilal.hundal1.services.JpaUserDetailsService#loadUserByUsername(java.lang.String)}.
	 */
	@Test
	void testLoadUserByUsername() {
		//Given
		when(personRep.findByFirstName("Bilal2")).thenReturn(Optional.of(person));
		//when
		jpaUserDetailsService.loadUserByUsername("Bilal2");
		//then verify
		verify(personRep).findByFirstName(stCap.capture());
		
	}

}






/**
 * 
 */
package com.bilal.hundal1.repos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.bilal.hundal1.AddressesBookApplication;
import com.bilal.hundal1.models.Address;
import com.bilal.hundal1.models.Person;
import jakarta.transaction.Transactional;

/**
 * @author Bilal Saddique
 *
 */

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = AddressesBookApplication.class)
class PersonRepTest {
	@Autowired
	PersonRep personRepo;
	Person person;
	private Set<String> phoneNumbers;
	private Set<Address> adresses;
	//Method for saving Person in Repository before all tests method execution
	@BeforeAll
	void when() {
		//When
		this.phoneNumbers=new HashSet<>();
		this.adresses=new HashSet<>();
		phoneNumbers.add("+44-101010101030");
		phoneNumbers.add("+44-202020202030");
		adresses.add(new Address("747", "BT48"));
		adresses.add(new Address("Plot No 22", "BT48 2"));
		this.person=new Person("Bilal3", "Saddique3", "password123", "student,admin", this.phoneNumbers, this.adresses);
		this.personRepo.save(this.person);	
	}
	/**
	 * Test method for {@link com.bilal.hundal1.repos.PersonRep#findByFirstName(java.lang.String)}.
	 */
	@Test
	void testFindByFirstName() {
		assertEquals(this.personRepo.findByFirstName("Bilal3").get().getFirstName(),this.person.getFirstName());
	}
// Method for execution after all tests methods to delete data used for testing purpose only
	@AfterAll
	void discardTestPerson() {
		this.personRepo.delete(this.person);
	}
}





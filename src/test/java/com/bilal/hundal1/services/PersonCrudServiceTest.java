/**
 * 
 */
package com.bilal.hundal1.services;
import static org.mockito.Mockito.verify;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.bilal.hundal1.AddressesBookApplication;
import com.bilal.hundal1.models.Address;
import com.bilal.hundal1.models.Person;
import com.bilal.hundal1.repos.PersonRep;
import jakarta.transaction.Transactional;
/**
 * @author Bilal Saddique
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@Transactional
@SpringBootTest(classes = AddressesBookApplication.class)
class PersonCrudServiceTest {
	Person person;
	private Set<String> phoneNumbers;
	private Set<Address> adresses;
	@InjectMocks
	PersonCrudService personCrudService;
	@Mock
	PersonRep personRepo;
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
			this.personCrudService.insertPerson(person);
		}

	/**
	 * Test method for {@link com.bilal.hundal1.services.PersonCrudService#deletePerson(java.lang.Long)}.
	 */
	@Test
	void testDeletePerson() {
		//when
		this.personCrudService.deletePerson((long) 20);
		//then
		verify(personRepo).deleteById((long) 20);
		
		
	}

	/**
	 * Test method for {@link com.bilal.hundal1.services.PersonCrudService#updatePerson(com.bilal.hundal1.models.Person)}.
	 */
	@Test
	void testUpdatePerson() {
		//when
		this.personCrudService.updatePerson(person);
		//then
		verify(personRepo).existsById(person.getId());
		
		
		
	}

	/**
	 * Test method for {@link com.bilal.hundal1.services.PersonCrudService#insertPerson(com.bilal.hundal1.models.Person)}.
	 */
	@Test
	void testInsertPerson() {
		//when 
		this.personCrudService.insertPerson(person);
		//then
		verify(personRepo).save(person);
		
	}

	/**
	 * Test method for {@link com.bilal.hundal1.services.PersonCrudService#deleteAll()}.
	 */
	@Test
	void testDeleteAll() {
		//when
		this.personCrudService.deleteAll();
		//then
		verify(personRepo).deleteAll();
		
	}

	/**
	 * Test method for {@link com.bilal.hundal1.services.PersonCrudService#saveAll(java.util.List)}.
	 */
	@Test
	void testSaveAll() {
		//when
		this.personCrudService.saveAll(null);
		//then
		verify(personRepo).saveAll(null);
		
	}

	/**
	 * Test method for {@link com.bilal.hundal1.services.PersonCrudService#listPersons()}.
	 */
	@Test
	void testListPersons() {
		//when
		this.personCrudService.listPersons();
		//then
		verify(personRepo).findAll();
		
	}

	/**
	 * Test method for {@link com.bilal.hundal1.services.PersonCrudService#getPerson(java.lang.Long)}.
	 */
	@Disabled
	@Test
	void testGetPerson() {
		//when
		this.personCrudService.getPerson(ArgumentMatchers.anyLong());
		//then
		verify(personRepo).findById(ArgumentMatchers.anyLong());
	   
		
		
	}

}









/**
 * 
 */
package com.bilal.hundal1.controllers;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.bilal.hundal1.models.Address;
import com.bilal.hundal1.models.Person;
import com.bilal.hundal1.services.PersonCrudService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Bilal Saddique
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class PersonCrudControllerTest {
    @MockBean
    PersonCrudService personCrudService;
    @Autowired
    private WebApplicationContext context;
    @Captor 
    ArgumentCaptor<List<Person>> acListPerson;
    @Captor 
    ArgumentCaptor<Person> acPerson;
    @Captor
    ArgumentCaptor<Long> longCap;
    private MockMvc mvc;
    // Method to call before each test to ensure initialization of MockMvc
	@BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
          .webAppContextSetup(context)
          .apply(springSecurity())
          .build();
    }
	/**
	 * Test method for {@link com.bilal.hundal1.controllers.PersonCrudController#listPersons(com.bilal.hundal1.models.SecurityUser)}.
	 * @throws Exception 
	 */
    @Test
    @WithMockUser(username="Bilal2",roles={"STUDENT","ADMIN"})
	void testListPersons() throws Exception {
    	//when
    	//then
     	mvc.perform(get("/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
     	//And Then Verify
     	verify(personCrudService).listPersons();
    }
    /**
	 * Test method for {@link com.bilal.hundal1.controllers.PersonCrudController#getPerson(java.lang.Long)}.
	 * @throws Exception 
	 */
    @Test
    @WithMockUser(username="Bilal2",authorities ={"student"})
	void testGetPerson() throws Exception {
    	//Given
		//initiating persons in this case only one can be multiple
    	Long id=(long)101;
		Person person=null;
        //when
        when(personCrudService.getPerson(id)).thenReturn(person);
        //then
    	mvc.perform(get("/getPerson/00").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
    	//And Then Verify
    	verify(personCrudService).getPerson(longCap.capture());	
	}
	/**
	 * Test method for {@link com.bilal.hundal1.controllers.PersonCrudController#insertPerson(com.bilal.hundal1.models.Person)}.
	 * @throws Exception 
	 */
    @Test
    @WithMockUser(username="Bilal2",authorities={"admin"})
	void testInsertPerson() throws Exception {
    	//give
    	Person person;
    	Set<String> phoneNumbers=new HashSet<>();
	    Set<Address> adresses=new HashSet<>();
		phoneNumbers.add("+44-101010101030");
		phoneNumbers.add("+44-202020202030");
		adresses.add(new Address("747", "BT48"));
		adresses.add(new Address("Plot No 22", "BT48 2"));
		person=new Person("Bilal5", "Saddique5", "password123", "student,admin", phoneNumbers,adresses);
		person.setId((long)101);
		ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(person);
        //when
        when(personCrudService.insertPerson(person)).thenReturn(person);
        //then
    	mvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON).content(jsonContent))
    	.andExpect(status().isOk());
    	//And Then Verify
    	verify(personCrudService).insertPerson(acPerson.capture());
	}
    /**
	 * Test method for {@link com.bilal.hundal1.controllers.PersonCrudController#insertPersons(java.util.List)}.
	 * @throws Exception 
	 */
	@Test
	@WithMockUser(username="Bilal2",authorities={"admin"})
	void testInsertPersons() throws Exception {
		//Given
		//list for persons
		List<Person> persons=new ArrayList<>();
		//initiating persons in this case only one can be multiple
		Person person;
    	Set<String> phoneNumbers=new HashSet<>();
	    Set<Address> adresses=new HashSet<>();
		phoneNumbers.add("+44-101010101030");
		phoneNumbers.add("+44-202020202030");
		adresses.add(new Address("747", "BT48"));
		adresses.add(new Address("Plot No 22", "BT48 2"));
		person=new Person("Bilal5", "Saddique5", "password123", "student,admin", phoneNumbers,adresses);
		person.setId((long)101);
		persons.add(person);
		ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(persons);
        //when
        when(personCrudService.saveAll(persons)).thenReturn(persons);
        //then
    	mvc.perform(post("/saveAll").contentType(MediaType.APPLICATION_JSON).content(jsonContent))
    	.andExpect(status().isOk());
    	//and then
    	verify(personCrudService).saveAll(acListPerson.capture());
		
	}

	/**
	 * Test method for {@link com.bilal.hundal1.controllers.PersonCrudController#updatePerson(com.bilal.hundal1.models.Person)}.
	 * @throws Exception 
	 */
	@Test
	@WithMockUser(username="Bilal2",authorities={"admin"})
	void testUpdatePerson() throws Exception {
		//Given
				
				//initiating persons in this case only one can be multiple
				Person person;
		    	Set<String> phoneNumbers=new HashSet<>();
			    Set<Address> adresses=new HashSet<>();
				phoneNumbers.add("+44-101010101030");
				phoneNumbers.add("+44-202020202030");
				adresses.add(new Address("747", "BT48"));
				adresses.add(new Address("Plot No 22", "BT48 2"));
				person=new Person("Bilal5", "Saddique5", "password123", "student,admin", phoneNumbers,adresses);
				person.setId((long)101);
				ObjectMapper mapper = new ObjectMapper();
		        String jsonContent = mapper.writeValueAsString(person);
		        //when
		        when(personCrudService.updatePerson(person)).thenReturn(person);
		        //then
		    	mvc.perform(put("/update").contentType(MediaType.APPLICATION_JSON).content(jsonContent))
		    	.andExpect(status().isOk());
		    	//and then verify
		    	verify(personCrudService).updatePerson(acPerson.capture());
		
	}

	/**
	 * Test method for {@link com.bilal.hundal1.controllers.PersonCrudController#deletePerson(java.lang.Long)}.
	 * @throws Exception 
	 */
	@Test
	@WithMockUser(username="Bilal2",authorities={"admin"})
	void testDeletePerson() throws Exception {
		//given
		Long id=(long)101;
		when(personCrudService.deletePerson(id)).thenReturn("101");
		//when
		//then
		mvc.perform(delete("/delete/101").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		// And Then Verify
		verify(personCrudService).deletePerson(longCap.capture());
		
	}

	/**
	 * Test method for {@link com.bilal.hundal1.controllers.PersonCrudController#deletePerson()}.
	 * @throws Exception 
	 */
	@Test
	@WithMockUser(username="Bilal2",authorities={"student"})
	void testDeletePersons() throws Exception {
		 //when
	     //then
		mvc.perform(delete("/deleteAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		//and then verify
		verify(personCrudService).deleteAll();	
	}

}

package com.bilal.hundal1.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bilal.hundal1.models.Person;
import com.bilal.hundal1.models.SecurityUser;
import com.bilal.hundal1.services.LoggerClass;
import com.bilal.hundal1.services.PersonCrudService;


/**
 * @author Bilal Saddique
 * @category Rest Controller Class for CRUD Operations
 */
@RestController
public class PersonCrudController {
	@Autowired
	PersonCrudService personCrudService;
	/**
	 * @param securityUser
	 * @return List<Person>
	 */
	@GetMapping("/")
	public List<Person> listPersons(@AuthenticationPrincipal SecurityUser securityUser){
		LoggerClass.info("PersonCrudController method listPersons():Begninng");
		return personCrudService.listPersons();
		
	}
	/**
	 * @param id
	 * @return Person
	 */
	@PreAuthorize("hasAuthority('student')")
	@GetMapping("/getPerson/{id}")
	public Person getPerson(@PathVariable("id") Long id){
		LoggerClass.info("PersonCrudController method getPerson():Begninng");
		return personCrudService.getPerson(id);
	}
	/**
	 * @param person
	 * @return esponseEntity<Person>
	 */
	@PostMapping("/save")
	@PreAuthorize("hasAuthority('admin')")
	 public ResponseEntity<Person> insertPerson(@RequestBody Person person){
		LoggerClass.info("PersonCrudController method insertPerson():Begninng");
    	return ResponseEntity.ok().body(personCrudService.insertPerson(person));	
    }
	/**
	 * @param persons
	 * @return List<Person>
	 */
	@PostMapping("/saveAll")
	@PreAuthorize("hasAuthority('admin')")
	 public List<Person> insertPersons(@RequestBody List<Person> persons){
		LoggerClass.info("PersonCrudController method insertPersons():Begninng");
     	return personCrudService.saveAll(persons);
   }
	/**
	 * @param person
	 * @return ResponseEntity<Person>
	 */
	@PutMapping("/update")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person){
		LoggerClass.info("PersonCrudController method updatePerson():Begninng");
    	return ResponseEntity.ok().body(personCrudService.updatePerson(person));	
    }
	/**
	 * @param id
	 * @return ResponseEntity<String>
	 */
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<String> deletePerson(@PathVariable("id") Long id){
		LoggerClass.info("PersonCrudController method deletePerson(Long id):Begninng");
		String response=personCrudService.deletePerson(id);
		return ResponseEntity.ok().body(response);	
    }
	/**
	 * @return void
	 */
	@PreAuthorize("hasAuthority('student')")
	@DeleteMapping("/deleteAll")
	public void deletePersons(){
		LoggerClass.info("PersonCrudController method deletePersons():Begninng");
		personCrudService.deleteAll();	
    }
	

}














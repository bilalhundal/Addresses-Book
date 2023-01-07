package com.bilal.hundal1.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bilal.hundal1.models.Person;
import com.bilal.hundal1.repos.PersonRep;
/**
 * @author Bilal Saddique
 * @category Service Class for CRUD Operations
 */
@Transactional(readOnly = true)
@Service
public class PersonCrudService {
	private PersonRep personRepo;
	/**
	 * @param personRep
	 */
	public PersonCrudService(PersonRep personRep) {
		LoggerClass.info("PersonCrudService costructor: Begininng");
		this.personRepo=personRep;
		LoggerClass.info("PersonCrudService costructor: End");
	}
	/**
	 * @param id
	 * @return String
	 */
	@Transactional
	public String deletePerson(Long id) {
		LoggerClass.info("PersonCrudService mothod deletePerson(Long id): Begininng with id="+id);
		 this.personRepo.deleteById(id);
		 LoggerClass.info("PersonCrudService mothod deletePerson(Long id): End with id="+id);
		 return ""+id;
	}
	/**
	 * @param person
	 * @return person:Person
	 */
	@Transactional
	public Person updatePerson(Person person) {
		LoggerClass.info("PersonCrudService mothod updatePerson(Person person): Beginning with person="+person);
		if(personRepo.existsById(person.getId())) {
			LoggerClass.info("PersonCrudService mothod updatePerson(Person person): End with Person exists=true");
			return personRepo.save(person);
		}else {
			LoggerClass.info("PersonCrudService mothod updatePerson(Person person): End with Person exists=false");
			return null;
		}
	}
	/**
	 * @param person
	 * @return person:Person
	 */
	@Transactional
	public Person insertPerson(Person person) {
		LoggerClass.info("PersonCrudService mothod insertPerson(Person person): Beginning with Person ="+person);
		if(!personRepo.existsById(person.getId())) {
			LoggerClass.info("PersonCrudService mothod isertPerson(Person person): End with Person exists=true");
			return personRepo.save(person);
		}else {
			LoggerClass.info("PersonCrudService mothod insertPerson(Person person): End with Person exists=false");
			return null;
		}
	}
	/**
	 * @return void
	 */
	@Transactional
	public void deleteAll() {
		LoggerClass.info("PersonCrudService mothod deleteAll(): Begininng");
		personRepo.deleteAll();
	}
	/**
	 * @param persons
	 * @return persons:List<Person>
	 */
	/**
	 * @param persons
	 * @return persons:List<Person>
	 */
	@Transactional
	public List<Person> saveAll(List<Person> persons) {
		LoggerClass.info("PersonCrudService mothod saveAll(List<Person> persons): Begininng with persons = "+persons);
		return personRepo.saveAll(persons);
		
	}
	
	/**
	 * @return persons:List<Person>
	 */
	public List<Person> listPersons() {
		LoggerClass.info("PersonCrudService mothod listPersons():List<Person>: Begininng ");
		return personRepo.findAll();
	}
	/**
	 * @param id
	 * @return person:Person
	 */
	public Person getPerson(Long id) {
		LoggerClass.info("PersonCrudService mothod getPerson(Long id): Begininng with id = "+id);
		Optional<Person> optional=personRepo.findById(id);
		if(optional.isPresent()) {
			LoggerClass.info("PersonCrudService mothod getPerson(Long id): End with Status= Found");
		return optional.get();
		}
		LoggerClass.warn("PersonCrudService mothod getPerson(Long id): End with Status= Not Found");
		return null;
	}
	

}


















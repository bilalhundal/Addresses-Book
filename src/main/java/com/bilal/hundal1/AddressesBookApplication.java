package com.bilal.hundal1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bilal.hundal1.models.Address;
import com.bilal.hundal1.models.Person;
import com.bilal.hundal1.services.LoggerClass;
import com.bilal.hundal1.services.PersonCrudService;
@SpringBootApplication
public class AddressesBookApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(AddressesBookApplication.class, args);
	}
	@Bean CommandLineRunner
	commandLineRunner(PersonCrudService personCrudService,PasswordEncoder passwordEncoder) throws Exception {
		    
       // Cleanup database tables.
		LoggerClass.warn("Cleaning all records from database");
		     personCrudService.deleteAll();

	  return args->{    
		  // Insert a user with multiple phone numbers and addresses.
		  LoggerClass.info("CommandLine method run():beginning ");
	        Set<String> phoneNumbers1 = new HashSet<String>();
	        phoneNumbers1.add("+44-101010101010");
	        phoneNumbers1.add("+44-202020202020");

	        Set<Address> addresses1 = new HashSet<>();
	        addresses1.add(new Address("747", "BT48"));
	        addresses1.add(new Address("Plot No 44", "BT48"));
	        Person person1=new Person("Bilal","Saddique",passwordEncoder.encode("pass1"),"student",phoneNumbers1,addresses1);
	        //Second Person
	        Set<String> phoneNumbers2 = new HashSet<>();
	        phoneNumbers2.add("+44-101010101030");
	        phoneNumbers2.add("+44-202020202030");

	        Set<Address> addresses2 = new HashSet<>();
	        addresses2.add(new Address("747", "BT48"));
	        addresses2.add(new Address("Plot No 22", "BT48 2"));
	        Person person2=new Person("Bilal2","Saddique2",passwordEncoder.encode("pass2"),"student,admin",phoneNumbers2,addresses2);
            List<Person> personsList=new ArrayList<Person>();
            personsList.add(person1);
            personsList.add(person2);

	        personCrudService.saveAll(personsList);
	        LoggerClass.info("CommandLine method run():end ");
	  };
	    }

}











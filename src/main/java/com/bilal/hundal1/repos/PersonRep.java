package com.bilal.hundal1.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bilal.hundal1.models.Person;
@Repository
public interface PersonRep extends JpaRepository<Person, Long>{
	 Optional<Person> findByFirstName(String FirstName);

}

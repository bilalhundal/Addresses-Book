package com.bilal.hundal1.models;

import java.util.Set;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;


/**
 * @author hs
 *
 */
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private String password;
	private String roles;
	 @ElementCollection
	 @CollectionTable(name = "user_phone_numbers", joinColumns = @JoinColumn(name = "person_id"))
	 @Column(name = "phone_number")
	private Set<String> phoneNumbers;
	 @ElementCollection(fetch = FetchType.LAZY)
	 @CollectionTable(name = "person_addresses", joinColumns = @JoinColumn(name = "person_id"))
	private Set<Address> adresses;
	public Person() {
		
	}
	public Person(String firstName, String lastName, String password, String roles, Set<String> phoneNumbers,
			Set<Address> adresses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.roles = roles;
		this.phoneNumbers = phoneNumbers;
		this.adresses = adresses;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Set<Address> getAdresses() {
		return adresses;
	}
	public void setAdresses(Set<Address> adresses) {
		this.adresses = adresses;
	}
	@Override
	public String toString() {
		return "Person [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", roles=" + roles + ", phoneNumbers=" + phoneNumbers + ", adresses=" + adresses + "]";
	}
	
}

package com.bilal.hundal1.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Person person;
	public SecurityUser(Person person) {
		this.person=person;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> authorities=Arrays.stream(this.person.getRoles()
				.split(",")).map(SimpleGrantedAuthority::new).toList();
		Arrays.stream(this.person.getRoles().split(",")).forEach(s->System.out.println(s));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.person.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.person.getFirstName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

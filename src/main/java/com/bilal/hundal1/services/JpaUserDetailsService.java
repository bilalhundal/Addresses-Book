package com.bilal.hundal1.services;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bilal.hundal1.models.SecurityUser;
import com.bilal.hundal1.repos.PersonRep;
/**
 * @author Bilal Saddique
 *
 */
@Service
public class JpaUserDetailsService implements UserDetailsService {
	PersonRep personRep;
	public JpaUserDetailsService(PersonRep Pr) {
		this.personRep=Pr;
	}
	/**
	 * @param String
	 *@return UserDetails
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return this.personRep.findByFirstName(username).map(SecurityUser::new)
				.orElseThrow(()->new UsernameNotFoundException("User Not Found"));
	}

}

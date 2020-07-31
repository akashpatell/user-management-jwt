package com.akash.jwtusermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akash.jwtusermanagement.domain.CustomeUserDetails;
import com.akash.jwtusermanagement.repository.UserProfileRepository;

/**
 * A custome service implementation class of {@link UserDetailsService}
 * 
 * @author Akash.Patel
 *
 */
@Service
public class CustomeUserDetailsService implements UserDetailsService {

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {

		return userProfileRepository.findByUserName(username).map(CustomeUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + username));
	}

}

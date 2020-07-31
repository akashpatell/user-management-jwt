package com.akash.jwtusermanagement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.akash.jwtusermanagement.domain.UserProfile;
import com.akash.jwtusermanagement.repository.UserProfileRepository;

@SpringBootApplication
public class UserManagementJwtApplication {

	@Autowired
	private UserProfileRepository userProfileRepository;

	@PostConstruct
	public void initUsers() {

		userProfileRepository.save(new UserProfile(1L, "admin", "admin", true, "ROLE_ADMIN"));

	}

	public static void main(String[] args) {
		SpringApplication.run(UserManagementJwtApplication.class, args);
	}

}

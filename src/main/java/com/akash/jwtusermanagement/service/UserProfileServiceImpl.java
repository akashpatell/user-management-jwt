package com.akash.jwtusermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akash.jwtusermanagement.domain.ApiResponse;
import com.akash.jwtusermanagement.domain.UserProfile;
import com.akash.jwtusermanagement.repository.UserProfileRepository;

/**
 * A custome service implementation class of {@link UserProfileService}
 * 
 * @author Akash.Patel
 *
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	@Transactional
	public ApiResponse<UserProfile> saveUser(UserProfile user) {

		Optional<UserProfile> findByUserName = userProfileRepository.findByUserName(user.getUserName());

		if (findByUserName.isPresent())
			return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "User Already Exist");

		return new ApiResponse<>(userProfileRepository.save(user), HttpStatus.CREATED.value(),
				"User Created Successful");
	}

	@Override
	public List<UserProfile> getUsers() {

		return userProfileRepository.findAll();
	}

	@Override
	public ApiResponse<Void> deleteUser(Long userId) {

		Optional<UserProfile> user = userProfileRepository.findById(userId);

		if (user.isPresent()) {
			userProfileRepository.delete(user.get());
			return new ApiResponse<>(HttpStatus.OK.value(), "User Deleted Successful");
		}

		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User Not Found");
	}

}

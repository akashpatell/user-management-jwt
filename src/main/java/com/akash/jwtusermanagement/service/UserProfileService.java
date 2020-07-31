package com.akash.jwtusermanagement.service;

import java.util.List;

import com.akash.jwtusermanagement.domain.ApiResponse;
import com.akash.jwtusermanagement.domain.UserProfile;

public interface UserProfileService {

	ApiResponse<UserProfile> saveUser(UserProfile user);

	List<UserProfile> getUsers();

	ApiResponse<Void> deleteUser(Long userId);

}

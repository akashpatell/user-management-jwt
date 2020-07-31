package com.akash.jwtusermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.jwtusermanagement.domain.ApiResponse;
import com.akash.jwtusermanagement.domain.UserProfile;
import com.akash.jwtusermanagement.service.UserProfileService;

/**
 * A Controller to manage User Services
 * 
 * @author Akash.Patel
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserProfileService userProfileService;

	/**
	 * POST: request to create new UserProfile
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/admin/add")
	public ApiResponse<UserProfile> saveUser(@RequestBody UserProfile user) {

		try {
			return userProfileService.saveUser(user);

		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Failed to save user");
		}
	}

	/**
	 * GET: request to get all Users
	 * 
	 * @return
	 */
	@GetMapping("/user/get")
	public ApiResponse<List<UserProfile>> getUsers() {
		try {
			return new ApiResponse<>(userProfileService.getUsers(), HttpStatus.OK.value(), "Users Fetched Successful");

		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Failed to fetch users");
		}
	}

	/**
	 * DELETE: request to remove UserProfile
	 * 
	 * @param userId
	 * @return
	 */
	@DeleteMapping("/admin/delete/{userId}")
	public ApiResponse<Void> deleteUser(@PathVariable Long userId) {
		try {
			return userProfileService.deleteUser(userId);

		} catch (Exception e) {
			return new ApiResponse<>(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Failed to delete user");
		}
	}

}

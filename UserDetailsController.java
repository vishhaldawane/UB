package com.example.demo.layer5;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.UserDetails;

@RestController
public interface UserDetailsController {
	List<UserDetails> getAllUserDetails();
	UserDetails 	  getUserDetails(int userid);
	void addUserDetails(UserDetails user);
	void editUserDetails(UserDetails user);
	void deleteUserDetails(int userid);
}

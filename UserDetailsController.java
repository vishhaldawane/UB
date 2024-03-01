package com.example.demo.layer5;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.UserDetails;

@RestController
public interface UserDetailsController {
	List<UserDetails> getAllUserDetails();
	ResponseEntity 	  getUserDetails(Integer userid);
	ResponseEntity addUserDetails(UserDetails user);
	ResponseEntity editUserDetails(UserDetails user);
	ResponseEntity deleteUserDetails(Integer userid);
}

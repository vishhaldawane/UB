package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.UserDetails;
import com.example.demo.layer4.UserDetailsService;
import com.example.demo.layer4.myexceptions.UserDetailsAlreadyExistsException;
import com.example.demo.layer4.myexceptions.UserDetailsNotFoundException;

// http://localhost:8080/sa/users
//http://localhost:8080/ca/users

@RestController // REpresentational State Transfer
@RequestMapping("/userdetails")
public class UserDetailsControllerImplementation implements UserDetailsController {

	@Autowired
	UserDetailsService userService;
	
	public UserDetailsControllerImplementation() {
		System.out.println("UserDetailsControllerImplementation() ctor...");
	}
	
	@GetMapping("/users") //plural
	public List<UserDetails> getAllUserDetails() {
		System.out.println("getAllUserDetails() invoked...");
		return userService.getAllUserDetailsService();
	}

	@GetMapping("/user/{id}") //singular
	public ResponseEntity getUserDetails(@PathVariable("id") Integer userid) {
		System.out.println("getUserDetails() invoked...");
		UserDetails userDetails = null;
		try {
			userDetails = userService.findASingleUserDetailsService(userid);	
		}
		catch(UserDetailsNotFoundException userDetNotFoundEx) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userDetNotFoundEx.getMessage());
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(userDetails);
	}

	@Override
	@PostMapping("/addUser") // send the complete body of the UserDetails
	public ResponseEntity addUserDetails(@RequestBody UserDetails user) {
		try {
			userService.createANewUserDetailsService(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
		}
		catch(UserDetailsAlreadyExistsException userAlreadyExistFoundEx) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(userAlreadyExistFoundEx.getMessage());
		}
		
	}

	@Override
	public ResponseEntity editUserDetails(UserDetails user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity deleteUserDetails(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

}

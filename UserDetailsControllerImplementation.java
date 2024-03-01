package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.UserDetails;
import com.example.demo.layer4.UserDetailsService;

// http://localhost:8080/sa/users
//http://localhost:8080/ca/users

@RestController // REpresentational State Transfer
@RequestMapping("/userdetails")
public class UserDetailsControllerImplementation implements UserDetailsController {

	@Autowired
	UserDetailsService userService;
	
	@GetMapping("/users") //plural
	public List<UserDetails> getAllUserDetails() {
		return userService.getAllUserDetailsService();
	}

	@Override
	public UserDetails getUserDetails(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserDetails(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editUserDetails(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserDetails(int userid) {
		// TODO Auto-generated method stub

	}

}

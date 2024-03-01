package com.example.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.UserDetails;
import com.example.demo.layer3.UserDetailsRepository;
import com.example.demo.layer4.UserDetailsService;

@SpringBootTest
class UserDetailsServiceTests {

	@Autowired
	UserDetailsService userService;
	
	//ctrl+shift+m
	@Test
	void showAllUserDetailsServiceTest() {
		List<UserDetails> allUsers = userService.getAllUserDetailsService();
		Iterator<UserDetails> iterator = allUsers.iterator();
		while(iterator.hasNext()) {
			UserDetails userDetails = iterator.next();
			System.out.println("User ID    : "+userDetails.getUserIdentificationNumber());
			System.out.println("User Name  : "+userDetails.getNameOfUser());
			System.out.println("User Email : "+userDetails.getEmailAddress());
			System.out.println("User City  : "+userDetails.getCityAddress());
			System.out.println("User Age   : "+userDetails.getUserAge());
			System.out.println("--------------------");
		}
	}
	
	

}

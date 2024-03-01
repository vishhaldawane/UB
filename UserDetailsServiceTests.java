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
	
	@Test
	void findASingleUserDetailsServiceTest() {
		UserDetails userDetails = userService.findASingleUserDetailsService(111);
		System.out.println("User ID    : "+userDetails.getUserIdentificationNumber());
		System.out.println("User Name  : "+userDetails.getNameOfUser());
		System.out.println("User Email : "+userDetails.getEmailAddress());
		System.out.println("User City  : "+userDetails.getCityAddress());
		System.out.println("User Age   : "+userDetails.getUserAge());
		System.out.println("--------------------");
	}
	
	@Test
	void createANewUserDetailsService() {
		UserDetails user = new UserDetails();
		user.setUserIdentificationNumber(9);
		user.setNameOfUser("Sachin");
		user.setEmailAddress("sachin@gmail.com");
		user.setCityAddress("Mumbai");
		user.setUserAge(35);
		userService.createANewUserDetailsService(user);
	}
	
	@Test
	void modifyExistingUserDetailsService() {
		UserDetails user = new UserDetails();
		user.setUserIdentificationNumber(19);
		user.setNameOfUser("Sachin Tendulkar");
		user.setEmailAddress("sachint@gmail.com");
		user.setCityAddress("PUNE");
		user.setUserAge(40);
		userService.modifyExistingUserDetailsService(user);
	}
}






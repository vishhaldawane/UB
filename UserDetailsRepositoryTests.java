package com.example.demo;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.UserDetails;
import com.example.demo.layer3.UserDetailsRepository;

@SpringBootTest
class UserDetailsRepositoryTests {

	@Autowired
	UserDetailsRepository userRepo;
	
	@Test
	void insertUserDetailsTest() {
		UserDetails user = new UserDetails();
		user.setUserIdentificationNumber(8);
		user.setNameOfUser("Martin");
		user.setEmailAddress("martin@gmail.com");
		user.setCityAddress("Pune");
		user.setUserAge(25);
		userRepo.save(user);
	}
	
	@Test
	void findAllUsersTest() {
		
		Iterable<UserDetails> iterable = userRepo.findAll();
		Iterator<UserDetails> iterator = iterable.iterator();
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
	void findAllUsersByCityTest() {
		
		Iterable<UserDetails> iterable = userRepo.searchByCity("Kolkatta");
		Iterator<UserDetails> iterator = iterable.iterator();
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

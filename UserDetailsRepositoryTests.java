package com.example.demo;

import java.util.Iterator;
import java.util.Optional;

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
	void updateUserDetailsTest() {
		UserDetails user = new UserDetails();
		user.setUserIdentificationNumber(8);
		user.setNameOfUser("MARTIN KING");
		user.setEmailAddress("matrinking@gmail.com");
		user.setCityAddress("Nagpur");
		user.setUserAge(26);
		userRepo.save(user); //if the record exists by this ID, then update
	}
	
	@Test
	void deleteUserDetailsTest() {
		UserDetails user = new UserDetails();
		user.setUserIdentificationNumber(8);
		userRepo.delete(user);
	}
	
	@Test
	void findSingleUserTest() {
		int userId=11;
		Optional<UserDetails> user = userRepo.findById(userId);
		if(user.isPresent()) {
			UserDetails userDetails = user.get();
			System.out.println("User ID    : "+userDetails.getUserIdentificationNumber());
			System.out.println("User Name  : "+userDetails.getNameOfUser());
			System.out.println("User Email : "+userDetails.getEmailAddress());
			System.out.println("User City  : "+userDetails.getCityAddress());
			System.out.println("User Age   : "+userDetails.getUserAge());
		}
		else {
			System.out.println("User NOT found : "+userId);
		}
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

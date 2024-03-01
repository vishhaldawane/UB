package com.example.demo.layer4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.layer2.UserDetails;
import com.example.demo.layer3.UserDetailsRepository;

public class UserDetailsServiceImplementation implements UserDetailsService {
	
	@Autowired	UserDetailsRepository userRepo;
	
	public List<UserDetails> getAllUserDetailsService() {
		ArrayList<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		Iterable<UserDetails> iterable = userRepo.findAll();
		Iterator<UserDetails> iterator = iterable.iterator();
		while(iterator.hasNext()) {
			UserDetails userDetails= iterator.next();
			userDetailsList.add(userDetails);
		}
		return userDetailsList;
	}

	@Override
	public UserDetails findASingleUserDetailsService(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createANewUserDetailsService(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyExistingUserDetailsService(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteExistingUserDetailsService(int userid) {
		// TODO Auto-generated method stub

	}

}

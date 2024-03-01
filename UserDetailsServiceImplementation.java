package com.example.demo.layer4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.UserDetails;
import com.example.demo.layer3.UserDetailsRepository;
import com.example.demo.layer4.myexceptions.UserDetailsAlreadyExistsException;
import com.example.demo.layer4.myexceptions.UserDetailsNotFoundException;

@Service
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
		UserDetails userDetails = null;
		Optional<UserDetails> box = userRepo.findById(userid);
		if(box.isPresent()) {
			userDetails = box.get();
		}
		else {
			throw new UserDetailsNotFoundException("This user id does not exists ! "+userid);
		}
		return userDetails;
	}

	
	
	
	
	@Override
	public void createANewUserDetailsService(UserDetails user) {
		Optional<UserDetails> box = userRepo.findById(user.getUserIdentificationNumber());
		if(box.isPresent()) {
			throw new UserDetailsAlreadyExistsException("This user id already exists ! "+user.getUserIdentificationNumber());
		}
		else {
			userRepo.save(user);
		}
	}

	@Override
	public void modifyExistingUserDetailsService(UserDetails user) {
		Optional<UserDetails> box = userRepo.findById(user.getUserIdentificationNumber());
		if(box.isPresent()) {
			userRepo.save(user); //modify it if found, wont add it 
		}
		else {
			//if not found, wont add it, rather an exception is thrown
			throw new UserDetailsNotFoundException("This user id does not exists ! "+user.getUserIdentificationNumber()); 
		}
	}

	@Override
	public void deleteExistingUserDetailsService(int userid) {
		Optional<UserDetails> box = userRepo.findById(userid);
		if(box.isPresent()) {
			userRepo.deleteById(userid); 
		}
		else {
			//if not found, rather an exception is thrown
			throw new UserDetailsNotFoundException("This user id does not exists ! "+userid); 
		}
	}

}

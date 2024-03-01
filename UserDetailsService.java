package com.example.demo.layer4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.UserDetails;

/* cook vs chef
 * 
 * 				@Component
 * 
 * @Repository		@Service		@Controller		@RestController
 * 		CRUD	   business logic	   MVC			   REST MVC
 * 	
 */

@Service //extension of @Component but marked as Service
public interface UserDetailsService { //BL is involved in below functions
	List<UserDetails> getAllUserDetailsService();
	UserDetails   findASingleUserDetailsService(int userid);
	void createANewUserDetailsService(UserDetails user);
	void modifyExistingUserDetailsService(UserDetails user);
	void deleteExistingUserDetailsService(int userid);
}








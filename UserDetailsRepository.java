package com.example.demo.layer3;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.layer2.UserDetails;

@Repository // extension of @Component
public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer> {
	@Modifying
	//      select * from userdetails   where u.city = 'Mumbai'
	@Query("select u from UserDetails u where u.cityAddress= :mycity")//JPQL
	public List<UserDetails> searchByCity(@Param("mycity") String mc);
}

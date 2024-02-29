package com.example.demo.layer2;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="userdetails")
public class UserDetails { //POJO mapped with the DATABASE - ORM
	 @Id //mandatory - as long as their is a primary key 
	 @Column(name="userid")
	 int userIdentificationNumber;
	 
	 @Column(name="username")
     String nameOfUser; 
	 
	 @Column(name="email")
     String emailAddress ;
	 
	 @Column(name="city")
     String cityAddress;
     
	 @Column(name="age")
     int userAge ;

	public int getUserIdentificationNumber() {
		return userIdentificationNumber;
	}

	public void setUserIdentificationNumber(int userIdentificationNumber) {
		this.userIdentificationNumber = userIdentificationNumber;
	}

	public String getNameOfUser() {
		return nameOfUser;
	}

	public void setNameOfUser(String nameOfUser) {
		this.nameOfUser = nameOfUser;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCityAddress() {
		return cityAddress;
	}

	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	
	
	 
	 
	 
}

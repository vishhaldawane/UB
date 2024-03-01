package com.example.demo.layer4.myexceptions;

public class UserDetailsAlreadyExistsException extends RuntimeException {
	public UserDetailsAlreadyExistsException(String str) {
		super(str);
	}
}

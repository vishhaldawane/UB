package com.example.demo.layer4.myexceptions;

public class UserDetailsNotFoundException extends RuntimeException {
	public UserDetailsNotFoundException(String msg) {
		super(msg);
	}
}

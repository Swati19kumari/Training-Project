package com.java.lib.model;

import lombok.Data;

@Data
public class AdminLogin {

	private String username;
	private String passcode;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public AdminLogin(String username, String passcode) {
		super();
		this.username = username;
		this.passcode = passcode;
	}
	@Override
	public String toString() {
		return "AdminLogin [username=" + username + ", passcode=" + passcode + "]";
	}
	
	
}
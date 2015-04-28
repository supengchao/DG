package com.spc.bean;

import com.avos.avoscloud.AVUser;

public class User extends AVUser {
	
	public String getUsername() {
		return this.getString("username");
	}
	public void setUsername(String username) {
		this.put("username", username );
	}
	public String getPassword() {
		return this.getString("password");
	}
	public void setPassword(String password) {
		this.put("password", password);
	}
	public String getEmail() {
		return this.getString("email");
	}
	public void setEmail(String email) {
		this.put("email", email);
	}
	public String getPhoneNumber() {
		return this.getString("phoneNumber");
	}
	public void setPhoneNumber(String phoneNumber) {
		this.put("phoneNumber", phoneNumber);
	}
	
	
}

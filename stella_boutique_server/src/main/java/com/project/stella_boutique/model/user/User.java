package com.project.stella_boutique.model.user;

import java.util.Random;

public class User {
    private int userID;
    private String password;
    private String fullName;
    private String username;
    private String birthday;
    private String address;
    private String phoneNumber;
    private String email;

	public User(int id, String password, String fullName, String username, String birthday, String address, String phoneNumber, String email) {
		this.userID = id;
		this.password = password;
		this.fullName = fullName;
		this.username = username;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public User(String password, String fullName, String username, String birthday, String address, String phoneNumber, String email) {
		Random rand = new Random();
		this.userID = rand.nextInt(999999);
		this.password = password;
		this.fullName = fullName;
		this.username = username;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getUserID() {
        return this.userID;
	}
	
    public void setUserID(int id) {
        this.userID = id;
    }

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

package com.optimus.client.dto;

public class Client {
	
	private String username;
	private String password;
	private String name;
	private String designation;
	private String email;
	private boolean gender;
	private String mobile;
	private int privilege;

	public Client( String username,String password ,String name, String designation, String email, boolean gender,  String mobile, int privilege) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.designation = designation;
		this.email = email;
		this.gender = gender;
		this.mobile = mobile;
		this.privilege = privilege;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public int getPrivilege() {
		return privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client [username=" + username + ", password=" + password + ", name=" + name + ", designation="
				+ designation + ", email=" + email + ", gender=" + gender + ", mobile=" + mobile + ", privilege="
				+ privilege + "]";
	}

	
	
	
}

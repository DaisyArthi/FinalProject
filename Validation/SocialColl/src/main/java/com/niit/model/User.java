package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Userdetails")
public class User {

	@Id
	@NotBlank(message="Please enter the Username")
	private String username;
	
	@Column
	@NotBlank(message="Please enter the password")
	private String password;
	
	@Column
	@NotBlank(message="Please enter the valid email")
	private String email;
	
	@Column
	@NotBlank(message="Please enter the contact no")
	private String contact;
	
	@Column
	@NotBlank(message="Enter your first Name")
	private String firstname;
	
	@Column
	@NotBlank(message="Enter your last name")
	private String lastname;
	
	@Column(name="online_status")
	private boolean online;
	
	@Column
	private String role="ROLE_USER";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}

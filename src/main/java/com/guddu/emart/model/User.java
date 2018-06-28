package com.guddu.emart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component//provide bean to user class
@Table(name="user")
public class User implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 3172653328889041555L;
//to save state of transaction or to save object details...using the unique id

	@Id//to make id as primary key
	@GeneratedValue(strategy=GenerationType.AUTO)//to generate values automatically
	private int id;
	@Column(unique=true)
	private String username;
	@Column(unique=true)
	private String emailId;
	private String address;
	@Column(unique=true)
	private long phone;
	transient private String password;//to not save password in database
	private int age;
	private boolean enabled=false;//for admin verification of the new user
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}

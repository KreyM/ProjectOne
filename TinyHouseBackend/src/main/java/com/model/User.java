package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.*;
import org.springframework.stereotype.Component;



@Component
@Entity
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Email(message="Enter valid Email" )
	private String email;
	@NotNull
	private String name;	
	@NotNull
	private String password;
	private String role;
	private String address;
	@Pattern(regexp="[\\d]{10}", message="Enter only 10 digits" )
	@Size( min=8, max=10, message="Enter valid number")
	private String phone;
	private boolean enables;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isEnables() {
		return enables;
	}
	public void setEnables(boolean enables) {
		this.enables = enables;
	}
	

}

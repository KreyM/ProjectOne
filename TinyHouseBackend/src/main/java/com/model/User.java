package com.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.*;
import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name="UserDemo")
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Email(message="Enter valid Email" )
	private String email;
/*	@Id

	private int id;*/

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	private Cart cart;
	@NotNull
	private String name;	
	private String surname;
	@NotNull
	private String password;
	private String role;
	private String address;
	@Pattern(regexp="[\\d]{10}", message="Enter only 10 digits" )
	@Size( min=8, max=10, message="Enter valid number")
	private String phone;
	private boolean enables;
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
//	@JoinColumn(name="id")
//	private Cart cart;


	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
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

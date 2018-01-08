package com.model;

import java.io.Serializable;

import javax.persistence.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.*;
import org.springframework.stereotype.Component;
@Component
@Entity
public class Orders implements Serializable 
{
	private int OrderId;
	
	@OneToMany
	@JoinColumn
	private User user;
	private String payment;


	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
}

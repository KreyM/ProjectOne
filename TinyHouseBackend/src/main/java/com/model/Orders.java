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
	@Id
	@GeneratedValue
	private int OrderId;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	private String payment;
	private double total;

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
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

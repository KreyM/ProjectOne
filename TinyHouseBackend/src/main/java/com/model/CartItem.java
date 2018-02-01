package com.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;
@Component
@Entity
public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double totalPrice;
	private int quantity;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cartId")
	private Cart cart;
	
			
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pid")
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String toString() {
		return "CartItems [id=" + id + ", totalPrice=" + totalPrice + ", quantity=" + quantity + "]";
	}


	

}

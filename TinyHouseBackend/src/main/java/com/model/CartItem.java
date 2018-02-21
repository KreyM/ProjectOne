package com.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;
/*@Component*/
@Entity
@Table
public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int itemId;
	
	private double totalPrice;
	
	private int quantity;
	
	
	@ManyToOne( fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	private Cart cart;
	
			
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pid")
	private Product product;

	

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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
		System.out.println("setCart done");
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
	@Override
	public String toString() {
		return "CartItems [itemId=" + itemId + ", totalPrice=" + totalPrice + ", quantity=" + quantity + "]";
	}


	

}

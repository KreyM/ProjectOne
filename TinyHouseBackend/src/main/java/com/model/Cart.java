package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Cart implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int cartId;
	private int cartProductId;
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name="userMailId")
	private User cartUserDetails;
	private double cartPrice;// grand total
	private int cartStock;
	private String cartImage;
	private String cartProductName;
	private int totalItems;
	private double grandTotal;
	@OneToOne (cascade=CascadeType.PERSIST)
	private User user;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	private Set<CartItem> cartItem=new HashSet<CartItem>();
	/*@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER, mappedBy="category") // make changes
	private Set<Product> product=new HashSet<Product>(0);*/
	@Override
	public String toString() {
		return "Cart [id=" + cartId + ", totalItems=" + totalItems + ", grandTotal=" + grandTotal +"]";
	}

	public Set<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cart()
	{}
	
	public Cart(int cartId,int cartProductId, User cartUserDetails, double cartPrice, int cartStock, String cartProductName  )
	{
		this.cartId= cartId;
		this.cartProductId=cartProductId;
		this.cartUserDetails= cartUserDetails;
		this.cartPrice=cartPrice;
		this.cartStock=cartStock;
		/*this.cartImage=cartImage;
		*/
		
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public User getCartUserDetails() {
		return cartUserDetails;
	}

	public void setCartUserDetails(User cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}

	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCartStock() {
		return cartStock;
	}

	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}

	public String getCartImage() {
		return cartImage;
	}

	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}

	public String getCartProductName() {
		return cartProductName;
	}

	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	

}

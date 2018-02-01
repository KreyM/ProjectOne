package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

//import org.springframework.stereotype.Component;
//@Component
@Entity
public class Cart implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int totalItems;
	private double grandTotal;
	
	//private int cartProductId;
	@OneToOne (cascade=CascadeType.PERSIST)
	private User user;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	private Set<CartItem> cartItem=new HashSet<CartItem>();

	public Cart(int cartId, User cartUserDetails, double cartPrice, int cartStock )
	{
		this.id= cartId;
		this.grandTotal=cartPrice;
		this.totalItems=cartStock;
		this.user=cartUserDetails;
		
		//this.cartProductId=cartProductId;
		//this.cartUserDetails= cartUserDetails;
		//this.cartPrice=cartPrice;
		//this.cartStock=cartStock;
		/*this.cartImage=cartImage;
		*/
		
	}
	/*@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name="email")
	private User cartUserDetails;
	private double cartPrice;// grand total
	private int cartStock;
	private String cartImage;
	private String cartProductName;*/
	
	
		/*@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER, mappedBy="category") // make changes
	private Set<Product> product=new HashSet<Product>(0);*/
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", totalItems=" + totalItems + ", grandTotal=" + grandTotal +"]";
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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
	{System.out.println("cart constructor");}
	
	

	


	





	
	

}

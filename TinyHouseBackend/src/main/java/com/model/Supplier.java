package com.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="SupplierTable")
public class Supplier implements Serializable
{/*
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;*/
	@Id
	private int sid;
	private String supplierName;
	@Pattern(regexp="[\\d]{10}", message="Enter only 10 digits" )
	@Size( min=8, max=10, message="Enter valid number")
	private String sphone;
	
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	private String saddress;
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER, mappedBy="supplier")
	private Set<Product> product= new HashSet<Product>(0);
	
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	/*
	private Set<Product> product=new HashSet<Product>(0);*/
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	

}

package com.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;

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
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}/*
	@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER)
	private Set<Product> product= new HashSet<Product>(0);*/
	/*
	private Set<Product> product=new HashSet<Product>(0);*/
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	

}

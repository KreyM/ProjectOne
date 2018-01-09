package com.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CategoryTable")
public class Category implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	@Id
	private int cid;
	private String cname;
	
	
	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}

/*
	@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER, mappedBy="Category") // make changes
	private Set<Product> product=new HashSet<Product>(0);*/
	
}

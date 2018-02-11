package com.Dao;

import java.util.List;

import com.model.*;
public interface ProductDao {
	public void insertProduct(Product product);
	public List<Product> retrieve();
	public Product findByPID(int pid);
	public  boolean update(Product prod) ;
	public Category getCategory(int catId);
	//public boolean updateProduct(Product product);
}
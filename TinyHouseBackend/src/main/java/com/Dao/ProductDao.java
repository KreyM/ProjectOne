package com.Dao;

import java.util.List;

import com.model.*;
public interface ProductDao {
	public void insertProduct(Product product);
	public List<Product> retrieve();
	public Product findByPID(int pid);
	public  void update(Product prod) ;
	public Category getCategory(int catId);
	public void updateProduct(Product product);
}
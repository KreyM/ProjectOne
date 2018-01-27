package com.Dao;

import java.util.List;

import com.model.Product;
import com.model.Supplier;

public interface SupplierDao 
{
	public void insertSupplier(Supplier supplier);
	public List<Supplier> retrieve();
	public Supplier findBySID(int sid);
	public  void update(Supplier supp) ;
	public void updateSupplier(Supplier supplier);
}

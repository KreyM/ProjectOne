package com.Dao;
import java.util.List;

import com.model.*;
public interface CategoryDao {
	public void insertCategory(Category category);
	public List<Category> retrieve();
	public Category findByCID(int cid);
	public  void updateCat(Category cat) ;
	public boolean updateCategory(Category category);
}

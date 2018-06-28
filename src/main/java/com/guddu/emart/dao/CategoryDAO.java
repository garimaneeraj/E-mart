package com.guddu.emart.dao;

import java.util.List;

import com.guddu.emart.model.Category;


public interface CategoryDAO {

	public boolean addCategory(Category category);

	public boolean updateCategory(Category category);

	public boolean deleteCategory(Category category);

	public Category getCategory(int categoryId);

	public List<Category> ListCategories();

}

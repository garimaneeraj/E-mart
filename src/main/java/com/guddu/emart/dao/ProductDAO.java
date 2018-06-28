package com.guddu.emart.dao;

import java.util.List;

import com.guddu.emart.model.Product;

public interface ProductDAO {

	public boolean addProduct(Product product);

	public boolean updateProduct(Product product);

	public boolean deleteProduct(Product product);

	public Product getProduct(int productId);
	public List<Product> ListProducts();
	public List<Product> ListProductsByCategory(int categoryId);

}

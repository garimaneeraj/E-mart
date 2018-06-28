package com.guddu.emart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guddu.emart.dao.ProductDAO;
import com.guddu.emart.model.Product;


@Repository(value="productDAO")
@Transactional
public class ProductDAOImpl  implements ProductDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public Product getProduct(int productId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Product pro=(Product)session.get(Product.class, productId);
			return pro;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> ListProducts() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from product");
			List<Product>ListProducts=q.list();
			return ListProducts;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> ListProductsByCategory(int categoryId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from product where categoryId= :catid");
			q.setParameter("catid", categoryId);
			List<Product>ListProductsByCategory=q.list();
			return ListProductsByCategory;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}

package com.guddu.emart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guddu.emart.dao.SupplierDAO;
import com.guddu.emart.model.Category;
import com.guddu.emart.model.Supplier;

@Repository(value="supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	@Override
	public Supplier getSupplier(int supplierId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Supplier sup=(Supplier)session.get(Supplier.class, supplierId);
			return sup;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Supplier> ListSuppliers() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from supplier");
			List<Supplier>ListSuppliers=q.list();
			return ListSuppliers;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}

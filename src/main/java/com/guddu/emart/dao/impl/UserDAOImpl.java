package com.guddu.emart.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.guddu.emart.dao.UserDAO;
import com.guddu.emart.model.User;

@Repository(value="userDAO")//bean creation and a child class of component
@Transactional//spring framework one---to follow ACID properties of JDBC--can be provided for individual method as well
public class UserDAOImpl implements UserDAO {
//to hide implementation details and to do loose coupling--factory pattern
	
	@Autowired
	private SessionFactory sessionFactory;//pool of sessions r created
	@Override
	public boolean saveUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);//open session explicitly close
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {

			return false;
		}
	}
	@Override
	public User getUser(String Username) {
		try {
			Session session=sessionFactory.getCurrentSession();
			User user=(User)session.get(User.class, Username);
			return user;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}

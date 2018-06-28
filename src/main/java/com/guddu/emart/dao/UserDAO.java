package com.guddu.emart.dao;

import com.guddu.emart.model.User;

public interface UserDAO {
	public boolean saveUser(User user);//public boolean getUserId(User user);
	public boolean updateUser(User user);
	public User getUser(String Username);

}

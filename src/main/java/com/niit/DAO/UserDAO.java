package com.niit.DAO;

import com.niit.model.User;


public interface UserDAO {
	public User registerUser(User user);
	public User login(User user);
	public void updateUser(User user);
	public User getUser(int id);

}

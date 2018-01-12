package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {

	public void addUser(User user);
	
	public List<User> getList();
	
	public void deleteUser(User user);
	
	public User getUser(String username);
	
	public void updateUser(User user);
	
	public User login(User user);
	
	public User getUserByUsername(String username);
}

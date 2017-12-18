package com.niit.SocialColl.Dao;

import java.util.List;

import com.niit.SocialColl.Modal.User;

public interface UserDAO {

	public void addUser(User user);
	
	public List<User> getList();
	
	public void deleteUser(User user);
	
	public User getUser(String userName);
	
	public void updateUser(User user);
}

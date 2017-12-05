package com.niit.SocialColl.Dao;

import java.util.List;

import com.niit.SocialColl.Modal.User;

public interface UserDAO {

	public void addUser(User user);
	
	public List<User> getList();
	
	public void updateUser(User user);
	
	public User getUser(String UserName);
	
	public void approveUser(User user);

	public void deleteUser(String UserName);
	
}

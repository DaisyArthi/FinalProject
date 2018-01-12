package com.niit.dao;

import java.util.List;

import com.niit.model.Friend;
import com.niit.model.User;

public interface FriendDAO {

	public List<User> getListOfSuggestedUsers(String username);
	
	public void addFriendRequest(String username,String toId);
	
	public List<Friend> getPendingRequests(String username);
	
	public void updatePendingRequest(Friend pendingRequest);
	
	public List<Friend> listOfFriends(String username);
}

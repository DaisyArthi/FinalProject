package com.niit.SocialColl.Dao;

import java.util.List;

import com.niit.SocialColl.Modal.Forum;



public interface ForumDAO {

    public void addForum(Forum forum);
	
	public List<Forum> getList();
	
	public void updateForum(Forum forum);
	
	public Forum getForum(int ForumId);
	
	public void approveForum(Forum forum);

	public void deleteForum(int ForumId); 
	
}

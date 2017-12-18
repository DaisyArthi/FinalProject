package com.niit.SocialColl.Dao;

import java.util.List;


import com.niit.SocialColl.Modal.Forum;

public interface ForumDAO {

	public void addForum(Forum forum);
	
	public List<Forum> getForumList();
	
	public void deleteForum(Forum forum);
}

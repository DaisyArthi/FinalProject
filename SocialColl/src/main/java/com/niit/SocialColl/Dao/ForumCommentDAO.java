package com.niit.SocialColl.Dao;

import java.util.List;


import com.niit.SocialColl.Modal.ForumComment;

public interface ForumCommentDAO {

	public void addForumComment(ForumComment forumcomment);
	
	public List<ForumComment> getForumCommentList();
}
